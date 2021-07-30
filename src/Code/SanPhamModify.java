/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SanPhamModify {
    public static List<SanPham> findAll(){
        
        Connection connection=null;
        List<SanPham> spList=new ArrayList<>();
        
        Statement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from sanpham";
            statement=connection.createStatement();
            
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                SanPham sp=new SanPham(resultSet.getString("MASP"),
                        resultSet.getString("TENSP"),resultSet.getInt("GIANHAP")
                        ,resultSet.getInt("GIAXUAT"),resultSet.getInt("SOLUONG"),
                        resultSet.getString("DVTINH"),
                        resultSet.getString("MALOAISP"),
                        resultSet.getString("MANCC")
                );
                spList.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return spList;
    }
    public static void insert(SanPham sp){
        Connection connection=null;
        
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="insert into sanpham(MASP,TENSP,GIANHAP,GIAXUAT,DVTINH,SOLUONG,MALOAISP,MANCC)values (?,?,?,?,?,?,?,?)";
            statement=connection.prepareCall(sql);
            
            statement.setString(1,sp.getMaSP());
            statement.setString(2,sp.getTenSP());
            statement.setInt(3,sp.getGiaNhap());
            statement.setInt(4,sp.getGiaXuat());
            statement.setString(5,sp.getDonVi());
            statement.setInt(6,sp.getSoLuong());
            statement.setString(7,sp.getMaLoaiSP());
             statement.setString(8,sp.getMaNCC());
            
            
            statement.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
     
    }
    
    public static void update(SanPham sp){
          Connection connection=null;
        
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="update sanpham set TENSP=?,GIANHAP=?,GIAXUAT=?,DVTINH=?,SOLUONG=?,MALOAISP=?,MANCC=? where MASP=?";
            statement=connection.prepareCall(sql);
            
            statement.setString(1,sp.getTenSP());
            statement.setInt(2,sp.getGiaNhap());
            statement.setInt(3,sp.getGiaXuat());
            statement.setString(4,sp.getDonVi());
            statement.setInt(5,sp.getSoLuong());
            statement.setString(6,sp.getMaLoaiSP());     
            statement.setString(7,sp.getMaNCC());
            
            statement.setString(8,sp.getMaSP());
            
            
            statement.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
     
    }
     public static void delete(String maSp){
        
         Connection connection=null;
    
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="DELETE FROM sanpham where MASP=?";
            statement=connection.prepareCall(sql);
            statement.setString(1,maSp);
            
            
            statement.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
     
    }
     public static List<SanPham> findByName(String Name){
        Connection connection=null;
        List<SanPham> spList=new ArrayList<>();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from sanpham where TENSP like ?";
            
            statement=connection.prepareCall(sql);
            statement.setString(1, "%"+Name+"%");
            
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                SanPham sp=new SanPham(resultSet.getString("MASP"),
                        resultSet.getString("TENSP"),
                        resultSet.getInt("GIANHAP"),
                        resultSet.getInt("GIAXUAT"),
                        resultSet.getInt("SOLUONG"),
                        resultSet.getString("DVTINH"),
                        resultSet.getString("MALOAISP"),
                        resultSet.getString("MANCC")
                );
                spList.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return spList;
    }
    public static SanPham findByExName(String Name){
        Connection connection=null;
        SanPham sp=new SanPham();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from sanpham where TENSP=?";
            
            statement=connection.prepareCall(sql);
            statement.setString(1, Name);
            
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                sp=new SanPham(resultSet.getString("MASP"),
                        resultSet.getString("TENSP"),
                        resultSet.getInt("GIANHAP"),
                        resultSet.getInt("GIAXUAT"),
                        resultSet.getInt("SOLUONG"),
                        resultSet.getString("DVTINH"),
                        resultSet.getString("MALOAISP"),
                        resultSet.getString("MANCC")
                );
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return sp;
    }
     
    public static SanPham findByID(String ID){
        Connection connection=null;
        SanPham sp=new SanPham();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from sanpham where MASP= ?";
            
            statement=connection.prepareCall(sql);
            statement.setString(1, ID);
            
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                sp=new SanPham(resultSet.getString("MASP"),
                        resultSet.getString("TENSP"),
                        resultSet.getInt("GIANHAP"),
                        resultSet.getInt("GIAXUAT"),
                        resultSet.getInt("SOLUONG"),
                        resultSet.getString("DVTINH"),
                        resultSet.getString("MALOAISP"),
                        resultSet.getString("MANCC"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return sp;
    }
    public static boolean compareByID(String masp){
        boolean isExisted=false;
        List<SanPham> spList=SanPhamModify.findAll();
        for(int i=0;i<spList.size();i++){
            if(masp.compareTo(spList.get(i).getMaSP())==0){
                isExisted= true;
            }
        }
        return isExisted;
     }
     public static List<SanPham> findByMaLoaiSP(String malsp){
        Connection connection=null;
        List<SanPham> spList=new ArrayList<>();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from sanpham where MALOAISP= ?";
            
            statement=connection.prepareCall(sql);
            statement.setString(1,malsp);
            
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                SanPham sp=new SanPham(resultSet.getString("MASP"),
                        resultSet.getString("TENSP"),
                        resultSet.getInt("GIANHAP"),
                        resultSet.getInt("GIAXUAT"),
                        resultSet.getInt("SOLUONG"),
                        resultSet.getString("DVTINH"),
                        resultSet.getString("MALOAISP"),
                        resultSet.getString("MANCC")
                );
                spList.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return spList;
    }
     public static List<SanPham> findByMaLSPtenSP(String malsp,String tensp){
        Connection connection=null;
        List<SanPham> spList=new ArrayList<>();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from sanpham where MALOAISP= ? AND TENSP like ?";
            
            statement=connection.prepareCall(sql);
            statement.setString(1,malsp);
            statement.setString(2,"%"+tensp+"%");
            
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                SanPham sp=new SanPham(resultSet.getString("MASP"),
                        resultSet.getString("TENSP"),
                        resultSet.getInt("GIANHAP"),
                        resultSet.getInt("GIAXUAT"),
                        resultSet.getInt("SOLUONG"),
                        resultSet.getString("DVTINH"),
                        resultSet.getString("MALOAISP"),
                        resultSet.getString("MANCC")
                );
                spList.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return spList;
    }
    
}

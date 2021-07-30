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
public class KhachHangModify {
    public static List<KhachHang> findAll(){
        
        Connection connection=null;
        List<KhachHang> khachHangList=new ArrayList<>();
        
        Statement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from khachhang";
            statement=connection.createStatement();
            
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                KhachHang kh=new KhachHang(resultSet.getString("MAKH"),
                resultSet.getString("TENKH"),resultSet.getString("DIACHI"),
                resultSet.getString("SDT"),resultSet.getInt("DIEMTICHLUY"));
                khachHangList.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return khachHangList;
    }
    public static void insert(KhachHang kh){
        Connection connection=null;
        
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="insert into khachhang(MAKH,TENKH,DIACHI,SDT,DIEMTICHLUY)values (?,?,?,?,?)";
            statement=connection.prepareCall(sql);
            
            statement.setString(1,kh.getMaKH());
            statement.setString(2,kh.getTenKH());
            statement.setString(3, kh.getDiaChi());
            statement.setString(4, kh.getSdt());
            statement.setInt(5, kh.getDiemTichLuy());
            
            statement.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
     
    }
    
    public static void update(KhachHang kh){
          Connection connection=null;
        
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="update khachhang set TENKH=?,DIACHI=?,SDT=?,DIEMTICHLUY=? where MAKH=?";
            statement=connection.prepareCall(sql);
            
            statement.setString(1,kh.getTenKH());
            statement.setString(2,kh.getDiaChi());
            statement.setString(3,kh.getSdt());
            statement.setInt(4,kh.getDiemTichLuy());
             statement.setString(5,kh.getMaKH());
            
            
            statement.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
     
    }
     public static void delete(String MaKH){
        
         Connection connection=null;
    
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="delete from khachhang where MAKH=?";
            statement=connection.prepareCall(sql);
            statement.setString(1,MaKH);
            
            
            statement.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
     
    }
     public static List<KhachHang> findByName(String Name){
        Connection connection=null;
        List<KhachHang> customerList=new ArrayList<>();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from khachhang where TENKH like ?";
           
            statement=connection.prepareCall(sql);
            statement.setString(1,"%"+Name+"%");
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                KhachHang kh=new KhachHang(resultSet.getString("MAKH"),
                resultSet.getString("TENKH"),resultSet.getString("DIACHI"),
                resultSet.getString("SDT"),resultSet.getInt("DIEMTICHLUY"));
                                           
                customerList.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return customerList;
    }
     public static KhachHang findByID(String id){
        Connection connection=null;
        KhachHang  kh=new KhachHang();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from khachhang where MAKH=?";
           
            statement=connection.prepareCall(sql);
            statement.setString(1,id);
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                kh=new KhachHang(resultSet.getString("MAKH"),
                resultSet.getString("TENKH"),resultSet.getString("DIACHI"),
                resultSet.getString("SDT"),resultSet.getInt("DIEMTICHLUY"));
                                           
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return kh;
    }
    public static boolean compareByID(String makh){
        boolean isExisted=false;
        List<KhachHang> cusList=KhachHangModify.findAll();
        for(int i=0;i<cusList.size();i++){
            if(makh.compareTo(cusList.get(i).getMaKH())==0){
                isExisted= true;
            }
        }
        return isExisted;
     }
}

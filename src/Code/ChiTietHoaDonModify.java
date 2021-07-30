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
public class ChiTietHoaDonModify {
     public static List<ChiTietHoaDon> findAll(){
        
        Connection connection=null;
        List<ChiTietHoaDon> cthdList=new ArrayList<>();
        
        Statement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from cthoadon";
            statement=connection.createStatement();
            
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                ChiTietHoaDon cthd=new ChiTietHoaDon(resultSet.getString("MACTHD"),
                resultSet.getString("MAHD"),
                resultSet.getString("MASP"),resultSet.getInt("SOLUONG"),
                resultSet.getInt("THANHTIEN")
                );
                cthdList.add(cthd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(ChiTietHoaDonModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietHoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return cthdList;
    }
    public static void insert(ChiTietHoaDon cthd){
        Connection connection=null;
        
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="insert into cthoadon(MACTHD,MAHD,MASP,SOLUONG,THANHTIEN)values (?,?,?,?,?)";
            statement=connection.prepareCall(sql);
            
            statement.setString(1,cthd.getMaCTHD());
            statement.setString(2,cthd.getMaHD());
            statement.setString(3,cthd.getMaSP());
            statement.setInt(4,cthd.getSoLuong());
            statement.setInt(5,cthd.getThanhTien());
            
            statement.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(ChiTietHoaDonModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietHoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
     
    }
    
    public static void update(ChiTietHoaDon cthd){
          Connection connection=null;
        
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="update cthoadon set MAHD=?,MASP=?,SOLUONG=?,THANHTIEN=? where MACTHD=?";
            statement=connection.prepareCall(sql);
            
            statement.setString(1,cthd.getMaHD());
            statement.setString(2,cthd.getMaSP());
            statement.setInt(3,cthd.getSoLuong());
              statement.setInt(4,cthd.getThanhTien());
            statement.setString(5,cthd.getMaCTHD()); 
            
            
            statement.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(ChiTietHoaDonModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietHoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
     
    }
     public static void delete(String macthd){
        
         Connection connection=null;
    
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="delete from cthoadon where MACTHD=?";
            statement=connection.prepareCall(sql);
            statement.setString(1,macthd);
            
            
            statement.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSPModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(LoaiSPModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiSPModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
     
    }
     public static List<ChiTietHoaDon> findByMaHD(String maHD){
        Connection connection=null;
        List<ChiTietHoaDon> cthdList=new ArrayList<>();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from cthoadon where MAHD=?";
           
            statement=connection.prepareCall(sql);
            statement.setString(1,maHD);
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                ChiTietHoaDon cthd=new ChiTietHoaDon(resultSet.getString("MACTHD"),
                resultSet.getString("MAHD"),
                resultSet.getString("MASP"),resultSet.getInt("SOLUONG"),
                resultSet.getInt("THANHTIEN")
                );
                cthdList.add(cthd);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSPModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(LoaiSPModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiSPModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return cthdList;
    }
     public static ChiTietHoaDon findByID(String id){
        Connection connection=null;
        ChiTietHoaDon cthd=new ChiTietHoaDon();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from loaisp where MACTHD=?";
           
            statement=connection.prepareCall(sql);
            statement.setString(1,id);
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                cthd=new ChiTietHoaDon(resultSet.getString("MACTHD"),
                resultSet.getString("MAHD"),
                resultSet.getString("MASP"),
                resultSet.getInt("SOLUONG"),
                resultSet.getInt("THANHTIEN"))
                ;
               
                                           
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSPModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(LoaiSPModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiSPModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return cthd;
    }
     
    public static boolean compareByID(String macthd){
        boolean isExisted=false;
        List<ChiTietHoaDon> cthdList=ChiTietHoaDonModify.findAll();
        for(int i=0;i<cthdList.size();i++){
            if(macthd.compareTo(cthdList.get(i).getMaCTHD())==0){
                isExisted= true;
            }
        }
        return isExisted;
     }
}

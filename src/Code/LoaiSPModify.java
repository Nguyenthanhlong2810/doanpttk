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
public class LoaiSPModify {
    public static List<LoaiSanPham> findAll(){
        
        Connection connection=null;
        List<LoaiSanPham> loaiSPList=new ArrayList<>();
        
        Statement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from loaisp";
            statement=connection.createStatement();
            
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                LoaiSanPham lsp=new LoaiSanPham(resultSet.getString("MALOAISP"),
                resultSet.getString("TENLOAISP")
                );
                loaiSPList.add(lsp);
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
        return loaiSPList;
    }
    public static void insert(LoaiSanPham lsp){
        Connection connection=null;
        
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="insert into loaisp(MALOAISP,TENLOAISP)values (?,?)";
            statement=connection.prepareCall(sql);
            
            statement.setString(1,lsp.getMaLoaiSP());
            statement.setString(2,lsp.getTenLoaiSP());
           
            
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
    
    public static void update(LoaiSanPham lsp){
          Connection connection=null;
        
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="update loaisp set TENLOAISP=? where MALOAISP=?";
            statement=connection.prepareCall(sql);
            
            statement.setString(1,lsp.getTenLoaiSP());
             statement.setString(2,lsp.getMaLoaiSP());
            
            
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
     public static void delete(String malsp){
        
         Connection connection=null;
    
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="delete from loaisp where MALOAISP=?";
            statement=connection.prepareCall(sql);
            statement.setString(1,malsp);
            
            
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
     public static List<LoaiSanPham> findByName(String Name){
        Connection connection=null;
        List<LoaiSanPham> lspList=new ArrayList<>();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from loaisp where TENLOAISP like ?";
           
            statement=connection.prepareCall(sql);
            statement.setString(1,"%"+Name+"%");
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                LoaiSanPham lsp=new LoaiSanPham(resultSet.getString("MALOAISP"),
                resultSet.getString("TENLOAISP"));
               
                                           
                lspList.add(lsp);
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
        return lspList;
    }
     public static LoaiSanPham findByID(String id){
        Connection connection=null;
        LoaiSanPham lsp=new LoaiSanPham();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from loaisp where MALOAISP= ?";
           
            statement=connection.prepareCall(sql);
            statement.setString(1,id);
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                lsp=new LoaiSanPham(resultSet.getString("MALOAISP"),
                resultSet.getString("TENLOAISP"));
               
                                           
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
        return lsp;
    }
     public static LoaiSanPham findByExName(String name){
        Connection connection=null;
        LoaiSanPham lsp=new LoaiSanPham();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from loaisp where TENLOAISP= ?";
           
            statement=connection.prepareCall(sql);
            statement.setString(1,name);
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                lsp=new LoaiSanPham(resultSet.getString("MALOAISP"),
                resultSet.getString("TENLOAISP"));
               
                                           
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
        return lsp;
    }
    public static boolean compareByID(String malsp){
        boolean isExisted=false;
        List<LoaiSanPham> lspList=LoaiSPModify.findAll();
        for(int i=0;i<lspList.size();i++){
            if(malsp.compareTo(lspList.get(i).getMaLoaiSP())==0){
                isExisted= true;
            }
        }
        return isExisted;
     }
}

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
public class NhaCCModify {
    public static List<NhaCC> findAll(){
        
        Connection connection=null;
        List<NhaCC> nhaCCList=new ArrayList<>();
        
        Statement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from nhacc";
            statement=connection.createStatement();
            
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                NhaCC nhaCC=new NhaCC(resultSet.getString("MANCC"),
                resultSet.getString("TENNCC"),
                resultSet.getString("SDT"),
                resultSet.getString("DIACHI"));
                nhaCCList.add(nhaCC);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return nhaCCList;
    }
    public static void insert(NhaCC ncc){
        Connection connection=null;
        
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="insert into nhacc(MANCC,TENNCC,SDT,DIACHI)values (?,?,?,?)";
            statement=connection.prepareCall(sql);
            
            statement.setString(1,ncc.getMaNCC());
            statement.setString(2,ncc.getTenNCC());
            statement.setString(3, ncc.getSdt());
            statement.setString(4, ncc.getDiaChi());
            
            
            statement.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
     
    }
    
    public static void update(NhaCC ncc){
          Connection connection=null;
        
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="update nhacc set TENNCC=?,SDT=?,DIACHI=? where MANCC=?";
            statement=connection.prepareCall(sql);
            
            statement.setString(1,ncc.getTenNCC());
            statement.setString(2,ncc.getSdt());
            statement.setString(3,ncc.getDiaChi());
            statement.setString(4,ncc.getMaNCC());
             
            
            
            statement.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
     
    }
     public static void delete(String maNCC){
        
         Connection connection=null;
    
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="delete from nhacc where MANCC=?";
            statement=connection.prepareCall(sql);
            statement.setString(1,maNCC);
            
            
            statement.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
     
    }
     public static List<NhaCC> findByName(String Name){
        Connection connection=null;
        List<NhaCC> nccList=new ArrayList<>();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from nhacc where TENNCC like ?";
           
            statement=connection.prepareCall(sql);
            statement.setString(1,"%"+Name+"%");
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                NhaCC ncc=new NhaCC(resultSet.getString("MANCC"),
                resultSet.getString("TENNCC"),
                resultSet.getString("SDT"),resultSet.getString("DIACHI"));
                                           
                nccList.add(ncc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return nccList;
    }
     public static NhaCC findByID(String id){
        Connection connection=null;
        NhaCC ncc=new NhaCC();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from nhacc where MANCC= ?";
           
            statement=connection.prepareCall(sql);
            statement.setString(1,id);
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                ncc=new NhaCC(resultSet.getString("MANCC"),
                resultSet.getString("TENNCC"),
                resultSet.getString("SDT"),resultSet.getString("DIACHI"));
                                           
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return ncc;
     }
     public static NhaCC findByExName(String name){
        Connection connection=null;
        NhaCC ncc=new NhaCC();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from nhacc where TENNCC= ?";
           
            statement=connection.prepareCall(sql);
            statement.setString(1,name);
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                ncc=new NhaCC(resultSet.getString("MANCC"),
                resultSet.getString("TENNCC"),
                resultSet.getString("SDT"),resultSet.getString("DIACHI"));
                                           
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCCModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return ncc;
     }
    public static boolean compareByID(String mancc){
        boolean isExisted=false;
        List<NhaCC> nccList=NhaCCModify.findAll();
        for(int i=0;i<nccList.size();i++){
            if(mancc.compareTo(nccList.get(i).getMaNCC())==0){
                isExisted= true;
            }
        }
        return isExisted;
     }
}

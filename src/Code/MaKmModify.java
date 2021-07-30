/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class MaKmModify {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
   
    public static List<MaKM> findAll(){
        
        Connection connection=null;
        List<MaKM> kmList=new ArrayList<>();
        
        Statement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from makhuyenmai";
            statement=connection.createStatement();
            
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                MaKM km=new MaKM(resultSet.getString("MAKM"),
                        resultSet.getInt("GIATRI"),
                        resultSet.getString("GHICHU"),    
                        resultSet.getString("NGAYBD"),
                        resultSet.getString("NGAYKT")                     
                );
                kmList.add(km);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return kmList;
    }
    public static void insert(MaKM km){
        Connection connection=null;
        
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="insert into makhuyenmai(MAKM,GIATRI,NGAYBD,NGAYKT,GHICHU)values (?,?,?,?,?)";
            statement=connection.prepareCall(sql);
            
            statement.setString(1,km.getMaKM());
            statement.setInt(2,km.getGiaTri());        
            statement.setString(3,km.getNgayBD());         
            statement.setString(4,km.getNgayKT());
            statement.setString(5,km.getGhiChu());
          
            
            
            statement.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
     
    }
    
    public static void update(MaKM km){
          Connection connection=null;
        
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="update makhuyenmai set GIATRI=?,NGAYBD=?,NGAYKT=?,GHICHU=? where MAKM=?";
            statement=connection.prepareCall(sql);
            
            statement.setInt(1,km.getGiaTri());    
            statement.setString(2,km.getNgayBD());         
            statement.setString(3,km.getNgayKT());  
            statement.setString(4,km.getGhiChu());       
            
            statement.setString(5,km.getMaKM());
            
           
            
            
            statement.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
     
    }
     public static void delete(String makm){
        
         Connection connection=null;
    
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="DELETE FROM makhuyenmai where makm=?";
            statement=connection.prepareCall(sql);
            statement.setString(1,makm);
            
            
            statement.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
     
    }
     public static List<MaKM> findByND(String noidung){
        Connection connection=null;
        List<MaKM> kmList=new ArrayList<>();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from makhuyemai where NOIDUNG like ?";
            
            statement=connection.prepareCall(sql);
            statement.setString(1, "%"+noidung+"%");
            
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
               MaKM km=new MaKM(resultSet.getString("MAKM"),
                        resultSet.getInt("GIATRI"),
                        resultSet.getString("GHICHU"),    
                        resultSet.getString("NGAYBD"),
                        resultSet.getString("NGAYKT")                                 
                );
                kmList.add(km);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return kmList;
    }
     
    public static List<MaKM> findByDate(){
        Connection connection=null;
        List<MaKM> kmList=new ArrayList<>();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from makhuyenmai where NGAYBD <= ? and NGAYKT >=?";
            
            statement=connection.prepareCall(sql);
            statement.setString(1,""+LocalDate.now());
            statement.setString(2,""+LocalDate.now());
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
               MaKM km=new MaKM(resultSet.getString("MAKM"),
                        resultSet.getInt("GIATRI"),
                        resultSet.getString("GHICHU"),    
                        resultSet.getString("NGAYBD"),
                        resultSet.getString("NGAYKT")                                 
                );
                kmList.add(km);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return kmList;
    }
    public static MaKM findByID(String ID){
        Connection connection=null;
        MaKM km=new MaKM();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from makhuyenmai where MAKM= ?";
            
            statement=connection.prepareCall(sql);
            statement.setString(1, ID);
            
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                km=new MaKM(resultSet.getString("MAKM"),
                        resultSet.getInt("GIATRI"),
                        resultSet.getString("GHICHU"),    
                        resultSet.getString("NGAYBD"),
                        resultSet.getString("NGAYKT")              
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MaKmModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return km;
    }
    public static boolean compareByID(String masp){
        boolean isExisted=false;
        List<MaKM> kmList=MaKmModify.findAll();
        for(int i=0;i<kmList.size();i++){
            if(masp.compareTo(kmList.get(i).getMaKM())==0){
                isExisted= true;
            }
        }
        return isExisted;
     }
}

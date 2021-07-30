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
public class HoaDonModify {
    public static List<HoaDon> findAll(){
        
        Connection connection=null;
        List<HoaDon> hdList=new ArrayList<>();
        
        Statement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from hoadon";
            statement=connection.createStatement();
            
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                HoaDon hd=new HoaDon(resultSet.getString("MAHD"),
                resultSet.getString("MAKH"),resultSet.getString("NGAYBAN"),
                resultSet.getInt("TONGHOADON"),
                resultSet.getString("GHICHU"));
                hdList.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return hdList;
    }
    public static void insert(HoaDon hd){
        Connection connection=null;
        
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="insert into hoadon(MAHD,MAKH,NGAYBAN,TONGHOADON,GHICHU)values (?,?,?,?,?)";
            statement=connection.prepareCall(sql);
            
            statement.setString(1,hd.getMaHD());
            statement.setString(2,hd.getMaKH());
            statement.setString(3,hd.getNgayBan());
            statement.setInt(4,hd.getTongHD());
            statement.setString(5,hd.getGhiChu());
            statement.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
     
    }
    
    public static void update(HoaDon hd){
          Connection connection=null;
        
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="update hoadon set MAKH=?,NGAYBAN=?,TONGHOADON=?,GHICHU=? where MAHD=?";
            statement=connection.prepareCall(sql);
            
            statement.setString(1,hd.getMaKH());
            statement.setString(2,hd.getNgayBan());
            statement.setInt(3,hd.getTongHD());
            statement.setString(4,hd.getGhiChu());
            statement.setString(5,hd.getMaHD());
            
            
            statement.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
     
    }
     public static void delete(String maHD){
        
         Connection connection=null;
    
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="delete from hoadon where MAHD=?";
            statement=connection.prepareCall(sql);
            statement.setString(1,maHD);
            
            
            statement.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
     
    }
     public static List<HoaDon> findListHdById(String maHD){
        Connection connection=null;
        List<HoaDon> hdList=new ArrayList<>();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from hoadon where MAHD like ?";
           
            statement=connection.prepareCall(sql);
            statement.setString(1,"%"+maHD+"%");
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                HoaDon hd=new HoaDon(resultSet.getString("MAHD"),
                resultSet.getString("MAKH"),resultSet.getString("NGAYBAN"),
                resultSet.getInt("TONGHOADON"),
                resultSet.getString("GHICHU"));
                                           
                hdList.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return hdList;
    }
     
      public static HoaDon findHdById(String maHD){
        Connection connection=null;
        HoaDon hd=new HoaDon();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from hoadon where MAHD= ?";
           
            statement=connection.prepareCall(sql);
            statement.setString(1,maHD);
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                hd=new HoaDon(resultSet.getString("MAHD"),
                resultSet.getString("MAKH"),resultSet.getString("NGAYBAN"),
                resultSet.getInt("TONGHOADON"),
                resultSet.getString("GHICHU"));
                                         
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return hd;
    }
        public static boolean compareByID(String mahd){
        boolean isExisted=false;
        List<HoaDon> hdList=HoaDonModify.findAll();
        for(int i=0;i<hdList.size();i++){
            if(mahd.compareTo(hdList.get(i).getMaHD())==0){
                isExisted= true;
            }
        }
        return isExisted;
     }
    public static HoaDon findHdByMaKH(String maKH){
        Connection connection=null;
      //  List<HoaDon> hdList=new ArrayList<>();
        HoaDon hd=new HoaDon();
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from hoadon where TENKH like ?";
           
            statement=connection.prepareCall(sql);
            statement.setString(1,maKH);
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){               
                hd=new HoaDon(resultSet.getString("MAHD"),
                resultSet.getString("MAKH"),resultSet.getString("NGAYBAN"),
                resultSet.getInt("TONGHOADON"),
                resultSet.getString("GHICHU"));
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return hd;
    }
     public static List<HoaDon> findListHdByMaKH(String maKH){
        Connection connection=null;
        List<HoaDon> hdList=new ArrayList<>();
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from hoadon where maKH= ?";
           
            statement=connection.prepareCall(sql);
            statement.setString(1,maKH);
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){               
                HoaDon hd=new HoaDon(resultSet.getString("MAHD"),
                resultSet.getString("MAKH"),resultSet.getString("NGAYBAN"),
                resultSet.getInt("TONGHOADON"),
                resultSet.getString("GHICHU"));
                
                hdList.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return hdList;
    }
    public static List<HoaDon> findListHdByDate(String ngayBD,String ngayKT){
        Connection connection=null;
        List<HoaDon> hdList=new ArrayList<>();
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from hoadon where NGAYBAN <=? and NGAYBAN >=?";
           
            statement=connection.prepareCall(sql);
            statement.setString(1,ngayKT);
            statement.setString(2,ngayBD);
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                HoaDon hd=new HoaDon(resultSet.getString("MAHD"),
                resultSet.getString("MAKH"),resultSet.getString("NGAYBAN"),
                resultSet.getInt("TONGHOADON"),
                resultSet.getString("GHICHU"));
                                           
                hdList.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return hdList;
    }
}

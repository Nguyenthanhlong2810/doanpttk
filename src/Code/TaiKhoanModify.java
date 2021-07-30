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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class TaiKhoanModify {
    public static TaiKhoan findByTK(String taikhoan){
        
       Connection connection=null;
       TaiKhoan taiKhoan=new TaiKhoan();
        
        
        PreparedStatement statement=null;
        try {
            //lay tat ca danh sach sinh vien
            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
            
            //query
            String sql="select * from taikhoan where TK = ?";
            
            statement=connection.prepareCall(sql);
            statement.setString(1, taikhoan);
            
            
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                taiKhoan=new TaiKhoan(resultSet.getString("TK"),resultSet.getString("MK"),
                                            resultSet.getString("CHUCVU"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    Logger.getLogger(TaiKhoanModify.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TaiKhoanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return taiKhoan;
    }
     
    }
    
//    public static void update(Product prod){
//          Connection connection=null;
//        
//        
//        PreparedStatement statement=null;
//        try {
//            //lay tat ca danh sach sinh vien
//            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
//            
//            //query
//            String sql="update product_tbl set name=?,giaNhap=?,giaXuat=?,donVi=?,soLuong=?,maLoaiSp=? where id=?";
//            statement=connection.prepareCall(sql);
//            
//            statement.setString(1,prod.getName());
//            statement.setInt(2,prod.getGiaNhap());
//            statement.setInt(3,prod.getGiaXuat());
//            statement.setString(4,prod.getDonVi());
//            statement.setInt(5,prod.getSoLuong());
//            statement.setString(6,prod.getMaLoaiSp());
//            
//            statement.setString(7,prod.getId());
//            
//            
//            statement.execute();
//                  
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            if(statement!=null){
//                try{
//                    statement.close();
//                }catch(SQLException ex){
//                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE,null,ex);
//                }
//            }
//            if(connection!=null){
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        //ket thuc
//     
//    }
//     public static void delete(String maSp){
//        
//         Connection connection=null;
//    
//        PreparedStatement statement=null;
//        try {
//            //lay tat ca danh sach sinh vien
//            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
//            
//            //query
//            String sql="DELETE FROM product_tbl where id=?";
//            statement=connection.prepareCall(sql);
//            statement.setString(1,maSp);
//            
//            
//            statement.execute();
//                  
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            if(statement!=null){
//                try{
//                    statement.close();
//                }catch(SQLException ex){
//                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE,null,ex);
//                }
//            }
//            if(connection!=null){
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        //ket thuc
//     
//    }
//     public static List<Product> findByName(String Name){
//        Connection connection=null;
//        List<Product> productList=new ArrayList<>();
//        
//        PreparedStatement statement=null;
//        try {
//            //lay tat ca danh sach sinh vien
//            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
//            
//            //query
//            String sql="select * from product_tbl where name like ?";
//            
//            statement=connection.prepareCall(sql);
//            statement.setString(1, "%"+Name+"%");
//            
//            
//            ResultSet resultSet=statement.executeQuery();
//            while(resultSet.next()){
//                Product prod=new Product(resultSet.getString("id"),resultSet.getString("name"),resultSet.getInt("giaNhap"),resultSet.getInt("giaXuat"),
//                                            resultSet.getString("donVi"),resultSet.getInt("soLuong"),resultSet.getString("maLoaiSp"));
//                productList.add(prod);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            if(statement!=null){
//                try{
//                    statement.close();
//                }catch(SQLException ex){
//                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE,null,ex);
//                }
//            }
//            if(connection!=null){
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        //ket thuc
//        return productList;
//    }
//     
//    public static Product findByID(String ID){
//        Connection connection=null;
//        Product product=new Product();
//        
//        PreparedStatement statement=null;
//        try {
//            //lay tat ca danh sach sinh vien
//            connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doanpttk","root","");
//            
//            //query
//            String sql="select * from product_tbl where id like ?";
//            
//            statement=connection.prepareCall(sql);
//            statement.setString(1, "%"+ID+"%");
//            
//            
//            ResultSet resultSet=statement.executeQuery();
//            while(resultSet.next()){
//                product=new Product(resultSet.getString("id"),resultSet.getString("name"),resultSet.getInt("giaNhap"),resultSet.getInt("giaXuat"),
//                                            resultSet.getString("donVi"),resultSet.getInt("soLuong"),resultSet.getString("maLoaiSp"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            if(statement!=null){
//                try{
//                    statement.close();
//                }catch(SQLException ex){
//                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE,null,ex);
//                }
//            }
//            if(connection!=null){
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        //ket thuc
//        return product;
//    }
    


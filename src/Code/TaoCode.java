/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;
import java.time.LocalDate;
import java.util.ArrayList; 
import java.util.Collections;
import java.util.List; 
import java.util.Random;
import java.util.function.Consumer; 
public class TaoCode {   
    private static final String alpha = "abcdefghijklmnopqrstuvwxyz";
    // a-z  
    private static final String alphaUpperCase = alpha.toUpperCase(); 
    // A-Z  
    private static final String digits = "0123456789"; 
    // 0-9   
    private static final String specials = "~=+%^*/()[]{}/!@#$?|"; 
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;  
    private static final String ALL = alpha + alphaUpperCase + digits + specials;
    private static Random generator = new Random();
     /**      * Random string with a-zA-Z0-9, not included special characters      */    
    public String randomAlphaNumeric(int numberOfCharactor) {       
        StringBuilder sb = new StringBuilder();        
        for (int i = 0; i < numberOfCharactor; i++) {  
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);  
            char ch = ALPHA_NUMERIC.charAt(number);    
            sb.append(ch);     
        }     
        sb.insert(0, "LDTK");
        sb.append(LocalDate.now().getDayOfMonth());
        return sb.toString();  
    }     
    public int createLspID(){
        int id;
        List<LoaiSanPham> lspList=LoaiSPModify.findAll();
        if(lspList.size()==0){
            id=0;
            return id;
        }else{
            id=lspList.size();
            return id;
        }
    }
    public int createSpID(){
        int id;
        List<SanPham> spList=SanPhamModify.findAll();
        if(spList.size()==0){
            id=0;
            return id;
        }else{
            id=spList.size();
            return id;
        }
    }
    public String randomAlphaNumericMaKm(int numberOfCharactor) {       
        StringBuilder sb = new StringBuilder();        
        for (int i = 0; i < numberOfCharactor; i++) {  
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);  
            char ch = ALPHA_NUMERIC.charAt(number);    
            sb.append(ch);     
        }     
//        sb.insert(0, "LDTK");
//        sb.append(LocalDate.now().getDayOfMonth());
        return sb.toString();  
    }    
     public String createIdHD(){
        String maHD;
        int id;
        List<HoaDon> hdList=HoaDonModify.findAll();
        if(hdList.size()==0){
            id=0;
        }else{
            id=hdList.size();
        }
        maHD="HD"+id;
        return maHD;
    }
     public int createIdCTHD(List<ChiTietHoaDon> cthdList){
        String maCTHD;
        int id;
        if(cthdList.size()==0){
            id=0;
        }else{
            id=cthdList.size();
        }       
        return id;
    }
    public TaoCode() {
    }
    
    /**      * Random string password with at least 1 digit and 1 special character      */  
//    public String randomPassword(int numberOfCharactor) {    
//        List<String> result = new ArrayList<>();      
//        Consumer<String> appendChar = s -> {       
//            int number = randomNumber(0, s.length() - 1);    
//            result.add("" + s.charAt(number));     
//        };      
//        appendChar.accept(digits);  
//        appendChar.accept(specials);   
//        while (result.size() < numberOfCharactor) {     
//            appendChar.accept(ALL);     
//        }       
//        Collections.shuffle(result, generator);   
//        return String.join("", result);     
//    }  
    public static int randomNumber(int min, int max) {    
        return generator.nextInt((max - min) + 1) + min;   
    }    
    public static void main(String a[]){         
        int numberOfCharactor = 4;     
        TaoCode rand = new TaoCode();
        String idhoadon=rand.randomAlphaNumeric(numberOfCharactor);
        System.out.println(idhoadon);
        
  
    } 
}
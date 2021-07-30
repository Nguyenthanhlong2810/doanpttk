/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author Admin
 */
public class MaKM {
    String maKM;
    int giaTri;
    String ghiChu;
    String NgayBD;
    String NgayKT;
    
    public MaKM() {
    }

    public MaKM(String maKM, int giaTri, String ghiChu, String NgayBD, String NgayKT) {
        this.maKM = maKM;
        this.giaTri = giaTri;
        this.ghiChu = ghiChu;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
    }

    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }

  

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
 
    public String getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(String NgayBD) {
        this.NgayBD = NgayBD;
    }

    public String getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(String NgayKT) {
        this.NgayKT = NgayKT;
    }
    
    
}

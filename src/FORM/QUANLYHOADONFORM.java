/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FORM;



import Code.ChiTietHoaDon;
import Code.ChiTietHoaDonModify;
import Code.HoaDon;
import Code.HoaDonModify;
import Code.KhachHang;
import Code.KhachHangModify;
import Code.SanPhamModify;
import Code.TaoCode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QUANLYHOADONFORM extends javax.swing.JFrame {
    
    
    DefaultTableModel tableModelHoaDon;
    DefaultTableModel tableModelCTHD;
    int selectedIndex=-1;
    /**
     * Creates new form HOADONFORM
     */
    public QUANLYHOADONFORM() {
        initComponents();
        this.setLocationRelativeTo(null);
        tableModelHoaDon=(DefaultTableModel) tblHoadon.getModel();  
        tableModelCTHD=(DefaultTableModel) tblCthd.getModel();
        showHoaDon();
        showInfo();
        showCTHD();
    
       
    }
     public QUANLYHOADONFORM(String Chucvu) {
        initComponents();
        this.setLocationRelativeTo(null);
        tableModelHoaDon=(DefaultTableModel) tblHoadon.getModel();
        tableModelCTHD=(DefaultTableModel) tblCthd.getModel();
        txtChucvu.setText(Chucvu);
        showHoaDon();
        showInfo();
        showCTHD();
    }
    public QUANLYHOADONFORM(String maHD,String chucvu){
        initComponents();
        this.setLocationRelativeTo(null);
        tableModelHoaDon=(DefaultTableModel) tblHoadon.getModel();
        tableModelCTHD=(DefaultTableModel) tblCthd.getModel();
        showSelectedHD(maHD);
        txtChucvu.setText(chucvu);
        showHoaDon();
     //   showInfo();
        showCTHD();
    }
     
//     public QUANLYHOADONFORM(String Chucvu,String maKH,String maHD) {
//        initComponents();
//        this.setLocationRelativeTo(null);
//        tableModel=(DefaultTableModel) tblHoadon.getModel();
//        txtMahd.setText(maHD);
//        txtMakh.setText(maKH);
//        txtNgayban.setText(""+LocalDate.now());
//        txtChucvu.setText(Chucvu);
//        txtTonghoadon.setText("0");
        
       // showInfo();
    //    showHoaDon();
   
    //}
    private void showSelectedHD(String maHD){
         HoaDon hd=HoaDonModify.findHdById(maHD);
         txtMahd.setText(hd.getMaHD());
         txtMakh.setText(hd.getMaKH());
         txtNgayban.setText(hd.getNgayBan());
         txtTonghoadon.setText(""+hd.getTongHD());
         txtGhichu.setText(hd.getGhiChu());
    }
    private void showHoaDon(){
        List<HoaDon> hdList=HoaDonModify.findAll();
        tableModelHoaDon.setRowCount(0);
        hdList.forEach(hd -> {
            tableModelHoaDon.addRow(new Object[] {hd.getMaHD(),
                KhachHangModify.findByID(hd.getMaKH()).getTenKH(),hd.getNgayBan(),hd.getTongHD(),
                hd.getGhiChu()
            });         
        });
    }
    private void showInfo(){
        List<HoaDon> hdList=HoaDonModify.findAll();
       try{
           HoaDon hd=hdList.get(hdList.size()-1);
           txtMahd.setText(hd.getMaHD());
           txtMakh.setText(hd.getMaKH());    
            txtNgayban.setText(hd.getNgayBan());
            txtTonghoadon.setText(""+hd.getTongHD());
            txtGhichu.setText(hd.getGhiChu());
           
       }catch(Exception ex){
           txtMahd.setText("");
           txtMakh.setText("");      
            txtNgayban.setText("");
            txtTonghoadon.setText("");
            txtGhichu.setText("");
       }
    }
    
    private void showCTHD(){
        List<ChiTietHoaDon> cthdList=ChiTietHoaDonModify.findByMaHD(txtMahd.getText());
        if(cthdList.size()>0){
            tableModelCTHD.setRowCount(0);
            cthdList.forEach(cthd -> {
            tableModelCTHD.addRow(new Object[] {cthd.getMaCTHD(),
                cthd.getMaSP(),SanPhamModify.findByID(cthd.getMaSP()).getTenSP(),
                cthd.getSoLuong(),SanPhamModify.findByID(cthd.getMaSP()).getGiaXuat(),
                cthd.getThanhTien()
            });
           
        });
            
        }
    }
    public void selectedKH(String makh){
        txtMakh.setText(makh);
    }
     private void showSelectedRow(){
       // List<HoaDon> hdList=HoaDonModify.findAll();
        
        selectedIndex=tblHoadon.getSelectedRow();
       
        if(selectedIndex>=0){
            String maHD=(String) tblHoadon.getValueAt(selectedIndex, 0);
            HoaDon hd=HoaDonModify.findHdById(maHD);
           
            txtMahd.setText(hd.getMaHD());
            txtMakh.setText(hd.getMaKH());
            txtNgayban.setText(hd.getNgayBan());
            txtTonghoadon.setText(""+hd.getTongHD());
            txtGhichu.setText(hd.getGhiChu());
        }else{
            showInfo();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMahd = new javax.swing.JTextField();
        txtMakh = new javax.swing.JTextField();
        txtNgayban = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnThemmoi = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoadon = new javax.swing.JTable();
        btnFind = new javax.swing.JButton();
        btnQuaylai = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTonghoadon = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtChucvu = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtGhichu = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCthd = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setBackground(new java.awt.Color(153, 0, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("QUẢN LÍ HÓA ĐƠN");

        jLabel2.setText("MÃ HÓA ĐƠN");

        jLabel3.setText("MÃ KH");

        jLabel4.setText("NGÀY BÁN");

        txtMahd.setEditable(false);

        txtMakh.setEditable(false);

        txtNgayban.setEditable(false);
        txtNgayban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaybanActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Img/Refresh(1).png"))); // NOI18N
        btnReset.setText("LÀM MỚI");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnThemmoi.setBackground(new java.awt.Color(0, 255, 0));
        btnThemmoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Img/Save(1).png"))); // NOI18N
        btnThemmoi.setText("THÊM MỚI");
        btnThemmoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemmoiActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Img/Delete(1).png"))); // NOI18N
        btnDelete.setText("XÓA");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tblHoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MAHD", "TENKH", "NGAYBAN", "TONGTIENHOADON", "GHICHU"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoadon);
        if (tblHoadon.getColumnModel().getColumnCount() > 0) {
            tblHoadon.getColumnModel().getColumn(0).setResizable(false);
            tblHoadon.getColumnModel().getColumn(1).setResizable(false);
            tblHoadon.getColumnModel().getColumn(2).setResizable(false);
            tblHoadon.getColumnModel().getColumn(3).setResizable(false);
            tblHoadon.getColumnModel().getColumn(4).setResizable(false);
        }

        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Img/Find(1).png"))); // NOI18N
        btnFind.setText("TÌM ");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnQuaylai.setBackground(new java.awt.Color(255, 153, 0));
        btnQuaylai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Img/Back(1).png"))); // NOI18N
        btnQuaylai.setText("QUAY LẠI");
        btnQuaylai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuaylaiActionPerformed(evt);
            }
        });

        jLabel6.setText("TONG HOA DON");

        txtTonghoadon.setEditable(false);
        txtTonghoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTonghoadonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 102));
        jLabel7.setText("Chức vụ :");

        txtChucvu.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        txtChucvu.setText("jLabel3");

        jLabel8.setText("GHI CHÚ");

        txtGhichu.setEditable(false);
        txtGhichu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhichuActionPerformed(evt);
            }
        });

        tblCthd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MACTHD", "MASP", "TENSP", "SOLUONG", "GIABAN", "THANHTIEN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCthd);

        jLabel5.setText("Chi tiết hóa đơn:");

        jLabel9.setText("DANH SÁCH HÓA ĐƠN ");

        jLabel10.setText("THÔNG TIN HÓA ĐƠN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnQuaylai)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(189, 189, 189)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtChucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(308, 308, 308)
                                .addComponent(jLabel1)))
                        .addGap(127, 127, 127))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 177, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGhichu, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                            .addComponent(txtTonghoadon)
                            .addComponent(txtNgayban)
                            .addComponent(txtMakh)
                            .addComponent(txtMahd))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(btnThemmoi))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtChucvu)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMahd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMakh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNgayban, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTonghoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGhichu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReset)
                            .addComponent(btnThemmoi)
                            .addComponent(btnDelete)
                            .addComponent(btnFind))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuaylai)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuaylaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuaylaiActionPerformed
        this.dispose();
        new MENUFORM(txtChucvu.getText()).setVisible(true);
    }//GEN-LAST:event_btnQuaylaiActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
           showInfo();
           showHoaDon();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnThemmoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemmoiActionPerformed
        TaoCode code=new TaoCode();
        String mahd=code.createIdHD();
        new HOADONFORM(txtChucvu.getText(),mahd).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnThemmoiActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if(txtChucvu.getText().compareTo("QL")==0){
            System.out.println(txtChucvu.getText());
            int option=JOptionPane.showConfirmDialog(this, "BẠN CÓ MUỐN XÓA HÓA ĐƠN NÀY?");
            if(option==0){
                List<ChiTietHoaDon> cthdList=ChiTietHoaDonModify.findByMaHD(txtMahd.getText());
                for(int i=0;i<cthdList.size();i++){
                    ChiTietHoaDonModify.delete(cthdList.get(i).getMaCTHD());
                }  
                HoaDon hd=HoaDonModify.findHdById(txtMahd.getText());
                HoaDonModify.delete(hd.getMaHD());
                JOptionPane.showMessageDialog(rootPane, "XÓA THÀNH CÔNG !");
                showHoaDon();
                showInfo();
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "BẠN KHÔNG PHẢI QUẢN LÍ!");
            }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        boolean isNull=false;
        List<KhachHang> khList=new ArrayList<>();
        String input =JOptionPane.showInputDialog(this,"NHẬP TÊN KHÁCH HÀNG CẦN TÌM KIẾM");;
        if(input!=null&&input.length()>0){
            khList=KhachHangModify.findByName(input);
            if(khList.size()==0){
                JOptionPane.showMessageDialog(rootPane, "KHÔNG CÓ KHÁCH HÀNG NÀO PHÙ HỢP !");
            }else{
                List<HoaDon> hdList1=new ArrayList<>();
                List<HoaDon> hdList2=new ArrayList<>();
                for(int i=0;i<khList.size();i++){
                    hdList2=HoaDonModify.findListHdByMaKH(khList.get(i).getMaKH());
                    if(hdList2.size()==1){
                        hdList1.add(hdList2.get(0));
                    }else{
                        for(int j=0;j<hdList2.size();j++){
                            hdList1.add(hdList2.get(j));
                        }
                    }
                }
                if(hdList1.size()>0){
                tableModelHoaDon.setRowCount(0);
                hdList1.forEach(hd -> {
                    tableModelHoaDon.addRow(new Object[] {hd.getMaHD(),
                    KhachHangModify.findByID(hd.getMaKH()).getTenKH(),hd.getNgayBan(),
                    hd.getTongHD(),hd.getGhiChu()
                    });
                }); 
                }else{
                    JOptionPane.showMessageDialog(rootPane,"KHÔNG CÓ HÓA ĐƠN NÀO PHÙ HỢP!");
                }
            }
        }else{
            showHoaDon();
        }                  
    }//GEN-LAST:event_btnFindActionPerformed

    private void txtTonghoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTonghoadonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTonghoadonActionPerformed

    private void txtGhichuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhichuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhichuActionPerformed

    private void tblHoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoadonMouseClicked
        // TODO add your handling code here:         
         showSelectedRow();
         showCTHD();
    }//GEN-LAST:event_tblHoadonMouseClicked

    private void txtNgaybanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaybanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaybanActionPerformed
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QUANLYHOADONFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QUANLYHOADONFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QUANLYHOADONFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QUANLYHOADONFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QUANLYHOADONFORM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnQuaylai;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThemmoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCthd;
    private javax.swing.JTable tblHoadon;
    private javax.swing.JLabel txtChucvu;
    private javax.swing.JTextField txtGhichu;
    private javax.swing.JTextField txtMahd;
    private javax.swing.JTextField txtMakh;
    private javax.swing.JTextField txtNgayban;
    private javax.swing.JTextField txtTonghoadon;
    // End of variables declaration//GEN-END:variables
}

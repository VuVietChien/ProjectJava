/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.ThongKeNhapHangController;
import Controllers.ThongKeDoanhSoController;
import Models.ChiTietHoaDon;
import Models.ChiTietPhieuNhap;
import Models.KhachHang;
import Models.NhaCungCap;
import Models.NhanVien;
import Models.SanPham1;
import Models.ThongKe;
import helpers.PriceFormatter;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author admin
 */
public class HomeThongKe extends javax.swing.JInternalFrame {

    List<ChiTietHoaDon> cthdList = new ArrayList<>();
    List<ChiTietPhieuNhap> ctpnList = new ArrayList<>();
    
    List<ThongKe> tkList = new ArrayList<>();
    List<SanPham1> tksp = new ArrayList<>();
    List<NhanVien> tknv = new ArrayList<>();
    List<KhachHang> tkkh = new ArrayList<>();
    List<NhaCungCap> tkncc = new ArrayList<>();
    
    DefaultTableModel tableModel;
    DefaultTableModel tableModel1;
    public HomeThongKe() {
        initComponents();
        setResizable(false);
        //setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) tblDanhSach.getModel();
        tableModel1 = (DefaultTableModel) tblDanhSach1.getModel();
        try {
            loadData();
            loadData1();
            loadTongTien();
            loadSoLuongHD();  
            loadTongTien1();
            loadSoLuongHD1();
            loadSP();
            loadNV();
            loadKH();
            loadNCC();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Ch??a c?? d??? li???u ????? th???ng k??");
        }
    }

    private void loadData() {
        cthdList = ThongKeDoanhSoController.layNguon();
        tableModel.setRowCount(0);
         cthdList.forEach(p ->{
            tableModel.addRow(new Object[]{
                p.getMaHD(),
                p.getTenNV(),
                p.getTenKH(),
                p.getTenSP(),
                p.getNgayLap(),
                p.getSoLuong(),
                PriceFormatter.format(p.getDongia()),
                PriceFormatter.format(p.getThanhTien()) 
            });
        });
         
    }
    //t???ng c???a b??n sp
    private void loadSoLuongHD() {
        int n = tableModel.getRowCount();
        lblSLhoaDon.setText("S??? l?????ng h??ng b??n: " + String.valueOf(n));
    }
    

    private void loadTongTien() {
        tkList = ThongKeDoanhSoController.getTongTien();
        for(ThongKe tk : tkList){
            lblTongDoanhThu.setText("T???ng ti???n: " +PriceFormatter.format(tk.getThanhTien()) );
        }
    }
    
    
    private void loadData1() {
        ctpnList = ThongKeNhapHangController.layNguonPN();
        tableModel1.setRowCount(0);
         ctpnList.forEach(p ->{
            tableModel1.addRow(new Object[]{
                p.getMaPN(),
                p.getTenNV(),
                p.getTenNCC(),
                p.getTenSP(),
                p.getNgayNhap(),
                p.getSoLuong(),
                PriceFormatter.format(p.getDonGia()),
                PriceFormatter.format(p.getThanhTien()) 
            });
        });
         
    }
    //t???ng c???a nh???p sp
    private void loadSoLuongHD1() {
        int n = tableModel1.getRowCount();
        lblSLhoaDon1.setText("S??? l?????ng h??ng nh???p: " + String.valueOf(n));
    }
    

    private void loadTongTien1() {
        tkList = ThongKeNhapHangController.getTongTienPN();
        for(ThongKe tk : tkList){
            lblTongDoanhThu1.setText("T???ng ti???n: " +PriceFormatter.format(tk.getThanhTien()) );
        }
    }
    
    //th???ng k?? t???ng qu??t
    private void loadSP() {
        tksp = ThongKeDoanhSoController.getTongSP();
        for(SanPham1 tk : tksp){
            lblSP.setText(" " +String.valueOf(tk.getMaSP()) );
        }
    }
     private void loadNV() {
        tknv = ThongKeDoanhSoController.getTongNV();
        for(NhanVien nv : tknv){
            lblnv.setText(" " +String.valueOf(nv.getMaNV()) );
        }
    }
    private void loadKH() {
        tkkh = ThongKeDoanhSoController.getTongKH();
        for(KhachHang kh : tkkh){
            lblkh.setText(" " +String.valueOf(kh.getMaKHString()) );
        }
    }
     private void loadNCC() {
        tkncc = ThongKeDoanhSoController.getTongNCC();
        for(NhaCungCap ncc : tkncc){
            lblncc.setText(" " +String.valueOf(ncc.getMaNCC()) );
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lnhanvien = new javax.swing.JPanel();
        lblnv = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pkhachhang = new javax.swing.JPanel();
        lblkh = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnhacc = new javax.swing.JPanel();
        lblncc = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        psanpham = new javax.swing.JPanel();
        lblSP = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        btnSapXep = new javax.swing.JButton();
        btnInThongKe = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        dateNgayThongKe = new com.toedter.calendar.JDateChooser();
        btnThongKeNgay = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        month = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        year = new javax.swing.JTextField();
        btnThongKeThang = new javax.swing.JButton();
        lblTongDoanhThu = new javax.swing.JLabel();
        lblSLhoaDon = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhSach1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnReset1 = new javax.swing.JButton();
        btnSapXep1 = new javax.swing.JButton();
        btnInThongKe1 = new javax.swing.JButton();
        btnBack1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        dateNgayThongKe1 = new com.toedter.calendar.JDateChooser();
        btnThongKeNgay1 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        month1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        year1 = new javax.swing.JTextField();
        btnThongKeThang1 = new javax.swing.JButton();
        lblSLhoaDon1 = new javax.swing.JLabel();
        lblTongDoanhThu1 = new javax.swing.JLabel();

        setClosable(true);

        lnhanvien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));

        lblnv.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblnvMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_assistant_100px.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Nh??n Vi??n");

        javax.swing.GroupLayout lnhanvienLayout = new javax.swing.GroupLayout(lnhanvien);
        lnhanvien.setLayout(lnhanvienLayout);
        lnhanvienLayout.setHorizontalGroup(
            lnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lnhanvienLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(lnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lnhanvienLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lnhanvienLayout.createSequentialGroup()
                        .addComponent(lblnv, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        lnhanvienLayout.setVerticalGroup(
            lnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lnhanvienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(26, 26, 26)
                .addComponent(lblnv, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pkhachhang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));

        lblkh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblkh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblkhMouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_person_male_100px.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Kh??ch H??ng");

        javax.swing.GroupLayout pkhachhangLayout = new javax.swing.GroupLayout(pkhachhang);
        pkhachhang.setLayout(pkhachhangLayout);
        pkhachhangLayout.setHorizontalGroup(
            pkhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pkhachhangLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pkhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pkhachhangLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(pkhachhangLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblkh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pkhachhangLayout.setVerticalGroup(
            pkhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pkhachhangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(lblkh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnhacc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));

        lblncc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_company_100px.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Nh?? Cung C???p");

        javax.swing.GroupLayout pnhaccLayout = new javax.swing.GroupLayout(pnhacc);
        pnhacc.setLayout(pnhaccLayout);
        pnhaccLayout.setHorizontalGroup(
            pnhaccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnhaccLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnhaccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnhaccLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnhaccLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblncc, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        pnhaccLayout.setVerticalGroup(
            pnhaccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnhaccLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(26, 26, 26)
                .addComponent(lblncc, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        psanpham.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));

        lblSP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSPMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_google_mobile_100px.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("S???n Ph???m");

        javax.swing.GroupLayout psanphamLayout = new javax.swing.GroupLayout(psanpham);
        psanpham.setLayout(psanphamLayout);
        psanphamLayout.setHorizontalGroup(
            psanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(psanphamLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(psanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(psanphamLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7))
                    .addGroup(psanphamLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblSP, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        psanphamLayout.setVerticalGroup(
            psanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(psanphamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addComponent(lblSP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setText("TH???NG K?? T???NG QU??T ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(psanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(lnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(pkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(pnhacc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lnhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(psanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnhacc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(262, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("T???ng", jPanel1);

        jPanel3.setBackground(new java.awt.Color(102, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Th???ng k?? b??n h??ng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(440, 440, 440))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tblDanhSach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M?? h??a ????n", "T??n nh??n vi??n", "T??n kh??ch h??ng", "T??n s???n ph???m", "Ng??y l???p", "S??? l?????ng", "????n gi??", "Th??nh ti???n"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSach.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tblDanhSach);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_data_backup_30px.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnSapXep.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSapXep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/sort-ascending_icon-icons.com_73158.png"))); // NOI18N
        btnSapXep.setText("S???p x???p theo th??nh ti???n");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        btnInThongKe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_ms_excel_30px.png"))); // NOI18N
        btnInThongKe.setText("In danh s??ch (Excel)");
        btnInThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInThongKeActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_exit_30px.png"))); // NOI18N
        btnBack.setText("K???t Th??c");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Th???ng k?? theo ng??y", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btnThongKeNgay.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThongKeNgay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_bar_chart_30px.png"))); // NOI18N
        btnThongKeNgay.setText("Th???ng k?? theo ng??y");
        btnThongKeNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeNgayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dateNgayThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThongKeNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dateNgayThongKe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThongKeNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Th???ng k?? theo ng??y", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Th??ng :");

        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("N??m :");

        btnThongKeThang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThongKeThang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_bar_chart_30px.png"))); // NOI18N
        btnThongKeThang.setText("Th???ng k?? theo th??ng");
        btnThongKeThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeThangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThongKeThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThongKeThang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel14)
                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnSapXep))
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnInThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        lblTongDoanhThu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTongDoanhThu.setText("T???ng ti???n: ");

        lblSLhoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSLhoaDon.setText("S??? l?????ng h??a ????n: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(lblSLhoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTongDoanhThu)
                .addGap(133, 133, 133))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSLhoaDon)
                    .addComponent(lblTongDoanhThu))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("B??n H??ng", jPanel2);

        tblDanhSach1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblDanhSach1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M?? phi???u nh???p", "T??n nh??n vi??n", "T??n nh?? cung c???p", "T??n s???n ph???m", "Ng??y l???p", "S??? l?????ng", "????n gi??", "Th??nh ti???n"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSach1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(tblDanhSach1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(102, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setText("Th???ng k?? nh???p h??ng");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(434, 434, 434)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel11)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnReset1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnReset1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_data_backup_30px.png"))); // NOI18N
        btnReset1.setText("Reset");
        btnReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset1ActionPerformed(evt);
            }
        });

        btnSapXep1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSapXep1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/sort-ascending_icon-icons.com_73158.png"))); // NOI18N
        btnSapXep1.setText("S???p x???p theo th??nh ti???n");
        btnSapXep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXep1ActionPerformed(evt);
            }
        });

        btnInThongKe1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInThongKe1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_ms_excel_30px.png"))); // NOI18N
        btnInThongKe1.setText("In danh s??ch (Excel)");
        btnInThongKe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInThongKe1ActionPerformed(evt);
            }
        });

        btnBack1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_exit_30px.png"))); // NOI18N
        btnBack1.setText("K???t Th??c");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Th???ng k?? theo ng??y", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        btnThongKeNgay1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThongKeNgay1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_bar_chart_30px.png"))); // NOI18N
        btnThongKeNgay1.setText("Th???ng k?? theo ng??y");
        btnThongKeNgay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeNgay1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dateNgayThongKe1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThongKeNgay1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateNgayThongKe1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThongKeNgay1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Th???ng k?? theo th??ng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Th??ng :");

        month1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        month1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                month1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("N??m :");

        year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year1ActionPerformed(evt);
            }
        });

        btnThongKeThang1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThongKeThang1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_bar_chart_30px.png"))); // NOI18N
        btnThongKeThang1.setText("Th???ng k?? theo th??ng");
        btnThongKeThang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeThang1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(month1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(year1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThongKeThang1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(month1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(btnThongKeThang1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btnSapXep1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(btnInThongKe1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset1)
                    .addComponent(btnSapXep1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInThongKe1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        lblSLhoaDon1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSLhoaDon1.setText("S??? l?????ng h??ng nh???p: ");

        lblTongDoanhThu1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTongDoanhThu1.setText("T???ng doanh thu: ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lblSLhoaDon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 571, Short.MAX_VALUE)
                .addComponent(lblTongDoanhThu1)
                .addGap(145, 145, 145))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSLhoaDon1)
                    .addComponent(lblTongDoanhThu1)))
        );

        jTabbedPane1.addTab("Nh???p H??ng", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThongKeNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeNgayActionPerformed
        // TODO add your handling code here:

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String ngayLap = dateFormat.format(dateNgayThongKe.getDate());
            int tongTT = 0;
            if (dateNgayThongKe.getDate() != null || dateNgayThongKe.equals("") == false) {
                cthdList = ThongKeDoanhSoController.findByDate(ngayLap);
                tableModel.setRowCount(0);
                for (ChiTietHoaDon cthd : cthdList) {
                    tableModel.addRow(new Object[]{
                        cthd.getMaHD(),
                        cthd.getTenNV(),
                        cthd.getTenKH(),
                        cthd.getTenSP(),
                        cthd.getNgayLap(),
                        cthd.getSoLuong(),
                        PriceFormatter.format(cthd.getDongia()),
                        PriceFormatter.format(cthd.getThanhTien())
                    });
                    PriceFormatter.format(tongTT += cthd.getThanhTien());
                    lblTongDoanhThu.setText("T???ng doanh thu: " + String.valueOf(PriceFormatter.format(tongTT)));
                }
                loadSoLuongHD();
            } if(tableModel.getRowCount() == 0)
            {
                loadData();
                loadSoLuongHD();
                loadTongTien();
                dateNgayThongKe.setDate(null);
                JOptionPane.showMessageDialog(this, "Kh??ng c?? d???u li???u, Vui l??ng ch???n th???i gian kh??c", "Th??ng B??o", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Ng??y th???ng k?? kh??ng ????? tr???ng!");
        }
    }//GEN-LAST:event_btnThongKeNgayActionPerformed

    private void btnInThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInThongKeActionPerformed

        FileOutputStream fileOutputStream = null;
        BufferedOutputStream outputStream = null;
        XSSFWorkbook workbook = null;

        //Ch???n ???????ng d???n ????? l??u file
        JFileChooser excelFileChooser = new JFileChooser("F:\\hocjava\\Baitaplon\\ProjectJava");
        //Thay ?????i ti??u ?????
        excelFileChooser.setDialogTitle("Save as");
        //Ch??? l??u d?????i d???ng c??c t???p tin n??y
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChoose = excelFileChooser.showSaveDialog(null);
        Cell cell;
        Row row;
        //check n???u file ???? ???????c ch???n
        if (excelChoose == JFileChooser.APPROVE_OPTION) {
            try {
                workbook = new XSSFWorkbook();
                XSSFSheet excelSheet = workbook.createSheet("JTable Sheet");

                int rowNum = 0;

                row = excelSheet.createRow(rowNum++);
                cell = row.createCell(0);
                cell.setCellValue("TH???NG K?? DANH S??CH HO?? ????N");

                row = excelSheet.createRow(rowNum++);

                cell = row.createCell(0);
                cell.setCellValue("M?? HO?? ????N");

                cell = row.createCell(1);
                cell.setCellValue("T??N NH??N VI??N");

                cell = row.createCell(2);
                cell.setCellValue("T??N KH??CH H??NG");

                cell = row.createCell(3);
                cell.setCellValue("T??N S???N PH???M");

                cell = row.createCell(4);
                cell.setCellValue("NG??Y L???P");

                cell = row.createCell(5);
                cell.setCellValue("S??? L?????NG");

                cell = row.createCell(6);
                cell.setCellValue("????N GI??");

                cell = row.createCell(7);
                cell.setCellValue("TH??NH TI???N");

                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(rowNum++);
                    for (int j = 0; j < tableModel.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(tableModel.getValueAt(i, j).toString());
                    }
                }

                fileOutputStream = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                outputStream = new BufferedOutputStream(fileOutputStream);
                workbook.write(outputStream);

                JOptionPane.showMessageDialog(rootPane, "Xu???t d??? li???u th??nh c??ng");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(rootPane, "???????ng d???n file kh??ng h???p l???");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException ex) {
                        Logger.getLogger(HomeThongKe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException ex) {
                        Logger.getLogger(HomeThongKe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (workbook != null) {
                    try {
                        workbook.close();
                    } catch (IOException ex) {
                        Logger.getLogger(HomeThongKe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnInThongKeActionPerformed

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
        // TODO add your handling code here:
        try {
            cthdList = ThongKeDoanhSoController.sortByTT();
            tableModel.setRowCount(0);
            for (ChiTietHoaDon cthd : cthdList) {
                tableModel.addRow(new Object[]{
                    cthd.getMaHD(),
                    cthd.getTenNV(),
                    cthd.getTenKH(),
                    cthd.getTenSP(),
                    cthd.getNgayLap(),
                    cthd.getSoLuong(),
                    PriceFormatter.format(cthd.getDongia()),
                    PriceFormatter.format(cthd.getThanhTien())
                });
            }
            loadSoLuongHD();
            loadTongTien();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Ch??a c?? d??? li???u ????? s???p x???p");
        }
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        dateNgayThongKe.setDate(null);
        try {
            loadData();
            loadSoLuongHD();
            loadTongTien();
            year.setText("");
            month.setSelectedItem("1");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Ch??a c?? d??? li???u");
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        int kq = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n k???t th??c kh??ng?", "Th??ng b??o", JOptionPane.YES_NO_OPTION);
        if (kq == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void lblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblSPMouseClicked

    private void lblkhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblkhMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblkhMouseClicked

    private void lblnvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblnvMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnvMouseClicked

    
      //th???ng k?? nh???p h??ng
    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        int kq = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n k???t th??c kh??ng?", "Th??ng b??o", JOptionPane.YES_NO_OPTION);
        if (kq == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset1ActionPerformed
        dateNgayThongKe1.setDate(null);
        try {
            loadData1();
            loadSoLuongHD1();
            loadTongTien1();
            year1.setText("");
            month1.setSelectedItem("1");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Ch??a c?? d??? li???u");
        }
    }//GEN-LAST:event_btnReset1ActionPerformed

    private void btnSapXep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXep1ActionPerformed
        // TODO add your handling code here:
        try {
            ctpnList = ThongKeNhapHangController.sortByTTPN();
            tableModel1.setRowCount(0);
            for (ChiTietPhieuNhap ctpn : ctpnList) {
                tableModel1.addRow(new Object[]{
                    ctpn.getMaPN(),
                    ctpn.getTenNV(),
                    ctpn.getTenNCC(),
                    ctpn.getTenSP(),
                    ctpn.getNgayNhap(),
                    ctpn.getSoLuong(),
                    PriceFormatter.format(ctpn.getDonGia()),
                    PriceFormatter.format(ctpn.getThanhTien())
                });
            }
            loadSoLuongHD1();
            loadTongTien1();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Ch??a c?? d??? li???u ????? s???p x???p");
        }
    }//GEN-LAST:event_btnSapXep1ActionPerformed

    private void btnInThongKe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInThongKe1ActionPerformed
        // TODO add your handling code here:
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream outputStream = null;
        XSSFWorkbook workbook = null;

        //Ch???n ???????ng d???n ????? l??u file
        JFileChooser excelFileChooser = new JFileChooser("F:\\hocjava\\Baitaplon\\ProjectJava");
        //Thay ?????i ti??u ?????
        excelFileChooser.setDialogTitle("Save as");
        //Ch??? l??u d?????i d???ng c??c t???p tin n??y
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChoose = excelFileChooser.showSaveDialog(null);
        Cell cell;
        Row row;
        //check n???u file ???? ???????c ch???n
        if (excelChoose == JFileChooser.APPROVE_OPTION) {
            try {
                workbook = new XSSFWorkbook();
                XSSFSheet excelSheet = workbook.createSheet("JTable Sheet");

                int rowNum = 0;

                row = excelSheet.createRow(rowNum++);
                cell = row.createCell(0);
                cell.setCellValue("TH???NG K?? DANH S??CH Nh???p H??ng");

                row = excelSheet.createRow(rowNum++);

                cell = row.createCell(0);
                cell.setCellValue("M?? PHI???U NH???P");

                cell = row.createCell(1);
                cell.setCellValue("T??N NH??N VI??N");

                cell = row.createCell(2);
                cell.setCellValue("T??N NH?? CUNG C???P");

                cell = row.createCell(3);
                cell.setCellValue("T??N S???N PH???M");

                cell = row.createCell(4);
                cell.setCellValue("NG??Y NH???P");

                cell = row.createCell(5);
                cell.setCellValue("S??? L?????NG");

                cell = row.createCell(6);
                cell.setCellValue("????N GI??");

                cell = row.createCell(7);
                cell.setCellValue("TH??NH TI???N");

                for (int i = 0; i < tableModel1.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(rowNum++);
                    for (int j = 0; j < tableModel1.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(tableModel1.getValueAt(i, j).toString());
                    }
                }

                fileOutputStream = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                outputStream = new BufferedOutputStream(fileOutputStream);
                workbook.write(outputStream);

                JOptionPane.showMessageDialog(rootPane, "Xu???t d??? li???u th??nh c??ng");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(rootPane, "???????ng d???n file kh??ng h???p l???");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException ex) {
                        Logger.getLogger(HomeThongKe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException ex) {
                        Logger.getLogger(HomeThongKe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (workbook != null) {
                    try {
                        workbook.close();
                    } catch (IOException ex) {
                        Logger.getLogger(HomeThongKe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnInThongKe1ActionPerformed

    private void btnThongKeNgay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeNgay1ActionPerformed
        // TODO add your handling code here:
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String ngayLap = dateFormat.format(dateNgayThongKe1.getDate());
            int tongTT = 0;
            if (dateNgayThongKe1.getDate() != null || dateNgayThongKe1.equals("") == false) {
                ctpnList = ThongKeNhapHangController.findByDatePN(ngayLap);
                tableModel1.setRowCount(0);
                for (ChiTietPhieuNhap ctpn : ctpnList) {
                    tableModel1.addRow(new Object[]{
                         ctpn.getMaPN(),
                         ctpn.getTenNV(),
                         ctpn.getTenNCC(),
                         ctpn.getTenSP(),
                         ctpn.getNgayNhap(),
                         ctpn.getSoLuong(),
                         PriceFormatter.format(ctpn.getDonGia()),
                         PriceFormatter.format(ctpn.getThanhTien()) 
                    });
                    PriceFormatter.format(tongTT += ctpn.getThanhTien());
                    lblTongDoanhThu1.setText("T???ng s??? ti???n: " + String.valueOf(PriceFormatter.format(tongTT)));
                }
                loadSoLuongHD1();
            }if(tableModel1.getRowCount() == 0)
            {
                loadData1();
                loadSoLuongHD1();
                loadTongTien1();
                dateNgayThongKe1.setDate(null);
                JOptionPane.showMessageDialog(this, "Kh??ng c?? d???u li???u, Vui l??ng ch???n th???i gian kh??c", "Th??ng B??o", JOptionPane.ERROR_MESSAGE);   
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Ng??y th???ng k?? kh??ng ????? tr???ng!");
        }
    }//GEN-LAST:event_btnThongKeNgay1ActionPerformed

    private void btnThongKeThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeThangActionPerformed
        // TODO add your handling code here:
        try {
            String ngayLap = month.getSelectedItem().toString();
            String ngayLap1 = year.getText().toString().trim();
            int tongTT = 0;
            if(year.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "B???n ch??a nh???p n??m", "Th??ng B??o", JOptionPane.ERROR_MESSAGE);
            }else
            if (month.getSelectedItem().toString() != null || month.equals("") == false && year.getText().toString().trim()!=null) {
                cthdList = ThongKeDoanhSoController.findByMonth(ngayLap,ngayLap1);
                tableModel.setRowCount(0);
                for (ChiTietHoaDon cthd : cthdList) {
                    tableModel.addRow(new Object[]{
                        cthd.getMaHD(),
                        cthd.getTenNV(),
                        cthd.getTenKH(),
                        cthd.getTenSP(),
                        cthd.getNgayLap(),
                        cthd.getSoLuong(),
                        PriceFormatter.format(cthd.getDongia()),
                        PriceFormatter.format(cthd.getThanhTien())
                    });
                    PriceFormatter.format(tongTT += cthd.getThanhTien());
                    lblTongDoanhThu.setText("T???ng doanh thu: " + String.valueOf(PriceFormatter.format(tongTT)));
                }
                loadSoLuongHD();
                
                
            }if(tableModel.getRowCount() == 0)
            {
                loadData();
                loadSoLuongHD();
                loadTongTien();
                year.setText("");
                month.setSelectedItem("1");
                JOptionPane.showMessageDialog(this, "Kh??ng c?? d???u li???u, Vui l??ng ch???n th???i gian kh??c", "Th??ng B??o", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Ng??y th???ng k?? kh??ng ????? tr???ng!");
        }
    }//GEN-LAST:event_btnThongKeThangActionPerformed

    private void btnThongKeThang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeThang1ActionPerformed
        // TODO add your handling code here:
        try {
            String ngayLap = month1.getSelectedItem().toString();
            String ngayLap1 = year1.getText().toString().trim();
            int tongTT = 0;
            if(year1.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "B???n ch??a nh???p n??m", "Th??ng B??o", JOptionPane.ERROR_MESSAGE);
            }else
            if (month1.getSelectedItem().toString() != null || month1.equals("") ==false && year1.getText().toString().trim()!=null) {
                ctpnList = ThongKeNhapHangController.findByMonthPN(ngayLap,ngayLap1);
                tableModel1.setRowCount(0);
                for (ChiTietPhieuNhap ctpn : ctpnList) {
                    tableModel1.addRow(new Object[]{
                         ctpn.getMaPN(),
                         ctpn.getTenNV(),
                         ctpn.getTenNCC(),
                         ctpn.getTenSP(),
                         ctpn.getNgayNhap(),
                         ctpn.getSoLuong(),
                         PriceFormatter.format(ctpn.getDonGia()),
                         PriceFormatter.format(ctpn.getThanhTien()) 
                    });
                    PriceFormatter.format(tongTT += ctpn.getThanhTien());
                    lblTongDoanhThu1.setText("T???ng s??? ti???n: " + String.valueOf(PriceFormatter.format(tongTT)));
                    
                }
                loadSoLuongHD1();
                
            }if(tableModel1.getRowCount() == 0)
            {
                loadData1();
                loadSoLuongHD1();
                loadTongTien1();
                year1.setText("");
                month1.setSelectedItem("1");
                JOptionPane.showMessageDialog(this, "Kh??ng c?? d???u li???u, Vui l??ng ch???n th???i gian kh??c", "Th??ng B??o", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Ng??y th???ng k?? kh??ng ????? tr???ng!");
        }
    }//GEN-LAST:event_btnThongKeThang1ActionPerformed

    private void month1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_month1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_month1ActionPerformed

    private void year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_year1ActionPerformed

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnInThongKe;
    private javax.swing.JButton btnInThongKe1;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnReset1;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JButton btnSapXep1;
    private javax.swing.JButton btnThongKeNgay;
    private javax.swing.JButton btnThongKeNgay1;
    private javax.swing.JButton btnThongKeThang;
    private javax.swing.JButton btnThongKeThang1;
    private com.toedter.calendar.JDateChooser dateNgayThongKe;
    private com.toedter.calendar.JDateChooser dateNgayThongKe1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblSLhoaDon;
    private javax.swing.JLabel lblSLhoaDon1;
    private javax.swing.JLabel lblSP;
    private javax.swing.JLabel lblTongDoanhThu;
    private javax.swing.JLabel lblTongDoanhThu1;
    private javax.swing.JLabel lblkh;
    private javax.swing.JLabel lblncc;
    private javax.swing.JLabel lblnv;
    private javax.swing.JPanel lnhanvien;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JComboBox<String> month1;
    private javax.swing.JPanel pkhachhang;
    private javax.swing.JPanel pnhacc;
    private javax.swing.JPanel psanpham;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTable tblDanhSach1;
    private javax.swing.JTextField year;
    private javax.swing.JTextField year1;
    // End of variables declaration//GEN-END:variables
}

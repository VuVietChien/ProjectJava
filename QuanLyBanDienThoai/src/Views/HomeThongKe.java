/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.ThongKeDoanhSo_Controller;
import Models.ChiTietHoaDon;
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
    
    List<ThongKe> tkList = new ArrayList<>();
    List<SanPham1> tksp = new ArrayList<>();
    List<NhanVien> tknv = new ArrayList<>();
    List<KhachHang> tkkh = new ArrayList<>();
    List<NhaCungCap> tkncc = new ArrayList<>();
    
    DefaultTableModel tableModel;
    public HomeThongKe() {
        initComponents();
        setResizable(false);
        //setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) tblDanhSach.getModel();
        try {
            loadData();
            loadTongTien();
            loadSoLuongHD();
            loadSP();
            loadNV();
            loadKH();
            loadNCC();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Chưa có dữ liệu để thống kê");
        }
    }

    private void loadData() {
        cthdList = ThongKeDoanhSo_Controller.layNguon();
        tableModel.setRowCount(0);
         cthdList.forEach(p ->{
            tableModel.addRow(new Object[]{
                p.getMaHD(),
                p.getMaNV(),
                p.getTenNV(),
                p.getMaKH(),
                p.getNgayLap(),
                PriceFormatter.format(p.getThanhTien()) 
            });
        });
         
    }
    
    
    private void loadSoLuongHD() {
        int n = tableModel.getRowCount();
        lblSLhoaDon.setText("Số lượng hóa đơn: " + String.valueOf(n));
    }
    

    private void loadTongTien() {
        tkList = ThongKeDoanhSo_Controller.getTongTien();
        for(ThongKe tk : tkList){
            lblTongDoanhThu.setText("Tổng doanh thu: " +PriceFormatter.format(tk.getThanhTien()) );
        }
    }
    
    //thống kê tổng quát
    private void loadSP() {
        tksp = ThongKeDoanhSo_Controller.getTongSP();
        for(SanPham1 tk : tksp){
            lblSP.setText(" " +String.valueOf(tk.getMaSP()) );
        }
    }
     private void loadNV() {
        tknv = ThongKeDoanhSo_Controller.getTongNV();
        for(NhanVien nv : tknv){
            lblnv.setText(" " +String.valueOf(nv.getMaNV()) );
        }
    }
    private void loadKH() {
        tkkh = ThongKeDoanhSo_Controller.getTongKH();
        for(KhachHang kh : tkkh){
            lblkh.setText(" " +String.valueOf(kh.getMaKHString()) );
        }
    }
     private void loadNCC() {
        tkncc = ThongKeDoanhSo_Controller.getTongNCC();
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
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        btnSapXep = new javax.swing.JButton();
        btnInThongKe = new javax.swing.JButton();
        dateNgayThongKe = new com.toedter.calendar.JDateChooser();
        btnThongKeNgay = new javax.swing.JButton();
        lblTongDoanhThu = new javax.swing.JLabel();
        lblSLhoaDon = new javax.swing.JLabel();

        lnhanvien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));

        lblnv.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblnvMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_assistant_100px.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Nhân Viên");

        javax.swing.GroupLayout lnhanvienLayout = new javax.swing.GroupLayout(lnhanvien);
        lnhanvien.setLayout(lnhanvienLayout);
        lnhanvienLayout.setHorizontalGroup(
            lnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lnhanvienLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        jLabel9.setText("Khách Hàng");

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
        jLabel10.setText("Nhà Cung Cấp");

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
        jLabel7.setText("Sản Phẩm");

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
        jLabel5.setText("TỔNG QUÁT HÓA ĐƠN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(psanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(pkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(pnhacc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(282, 282, 282))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lnhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(psanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnhacc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(188, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tổng", jPanel1);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Thống kê doanh số");

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBack.setText("Quay lại menu");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(348, 348, 348))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBack))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        tblDanhSach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Mã nhân viên", "Tên nhân viên", "Mã khách hàng", "Ngày lập", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSach.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tblDanhSach);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnSapXep.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSapXep.setText("Sắp xếp theo thành tiền");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        btnInThongKe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInThongKe.setText("In danh sách (Excel)");
        btnInThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInThongKeActionPerformed(evt);
            }
        });

        dateNgayThongKe.setDateFormatString("");

        btnThongKeNgay.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThongKeNgay.setText("Thống kê theo ngày");
        btnThongKeNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeNgayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(dateNgayThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnThongKeNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addComponent(btnSapXep)
                .addGap(52, 52, 52)
                .addComponent(btnInThongKe)
                .addGap(40, 40, 40))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThongKeNgay)
                        .addComponent(btnReset)
                        .addComponent(btnSapXep)
                        .addComponent(btnInThongKe))
                    .addComponent(dateNgayThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTongDoanhThu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTongDoanhThu.setText("Tổng doanh thu: ");

        lblSLhoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSLhoaDon.setText("Số lượng hóa đơn: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(lblSLhoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTongDoanhThu)
                        .addGap(77, 77, 77)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSLhoaDon)
                    .addComponent(lblTongDoanhThu))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hóa Đơn", jPanel2);

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

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        dateNgayThongKe.setDate(null);
        try {
            loadData();
            loadSoLuongHD();
            loadTongTien();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Chưa có dữ liệu");
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
        // TODO add your handling code here:
        try {
            cthdList = ThongKeDoanhSo_Controller.sortByTT();
            tableModel.setRowCount(0);
            for (ChiTietHoaDon cthd : cthdList) {
                tableModel.addRow(new Object[]{
                    cthd.getMaHD(),
                    cthd.getMaNV(),
                    cthd.getTenNV(),
                    cthd.getMaKH(),
                    cthd.getNgayLap(),
                    PriceFormatter.format(cthd.getThanhTien())
                });
            }
            loadSoLuongHD();
            loadTongTien();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Chưa có dữ liệu để sắp xếp");
        }
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void btnInThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInThongKeActionPerformed

                FileOutputStream fileOutputStream = null;
                BufferedOutputStream outputStream = null;
                XSSFWorkbook workbook = null;
        
                //Chọn đường dẫn để lưu file
                JFileChooser excelFileChooser = new JFileChooser("F:\\hocjava\\Baitaplon\\ProjectJava");
                //Thay đổi tiêu đề
                excelFileChooser.setDialogTitle("Save as");
                //Chỉ lưu dưới dạng các tập tin này
                FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
                excelFileChooser.setFileFilter(fnef);
                int excelChoose = excelFileChooser.showSaveDialog(null);
                Cell cell;
                Row row;
                //check nếu file đã được chọn
                if (excelChoose == JFileChooser.APPROVE_OPTION) {
                        try {
                                workbook = new XSSFWorkbook();
                                XSSFSheet excelSheet = workbook.createSheet("JTable Sheet");
                
                                int rowNum = 0;
                
                                row = excelSheet.createRow(rowNum++);
                                cell = row.createCell(0);
                                cell.setCellValue("THỐNG KÊ DANH SÁCH HOÁ ĐƠN");
                
                                row = excelSheet.createRow(rowNum++);
                
                                cell = row.createCell(0);
                                cell.setCellValue("MÃ HOÁ ĐƠN");
                
                                cell = row.createCell(1);
                                cell.setCellValue("MÃ NHÂN VIÊN");
                
                                cell = row.createCell(2);
                                cell.setCellValue("TÊN NHÂN VIÊN");
                
                                cell = row.createCell(3);
                                cell.setCellValue("MÃ KHÁCH HÀNG");
                
                                cell = row.createCell(4);
                                cell.setCellValue("NGÀY LẬP");
                
                                cell = row.createCell(5);
                                cell.setCellValue("THÀNH TIỀN");
                
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
                
                                JOptionPane.showMessageDialog(rootPane, "Xuất dữ liệu thành công");
                            } catch (FileNotFoundException ex) {
                                JOptionPane.showMessageDialog(rootPane, "Đường dẫn file không hợp lệ");
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

    private void btnThongKeNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeNgayActionPerformed
        // TODO add your handling code here:

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String ngayLap = dateFormat.format(dateNgayThongKe.getDate());
            int tongTT = 0;
            if (dateNgayThongKe.getDate() != null || dateNgayThongKe.equals("") == false) {
                cthdList = ThongKeDoanhSo_Controller.findByDate(ngayLap);
                tableModel.setRowCount(0);
                for (ChiTietHoaDon cthd : cthdList) {
                    tableModel.addRow(new Object[]{
                        cthd.getMaHD(),
                        cthd.getMaNV(),
                        cthd.getTenNV(),
                        cthd.getMaKH(),
                        cthd.getNgayLap(),
                        cthd.getThanhTien()
                    });
                    PriceFormatter.format(tongTT += cthd.getThanhTien());
                    lblTongDoanhThu.setText("Tổng doanh thu: " + String.valueOf(PriceFormatter.format(tongTT)));
                }
                loadSoLuongHD();
            } else {
                loadData();
                loadTongTien();
                loadSoLuongHD();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Ngày thống kê không để trống!");
        }
    }//GEN-LAST:event_btnThongKeNgayActionPerformed

    private void lblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblSPMouseClicked

    private void lblnvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblnvMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnvMouseClicked

    private void lblkhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblkhMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblkhMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnInThongKe;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JButton btnThongKeNgay;
    private com.toedter.calendar.JDateChooser dateNgayThongKe;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblSLhoaDon;
    private javax.swing.JLabel lblSP;
    private javax.swing.JLabel lblTongDoanhThu;
    private javax.swing.JLabel lblkh;
    private javax.swing.JLabel lblncc;
    private javax.swing.JLabel lblnv;
    private javax.swing.JPanel lnhanvien;
    private javax.swing.JPanel pkhachhang;
    private javax.swing.JPanel pnhacc;
    private javax.swing.JPanel psanpham;
    private javax.swing.JTable tblDanhSach;
    // End of variables declaration//GEN-END:variables
}

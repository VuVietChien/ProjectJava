/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.TaiKhoanController;
import Models.TaiKhoan;
import helpers.SharedData;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author viết chiến
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    List<TaiKhoan> listTaiKhoan = new ArrayList<>();
    public String tentaikhoan;

    public Menu() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        processLoginSuccessful();
        listTaiKhoan = TaiKhoanController.Select();
    }

    // phan quyen tai khoan
    private void processLoginSuccessful() {
        lbLoginName.setText(SharedData.nguoiDangNhap.getTenTaiKhoan());
        lbRole.setText(SharedData.nguoiDangNhap.getTenQuyen());
        if (SharedData.nguoiDangNhap.getTenQuyen().equalsIgnoreCase("Nhân viên thống kê")) {
            lbSanPham.setVisible(false);
            lbTaiKhoan.setVisible(false);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        Desktop = new javax.swing.JDesktopPane();
        jPanel9 = new javax.swing.JPanel();
        lbLoginName = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JLabel();
        lbRole = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lbBanHang = new javax.swing.JLabel();
        lbNhapHang = new javax.swing.JLabel();
        lbLoaiSP = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbHoaDon = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lbNhanVien = new javax.swing.JLabel();
        lbKhachHang = new javax.swing.JLabel();
        lbSanPham = new javax.swing.JLabel();
        LbNhaCC = new javax.swing.JLabel();
        lbThongKe = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lbTaiKhoan = new javax.swing.JLabel();
        lbQuyen = new javax.swing.JLabel();
        lbDoiMatKhau = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(795, 425));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        title.setBackground(new java.awt.Color(0, 0, 0));
        title.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("                               Siêu Thị Điện Thoại");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Desktop))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Desktop))
        );

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));

        lbLoginName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLoginName.setForeground(new java.awt.Color(255, 255, 255));
        lbLoginName.setText("Admin");

        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_exit_30px.png"))); // NOI18N
        btnLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogOutMouseClicked(evt);
            }
        });

        lbRole.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbRole.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbLoginName, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lbLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33))))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lbBanHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbBanHang.setForeground(new java.awt.Color(255, 255, 255));
        lbBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_small_business_30px_3.png"))); // NOI18N
        lbBanHang.setText("Bán hàng");

        lbNhapHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNhapHang.setForeground(new java.awt.Color(255, 255, 255));
        lbNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_downloads_30px.png"))); // NOI18N
        lbNhapHang.setText("Nhập hàng");

        lbLoaiSP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLoaiSP.setForeground(new java.awt.Color(255, 255, 255));
        lbLoaiSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_small_business_30px_3.png"))); // NOI18N
        lbLoaiSP.setText("Loại Sản Phẩm");
        lbLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLoaiSPMouseClicked(evt);
            }
        });

        lbHoaDon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lbHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_agreement_30px.png"))); // NOI18N
        lbHoaDon.setText("Hóa Đơn");
        lbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHoaDonMouseClicked(evt);
            }
        });

        lbNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lbNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_assistant_30px.png"))); // NOI18N
        lbNhanVien.setText("Nhân Viên ");
        lbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNhanVienMouseClicked(evt);
            }
        });

        lbKhachHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        lbKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_user_30px.png"))); // NOI18N
        lbKhachHang.setText("Khách Hàng");
        lbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbKhachHangMouseClicked(evt);
            }
        });

        lbSanPham.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbSanPham.setForeground(new java.awt.Color(255, 255, 255));
        lbSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_multiple_smartphones_30px.png"))); // NOI18N
        lbSanPham.setText("Sản Phẩm");
        lbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSanPhamMouseClicked(evt);
            }
        });

        LbNhaCC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LbNhaCC.setForeground(new java.awt.Color(255, 255, 255));
        LbNhaCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_company_30px.png"))); // NOI18N
        LbNhaCC.setText("Nhà Cung Cấp");

        lbThongKe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lbThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_futures_30px.png"))); // NOI18N
        lbThongKe.setText("Thống kê");
        lbThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbThongKeMouseClicked(evt);
            }
        });

        lbTaiKhoan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        lbTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_key_30px.png"))); // NOI18N
        lbTaiKhoan.setText("Tài Khoản");
        lbTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTaiKhoanMouseClicked(evt);
            }
        });

        lbQuyen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbQuyen.setForeground(new java.awt.Color(255, 255, 255));
        lbQuyen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_police_badge_30px.png"))); // NOI18N
        lbQuyen.setText("Quyền");
        lbQuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQuyenMouseClicked(evt);
            }
        });

        lbDoiMatKhau.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbDoiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        lbDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_password_30px_2.png"))); // NOI18N
        lbDoiMatKhau.setText("Đổi Mật Khẩu");
        lbDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDoiMatKhauMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(lbQuyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLoaiSP)
                            .addComponent(lbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LbNhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lbNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbThongKe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                            .addComponent(lbTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LbNhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBounds(0, 0, 789, 825);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseClicked
        // TODO add your handling code here:
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (kq == JOptionPane.YES_OPTION) {
            dispose();
            JFrame dangnhap = new dangnhap();
            dangnhap.setVisible(true);
        }

    }//GEN-LAST:event_btnLogOutMouseClicked

    private void lbLoaiSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLoaiSPMouseClicked
        // TODO add your handling code here:
        Desktop.removeAll();
        mdiLoaiSanPham qlsp = new mdiLoaiSanPham();
        Desktop.add(qlsp).setVisible(true);
        qlsp.setLocation((Desktop.getWidth() - qlsp.getWidth()) / 2, (Desktop.getHeight() - qlsp.getHeight()) / 2);
    }//GEN-LAST:event_lbLoaiSPMouseClicked

    private void lbDoiMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDoiMatKhauMouseClicked
        Desktop.removeAll();
        DoiMatKhau qlsp = new DoiMatKhau();
        Desktop.add(qlsp).setVisible(true);
        qlsp.setLocation((Desktop.getWidth() - qlsp.getWidth()) / 2, (Desktop.getHeight() - qlsp.getHeight()) / 2);
    }//GEN-LAST:event_lbDoiMatKhauMouseClicked

    private void lbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSanPhamMouseClicked
        // TODO add your handling code here:
        Desktop.removeAll();
        mdiSanPham1 qlsp = new mdiSanPham1();
        Desktop.add(qlsp).setVisible(true);
        qlsp.setLocation((Desktop.getWidth() - qlsp.getWidth()) / 2, (Desktop.getHeight() - qlsp.getHeight()) / 2);
    }//GEN-LAST:event_lbSanPhamMouseClicked

    private void lbTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTaiKhoanMouseClicked
        // TODO add your handling code here:
        Desktop.removeAll();
        QuanLyTaiKhoan qlsp = new QuanLyTaiKhoan();
        Desktop.add(qlsp).setVisible(true);
        qlsp.setLocation((Desktop.getWidth() - qlsp.getWidth()) / 2, (Desktop.getHeight() - qlsp.getHeight()) / 2);
    }//GEN-LAST:event_lbTaiKhoanMouseClicked

    private void lbThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbThongKeMouseClicked
        Desktop.removeAll();
        QuanLyThongKe qlsp = new QuanLyThongKe();
        Desktop.add(qlsp).setVisible(true);
        qlsp.setLocation((Desktop.getWidth() - qlsp.getWidth()) / 2, (Desktop.getHeight() - qlsp.getHeight()) / 2);
    }//GEN-LAST:event_lbThongKeMouseClicked

    private void lbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNhanVienMouseClicked
        Desktop.removeAll();
        QuanLyNhanVien1 qlsp = new QuanLyNhanVien1();
        Desktop.add(qlsp).setVisible(true);
        qlsp.setLocation((Desktop.getWidth() - qlsp.getWidth()) / 2, (Desktop.getHeight() - qlsp.getHeight()) / 2);

        // TODO add your handling code here:
    }//GEN-LAST:event_lbNhanVienMouseClicked

    private void lbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbKhachHangMouseClicked
        Desktop.removeAll();
        QuanLyKhachHang qlsp = new QuanLyKhachHang();
        Desktop.add(qlsp).setVisible(true);
        qlsp.setLocation((Desktop.getWidth() - qlsp.getWidth()) / 2, (Desktop.getHeight() - qlsp.getHeight()) / 2);

        // TODO add your handling code here:
    }//GEN-LAST:event_lbKhachHangMouseClicked


    private void lbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHoaDonMouseClicked

        Desktop.removeAll();
        QuanLyHoaDon qlsp = new QuanLyHoaDon();
        Desktop.add(qlsp).setVisible(true);
        qlsp.setLocation((Desktop.getWidth() - qlsp.getWidth()) / 2, (Desktop.getHeight() - qlsp.getHeight()) / 2);

        // TODO add your handling code here:
    }//GEN-LAST:event_lbHoaDonMouseClicked

    private void lbQuyenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQuyenMouseClicked
        // TODO add your handling code here:
        Desktop.removeAll();
        mdiPhanQuyen qlsp = new mdiPhanQuyen();
        Desktop.add(qlsp).setVisible(true);
        qlsp.setLocation((Desktop.getWidth() - qlsp.getWidth()) / 2, (Desktop.getHeight() - qlsp.getHeight()) / 2);
    }//GEN-LAST:event_lbQuyenMouseClicked


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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JLabel LbNhaCC;
    private javax.swing.JLabel btnLogOut;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbBanHang;
    private javax.swing.JLabel lbDoiMatKhau;
    private javax.swing.JLabel lbHoaDon;
    private javax.swing.JLabel lbKhachHang;
    private javax.swing.JLabel lbLoaiSP;
    private javax.swing.JLabel lbLoginName;
    private javax.swing.JLabel lbNhanVien;
    private javax.swing.JLabel lbNhapHang;
    private javax.swing.JLabel lbQuyen;
    private javax.swing.JLabel lbRole;
    private javax.swing.JLabel lbSanPham;
    private javax.swing.JLabel lbTaiKhoan;
    private javax.swing.JLabel lbThongKe;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}

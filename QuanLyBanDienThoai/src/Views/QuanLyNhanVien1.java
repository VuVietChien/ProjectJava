/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.NhanVienController;
import Models.NhanVien;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class QuanLyNhanVien1 extends javax.swing.JInternalFrame {

    DefaultTableModel tbl;
    List<NhanVien> listTaiKhoan = new ArrayList<>();
    public String makh, tenkh, diachi, sdt, ngaysinh, macu;
    private boolean ktThem;

    public QuanLyNhanVien1() {
        initComponents();
        tbl = (DefaultTableModel) dgDanhSachTaiKhoan.getModel();
        LayNguon();
        Design();
    }

    public void KhoaMo(boolean b) {
        btnThem.setEnabled(b);
        btnSua.setEnabled(b);
        btnXoa.setEnabled(b);
        btnKetThuc.setEnabled(b);
        btnGhi.setEnabled(!b);
        btnKhong.setEnabled(!b);
        txtMaNV.setEditable(!b);
        txtTenkh.setEditable(!b);
        txtSDT.setEditable(!b);
        txtTenkh.setEditable(!b);
        txtNgaySinh.setEditable(!b);
        dgDanhSachTaiKhoan.setEnabled(b);
    }

    public void XoaTrang() {
        txtMaNV.setText("");
        txtTenkh.setText("");
        txtSDT.setText("");
        txtDiaChi.setText("");
        txtNgaySinh.setText("");
    }

    public void Design() {
        dgDanhSachTaiKhoan.setAutoResizeMode(dgDanhSachTaiKhoan.AUTO_RESIZE_OFF);
        dgDanhSachTaiKhoan.getColumnModel().getColumn(0).setPreferredWidth(100);
        dgDanhSachTaiKhoan.getColumnModel().getColumn(1).setPreferredWidth(100);
        dgDanhSachTaiKhoan.getColumnModel().getColumn(2).setPreferredWidth(100);
        dgDanhSachTaiKhoan.getColumnModel().getColumn(3).setPreferredWidth(100);
        dgDanhSachTaiKhoan.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    public void LayNguon() {
        listTaiKhoan = NhanVienController.LayNguonNganh();
        tbl.setRowCount(0);//xóa trắng danh sách
        listTaiKhoan.forEach(p -> {//mỗi vòng lặp add 1 dòng
            tbl.addRow(new Object[]{
                p.getMaNV(), p.getTenNV(), p.getNgaySinh(), p.getDiaChi(), p.getSDT()

            });
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        dgDanhSachTaiKhoan = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLaMaNV = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLaTenKH = new javax.swing.JLabel();
        JLaDiaChi = new javax.swing.JLabel();
        jLaSDT = new javax.swing.JLabel();
        txtTenkh = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnKetThuc = new javax.swing.JButton();
        btnKhong = new javax.swing.JButton();
        btnGhi = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtNgaySinh = new javax.swing.JTextField();
        jLNgaySinh = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();

        dgDanhSachTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Tên Nhân Viên", "Ngày Sinh", "Địa chỉ", "Số điện thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dgDanhSachTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgDanhSachTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(dgDanhSachTaiKhoan);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLaMaNV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLaMaNV.setText("Mã Nhân Viên:");

        jLaTenKH.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLaTenKH.setText("Tên Nhân Viên:");

        JLaDiaChi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JLaDiaChi.setText("Địa chỉ:");

        jLaSDT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLaSDT.setText("Số điện thoại:");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa ");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnKetThuc.setText("Kết thúc");
        btnKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucActionPerformed(evt);
            }
        });

        btnKhong.setText("Không");
        btnKhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhongActionPerformed(evt);
            }
        });

        btnGhi.setText("Ghi");
        btnGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiActionPerformed(evt);
            }
        });

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLNgaySinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLNgaySinh.setText("Ngày Sinh:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLaMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLaTenKH)
                            .addComponent(jLaSDT)
                            .addComponent(JLaDiaChi)
                            .addComponent(jLNgaySinh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                            .addComponent(txtTenkh)
                            .addComponent(txtSDT)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiem)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnGhi, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnKhong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKetThuc)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLaMaNV)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLaTenKH)
                    .addComponent(txtTenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLaDiaChi)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLaSDT)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLNgaySinh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset)
                    .addComponent(btnGhi)
                    .addComponent(btnKhong)
                    .addComponent(btnKetThuc))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dgDanhSachTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgDanhSachTaiKhoanMouseClicked
        // TODO add your handling code here:
        int index = dgDanhSachTaiKhoan.getSelectedRow();
        TableModel model = dgDanhSachTaiKhoan.getModel();
        makh = model.getValueAt(index, 0).toString();
        tenkh = model.getValueAt(index, 1).toString();
        ngaysinh = model.getValueAt(index, 2).toString();
        diachi = model.getValueAt(index, 3).toString();
         sdt= model.getValueAt(index, 4).toString();

        txtMaNV.setText(makh);
        txtTenkh.setText(tenkh);
        txtSDT.setText(sdt);
        txtDiaChi.setText(diachi);
        txtNgaySinh.setText(ngaysinh);
    }//GEN-LAST:event_dgDanhSachTaiKhoanMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        XoaTrang();
        KhoaMo(false);
        ktThem = true;
        txtMaNV.requestFocus();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (txtMaNV.getText().length() <= 0) {
            return;
        }
        macu = txtMaNV.getText();
        KhoaMo(false);
        ktThem = false;
        txtMaNV.requestFocus();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
    if (txtMaNV.getText().length() <= 0) {
            return;
        }
        int kq = JOptionPane.showConfirmDialog(this, "bạn có muốn xóa [" + txtMaNV.getText() + "] không ?",
                "thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (kq == JOptionPane.YES_OPTION) {
            macu = txtMaNV.getText();
            NhanVienController.XoaNganh(macu);
            XoaTrang();
            LayNguon();

        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucActionPerformed
        // TODO add your handling code here:
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn kết thúc không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (kq == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnKetThucActionPerformed

    private void btnKhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhongActionPerformed
        // TODO add your handling code here:
        XoaTrang();
        KhoaMo(true);
    }//GEN-LAST:event_btnKhongActionPerformed

    private void btnGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiActionPerformed
        if (txtMaNV.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "bạn chưa nhập mã nhân viên", "thông báo", JOptionPane.WARNING_MESSAGE);
            txtMaNV.requestFocus();
            return;
        }

        //
        if (txtTenkh.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "bạn chưa nhập tên nhân viên", "thông báo", JOptionPane.WARNING_MESSAGE);
            txtTenkh.requestFocus();
            return;
        }

          if (txtNgaySinh.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "bạn chưa nhập ngày sinh", "thông báo", JOptionPane.WARNING_MESSAGE);
            txtNgaySinh.requestFocus();
            return;
        }
        
        
        if (txtSDT.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "bạn chưa nhập số điện thoại", "thông báo", JOptionPane.WARNING_MESSAGE);
            txtSDT.requestFocus();
            return;
        }

        if (txtDiaChi.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "bạn chưa nhập địa chỉ", "thông báo", JOptionPane.WARNING_MESSAGE);
            txtDiaChi.requestFocus();
            return;
        }
        //kieemr tra trung ma
        if (NhanVienController.KiemTraTrungMa(txtMaNV.getText(), ktThem, macu) == true) {
            JOptionPane.showMessageDialog(this, "bạn nhập trùng mã đã có", "thông báo", JOptionPane.ERROR_MESSAGE);
            txtMaNV.requestFocus();
            return;
        }

        //ghi
        makh = txtMaNV.getText();
        tenkh = txtTenkh.getText();
        sdt = txtSDT.getText();
        diachi = txtTenkh.getText();
        ngaysinh=txtNgaySinh.getText();
        //
        NhanVien d = new NhanVien(makh, tenkh, ngaysinh,diachi,sdt);
        if (ktThem == true) {
            NhanVienController.ThemNganh(d);
        } else {
            NhanVienController.CapNhatNganh(d, macu);
        }
        // TODO add your handling code here:
        LayNguon();
        KhoaMo(true);
    }//GEN-LAST:event_btnGhiActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String tentk = JOptionPane.showInputDialog(this, "Nhập tên tài khoản cần tìm");
        if (tentk != null && tentk.length() > 0) {
            listTaiKhoan = NhanVienController.TimKiemTheoTenTaiKhoan(tentk);
            tbl.setRowCount(0);
            listTaiKhoan.forEach(p -> {
                tbl.addRow(new Object[]{
                   p.getMaNV(), p.getTenNV(), p.getNgaySinh(), p.getDiaChi(), p.getSDT()});
            });
        } else {
            LayNguon();
            XoaTrang();
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLaDiaChi;
    private javax.swing.JButton btnGhi;
    private javax.swing.JButton btnKetThuc;
    private javax.swing.JButton btnKhong;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JTable dgDanhSachTaiKhoan;
    private javax.swing.JLabel jLNgaySinh;
    private javax.swing.JLabel jLaMaNV;
    private javax.swing.JLabel jLaSDT;
    private javax.swing.JLabel jLaTenKH;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenkh;
    // End of variables declaration//GEN-END:variables
}
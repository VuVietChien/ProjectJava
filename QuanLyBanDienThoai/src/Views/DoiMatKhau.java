
package Views;


import Controllers.TaiKhoanController;
import CuaHangDienThoai.Splash;
import Models.TaiKhoan;
import helpers.SharedData;
import javax.swing.JOptionPane;

public class DoiMatKhau extends javax.swing.JInternalFrame {

    
    public DoiMatKhau() {
        initComponents();
        HienThongTin();
        KhoaMo(true);
    }
    
    private void HienThongTin(){
        txtTenTK.setText(SharedData.nguoiDangNhap.getTenTaiKhoan());
        txtMaNV.setText(SharedData.nguoiDangNhap.getMaNV());
        txtMaQuyen.setText(SharedData.nguoiDangNhap.getMaQuyen());
    }
    
    public void KhoaMo(boolean b) {
        txtTenTK.setEditable(!b);
        txtMaNV.setEditable(!b);
        txtMaQuyen.setEditable(!b);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenTK = new javax.swing.JTextField();
        txtMaQuyen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtGhi = new javax.swing.JButton();
        txtKetThuc = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        txtMatKhauL1 = new javax.swing.JPasswordField();
        txtMatKhauL2 = new javax.swing.JPasswordField();

        jLabel1.setText("Tên Tài Khoản :");

        jLabel2.setText("Mã Quyền :");

        jLabel3.setText("Mật Khẩu Cũ :");

        jLabel4.setText("Nhập Mật Khẩu Mới :");

        jLabel5.setText("Xác Nhận Mật Khẩu :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Đổi Mật Khẩu");

        txtGhi.setText("Ghi");
        txtGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiActionPerformed(evt);
            }
        });

        txtKetThuc.setText("Kết Thúc");
        txtKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKetThucActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã Nhân Viên :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtGhi, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33)
                                    .addComponent(txtKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtMatKhauL2)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel7)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtMaQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTenTK, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(txtMatKhauL1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(77, 77, 77)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMatKhauL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMatKhauL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGhi)
                    .addComponent(txtKetThuc))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiActionPerformed
         if (txtMatKhau.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mật khẩu.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtMatKhau.requestFocus();
            return;
        }
        if (txtMatKhau.getText().toUpperCase().equals(SharedData.nguoiDangNhap.getMatKhau().toUpperCase())==false) {
            JOptionPane.showMessageDialog(this, "Bạn nhập sai mật khẩu.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtMatKhau.requestFocus();
            return;
        }
        if (txtMatKhauL1.getText().toUpperCase().equals(txtMatKhauL2.getText().toUpperCase())==false) {
            JOptionPane.showMessageDialog(this, "Bạn sai mật khẩu mới.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtMatKhauL2.requestFocus();
            return;
        }
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn đổi mật khẩu mới không?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (kq == JOptionPane.YES_OPTION) {
            String TenTaiKhoan = txtTenTK.getText();
            String MatKhau = txtMatKhauL1.getText();
            String MaNV = txtMaNV.getText();
            String MaQuyen = txtMaQuyen.getText();
            TaiKhoan tk = new TaiKhoan(TenTaiKhoan, MatKhau, MaNV,MaQuyen);

            TaiKhoanController.Update(tk, txtTenTK.getText());
            txtMatKhau.setText("");
            txtMatKhauL1.setText("");
            txtMatKhauL2.setText("");
            JOptionPane.showMessageDialog(this,"Bạn thay đổi mật khẩu thành công","Thông Báo",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_txtGhiActionPerformed

    private void txtKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKetThucActionPerformed
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn kết thúc không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (kq == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_txtKetThucActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton txtGhi;
    private javax.swing.JButton txtKetThuc;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaQuyen;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JPasswordField txtMatKhauL1;
    private javax.swing.JPasswordField txtMatKhauL2;
    private javax.swing.JTextField txtTenTK;
    // End of variables declaration//GEN-END:variables
}

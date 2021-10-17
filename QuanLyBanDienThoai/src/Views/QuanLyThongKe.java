
package Views;


import Controllers.ThongKeDoanhSo_Controller;
import Models.ChiTietHoaDon;
import Models.ThongKe;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class QuanLyThongKe extends javax.swing.JInternalFrame {
    List<ChiTietHoaDon> cthdList = new ArrayList<>();
    
    List<ThongKe> tkList = new ArrayList<>();
    
    DefaultTableModel tableModel;
   
    public QuanLyThongKe() {
        initComponents();
        setResizable(false);
        //setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) tblDanhSach.getModel();
        try {
            loadData();
            loadTongTien();
            loadSoLuongHD();
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
                p.getThanhTien()
            });
        });
    }
    
    private void loadSoLuongHD() {
        int n = tableModel.getRowCount();
        lblSoLuongHD.setText("Số lượng hóa đơn: " + String.valueOf(n));
    }

    private void loadTongTien() {
        tkList = ThongKeDoanhSo_Controller.getTongTien();
        for(ThongKe tk : tkList){
            lblTongDanhThu.setText("Tổng doanh thu: " + tk.getThanhTien());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTongDanhThu = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblSoLuongHD = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        btnSapXep = new javax.swing.JButton();
        btnInThongKe = new javax.swing.JButton();
        dateNgayThongKe = new com.toedter.calendar.JDateChooser();
        btnThongKeNgay = new javax.swing.JButton();

        lblTongDanhThu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTongDanhThu.setText("Tổng doanh thu: ");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Thống kê doanh số");

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBack.setText("Quay lại menu");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(348, 348, 348))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBack))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        lblSoLuongHD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSoLuongHD.setText("Số lượng hóa đơn: ");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(lblSoLuongHD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTongDanhThu)
                .addGap(159, 159, 159))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTongDanhThu)
                    .addComponent(lblSoLuongHD))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    cthd.getThanhTien()
                });
            }
            loadSoLuongHD();
            loadTongTien();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Chưa có dữ liệu để sắp xếp");
        }
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void btnInThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInThongKeActionPerformed

//        FileOutputStream fileOutputStream = null;
//        BufferedOutputStream outputStream = null;
//        XSSFWorkbook workbook = null;
//
//        //Chọn đường dẫn để lưu file
//        JFileChooser excelFileChooser = new JFileChooser("E:\\JAVA-TRAIN\\BaiTapLon_Nhom2\\BTL_QuanLyBanHang\\XuatThongKeFileExcel");
//        //Thay đổi tiêu đề
//        excelFileChooser.setDialogTitle("Save as");
//        //Chỉ lưu dưới dạng các tập tin này
//        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
//        excelFileChooser.setFileFilter(fnef);
//        int excelChoose = excelFileChooser.showSaveDialog(null);
//        Cell cell;
//        Row row;
//        //check nếu file đã được chọn
//        if (excelChoose == JFileChooser.APPROVE_OPTION) {
//            try {
//                workbook = new XSSFWorkbook();
//                XSSFSheet excelSheet = workbook.createSheet("JTable Sheet");
//
//                int rowNum = 0;
//
//                row = excelSheet.createRow(rowNum++);
//                cell = row.createCell(0);
//                cell.setCellValue("THỐNG KÊ DANH SÁCH HOÁ ĐƠN");
//
//                row = excelSheet.createRow(rowNum++);
//
//                cell = row.createCell(0);
//                cell.setCellValue("MÃ HOÁ ĐƠN");
//
//                cell = row.createCell(1);
//                cell.setCellValue("MÃ NHÂN VIÊN");
//
//                cell = row.createCell(2);
//                cell.setCellValue("TÊN NHÂN VIÊN");
//
//                cell = row.createCell(3);
//                cell.setCellValue("TÊN KHÁCH HÀNG");
//
//                cell = row.createCell(4);
//                cell.setCellValue("NGÀY LẬP");
//
//                cell = row.createCell(5);
//                cell.setCellValue("THÀNH TIỀN");
//
//                for (int i = 0; i < tableModel.getRowCount(); i++) {
//                    XSSFRow excelRow = excelSheet.createRow(rowNum++);
//                    for (int j = 0; j < tableModel.getColumnCount(); j++) {
//                        XSSFCell excelCell = excelRow.createCell(j);
//                        excelCell.setCellValue(tableModel.getValueAt(i, j).toString());
//                    }
//                }
//
//                fileOutputStream = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
//                outputStream = new BufferedOutputStream(fileOutputStream);
//                workbook.write(outputStream);
//
//                JOptionPane.showMessageDialog(rootPane, "Xuất dữ liệu thành công");
//            } catch (FileNotFoundException ex) {
//                JOptionPane.showMessageDialog(rootPane, "Đường dẫn file không hợp lệ");
//            } catch (IOException ex) {
//                JOptionPane.showMessageDialog(rootPane, ex);
//            } finally {
//                if (outputStream != null) {
//                    try {
//                        outputStream.close();
//                    } catch (IOException ex) {
//                        Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                if (fileOutputStream != null) {
//                    try {
//                        fileOutputStream.close();
//                    } catch (IOException ex) {
//                        Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                if (workbook != null) {
//                    try {
//                        workbook.close();
//                    } catch (IOException ex) {
//                        Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//        }
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
                    tongTT += cthd.getThanhTien();
                    lblTongDanhThu.setText("Tổng doanh thu: " + String.valueOf(tongTT));
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnInThongKe;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JButton btnThongKeNgay;
    private com.toedter.calendar.JDateChooser dateNgayThongKe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSoLuongHD;
    private javax.swing.JLabel lblTongDanhThu;
    private javax.swing.JTable tblDanhSach;
    // End of variables declaration//GEN-END:variables
}

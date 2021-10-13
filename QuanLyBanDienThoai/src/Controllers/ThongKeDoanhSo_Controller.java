
package Controllers;

import static Controllers.TaiKhoanController.conn;
import Models.ChiTietHoaDon;
import Views.connectDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ThongKeDoanhSo_Controller {
    public static Connection conn;
    public static Statement state;
    public static String sql;
    public static PreparedStatement pstate;
    public static ResultSet rs;
    
    public static List<ChiTietHoaDon> layNguon(){
        List<ChiTietHoaDon> cthdList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "select quanlysieuthidienthoai.chitiethoadon.maHD, quanlysieuthidienthoai.HoaDon.maNV,tenNV, tenKH, ngayLap, sum(quanlysieuthidienthoai.chitiethoadon.soLuong * quanlysieuthidienthoai.chitiethoadon.DonGia) as 'thanhTien'\n" +
"from quanlysieuthidienthoai.chitiethoadon inner join quanlysieuthidienthoai.sanpham on quanlysieuthidienthoai.sanpham.maSP = quanlysieuthidienthoai.chitiethoadon.maSP\n" +
"inner join quanlysieuthidienthoai.HoaDon on quanlysieuthidienthoai.ChiTietHoaDon.maHD = quanlysieuthidienthoai.HoaDon.maHD,quanlysieuthidienthoai.NhanVien,quanlysieuthidienthoai.khachhang\n" +
"where NhanVien.maNV = HoaDon.maNV\n" +
"group by quanlysieuthidienthoai.chitiethoadon.maHD, quanlysieuthidienthoai.HoaDon.maNV, tenNV, tenKH, ngayLap";
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon ct = new ChiTietHoaDon();
                ct.setMaHD(rs.getString("maHD"));
                ct.setMaNV(rs.getString("maNV"));
                ct.setTenNV(rs.getString("tenNV"));
                ct.setMaKH(rs.getString("makh"));
                ct.setNgayLap(rs.getString("ngaylap"));
                ct.setTongTien(rs.getFloat("tongtien"));
                cthdList.add(ct);
            }
        } catch (SQLException ex) {
            System.out.println("Lôi: " + ex);
        } finally {
            if (pre != null) {
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDoanhSo_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDoanhSo_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cthdList;
    }
    
}


package Controllers;


import Models.ChiTietHoaDon;
import Models.ThongKe;
import Views.QuanLyThongKe;
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
        conn = null;
        pstate = null;
        rs = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "select quanlysieuthidienthoai.chitiethoadon.maHD, quanlysieuthidienthoai.HoaDon.maNV,tenNV, quanlysieuthidienthoai.khachhang.MaKH, ngayLap, sum(quanlysieuthidienthoai.chitiethoadon.SoLuong * quanlysieuthidienthoai.chitiethoadon.DonGia) as 'thanhTien'\n" +
                "from quanlysieuthidienthoai.chitiethoadon inner join quanlysieuthidienthoai.HoaDon on quanlysieuthidienthoai.ChiTietHoaDon.maHD = quanlysieuthidienthoai.HoaDon.maHD,quanlysieuthidienthoai.NhanVien,quanlysieuthidienthoai.khachhang\n" +
                "where NhanVien.maNV = HoaDon.maNV\n" +
                "group by quanlysieuthidienthoai.chitiethoadon.maHD, quanlysieuthidienthoai.HoaDon.maNV, tenNV, quanlysieuthidienthoai.khachhang.MaKH, ngayLap";
            pstate = conn.prepareStatement(sql);
            rs = pstate.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon ct = new ChiTietHoaDon();
                ct.setMaHD(rs.getString("maHD"));
                ct.setMaNV(rs.getString("maNV"));
                ct.setTenNV(rs.getString("tenNV"));
                ct.setMaKH(rs.getString("MaKH"));
                ct.setNgayLap(rs.getString("ngaylap"));
                ct.setThanhTien(rs.getFloat("thanhTien"));
                cthdList.add(ct);
            }
        } catch (SQLException ex) {
            System.out.println("Lôi: " + ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
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
    
     public static List<ChiTietHoaDon> sortByTT() {
        List<ChiTietHoaDon> cthds = new ArrayList<>();
        conn = null;
        pstate = null;
        rs = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "select quanlysieuthidienthoai.chitiethoadon.maHD, quanlysieuthidienthoai.HoaDon.maNV,tenNV, quanlysieuthidienthoai.khachhang.MaKH, ngayLap, sum(quanlysieuthidienthoai.chitiethoadon.soLuong * quanlysieuthidienthoai.chitiethoadon.DonGia) as 'thanhTien'\n" +
"from quanlysieuthidienthoai.chitiethoadon inner join quanlysieuthidienthoai.HoaDon on quanlysieuthidienthoai.ChiTietHoaDon.maHD = quanlysieuthidienthoai.HoaDon.maHD,quanlysieuthidienthoai.NhanVien,quanlysieuthidienthoai.khachhang\n" +
"where NhanVien.maNV = HoaDon.maNV\n" +
"group by quanlysieuthidienthoai.chitiethoadon.maHD, quanlysieuthidienthoai.HoaDon.maNV, tenNV, quanlysieuthidienthoai.khachhang.MaKH, ngayLap\n" +
                "order by thanhTien";
            
            pstate = conn.prepareStatement(sql);
            rs = pstate.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon ct = new ChiTietHoaDon();
                ct.setMaHD(rs.getString("maHD"));
                ct.setMaNV(rs.getString("maNV"));
                ct.setTenNV(rs.getString("tenNV"));
                ct.setMaKH(rs.getString("makh"));
                ct.setNgayLap(rs.getString("ngaylap"));
                ct.setTongTien(rs.getFloat("tongtien"));
                cthds.add(ct);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
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
        return cthds;
     }
    
    public static List<ThongKe> getTongTien() {
        List<ThongKe> tkList = new ArrayList<>();
        
        conn = null;
        pstate = null;
        rs = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "select sum(SoLuong*donGia) as 'tongTien'\n" +
                          "from quanlysieuthidienthoai.ChiTietHoaDon";
            pstate = conn.prepareStatement(sql);
            rs = pstate.executeQuery();
            while (rs.next()) {
                ThongKe tk = new ThongKe();
                tk.setThanhTien(Float.parseFloat(rs.getString("tongTien")));
                tkList.add(tk);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi: " + ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi: " + ex);
                }
            }
        }
        return tkList;
    }
    
}
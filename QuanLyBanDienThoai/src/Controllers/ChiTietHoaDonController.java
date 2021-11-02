package Controllers;

import Models.ChiTietHoaDon;
import Models.ThongKe;
import Views.connectDB;
import static Views.connectDB.dbURL;
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
import javax.swing.JOptionPane;

public class ChiTietHoaDonController {

    public static Connection conn;
    public static Statement state;
    public static String sql;
    public static PreparedStatement pstate;
    public static ResultSet rs;

    public static List<ChiTietHoaDon> layNguon() {
        List<ChiTietHoaDon> cthdList = new ArrayList<>();
        conn = null;
        pstate = null;
        rs = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "select chitiethoadon.maHD, HoaDon.maNV,tenNV, khachhang.MaKH, ngayLap, sum(chitiethoadon.SoLuong * chitiethoadon.DonGia) as 'thanhTien'\n"
                    + "from chitiethoadon inner join HoaDon on ChiTietHoaDon.maHD = HoaDon.maHD,NhanVien,khachhang\n"
                    + "where NhanVien.maNV = HoaDon.maNV and khachhang.MaKH=hoadon.MaKH\n"
                    + "group by chitiethoadon.maHD, HoaDon.maNV, tenNV, khachhang.MaKH, ngayLap";
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
                    Logger.getLogger(ThongKeDoanhSoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDoanhSoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cthdList;
    }

    public static List<ChiTietHoaDon> findByDate(String maHD) {
        List<ChiTietHoaDon> cthdList = new ArrayList<>();
        conn = null;
        pstate = null;
        rs = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "select chitiethoadon.maHD, HoaDon.maNV,tenNV, khachhang.MaKH, ngayLap, sum(chitiethoadon.SoLuong * chitiethoadon.DonGia) as 'thanhTien'\n"
                    + "from chitiethoadon inner join HoaDon on ChiTietHoaDon.maHD = HoaDon.maHD,NhanVien,khachhang\n"
                    + "where NhanVien.maNV = HoaDon.maNV and khachhang.MaKH=hoadon.MaKH and chitiethoadon.maHD=?\n"
                    + "group by chitiethoadon.maHD, HoaDon.maNV, tenNV, khachhang.MaKH, ngayLap";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, maHD);
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
            System.out.println("Lỗi: " + ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDoanhSoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDoanhSoController.class.getName()).log(Level.SEVERE, null, ex);
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
            String sql = "select chitiethoadon.maHD, HoaDon.maNV,tenNV, khachhang.MaKH, ngayLap, sum(chitiethoadon.soLuong * chitiethoadon.DonGia) as 'thanhTien'\n"
                    + "from chitiethoadon inner join HoaDon on ChiTietHoaDon.maHD = HoaDon.maHD,NhanVien,khachhang\n"
                    + "where NhanVien.maNV = HoaDon.maNV and khachhang.MaKH=hoadon.MaKH\n"
                    + "group by chitiethoadon.maHD, HoaDon.maNV, tenNV, khachhang.MaKH, ngayLap\n"
                    + "order by thanhTien";

            pstate = conn.prepareStatement(sql);
            rs = pstate.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon ct = new ChiTietHoaDon();
                ct.setMaHD(rs.getString("maHD"));
                ct.setMaNV(rs.getString("maNV"));
                ct.setTenNV(rs.getString("tenNV"));
                ct.setMaKH(rs.getString("makh"));
                ct.setNgayLap(rs.getString("ngaylap"));
                ct.setThanhTien(rs.getFloat("thanhtien"));
                cthds.add(ct);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDoanhSoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDoanhSoController.class.getName()).log(Level.SEVERE, null, ex);
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
            String sql = "select sum(SoLuong*donGia) as 'tongTien'\n"
                    + "from ChiTietHoaDon";
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

    public static void deleteCTHD(String maHD) {
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            conn = DriverManager.getConnection(dbURL);
            String sql = "delete from ChiTietHoaDon where maHD = ?";
            pre = conn.prepareStatement(sql);
            pre.setString(1, maHD);
            pre.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex);
        } finally {
            if (pre != null) {
                try {
                    pre.close();
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

    }
    
    public static void Insertcthd(ChiTietHoaDon cthd) {
        try {
            conn = null;
            pstate = null;
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "INSERT INTO chitiethoadon(MaHD,MaSP,soluong,DonGia) VALUES(?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, cthd.getMaHD());
            pstate.setString(2, cthd.getMSP());
            pstate.setInt(3, cthd.getSoLuong());
            pstate.setFloat(4, cthd.getDongia());
            
            pstate.execute();
            pstate.close();
            conn.close();
         
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

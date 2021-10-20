package Controllers;

import Models.ChiTietHoaDon;
import Views.connectDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietHoaDonController {

    public static List<ChiTietHoaDon> getTTHD(String maNV) {

        List<ChiTietHoaDon> cthds = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        String sql = "select ChiTietHoaDon.maHD, ngayLap, maNV, tenKH, sum(soLuong * donGia) as 'thanhTien'\n"
                + "from ChiTietHoaDon inner join SanPham on SanPham.maSP = ChiTietHoaDon.maSP\n"
                + "inner join HoaDon on ChiTietHoaDon.maHD = HoaDon.maHD\n"
                + "where maNV = ?\n"
                + "group by ChiTietHoaDon.maHD,ngayLap, maNV, tenKH";
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            pre = conn.prepareStatement(sql);
            pre.setString(1, maNV);
            rs = pre.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon ct = new ChiTietHoaDon(rs.getString("maHD"), rs.getString("ngayLap"),
                        rs.getString("maNV"), rs.getString("tenKH"), rs.getFloat("thanhTien"));
                cthds.add(ct);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex);
        } finally {
            if (pre != null) {
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietHoaDonController.class.getName()).log(Level.SEVERE, null, ex);
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
        return cthds;
    }

    public static List<ChiTietHoaDon> findByMaHD(String maHD, String maNV) {
        List<ChiTietHoaDon> cthds = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        String sql = "select ChiTietHoaDon.maHD, ngayLap, maNV, tenKH, sum(soLuong * donGia) as 'thanhTien'\n"
                + "from ChiTietHoaDon inner join SanPham on SanPham.maSP = ChiTietHoaDon.maSP inner join HoaDon on ChiTietHoaDon.maHD = HoaDon.maHD\n"
                + "where ChiTietHoaDon.maHD = ? and maNV = ?\n"
                + "group by ChiTietHoaDon.maHD,ngayLap, maNV, tenKH";

        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            pre = conn.prepareStatement(sql);
            pre.setString(1, maHD);
            pre.setString(2, maNV);
            rs = pre.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon ct = new ChiTietHoaDon(rs.getString("maHD"), rs.getString("ngayLap"), rs.getString("maNV"), rs.getString("tenKH"), rs.getFloat("thanhTien"));
                cthds.add(ct);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex);
        } finally {
            if (pre != null) {
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietHoaDonController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietHoaDonController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cthds;
    }

    public static void insertCTHD(ChiTietHoaDon cthd) {
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "insert into ChiTietHoaDon values(?,?,?)";
            pre = conn.prepareStatement(sql);
            pre.setString(1, cthd.getMaHD());
            pre.setString(2, cthd.getMSP());
            pre.setInt(3, cthd.getSoLuong());

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

    public static void deleteCTHD(String maHD) {
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
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

    public static List<ChiTietHoaDon> sortByDate(String maNV) {
        List<ChiTietHoaDon> cthds = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            String sql = "select ChiTietHoaDon.maHD, ngayLap, maNV, tenKH, sum(soLuong * donGia) as 'thanhTien'\n"
                    + "from ChiTietHoaDon inner join SanPham on SanPham.maSP = ChiTietHoaDon.maSP inner join HoaDon on ChiTietHoaDon.maHD = HoaDon.maHD\n"
                    + "where maNV = ?\n"
                    + "group by ChiTietHoaDon.maHD,ngayLap, maNV, tenKH\n"
                    + "order by ngayLap";
            conn = DriverManager.getConnection(connectDB.dbURL);
            pre = conn.prepareStatement(sql);
            pre.setString(1, maNV);
            rs = pre.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon ct = new ChiTietHoaDon(rs.getString("maHD"), rs.getString("ngayLap"),
                        rs.getString("maNV"), rs.getString("tenKH"), rs.getFloat("thanhTien"));
                cthds.add(ct);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex);
        } finally {
            if (pre != null) {
                try {
                    pre.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietHoaDonController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietHoaDonController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cthds;
    }
}

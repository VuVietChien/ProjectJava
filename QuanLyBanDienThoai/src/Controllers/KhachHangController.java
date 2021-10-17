package Controllers;

import Models.KhachHang;
import static Views.connectDB.dbURL;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHangController {

    public static Connection conn;
    public static Statement state;
    public static String sql;
    public static PreparedStatement pstate;
    public static ResultSet rs;

    public static List<KhachHang> LayNguonNganh() {
        List<KhachHang> arrNganh = new ArrayList<>();
        conn = null;
        Statement state = null;
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Select * From KhachHang";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                KhachHang cn = new KhachHang();
                cn.setMaKHString(rs.getString("makh"));
                cn.setTenKH(rs.getString("tenkh"));
                cn.setDiaChiString(rs.getString("diachi"));
                cn.setSodt(rs.getString("sdt"));
                arrNganh.add(cn);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return arrNganh;
    }

    public static void ThemNganh(KhachHang cn) {
        conn = null;
        PreparedStatement state = null;
        try {
            conn = DriverManager.getConnection(dbURL);

            sql = "Insert Into khachhang(makh,tenkh,diachi,sdt) values (?,?,?,?)";
            state = conn.prepareStatement(sql);
            state.setString(1, cn.getMaKHString());
            state.setString(2, cn.getTenKH());
            state.setString(3, cn.getDiaChiString());
            state.setString(4, cn.getSodt());
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void CapNhatNganh(KhachHang cn, String macu) {
        conn = null;
        PreparedStatement state = null;

        try {
            conn = DriverManager.getConnection(dbURL);

            sql = "Update khachhang Set makh=?,tenkh=?,diachi=?,sdt=? Where makh=?";
            state = conn.prepareStatement(sql);
            state.setString(1, cn.getMaKHString());
            state.setString(2, cn.getTenKH());
            state.setString(3, cn.getDiaChiString());
            state.setString(4, cn.getSodt());
            state.setString(5, macu);

            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void XoaNganh(String manganh) {
        conn = null;
        PreparedStatement state = null;

        try {
            conn = DriverManager.getConnection(dbURL);

            sql = "DELETE FROM khachhang WHERE KhachHang.tenkh=?";
            state = conn.prepareStatement(sql);
            state.setString(1, manganh);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    // Kiem tra trung tentaikhoan
    public static boolean KiemTraTrungMa(String manhap, boolean ktThem, String macu) {
        boolean kq = false;
        conn = null;
        state = null;
        try {
            conn = DriverManager.getConnection(dbURL);
            if (ktThem == true) {
                sql = "SELECT MaKH FROM khachhang WHERE MaKH = '" + manhap + "'";
            } else {
                sql = "SELECT MaKH FROM khachhang WHERE MaKH='"
                        + manhap + "' and MaKH<>'" + macu + "'";
            }
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            if (rs.next()) {
                kq = true;
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return kq;
    }

    public static List<KhachHang> TimKiemTheoTenTaiKhoan(String tentk) {
        List<KhachHang> listTaiKhoan = new ArrayList<>();
        conn = null;
        pstate = null;
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "SELECT * FROM khachhang where khachhang.makh like ?";
            pstate = conn.prepareCall(sql);
            pstate.setString(1, "%" + tentk + "%");
            ResultSet rs = pstate.executeQuery();
            while (rs.next()) {
                KhachHang temp = new KhachHang(
                        rs.getString("maKH"),
                        rs.getString("tenKH"),
                        rs.getString("diachi"),
                        rs.getString("sdt")
                );
                listTaiKhoan.add(temp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return listTaiKhoan;

    }
}

package Controllers;

import Models.KhachHang;
import Views.connectDB;
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
    public static Statement ppstate;
    public static String sql;
    public static PreparedStatement pppstate;
    public static ResultSet rs;

    public static List<KhachHang> LayNguonNganh() {
        List<KhachHang> arrNganh = new ArrayList<>();
        conn = null;
        Statement ppstate = null;
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Select * From KhachHang";
            ppstate = conn.createStatement();
            ResultSet rs = ppstate.executeQuery(sql);
            while (rs.next()) {
                KhachHang cn = new KhachHang();
                cn.setMaKHString(rs.getString("makh"));
                cn.setTenKH(rs.getString("tenkh"));
                cn.setDiaChiString(rs.getString("diachi"));
                cn.setSodt(rs.getString("sdt"));
                arrNganh.add(cn);
            }
            ppstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ppstate != null) {
                try {
                    ppstate.close();
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

    public static void Them(KhachHang cn) {
        try {
            conn = null;
            pppstate = null;
            conn = DriverManager.getConnection(dbURL);

            sql = "Insert Into khachhang(makh,tenkh,diachi,sdt) values (?,?,?,?)";
            ppstate = conn.prepareStatement(sql);
            pppstate.setString(1, cn.getMaKHString());
            pppstate.setString(2, cn.getTenKH());
            pppstate.setString(3, cn.getDiaChiString());
            pppstate.setString(4, cn.getSodt());
            pppstate.execute();
            ppstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ppstate != null) {
                try {
                    ppstate.close();
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
        PreparedStatement ppstate = null;

        try {
            conn = DriverManager.getConnection(dbURL);

            sql = "Update khachhang Set makh=?,tenkh=?,diachi=?,sdt=? Where makh=?";
            ppstate = conn.prepareStatement(sql);
            ppstate.setString(1, cn.getMaKHString());
            ppstate.setString(2, cn.getTenKH());
            ppstate.setString(3, cn.getDiaChiString());
            ppstate.setString(4, cn.getSodt());
            ppstate.setString(5, macu);

            ppstate.execute();
            ppstate.close();
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
            if (ppstate != null) {
                try {
                    ppstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void XoaNganh(String manganh) {
        conn = null;
        PreparedStatement ppstate = null;

        try {
            conn = DriverManager.getConnection(dbURL);

            sql = "DELETE FROM khachhang WHERE KhachHang.makh=?";
            ppstate = conn.prepareStatement(sql);
            ppstate.setString(1, manganh);
            ppstate.execute();
            ppstate.close();
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
            if (ppstate != null) {
                try {
                    ppstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static boolean KiemTraTrungMa(String manhap, boolean ktThem, String macu) {
        boolean kq = false;
        conn = null;
        ppstate = null;
        try {
            conn = DriverManager.getConnection(dbURL);
            if (ktThem == true) {
                sql = "SELECT MaKH FROM khachhang WHERE MaKH = '" + manhap + "'";
            } else {
                sql = "SELECT MaKH FROM khachhang WHERE MaKH='"
                        + manhap + "' and MaKH<>'" + macu + "'";
            }
            ppstate = conn.createStatement();
            ResultSet rs = ppstate.executeQuery(sql);
            if (rs.next()) {
                kq = true;
            }
            ppstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ppstate != null) {
                try {
                    ppstate.close();
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

    public static List<KhachHang> TimKiemKhachHang(String tenkh,String makh) {
        List<KhachHang> listKh = new ArrayList<>();
        conn = null;
        pppstate = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "SELECT * FROM khachhang where makh like ? or tenkh like ?";
            pppstate = conn.prepareCall(sql);
            pppstate.setString(1, "%" + tenkh + "%");
            pppstate.setString(2, "%" + makh + "%");
            ResultSet rs = pppstate.executeQuery();
            while (rs.next()) {
                KhachHang temp = new KhachHang(
                        rs.getString("maKH"),
                        rs.getString("tenKH"),
                        rs.getString("diachi"),
                        rs.getString("sdt")
                );
                listKh.add(temp);
            }
            ppstate.close();
            conn.close();
        } catch (SQLException ex) {
          //  Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
          ex.printStackTrace();
        } finally {
            if (ppstate != null) {
                try {
                    ppstate.close();
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
        return listKh;

    }
}

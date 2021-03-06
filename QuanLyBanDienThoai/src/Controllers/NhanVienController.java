package Controllers;

import Models.NhanVien;
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

public class NhanVienController {

    public static Connection conn;
    public static Statement state;
    public static String sql;
    public static PreparedStatement pstate;
    public static ResultSet rs;

    public static List<NhanVien> LayNguonNganh() {
        List<NhanVien> arrNganh = new ArrayList<>();
        conn = null;
        Statement state = null;
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Select * From NhanVien";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                NhanVien cn = new NhanVien();
                cn.setMaNV(rs.getString("MaNV"));
                cn.setTenNV(rs.getString("TenNV"));
                cn.setNgaySinh(rs.getString("NgaySinh"));
                cn.setDiaChi(rs.getString("DiaChi"));
                cn.setSDT(rs.getString("sdt"));

                arrNganh.add(cn);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return arrNganh;
    }

    public static void ThemNganh(NhanVien cn) {
        conn = null;
        PreparedStatement state = null;
        try {
            conn = DriverManager.getConnection(dbURL);

            sql = "Insert Into nhanvien(MaNV,TenNV,nhanvien.NgaySinh,DiaChi,SDT) values (?,?,?,?,?)";
            state = conn.prepareStatement(sql);
            state.setString(1, cn.getMaNV());
            state.setString(2, cn.getTenNV());
            state.setString(3, cn.getNgaySinh());
            state.setString(4, cn.getDiaChi());
            state.setString(5, cn.getSDT());

            //
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void CapNhatNganh(NhanVien cn, String macu) {
        conn = null;
        PreparedStatement state = null;

        try {
            conn = DriverManager.getConnection(dbURL);

            sql = "Update nhanvien Set manv=?,tennv=?,ngaysinh=?, nhanvien.diachi=?,nhanvien.sdt=? Where manv=?";
            state = conn.prepareStatement(sql);
            state.setString(1, cn.getMaNV());
            state.setString(2, cn.getTenNV());
            state.setString(3, cn.getNgaySinh());
            state.setString(4, cn.getDiaChi());
            state.setString(5, cn.getSDT());
            state.setString(6, macu);

            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void XoaNganh(String manganh) {

        try {
            conn = null;
            PreparedStatement state = null;
            conn = DriverManager.getConnection(dbURL);

            sql = "Delete From NhanVien Where nhanvien.manv = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, manganh);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
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
                sql = "SELECT Manv FROM nhanvien WHERE Manv = '" + manhap + "'";
            } else {
                sql = "SELECT Manv FROM nhanvien WHERE Manv='"
                        + manhap + "' and Manv<>'" + macu + "'";
            }
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            if (rs.next()) {
                kq = true;
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return kq;
    }

    public static List<NhanVien> TimKiemNhanVien(String tentk, String manv) {
        List<NhanVien> listNv = new ArrayList<>();
        conn = null;
        //state = null;
           PreparedStatement state = null;
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "SELECT * FROM nhanvien where nhanvien.tennv like ? or nhanvien.manv like ?";
            state = conn.prepareCall(sql);
            state.setString(1, "%" + tentk + "%");
              state.setString(2, "%" + manv + "%");
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                NhanVien temp = new NhanVien(
                        rs.getString("manv"),
                        rs.getString("tennv"),
                        rs.getString("ngaysinh"),
                        rs.getString("diachi"),
                        rs.getString("sdt")
                );
                listNv.add(temp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            //  Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
                  ex.printStackTrace();
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return listNv;

    }
}

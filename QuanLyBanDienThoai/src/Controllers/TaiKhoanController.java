/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.TaiKhoan;
import Views.connectDB;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thuan
 */
public class TaiKhoanController {

    public static Connection conn;
    public static Statement state;
    public static PreparedStatement pstate;
    public static String sql;

    public static List<TaiKhoan> Select() {
        List<TaiKhoan> listTaiKhoan = new ArrayList<>();
        conn = null;
        state = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "Select * from quanlysieuthidienthoai.taikhoan";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                TaiKhoan temp = new TaiKhoan(
                        rs.getString("TenTaiKhoan"),
                        rs.getString("MatKhau"),
                        rs.getString("MaNV"),
                        rs.getString("MaQuyen")
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
                    Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return listTaiKhoan;

    }

    public static void Insert(TaiKhoan tk) {
        try {
            conn = null;
            pstate = null;
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "INSERT INTO quanlysieuthidienthoai.taikhoan(TenTaiKhoan,MatKhau,MaNV,MaQuyen) VALUES(?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getTenTaiKhoan());
            pstate.setString(2, tk.getMatKhau());
            pstate.setString(3, tk.getMaNV());
            pstate.setString(4, tk.getMaQuyen());
            pstate.execute();
            pstate.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void Update(TaiKhoan tk, String macu) {
        try {
            conn = null;
            pstate = null;
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "UPDATE quanlysieuthidienthoai.taikhoan SET TenTaiKhoan=?,MatKhau=?,MaNV=?,MaQuyen=? WHERE TenTaiKhoan=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getTenTaiKhoan());
            pstate.setString(2, tk.getMatKhau());
            pstate.setString(3, tk.getMaNV());
            pstate.setString(4, tk.getMaQuyen());
            pstate.setString(5, macu);
            pstate.execute();
            pstate.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void Delete(String macu) {
        try {
            conn = null;
            pstate = null;
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "DELETE FROM quanlysieuthidienthoai.taikhoan WHERE TenTaiKhoan=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, macu);
            pstate.execute();
            pstate.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static List<TaiKhoan> TimKiemTheoTenTaiKhoan(String tentk) {
        List<TaiKhoan> listTaiKhoan = new ArrayList<>();
        conn = null;
        pstate = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "SELECT * FROM quanlysieuthidienthoai.taikhoan where TenTaiKhoan like ?";
            pstate = conn.prepareCall(sql);
            pstate.setString(1, "%" + tentk + "%");
            ResultSet rs = pstate.executeQuery();
            while (rs.next()) {
                TaiKhoan temp = new TaiKhoan(
                        rs.getString("TenTaiKhoan"),
                        rs.getString("MatKhau"),
                        rs.getString("MaNV"),
                        rs.getString("MaQuyen")
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
                    Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return listTaiKhoan;

    }

    // Kiem tra trung tentaikhoan
    public static boolean KiemTraTrungMa(String manhap, boolean ktThem, String macu) {
        boolean kq = false;
        conn = null;
        state = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            if (ktThem == true) {
                sql = "SELECT TenTaiKhoan FROM quanlysieuthidienthoai.taikhoan WHERE TenTaiKhoan = '" + manhap + "'";
            } else {
                sql = "SELECT TenTaiKhoan FROM quanlysieuthidienthoai.taikhoan WHERE TenTaiKhoan='"
                        + manhap + "' and TenTaiKhoan<>'" + macu + "'";
            }
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            if (rs.next()) {
                kq = true;
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
                    Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return kq;
    }
}

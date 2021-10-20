/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Quyen;
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

/**
 *
 * @author thuan
 */
public class QuyenController {

    public static Connection conn;
    public static Statement state;
    public static PreparedStatement pstate;
    public static String sql;

    public static List<Quyen> Select() {
        List<Quyen> listQuyen = new ArrayList<>();
        conn = null;
        state = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "Select * from phanquyen";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                Quyen temp = new Quyen(
                        rs.getString("MaQuyen"),
                        rs.getString("TenQuyen"),
                        rs.getString("ChiTietQuyen")
                );
                listQuyen.add(temp);

            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuyenController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuyenController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuyenController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return listQuyen;

    }

    public static void Insert(Quyen tk) {
        try {
            conn = null;
            pstate = null;
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "INSERT INTO phanquyen(MaQuyen,TenQuyen,ChiTietQuyen) VALUES(?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getMaQuyen());
            pstate.setString(2, tk.getTenQuyen());
            pstate.setString(3, tk.getChiTietQuyen());
            pstate.execute();
            pstate.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(QuyenController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuyenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuyenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void Update(Quyen tk, String macu) {
        try {
            conn = null;
            pstate = null;
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "UPDATE phanquyen SET MaQuyen=?,TenQuyen=?,ChiTietQuyen=? WHERE MaQuyen=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getMaQuyen());
            pstate.setString(2, tk.getTenQuyen());
            pstate.setString(3, tk.getChiTietQuyen());
            pstate.setString(4, macu);
            pstate.execute();
            pstate.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(QuyenController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuyenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuyenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void Delete(String macu) {
        try {
            conn = null;
            pstate = null;
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "DELETE FROM phanquyen WHERE MaQuyen=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, macu);
            pstate.execute();
            pstate.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(QuyenController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuyenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuyenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static List<Quyen> TimKiemTheoTenQuyen(String tenlsp) {
        List<Quyen> listQuyen = new ArrayList<>();
        conn = null;
        pstate = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "SELECT * FROM phanquyen where TenQuyen like ?";
            pstate = conn.prepareCall(sql);
            pstate.setString(1, "%" + tenlsp + "%");
            ResultSet rs = pstate.executeQuery();
            while (rs.next()) {
                Quyen temp = new Quyen(
                        rs.getString("MaQuyen"),
                        rs.getString("TenQuyen"),
                        rs.getString("ChiTietQuyen")
                );
                listQuyen.add(temp);

            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuyenController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuyenController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuyenController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return listQuyen;

    }

    // Kiem tra trung tenphanquyen
    public static boolean KiemTraTrungMa(String manhap, boolean ktThem, String macu) {
        boolean kq = false;
        conn = null;
        state = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            if (ktThem == true) {
                sql = "SELECT TenQuyen FROM phanquyen WHERE MaQuyen = '" + manhap + "'";
            } else {
                sql = "SELECT TenQuyen FROM phanquyen WHERE MaQuyen='"
                        + manhap + "' and MaQuyen<>'" + macu + "'";
            }
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            if (rs.next()) {
                kq = true;
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuyenController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuyenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuyenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return kq;
    }
}

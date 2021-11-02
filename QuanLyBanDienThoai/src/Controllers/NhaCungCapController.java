/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.NhaCungCap;
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
public class NhaCungCapController {

    public static Connection conn;
    public static Statement state;
    public static PreparedStatement pstate;
    public static String sql;

    public static List<NhaCungCap> Select() {
        List<NhaCungCap> listNhaCungCap = new ArrayList<>();
        conn = null;
        state = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "Select * from nhacungcap";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                NhaCungCap temp = new NhaCungCap(
                        rs.getString("MaNCC"),
                        rs.getString("TenNCC"),
                        rs.getString("DiaChi"),
                        rs.getString("SDT")
                );
                listNhaCungCap.add(temp);

            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return listNhaCungCap;

    }

    public static void Insert(NhaCungCap tk) {
        try {
            conn = null;
            pstate = null;
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "INSERT INTO nhacungcap(MaNCC,TenNCC,DiaChi,SDT) VALUES(?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getMaNCC());
            pstate.setString(2, tk.getTenNCC());
            pstate.setString(3, tk.getDiaChi());
            pstate.setString(4, tk.getSDT());
            pstate.execute();
            pstate.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void Update(NhaCungCap tk, String macu) {
        try {
            conn = null;
            pstate = null;
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "UPDATE nhacungcap SET MaNCC=?,TenNCC=?,DiaChi=?,SDT=? WHERE MaNCC=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getMaNCC());
            pstate.setString(2, tk.getTenNCC());
            pstate.setString(3, tk.getDiaChi());
            pstate.setString(4, tk.getSDT());
            pstate.setString(5, macu);
            pstate.execute();
            pstate.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void Delete(String macu) {
        try {
            conn = null;
            pstate = null;
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "DELETE FROM nhacungcap WHERE MaNCC=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, macu);
            pstate.execute();
            pstate.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static List<NhaCungCap> TimKiemTheoTenNhaCungCap(String tenlsp) {
        List<NhaCungCap> listNhaCungCap = new ArrayList<>();
        conn = null;
        pstate = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "SELECT * FROM nhacungcap where TenNCC like ?";
            pstate = conn.prepareCall(sql);
            pstate.setString(1, "%" + tenlsp + "%");
            ResultSet rs = pstate.executeQuery();
            while (rs.next()) {
                NhaCungCap temp = new NhaCungCap(
                        rs.getString("MaNCC"),
                        rs.getString("TenNCC"),
                        rs.getString("DiaChi"),
                        rs.getString("SDT")
                );
                listNhaCungCap.add(temp);

            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return listNhaCungCap;

    }

    // Kiem tra trung tennhacungcap
    public static boolean KiemTraTrungMa(String manhap, boolean ktThem, String macu) {
        boolean kq = false;
        conn = null;
        state = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            if (ktThem == true) {
                sql = "SELECT TenNhaCungCap FROM nhacungcap WHERE MaNCC = '" + manhap + "'";
            } else {
                sql = "SELECT TenNhaCungCap FROM nhacungcap WHERE MaNCC='"
                        + manhap + "' and MaNCC<>'" + macu + "'";
            }
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            if (rs.next()) {
                kq = true;
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return kq;
    }
}

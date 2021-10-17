package Controllers;


import Controllers.LoaiSanPhamController;
import Models.LoaiSanPham;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thuan
 */
public class LoaiSanPhamController {
    public static Connection conn;
    public static Statement state;
    public static PreparedStatement pstate;
    public static String sql;

    public static List<LoaiSanPham> Select() {
        List<LoaiSanPham> listLoaiSanPham = new ArrayList<>();
        conn = null;
        state = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "Select * from loaisanpham";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                LoaiSanPham temp = new LoaiSanPham(
                        rs.getString("MaLSP"),
                        rs.getString("TenLSP"),
                        rs.getString("MoTa")
                );
                listLoaiSanPham.add(temp);

            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return listLoaiSanPham;

    }

    public static void Insert(LoaiSanPham tk) {
        try {
            conn = null;
            pstate = null;
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "INSERT INTO loaisanpham(MaLSP,TenLSP,MoTa) VALUES(?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getMaLSP());
            pstate.setString(2, tk.getTenLSP());
            pstate.setString(3, tk.getMoTa());
            pstate.execute();
            pstate.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void Update(LoaiSanPham tk, String macu) {
        try {
            conn = null;
            pstate = null;
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "UPDATE loaisanpham SET MaLSP=?,TenLSP=?,Mota=? WHERE MaLSP=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getMaLSP());
            pstate.setString(2, tk.getTenLSP());
            pstate.setString(3, tk.getMoTa());
            pstate.setString(4, macu);
            pstate.execute();
            pstate.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void Delete(String macu) {
        try {
            conn = null;
            pstate = null;
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "DELETE FROM loaisanpham WHERE MaLSP=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, macu);
            pstate.execute();
            pstate.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static List<LoaiSanPham> TimKiemTheoTenLoaiSanPham(String tenlsp) {
        List<LoaiSanPham> listLoaiSanPham = new ArrayList<>();
        conn = null;
        pstate = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "SELECT * FROM loaisanpham where TenLSP like ?";
            pstate = conn.prepareCall(sql);
            pstate.setString(1, "%" + tenlsp + "%");
            ResultSet rs = pstate.executeQuery();
            while (rs.next()) {
                LoaiSanPham temp = new LoaiSanPham(
                       rs.getString("MaLSP"),
                        rs.getString("TenLSP"),
                        rs.getString("MoTa")
                );
                listLoaiSanPham.add(temp);

            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return listLoaiSanPham;

    }

    // Kiem tra trung tenloaisanpham
    public static boolean KiemTraTrungMa(String manhap, boolean ktThem, String macu) {
        boolean kq = false;
        conn = null;
        state = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            if (ktThem == true) {
                sql = "SELECT TenLoaiSanPham FROM loaisanpham WHERE MaLSP = '" + manhap + "'";
            } else {
                sql = "SELECT TenLoaiSanPham FROM loaisanpham WHERE MaLSP='"
                        + manhap + "' and MaLSP<>'" + macu + "'";
            }
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            if (rs.next()) {
                kq = true;
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiSanPhamController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return kq;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.SanPham1;
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
public class SanPhamController {

    public static Connection conn;
    public static Statement state;
    public static PreparedStatement pstate;
    public static String sql;
    
   
    public static List<SanPham1> Select() {
        List<SanPham1> listSanPham = new ArrayList<>();
        conn = null;
        state = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "Select * from sanpham,loaisanpham where sanpham.MaLSP=loaisanpham.MaLSP";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                SanPham1 temp = new SanPham1(
                        rs.getString("MaSP"),
                        rs.getString("MaLSP"),
                        rs.getString("TenLSP"),
                        rs.getString("TenSP"),
                        rs.getString("HinhAnh"),
                        rs.getFloat("DonGia"),
                        rs.getInt("SoLuong")
                );
                listSanPham.add(temp);

            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
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
        return listSanPham;

    }
    
    
//    
//    public static int LaySLSP(String masp) {
//        List<SanPham1> listSanPham = new ArrayList<>();
//        conn = null;
//        state = null;
//        try {
//            conn = DriverManager.getConnection(connectDB.dbURL);
//            sql = "Select * from sanpham,loaisanpham where sanpham.MaLSP=loaisanpham.MaLSP";
//            state = conn.createStatement();
//            ResultSet rs = state.executeQuery(sql);
//            while (rs.next()) {
//                SanPham1 temp = new SanPham1(
//                        rs.getString("MaSP"),
//                        rs.getString("MaLSP"),
//                        rs.getString("TenLSP"),
//                        rs.getString("TenSP"),
//                        rs.getString("HinhAnh"),
//                        rs.getFloat("DonGia"),
//                        rs.getInt("SoLuong")
//                );
//                listSanPham.add(temp);
//
//            }
//            state.close();
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (state != null) {
//                try {
//                    state.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//        }
//        return listSanPham;
//
//    }
    
    
    
    

    public static void Insert(SanPham1 tk) {
        try {
            conn = null;
            pstate = null;
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "INSERT INTO sanpham(MaSP,MaLSP,TenSP,DonGia,SoLuong,HinhAnh) VALUES(?,?,?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getMaSP());
            pstate.setString(2, tk.getMaLSP());
            pstate.setString(3, tk.getTenSP());
            pstate.setFloat(4, tk.getDonGia());
            pstate.setInt(5, tk.getSoLuong());
            pstate.setString(6, tk.getHinhAnh());
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

    public static void Update(SanPham1 tk, String macu) {
        try {
            conn = null;
            pstate = null;
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "UPDATE sanpham SET MaSP=?,MaLSP=?,TenSP=?,DonGia=?,SoLuong=?,HinhAnh=? WHERE MaSP=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getMaSP());
            pstate.setString(2, tk.getMaLSP());
            pstate.setString(3, tk.getTenSP());
            pstate.setFloat(4, tk.getDonGia());
            pstate.setInt(5, tk.getSoLuong());
            pstate.setString(6, tk.getHinhAnh());
            pstate.setString(7, macu);
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
    
    public static void UpdateSLkhiban(String masp ,int soluong) {
        try {
            conn = null;
            pstate = null;
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "UPDATE sanpham SET SoLuong=? WHERE MaSP=?";
            pstate = conn.prepareStatement(sql);
            pstate.setInt(1, soluong);
            pstate.setString(2, masp);
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

    public static void Delete(String macu) {
        try {
            conn = null;
            pstate = null;
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "DELETE FROM sanpham WHERE MaSP=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, macu);
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

//    public static List<SanPham1> TimKiemTheoTenSanPham(String tenlsp) {
//        List<SanPham1> listSanPham = new ArrayList<>();
//        conn = null;
//        pstate = null;
//        try {
//            conn = DriverManager.getConnection(connectDB.dbURL);
//            sql = "Select * from sanpham,loaisanpham where sanpham.MaLSP=loaisanpham.MaLSP "
//                    + "and TenSP like ?";
//            pstate = conn.prepareCall(sql);
//            pstate.setString(1, "%" + tenlsp + "%");
//            ResultSet rs = pstate.executeQuery();
//            while (rs.next()) {
//                SanPham1 temp = new SanPham1(
//                        rs.getString("MaSP"),
//                        rs.getString("MaLSP"),
//                        rs.getString("TenLSP"),
//                        rs.getString("TenSP"),
//                        rs.getString("HinhAnh"),
//                        rs.getFloat("DonGia"),
//                        rs.getInt("SoLuong")
//                );
//                listSanPham.add(temp);
//
//            }
//            state.close();
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (state != null) {
//                try {
//                    state.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//        }
//        return listSanPham;
//
//    }
    
    public static List<SanPham1> TimKiem(String tenlsp, String tenSP) {
        List<SanPham1> listSanPham = new ArrayList<>();
        conn = null;
        pstate = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "Select * from sanpham,loaisanpham where sanpham.MaLSP=loaisanpham.MaLSP "
                    + "and TenSP like ? or TenLSP like ?";
            pstate = conn.prepareCall(sql);
            pstate.setString(1, "%" + tenSP + "%");
            pstate.setString(2, "%" + tenlsp + "%");
            ResultSet rs = pstate.executeQuery();
            while (rs.next()) {
                SanPham1 temp = new SanPham1(
                        rs.getString("MaSP"),
                        rs.getString("MaLSP"),
                        rs.getString("TenLSP"),
                        rs.getString("TenSP"),
                        rs.getString("HinhAnh"),
                        rs.getFloat("DonGia"),
                        rs.getInt("SoLuong")
                );
                listSanPham.add(temp);

            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
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
        return listSanPham;

    }

    // Kiem tra trung tensanpham
    public static boolean KiemTraTrungMa(String manhap, boolean ktThem, String macu) {
        boolean kq = false;
        conn = null;
        state = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            if (ktThem == true) {
                sql = "SELECT TenSanPham FROM sanpham WHERE MaSP = '" + manhap + "'";
            } else {
                sql = "SELECT TenSanPham FROM sanpham WHERE MaSP='"
                        + manhap + "' and MaSP<>'" + macu + "'";
            }
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            if (rs.next()) {
                kq = true;
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
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
        return kq;
    }
}

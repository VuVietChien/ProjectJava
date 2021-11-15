/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ChiTietHoaDon;
import Models.ChiTietPhieuNhap;
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

/**
 *
 * @author viết chiến
 */
public class ChiTietPhieuNhapController {
    public static Connection conn;
    public static Statement state;
    public static String sql;
    public static PreparedStatement pstate;
    public static ResultSet rs;
    public static void Insertctpn(ChiTietPhieuNhap ctpn) {
        try {
            conn = null;
            pstate = null;
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "INSERT INTO chitietphieunhap(MaPN,MaSP,soluong,DonGia) VALUES(?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, ctpn.getMaPN());
            pstate.setString(2, ctpn.getMaSP());
            pstate.setInt(3, ctpn.getSoLuong());
            pstate.setFloat(4, ctpn.getDonGia());
            
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

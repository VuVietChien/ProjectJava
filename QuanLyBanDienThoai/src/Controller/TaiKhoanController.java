/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.TaiKhoan;
import View.connectDB;
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

}

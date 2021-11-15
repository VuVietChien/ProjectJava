/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.PhieuNhap;
import Views.connectDB;
import static Views.connectDB.dbURL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author viết chiến
 */
public class PhieuNhapController {
    
    public static PreparedStatement pre;
    public static Connection conn;
    public static java.sql.Statement state;
    public static String sql;
    public static ResultSet rs;
    public static String LayMaPN() {
        List<PhieuNhap> listSanPham = new ArrayList<>();
        String maPN = "";
        conn = null;
        state = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "select top 1 * from phieunhap order by ngaynhap desc , MaPN desc";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
             
             while (rs.next()) {
                maPN = rs.getString("MaPN");
                
            }
             

            state.close();
            conn.close();
        } catch (SQLException ex) {
        } 
                String[] parts = maPN.split("N");
                String part1 = parts[0]; // H
                String part2 = parts[1];
                int a = Integer.parseInt(part2);
                a++;
                String mhdmoi ="PN" + String.valueOf(a);
            
        return mhdmoi;
    }
    
    public static void insertPN(PhieuNhap pn) {
        try {
            conn = DriverManager.getConnection(dbURL);
            String sql = "insert into PhieuNhap(MaPN,MaNCC,MaNV,ngayNhap,GioNhap,tongtien) values(?,?,?,?,?,?)";
            pre = conn.prepareStatement(sql);
            pre.setString(1, pn.getMaPN());
            pre.setString(2, pn.getMaNCC());
            pre.setString(3, pn.getMaNV());
            pre.setString(4, pn.getNgayNhap());
            pre.setString(5, pn.getGioNhap());
            pre.setFloat(6, pn.getTongTien());

            pre.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex);
        } finally {
            if (pre != null) {
                try {
                    pre.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi: " + ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi: " + ex);
                }
            }
        }
    }
}

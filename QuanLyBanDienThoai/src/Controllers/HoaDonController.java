package Controllers;

import Models.HoaDon;
import Views.connectDB;
import static Views.connectDB.dbURL;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoaDonController {

    public static PreparedStatement pre;
    public static Connection conn;
    public static java.sql.Statement state;
    public static String sql;
    public static ResultSet rs;
    
    public static String LayMahd() {
        List<HoaDon> listSanPham = new ArrayList<>();
        String mahd = "";
        conn = null;
        state = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            sql = "Select top 1 * from hoadon order by ngaylap desc";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
             
             while (rs.next()) {
                mahd = rs.getString("Mahd");
                
            }
             

            state.close();
            conn.close();
        } catch (SQLException ex) {
        } 
                String[] parts = mahd.split("D");
                String part1 = parts[0]; // H
                String part2 = parts[1];
                int a = Integer.parseInt(part2);
                a++;
                String mhdmoi ="HD" + String.valueOf(a);
            
        return mhdmoi;
    }

    public static void insertHD(HoaDon hd) {
        try {
            conn = DriverManager.getConnection(dbURL);
            String sql = "insert into HoaDon(mahd,manv,makh,ngaylap,tongtien) values(?,?,?,?,?)";
            pre = conn.prepareStatement(sql);
            pre.setString(1, hd.getMaHD());
            pre.setString(2, hd.getMaNV());
            pre.setString(3, hd.getMaKH());
            pre.setString(4, hd.getNgayLap());
            pre.setFloat(5, hd.getTongTien());

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

    public static void deleteHD(String maHD) {
        try {
            conn = DriverManager.getConnection(dbURL);
            String sql = "delete from HoaDon where maHD = ?";
            pre = conn.prepareStatement(sql);
            pre.setString(1, maHD);

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

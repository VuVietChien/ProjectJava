/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.TaiKhoanController.conn;
import static Controllers.TaiKhoanController.state;
import static Controllers.TaiKhoanController.sql;
import Views.connectDB;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thuan
 */
public class KiemTraDLController {
    public static boolean KiemTraTrungMa(String TenTruong, String TenBang, String manhap, boolean ktThem, String macu) {
        boolean kq = false;
        conn = null;
        state = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            if (ktThem == true) {
                sql = "SELECT " + TenTruong + " FROM " + TenBang + " WHERE " + TenTruong + "='" + manhap + "'";

            } else {
                sql = "SELECT " + TenTruong + "  FROM " + TenBang + " WHERE " + TenTruong + "='"
                        + manhap + "' and " + TenTruong + "<>'" + macu + "'";
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
    
    public static boolean isNumeric(String str)
    { 
        try {  
          Integer.parseInt(str);
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
    }
}

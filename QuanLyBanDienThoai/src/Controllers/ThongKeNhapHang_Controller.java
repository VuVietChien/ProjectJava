
package Controllers;

import static Controllers.ThongKeDoanhSo_Controller.conn;
import static Controllers.ThongKeDoanhSo_Controller.pstate;
import static Controllers.ThongKeDoanhSo_Controller.rs;
import Models.ChiTietPhieuNhap;
import Models.ThongKe;
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


public class ThongKeNhapHang_Controller {
    public static Connection conn;
    public static Statement state;
    public static String sql;
    public static PreparedStatement pstate;
    public static ResultSet rs;
    
    public static List<ChiTietPhieuNhap> layNguonPN(){
        List<ChiTietPhieuNhap> ctpnList = new ArrayList<>();
        conn = null;
        pstate = null;
        rs = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "select phieunhap.MaPN,TenNV,TenNCC,sanpham.TenSP,NgayNhap,chitietphieunhap.SoLuong,chitietphieunhap.DonGia,sum(chitietphieunhap.SoLuong * chitietphieunhap.DonGia)as 'thanhTien'\n" +
"from phieunhap inner join chitietphieunhap on phieunhap.MaPN=chitietphieunhap.MaPN inner join nhacungcap on phieunhap.MaNCC=nhacungcap.MaNCC\n" +
"inner join NhanVien on phieunhap.MaNV=NhanVien.MaNV ,sanpham\n" +
"where phieunhap.MaNV=NhanVien.MaNV and chitietphieunhap.MaSP=sanpham.MaSP\n" +
"group by phieunhap.MaPN, TenNV, TenNCC, sanpham.TenSP,NgayNhap,chitietphieunhap.SoLuong,chitietphieunhap.DonGia";
            pstate = conn.prepareStatement(sql);
            rs = pstate.executeQuery();
            while (rs.next()) {
                ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
                ct.setMaPN(rs.getString("maPN"));
                ct.setTenNV(rs.getString("tenNV"));
                ct.setTenNCC(rs.getString("tenNCC"));
                ct.setTenSP(rs.getString("tenSP"));
                ct.setNgayLap(rs.getString("ngaylap"));
                ct.setSoLuong(rs.getInt("SoLuong"));
                ct.setDonGia(rs.getFloat("DonGia"));
                ct.setThanhTien(rs.getFloat("thanhTien"));
                ctpnList.add(ct);
            }
        } catch (SQLException ex) {
            System.out.println("Lôi: " + ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeNhapHang_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeNhapHang_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return ctpnList;
    }
    
    public static List<ChiTietPhieuNhap> findByDatePN(String ngayLap){
        List<ChiTietPhieuNhap> ctpnList = new ArrayList<>();
        conn = null;
        pstate = null;
        rs = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "select phieunhap.MaPN,TenNV,TenNCC,sanpham.TenSP,NgayNhap,chitietphieunhap.SoLuong,chitietphieunhap.DonGia,sum(chitietphieunhap.SoLuong * chitietphieunhap.DonGia)as 'thanhTien'\n" +
"from phieunhap inner join chitietphieunhap on phieunhap.MaPN=chitietphieunhap.MaPN inner join nhacungcap on phieunhap.MaNCC=nhacungcap.MaNCC\n" +
"inner join NhanVien on phieunhap.MaNV=NhanVien.MaNV ,sanpham\n" +
"where phieunhap.MaNV=NhanVien.MaNV and chitietphieunhap.MaSP=sanpham.MaSP and NgayNhap=?\n" +
"group by phieunhap.MaPN, TenNV, TenNCC, sanpham.TenSP,NgayNhap,chitietphieunhap.SoLuong,chitietphieunhap.DonGia";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, ngayLap);
            rs = pstate.executeQuery();
            while (rs.next()) {
                ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
                ct.setMaPN(rs.getString("maPN"));
                ct.setTenNV(rs.getString("tenNV"));
                ct.setTenNCC(rs.getString("tenNCC"));
                ct.setTenSP(rs.getString("tenSP"));
                ct.setNgayLap(rs.getString("ngaylap"));
                ct.setSoLuong(rs.getInt("SoLuong"));
                ct.setDonGia(rs.getFloat("DonGia"));
                ct.setThanhTien(rs.getFloat("thanhTien"));
                ctpnList.add(ct);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeNhapHang_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeNhapHang_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return ctpnList;
    }
    
    public static List<ChiTietPhieuNhap> sortByTTPN() {
        List<ChiTietPhieuNhap> ctpns = new ArrayList<>();
        conn = null;
        pstate = null;
        rs = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "select phieunhap.MaPN,TenNV,TenNCC,sanpham.TenSP,NgayNhap,chitietphieunhap.SoLuong,chitietphieunhap.DonGia,sum(chitietphieunhap.SoLuong * chitietphieunhap.DonGia)as 'thanhTien'\n" +
"from phieunhap inner join chitietphieunhap on phieunhap.MaPN=chitietphieunhap.MaPN inner join nhacungcap on phieunhap.MaNCC=nhacungcap.MaNCC\n" +
"inner join NhanVien on phieunhap.MaNV=NhanVien.MaNV ,sanpham\n" +
"where phieunhap.MaNV=NhanVien.MaNV and chitietphieunhap.MaSP=sanpham.MaSP\n" +
"group by phieunhap.MaPN, TenNV, TenNCC, sanpham.TenSP,NgayNhap,chitietphieunhap.SoLuong,chitietphieunhap.DonGia\n" +
"order by thanhTien";
            
            pstate = conn.prepareStatement(sql);
            rs = pstate.executeQuery();
            while (rs.next()) {
                ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
                ct.setMaPN(rs.getString("maPN"));
                ct.setTenNV(rs.getString("tenNV"));
                ct.setTenNCC(rs.getString("tenNCC"));
                ct.setTenSP(rs.getString("tenSP"));
                ct.setNgayLap(rs.getString("ngaylap"));
                ct.setSoLuong(rs.getInt("SoLuong"));
                ct.setDonGia(rs.getFloat("DonGia"));
                ct.setThanhTien(rs.getFloat("thanhTien"));
                ctpns.add(ct);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeNhapHang_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeNhapHang_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return ctpns;
     }
    
    public static List<ThongKe> getTongTienPN() {
        List<ThongKe> tkList = new ArrayList<>();
        conn = null;
        pstate = null;
        rs = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "select sum(SoLuong*donGia) as 'tongTien'\n" +
                          "from ChiTietPhieuNhap";
            pstate = conn.prepareStatement(sql);
            rs = pstate.executeQuery();
            while (rs.next()) {
                ThongKe tk = new ThongKe();
                tk.setThanhTien(Float.parseFloat(rs.getString("tongTien")));
                tkList.add(tk);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
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
        return tkList;
    }
}

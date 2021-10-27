
package Controllers;


import Models.ChiTietHoaDon;
import Models.KhachHang;
import Models.NhaCungCap;
import Models.NhanVien;
import Models.SanPham1;
import Models.ThongKe;
//import Views.QuanLyThongKe;
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


public class ThongKeDoanhSoController {
    public static Connection conn;
    public static Statement state;
    public static String sql;
    public static PreparedStatement pstate;
    public static ResultSet rs;
    
    //thống kê bán hàng
    public static List<ChiTietHoaDon> layNguon(){
        List<ChiTietHoaDon> cthdList = new ArrayList<>();
        conn = null;
        pstate = null;
        rs = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "select ChiTietHoaDon.maHD,tenNV, tenKH,sanpham.TenSP, ngayLap,chitiethoadon.SoLuong,chitiethoadon.DonGia,sum(chitiethoadon.SoLuong * chitiethoadon.DonGia) as 'thanhTien'\n" +
"from ChiTietHoaDon inner join SanPham on SanPham.maSP = ChiTietHoaDon.maSP inner join HoaDon on ChiTietHoaDon.maHD = HoaDon.maHD inner join khachhang on khachhang.MaKH = HoaDon.MaKH, NhanVien\n" +
"where NhanVien.maNV = HoaDon.maNV\n" +
"group by ChiTietHoaDon.maHD, HoaDon.maNV, tenNV, tenKH,sanpham.TenSP, ngayLap,chitiethoadon.SoLuong,chitiethoadon.DonGia";
            pstate = conn.prepareStatement(sql);
            rs = pstate.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon ct = new ChiTietHoaDon();
                ct.setMaHD(rs.getString("maHD"));
                ct.setTenNV(rs.getString("tenNV"));
                ct.setTenKH(rs.getString("tenKH"));
                ct.setTenSP(rs.getString("tenSP"));
                ct.setNgayLap(rs.getString("ngaylap"));
                ct.setSoLuong(rs.getInt("SoLuong"));
                ct.setDongia(rs.getFloat("DonGia"));
                ct.setThanhTien(rs.getFloat("thanhTien"));
                cthdList.add(ct);
            }
        } catch (SQLException ex) {
            System.out.println("Lôi: " + ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDoanhSoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDoanhSoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cthdList;
    }
    
    public static List<ChiTietHoaDon> findByDate(String ngayLap){
        List<ChiTietHoaDon> cthdList = new ArrayList<>();
        conn = null;
        pstate = null;
        rs = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "select ChiTietHoaDon.maHD,tenNV, tenKH,sanpham.TenSP, ngayLap,chitiethoadon.SoLuong,chitiethoadon.DonGia,sum(chitiethoadon.SoLuong * chitiethoadon.DonGia) as 'thanhTien'\n" +
"from ChiTietHoaDon inner join SanPham on SanPham.maSP = ChiTietHoaDon.maSP inner join HoaDon on ChiTietHoaDon.maHD = HoaDon.maHD inner join khachhang on khachhang.MaKH = HoaDon.MaKH, NhanVien\n" +
"where NhanVien.maNV = HoaDon.maNV and ngayLap=?\n" +
"group by ChiTietHoaDon.maHD, HoaDon.maNV, tenNV, tenKH,sanpham.TenSP, ngayLap,chitiethoadon.SoLuong,chitiethoadon.DonGia";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, ngayLap);
            rs = pstate.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon ct = new ChiTietHoaDon();
                ct.setMaHD(rs.getString("maHD"));
                ct.setMaNV(rs.getString("tenNV"));
                ct.setTenKH(rs.getString("tenKH"));
                ct.setTenSP(rs.getString("tenSP"));
                ct.setNgayLap(rs.getString("ngaylap"));
                ct.setSoLuong(rs.getInt("SoLuong"));
                ct.setDongia(rs.getFloat("DonGia"));
                ct.setThanhTien(rs.getFloat("thanhTien"));
                cthdList.add(ct);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDoanhSoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDoanhSoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cthdList;
    }
    
     public static List<ChiTietHoaDon> sortByTT() {
        List<ChiTietHoaDon> cthds = new ArrayList<>();
        conn = null;
        pstate = null;
        rs = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "select ChiTietHoaDon.maHD,tenNV, tenKH,sanpham.TenSP, ngayLap,chitiethoadon.SoLuong,chitiethoadon.DonGia,sum(chitiethoadon.SoLuong * chitiethoadon.DonGia) as 'thanhTien'\n" +
"from ChiTietHoaDon inner join SanPham on SanPham.maSP = ChiTietHoaDon.maSP inner join HoaDon on ChiTietHoaDon.maHD = HoaDon.maHD inner join khachhang on khachhang.MaKH = HoaDon.MaKH, NhanVien\n" +
"where NhanVien.maNV = HoaDon.maNV \n" +
"group by ChiTietHoaDon.maHD, HoaDon.maNV, tenNV, tenKH,sanpham.TenSP, ngayLap,chitiethoadon.SoLuong,chitiethoadon.DonGia\n" +
"order by thanhTien";
            
            pstate = conn.prepareStatement(sql);
            rs = pstate.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon ct = new ChiTietHoaDon();
                ct.setMaHD(rs.getString("maHD"));
                ct.setTenNV(rs.getString("tenNV"));
                ct.setTenKH(rs.getString("tenKH"));
                ct.setTenSP(rs.getString("tenSP"));
                ct.setNgayLap(rs.getString("ngaylap"));
                ct.setSoLuong(rs.getInt("SoLuong"));
                ct.setDongia(rs.getFloat("DonGia"));
                ct.setThanhTien(rs.getFloat("thanhTien"));
                cthds.add(ct);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDoanhSoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDoanhSoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cthds;
     }
    
    public static List<ThongKe> getTongTien() {
        List<ThongKe> tkList = new ArrayList<>();
        conn = null;
        pstate = null;
        rs = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "select sum(SoLuong*donGia) as 'tongTien'\n" +
                          "from ChiTietHoaDon";
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
    
    
    //thống kê tổng quát
    public static List<SanPham1> getTongSP() {
        List<SanPham1> tksp = new ArrayList<>();
        
        conn = null;
        pstate = null;
        rs = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "select count(MaSP) as 'soluong' from sanpham";
            pstate = conn.prepareStatement(sql);
            rs = pstate.executeQuery();
            while (rs.next()) {
                SanPham1 tk1 = new SanPham1();
                tk1.setMaSP(rs.getString("soluong"));
                tksp.add(tk1);
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
        return tksp;
    }
    
     public static List<NhanVien> getTongNV() {
        List<NhanVien> tknv = new ArrayList<>();
        
        conn = null;
        pstate = null;
        rs = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "select count(MaNV) as 'soluong' from nhanvien";
            pstate = conn.prepareStatement(sql);
            rs = pstate.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("soluong"));
                tknv.add(nv);
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
        return tknv;
    }
    
     public static List<KhachHang> getTongKH() {
        List<KhachHang> tkkh = new ArrayList<>();
        
        conn = null;
        pstate = null;
        rs = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "select count(MaKH) as 'soluong' from khachhang";
            pstate = conn.prepareStatement(sql);
            rs = pstate.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKHString(rs.getString("soluong"));
                tkkh.add(kh);
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
        return tkkh;
    }
     
        
    public static List<NhaCungCap> getTongNCC() {
        List<NhaCungCap> tkncc = new ArrayList<>();
        
        conn = null;
        pstate = null;
        rs = null;
        try {
            conn = DriverManager.getConnection(connectDB.dbURL);
            String sql = "select count(MaNCC) as 'soluong' from NhaCungCap";
            pstate = conn.prepareStatement(sql);
            rs = pstate.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getString("soluong"));
                tkncc.add(ncc);
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
        return tkncc;
    }
}


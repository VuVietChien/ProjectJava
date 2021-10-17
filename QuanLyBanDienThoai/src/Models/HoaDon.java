/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


public class HoaDon extends NhanVien {
     private String MaHD,MaKH,NgayLap;
     private float TongTien;
    public HoaDon() {
    }


    public HoaDon(String MaHD, String MaKH, String NgayLap, float TongTien, String MaNV, String TenNV, String NgaySinh, String DiaChi, String SDT) {
        super(MaNV, TenNV, NgaySinh, DiaChi, SDT);
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.NgayLap = NgayLap;
        this.TongTien = TongTien;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String NgayLap) {
        this.NgayLap = NgayLap;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    
     
}

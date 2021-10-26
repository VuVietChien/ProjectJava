/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;


public class HoaDon extends NhanVien {
     protected Date nhapDate;
     protected String MaHD,MaKH,NgayLap,TenKH,TenSP;
     protected int soluong;
     protected float TongTien,dongia;

    public HoaDon() {
    }
    
    
//    public HoaDon(String MaHD, String MaKH, String NgayLap, String TenKH, float TongTien, String MaNV, String TenNV, String NgaySinh, String DiaChi, String SDT) {
//        super(MaNV, TenNV, NgaySinh, DiaChi, SDT);
//        this.MaHD = MaHD;
//        this.MaKH = MaKH;
//        this.NgayLap = NgayLap;
//        this.TenKH = TenKH;
//        this.TongTien = TongTien;
//    }
//
//
//    
//    public HoaDon(String maNV, String ngayLap, String tenKH){
//       // super(MaNV);
//        this.TenKH = tenKH;
//        this.NgayLap = ngayLap;
//    }
//
//    
//
//    public HoaDon(String MaHD, String MaKH, String NgayLap, float TongTien) {
//        this.MaHD = MaHD;
//        this.MaKH = MaKH;
//        this.NgayLap = NgayLap;
//        this.TongTien = TongTien;
//    }
//    

    public HoaDon(String MaHD, String MaKH, String NgayLap, String TenKH, String TenSP, int soluong, float TongTien, float dongia) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.NgayLap = NgayLap;
        this.TenKH = TenKH;
        this.TenSP = TenSP;
        this.soluong = soluong;
        this.TongTien = TongTien;
        this.dongia = dongia;
    }


    
    public HoaDon(String maNV, String ngayLap, String tenKH){
       // super(MaNV);
        this.TenKH = tenKH;
        this.NgayLap = ngayLap;
    }

    

    public HoaDon(String MaHD , String MaNV, String MaKH, String NgayLap, float TongTien) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.NgayLap = NgayLap;
        this.TenKH = TenKH;
        this.TenSP = TenSP;
        this.soluong = soluong;
        this.TongTien = TongTien;
        this.MaNV = MaNV;
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

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
    
     @Override
    public void setSDT(String SDT) {
        this.SDT = SDT;
    }


}
        
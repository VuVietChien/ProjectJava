/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author admin
 */
public class ChiTietHoaDon extends HoaDon{
    protected String MaHD,MSP;
    protected int SoLuong;
    protected float thanhTien,DonGia;

    public ChiTietHoaDon() {
    }
    
//    public ChiTietHoaDon(String MaHD, String MSP, int DonGia, int SoLuong, float thanhTien) {
//        this.MaHD = MaHD;
//        this.MSP = MSP;
//        this.DonGia = DonGia;
//        this.SoLuong = SoLuong;
//        this.thanhTien = thanhTien;
//    }
//
//    public ChiTietHoaDon(String MaHD, String MSP, int DonGia, int SoLuong, float thanhTien, String MaKH, String NgayLap, float TongTien, String MaNV, String TenNV, String NgaySinh, String DiaChi, String SDT) {
//  
//        this.MaHD = MaHD;
//        this.MSP = MSP;
//        this.DonGia = DonGia;
//        this.SoLuong = SoLuong;
//        this.thanhTien = thanhTien;
//    }
//
//    public ChiTietHoaDon(String maHD, String ngayLap, String tenNV,String tenKH, float thanhTien){
//        super(tenNV, ngayLap,tenKH);
//        this.MaHD = maHD;
//        this.thanhTien = thanhTien;
//    }

    public ChiTietHoaDon(String MaHD, String MSP, String TenNV, int SoLuong, float thanhTien, float DonGia) {
        this.MaHD = MaHD;
        this.MSP = MSP;
        this.TenNV = TenNV;
        this.SoLuong = SoLuong;
        this.thanhTien = thanhTien;
        this.DonGia = DonGia;
    }

    
    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "MaHD=" + MaHD + ", MSP=" + MSP + ", DonGia=" + DonGia + ", SoLuong=" + SoLuong + '}';
    }
    
    
//    public String getMaHD() {
//        return MaHD;
//    }
//
//    public void setMaHD(String MaHD) {
//        this.MaHD = MaHD;
//    }
//
//    public String getMSP() {
//        return MSP;
//    }
//
//    public void setMSP(String MSP) {
//        this.MSP = MSP;
//    }
//
//    public int getDonGia() {
//        return DonGia;
//    }
//
//    public void setDonGia(int DonGia) {
//        this.DonGia = DonGia;
//    }
//
//    public int getSoLuong() {
//        return SoLuong;
//    }
//
//    public void setSoLuong(int SoLuong) {
//        this.SoLuong = SoLuong;
//    }
//
//    public float getThanhTien() {
//        return thanhTien;
//    }
//
//    public void setThanhTien(float thanhTien) {
//        this.thanhTien = thanhTien;
//    }
//    
//   

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMSP() {
        return MSP;
    }

    public void setMSP(String MSP) {
        this.MSP = MSP;
    }

    

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
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

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    
    
    
}

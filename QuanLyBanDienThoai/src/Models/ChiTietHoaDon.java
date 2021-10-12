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
    protected String MaHD,MSP,SoLuong,DonGia;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String MaHD, String MSP, String SoLuong, String DonGia) {
        this.MaHD = MaHD;
        this.MSP = MSP;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public ChiTietHoaDon(String MaHD, String MSP, String SoLuong, String DonGia, String MaKH, String NgayLap, String TongTien) {
        super(MaHD, MaKH, NgayLap, TongTien);
        this.MaHD = MaHD;
        this.MSP = MSP;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public ChiTietHoaDon(String MaHD, String MSP, String SoLuong, String DonGia, String MaKH, String NgayLap, String TongTien, String MaNV, String TenNV, String NgaySinh, String DiaChi, String SDT) {
        super(MaHD, MaKH, NgayLap, TongTien, MaNV, TenNV, NgaySinh, DiaChi, SDT);
        this.MaHD = MaHD;
        this.MSP = MSP;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

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

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getDonGia() {
        return DonGia;
    }

    public void setDonGia(String DonGia) {
        this.DonGia = DonGia;
    }
    
}

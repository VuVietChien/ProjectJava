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
    protected String MaHD,MSP,DonGia;
    protected int SoLuong;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String MaHD, String MSP, String DonGia, int SoLuong) {
        this.MaHD = MaHD;
        this.MSP = MSP;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
    }

    public ChiTietHoaDon(String MaHD, String MSP, String DonGia, int SoLuong, String MaKH, String NgayLap, float TongTien, String MaNV, String TenNV, String NgaySinh, String DiaChi, String SDT) {
        super(MaHD, MaKH, NgayLap, TongTien, MaNV, TenNV, NgaySinh, DiaChi, SDT);
        this.MaHD = MaHD;
        this.MSP = MSP;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
    }

   
    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "MaHD=" + MaHD + ", MSP=" + MSP + ", DonGia=" + DonGia + ", SoLuong=" + SoLuong + '}';
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

    public String getDonGia() {
        return DonGia;
    }

    public void setDonGia(String DonGia) {
        this.DonGia = DonGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    
    
}

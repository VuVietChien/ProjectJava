/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author thuan
 */
public class SanPham1 {

    String MaSP, MaLSP, TenSP, HinhAnh, TenLSP;
    float DonGia;
    int SoLuong;

    public SanPham1(String MaSP, String MaLSP, String TenSP, String HinhAnh, float DonGia, int SoLuong) {
        this.MaSP = MaSP;
        this.MaLSP = MaLSP;
        this.TenSP = TenSP;
        this.HinhAnh = HinhAnh;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
    }

    public SanPham1(String MaSP, String MaLSP, String TenLSP, String TenSP, String HinhAnh, float DonGia, int SoLuong) {
        this.MaSP = MaSP;
        this.MaLSP = MaLSP;
        this.TenSP = TenSP;
        this.HinhAnh = HinhAnh;
        this.TenLSP = TenLSP;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
    }

    public SanPham1() {
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getMaLSP() {
        return MaLSP;
    }

    public void setMaLSP(String MaLSP) {
        this.MaLSP = MaLSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getTenLSP() {
        return TenLSP;
    }

    public void setTenLSP(String TenLSP) {
        this.TenLSP = TenLSP;
    }

}

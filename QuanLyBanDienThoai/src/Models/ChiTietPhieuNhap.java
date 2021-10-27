
package Models;


public class ChiTietPhieuNhap extends PhieuNhap{
    protected String MaPN,MaSP,TenNCC;
    protected int SoLuong;
    protected float DonGia,ThanhTien;

    public ChiTietPhieuNhap() {
    }
    
    
    
    public ChiTietPhieuNhap(String MaPN, String MaSP, String TenNCC, int SoLuong, float DonGia, float ThanhTien, String MaNCC, String MaNV, String NgayLap, String TenKH, String TenSP, float TongTien) {
        super(MaPN, MaNCC, MaNV, NgayLap, TenKH, TenSP, TongTien);
        this.MaPN = MaPN;
        this.MaSP = MaSP;
        this.TenNCC = TenNCC;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.ThanhTien = ThanhTien;
    }

    public ChiTietPhieuNhap(String MaPN, String MaSP, String TenNCC, int SoLuong, float DonGia, float ThanhTien, String MaNCC, String MaNV, String NgayLap, String TenKH, String TenSP, float TongTien, String TenNV, String NgaySinh, String DiaChi, String SDT) {
        super(MaPN, MaNCC, MaNV, NgayLap, TenKH, TenSP, TongTien, TenNV, NgaySinh, DiaChi, SDT);
        this.MaPN = MaPN;
        this.MaSP = MaSP;
        this.TenNCC = TenNCC;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.ThanhTien = ThanhTien;
    }

    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }


    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
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

    
    
}

 
package Models;


public class PhieuNhap extends NhanVien{
    protected String MaPN,MaNCC,MaNV,NgayNhap,gioNhap,TenKH,TenSP;
    protected float TongTien;

    public PhieuNhap() {
    }
     
    
    public PhieuNhap(String MaPN, String MaNCC, String MaNV, String NgayNhap, String TenKH, String TenSP, float TongTien) {
        this.MaPN = MaPN;
        this.MaNCC = MaNCC;
        this.MaNV = MaNV;
        this.NgayNhap = NgayNhap;
        this.TenKH = TenKH;
        this.TenSP = TenSP;
        this.TongTien = TongTien;
    }

    public PhieuNhap(String MaPN, String MaNCC, String MaNV, String NgayNhap, String gioNhap, float TongTien) {
        this.MaPN = MaPN;
        this.MaNCC = MaNCC;
        this.MaNV = MaNV;
        this.NgayNhap = NgayNhap;
        this.gioNhap = gioNhap;
        this.TongTien = TongTien;
    }
    
    
    

    public PhieuNhap(String MaPN, String MaNCC, String MaNV, String NgayNhap, String TenKH, String TenSP, float TongTien, String TenNV, String NgaySinh, String DiaChi, String SDT) {
        super(MaNV, TenNV, NgaySinh, DiaChi, SDT);
        this.MaPN = MaPN;
        this.MaNCC = MaNCC;
        this.MaNV = MaNV;
        this.NgayNhap = NgayNhap;
        this.TenKH = TenKH;
        this.TenSP = TenSP;
        this.TongTien = TongTien;
    }

    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
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

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
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

    public String getGioNhap() {
        return gioNhap;
    }

    public void setGioNhap(String gioNhap) {
        this.gioNhap = gioNhap;
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

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
}

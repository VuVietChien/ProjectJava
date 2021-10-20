
package Models;


public class TaiKhoan {
    String TenTaiKhoan,MatKhau,MaNV,MaQuyen,TenQuyen,TenNV;

    public TaiKhoan() {
    }

    public TaiKhoan(String TenTaiKhoan, String MatKhau, String MaNV, String MaQuyen) {
        this.TenTaiKhoan = TenTaiKhoan;
        this.MatKhau = MatKhau;
        this.MaNV = MaNV;
        this.MaQuyen = MaQuyen;
    }

    public TaiKhoan(String TenTaiKhoan, String MatKhau, String MaNV, String MaQuyen, String TenQuyen, String TenNV) {
        this.TenTaiKhoan = TenTaiKhoan;
        this.MatKhau = MatKhau;
        this.MaNV = MaNV;
        this.MaQuyen = MaQuyen;
        this.TenQuyen = TenQuyen;
        this.TenNV = TenNV;
    }
    
    public String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public void setTenTaiKhoan(String TenTaiKhoan) {
        this.TenTaiKhoan = TenTaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaQuyen() {
        return MaQuyen;
    }

    public void setMaQuyen(String MaQuyen) {
        this.MaQuyen = MaQuyen;
    }

    public String getTenQuyen() {
        return TenQuyen;
    }

    public void setTenQuyen(String TenQuyen) {
        this.TenQuyen = TenQuyen;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }
    
    
}

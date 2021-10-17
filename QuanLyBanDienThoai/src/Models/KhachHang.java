package Models;

public class KhachHang {

    private String maKHString;
    private String tenKH;
    private String diaChiString;
    private  String Sodt;
    //private int trangThaiString;

    public KhachHang() {
    }

    public KhachHang(String maKHString, String tenKH, String diaChiString, String Sodt) {
        this.maKHString = maKHString;
        this.tenKH = tenKH;
        this.diaChiString = diaChiString;
        this.Sodt = Sodt;
       // this.trangThaiString = trangThaiString;
    }

    public String getMaKHString() {
        return maKHString;
    }

    public void setMaKHString(String maKHString) {
        this.maKHString = maKHString;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChiString() {
        return diaChiString;
    }

    public void setDiaChiString(String diaChiString) {
        this.diaChiString = diaChiString;
    }

    public String getSodt() {
        return Sodt;
    }

    public void setSodt(String Sodt) {
        this.Sodt = Sodt;
    }

//    public int getTrangThaiString() {
//        return trangThaiString;
//    }
//
//    public void setTrangThaiString(int trangThaiString) {
//        this.trangThaiString = trangThaiString;
//    }
    
    

}
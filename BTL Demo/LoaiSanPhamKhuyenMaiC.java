package Demo7;
import java.util.Scanner;

public class LoaiSanPhamKhuyenMaiC {
    private String loaiSanPhamString;
    private double phanTramGiam;

    public LoaiSanPhamKhuyenMaiC(String loaiSanPhamString, double phanTramGiam) {
        this.loaiSanPhamString = loaiSanPhamString;
        this.phanTramGiam = phanTramGiam;
    }
    
    static LoaiSanPhamKhuyenMaiC nhapSPGiamGiaKMC(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Loai San Pham  : ");
        String loaiSP = sc.nextLine();
        System.out.println("Phan Tram Giam : ");
        double gg = Double.parseDouble(sc.nextLine());
        LoaiSanPhamKhuyenMaiC sP = new LoaiSanPhamKhuyenMaiC(loaiSP,gg);
        return sP;
    }
    
    String ToString(){
        return this.loaiSanPhamString +" " +String.valueOf(this.phanTramGiam);
    }
    
}
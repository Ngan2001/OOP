import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TT
 */
public class KhuyenMaiC extends KhuyenMai{
    static ArrayList<KhuyenMaiC>  listC = new ArrayList<KhuyenMaiC>();
    ArrayList<LoaiSanPhamKhuyenMaiC> sanPhamMKMuaKem = new ArrayList<LoaiSanPhamKhuyenMaiC>();
    static int dem = -1;




    KhuyenMaiC() {
              this.maKM = "C";
        dem++;
        for(int i =0;i<5-String.valueOf(dem).length();i++){
            this.maKM += "0";
        }
        this.maKM +=  String.valueOf(dem);        
    }
    
        void nhapKhuyenMai() throws ParseException{
        Scanner sc = new Scanner(System.in);
        super.nhapKhuyenMai();
        ArrayList<LoaiSanPhamKhuyenMaiC>  sanPhamMKMuaKem= new ArrayList<LoaiSanPhamKhuyenMaiC>();
        System.out.print("Số sản phẩm KM mua kèm: ");
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0;i<n;i++){
            System.out.println("Sản phẩm "+(i+1)+": ");
            sanPhamMKMuaKem.add(LoaiSanPhamKhuyenMaiC.nhapSPGiamGiaKMC());
        }
        this.sanPhamMKMuaKem = sanPhamMKMuaKem;
        
    }

}
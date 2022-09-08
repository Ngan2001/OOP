
import java.text.ParseException;
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
public class KhuyenMaiA extends KhuyenMai{
    private double giamGia ;

    public void setTyLePhanTram(int tyLePhanTram) {
        this.tyLePhanTram = tyLePhanTram;
    }
    private static int dem = -1;
    private int tyLePhanTram;
    public KhuyenMaiA(int tyLe){
        this.tyLePhanTram = tyLe;
    }

    @Override
         void nhapKhuyenMai() throws ParseException{
        super.nhapKhuyenMai();
        Scanner sc  = new Scanner(System.in);
        this.maKM = "A";
         dem++;
        for(int i =0;i<2-String.valueOf(dem).length();i++){
            this.maKM += "0";
        }
        this.maKM +=  String.valueOf(dem);
             System.out.println("\nGiảm Giá Của Khuyến Mãi (Tính theo %): ");
        double tlgg = sc.nextDouble();

        this.giamGia = tlgg;

    }

    public KhuyenMaiA() throws ParseException {
    }

}
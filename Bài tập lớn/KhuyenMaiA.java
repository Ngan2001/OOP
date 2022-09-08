package Demo7;
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





    /**
     * @return the tyLePhanTram
     */
    /*    public int getTyLePhanTram() {
    return tyLePhanTram;
    }*/

    /**
     * @param tyLePhanTram the tyLePhanTram to set
     */
    public void setTyLePhanTram(int tyLePhanTram) {
        this.tyLePhanTram = tyLePhanTram;
    }
    private static int dem = -1;
    private int tyLePhanTram;
    public KhuyenMaiA(int tyLe){
        this.tyLePhanTram = tyLe;
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += " Tỷ Lệ Phần Trăm Giảm Giá: "+ this.giamGia+" %";
        return s;
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

             System.out.println("Giảm Giá Của Khuyến Mãi : ");
        double tlgg = sc.nextDouble();

        this.giamGia = tlgg;

    }

    public KhuyenMaiA() throws ParseException {
    }

}
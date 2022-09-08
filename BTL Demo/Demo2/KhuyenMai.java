
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class KhuyenMai {
    protected String maKM;
    protected Date ngayTao;
    protected Date ngayHetHieuLuc;

    public String getMaKM() {
        return maKM;
    }



    @Override
    public String toString() {
        
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String s = "Mã Khuyến Mãi: "+this.maKM+"\nNgày Tạo: "+f.format(ngayTao)+"\nNgay Hết "+ "Hiệu Lực: "+f.format(ngayHetHieuLuc)+"\n";
        if(check()){
            s+="Hiệu Lực: Còn";
        }else 
            s+="Hiệu Lực: Hết";
        return s;
    }

    public KhuyenMai(){}
    
    void nhapKhuyenMai() throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ngày tạo\n Ngày: ");
        String d = sc.nextLine();
        Date ngayTao = df.parse(d);
        System.out.print("Nhập Ngày Kết Thúc\n Ngày: ");
        d = sc.nextLine();
        Date ngayKetThuc = df.parse(d);
        this.ngayTao  =ngayTao;
        this.ngayHetHieuLuc = ngayKetThuc;
    }
        boolean check(){
         Date n = new Date();
         if(this.ngayHetHieuLuc.getTime()  >n.getTime())
             return true;
         else   return false;
     }
    }

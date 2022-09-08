
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class ThanhVien {
    private static int dem = 0;
    private int stt = ++dem;
    private String hoTen;
    private GregorianCalendar ngaySinh;
    private GregorianCalendar ngayGiaNhap;
    private String gioiTinh;
    private String queQuan;
    private double[] diemMH;
    
    public void ThanhVien(String hoTen, GregorianCalendar ngaySinh, 
            GregorianCalendar ngayGiaNhap, String gioiTinh, String queQuan) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.ngayGiaNhap = ngayGiaNhap;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
    }
    
    public void nhapThanhVien(Scanner scanner){
        System.out.print("- Họ và tên: ");
        this.setHoTen(scanner.nextLine());
        System.out.print("- Giới tính: ");
        this.setQueQuan(scanner.nextLine());
        System.out.print("- Quê quán: ");
        this.setQueQuan(scanner.nextLine()); 
    }
    
   
    
    public void hienThiThanhVien() {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("+ STT: %d\n+ Họ tên: %s\n+ Ngày sinh: %d\n"
                + "+ Ngày gia nhập: %d\n+ Giới tính: %s\n+ Quê quán: %s\n",
                this.stt, this.hoTen, f.format(this.getNgaySinh().getTime()),
                f.format(this.ngayGiaNhap.getTime()), this.gioiTinh, 
                this.queQuan);
    }

    
    
    
    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the ngaySinh
     */
    public GregorianCalendar getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(GregorianCalendar ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the ngayGiaNhap
     */
    public GregorianCalendar getNgayGiaNhap() {
        return ngayGiaNhap;
    }

    /**
     * @param ngayGiaNhap the ngayGiaNhap to set
     */
    public void setNgayGiaNhap(GregorianCalendar ngayGiaNhap) {
        this.ngayGiaNhap = ngayGiaNhap;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the queQuan
     */
    public String getQueQuan() {
        return queQuan;
    }

    /**
     * @param queQuan the queQuan to set
     */
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    /**
     * @return the diemMH
     */
    public double[] getDiemMH() {
        return diemMH;
    }

    /**
     * @param diemMH the diemMH to set
     */
    public void setDiemMH(double[] diemMH) {
        this.diemMH = diemMH;
    }

    /**
     * @return the dem
     */
    public static int getDem() {
        return dem;
    }

    /**
     * @param aDem the dem to set
     */
    public static void setDem(int aDem) {
        dem = aDem;
    }

    /**
     * @return the stt
     */
    public int getStt() {
        return stt;
    }

    /**
     * @param stt the stt to set
     */
    public void setStt(int stt) {
        this.stt = stt;
    }
}
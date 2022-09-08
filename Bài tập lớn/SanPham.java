package Demo7;
import java.util.ArrayList;
import java.util.List;
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
public class SanPham {

    /**
     * @return the dSKhuyenMai
     */
    public ArrayList<KhuyenMai> getdSKhuyenMai() {
        return dSKhuyenMai;
    }

    /**
     * @param dSKhuyenMai the dSKhuyenMai to set
     */
    public void setdSKhuyenMai(ArrayList<KhuyenMai> dSKhuyenMai) {
        this.dSKhuyenMai = dSKhuyenMai;
    }

    
     /**
     * @return the giaSP
     */
    public double getGiaSP() {
        return giaSP;
    }

    /**
     * @param giaSP the giaSP to set
     */
    public void setGiaSP(double giaSP) {
        this.giaSP = giaSP;
    }
    /**
     * @return the danhMucSP
     */
    public String getDanhMucSP() {
        return danhMucSP;
    }

    /**
     * @param danhMucSP the danhMucSP to set
     */
    public void setDanhMucSP(String danhMucSP) {
        this.danhMucSP = danhMucSP;
    }

    

    /**
     * @return the maSP
     */
    public int getMaSP() {
        return maSP;
    }

    /**
     * @param maSP the maSP to set
     */
    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    /**
     * @return the tenSP
     */
    public String getTenSP() {
        return tenSP;
    }

    /**
     * @param tenSP the tenSP to set
     */
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    private static int dem = -1;
    private int maSP;
    private String tenSP;
    private double giaSP;
    private String danhMucSP;
    private ArrayList<KhuyenMai> dSKhuyenMai  = new ArrayList<>();
    
    
    public SanPham(){
        this.maSP = ++dem;
    }
    
    public SanPham( String tenSP , double giaSP, String danhMucSP, ArrayList<KhuyenMai> dsKM){
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.danhMucSP = danhMucSP;
        this.dSKhuyenMai = dsKM;
    }

    @Override
    public String toString() {
        return ("Mã Sản Phẩm: "+this.maSP+"\n Tên Sản Phẩm: "+this.tenSP+"\n "
                + "     Giá Sản Phẩm:  "+ this.getGiaSP());
    }
    
    public void nhapSanPham(Scanner scanner) {
		System.out.print(" + Nhap ten san pham: ");
		this.tenSP = scanner.nextLine();
		System.out.print(" + Nhap gia ban san pham: ");
                this.setGiaSP(Double.parseDouble(scanner.nextLine()));
		System.out.print(" + Nhap danh muc san pham: ");
                this.setDanhMucSP(scanner.nextLine());
		
	}
    
    public void themSanPham(){
        
    }
    
    public void themKhuyenMai(KhuyenMai KM){
        this.dSKhuyenMai.add(KM);
    }
    
    public void hienThi(){
        System.out.println("--------Thông Tin Sản Phẩm------------");
        System.out.print("Tên Sản Phẩm: " + tenSP);
        System.out.println("Giá Sản Phẩm: " + getGiaSP());
    }

    public void hienThiKM() {
		int dem = 0;
		if (getdSKhuyenMai().size() > 0) {
			String s = "";
			for (KhuyenMai L : this.getdSKhuyenMai())
				s += L.toString() + "\n";
			++dem;
			System.out.println("   KHUYEN MAI THU " + dem);
			System.out.println(s);
		} else
			System.out.println("    !!!Khong co khuyen mai nao!!!");
	}

    int demKMCon(){
        int d = 0;
        for(KhuyenMai x : dSKhuyenMai){
            if(x.check() == true)
                d ++;
        }
        return d;
    }

}

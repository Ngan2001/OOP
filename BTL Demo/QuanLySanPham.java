package Demo7;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TT
 */
public class QuanLySanPham extends SanPham{

    private ArrayList<SanPham> dsSP = new ArrayList<>(); 

    QuanLySanPham() {
    }
    
    public void QuanLySanPham(){
        this.dsSP = new ArrayList<>();
    }
    public QuanLySanPham(ArrayList<SanPham> dsSanPham) {
	this.dsSP = dsSP;
    }
    
   
    
    public ArrayList<SanPham> timKiemSanPhamTheoGia(double giaToiThieu, double giaToiDa) {
		ArrayList<SanPham> ketQua = (ArrayList<SanPham>) dsSP.stream()
				.filter(L -> L.getGiaSP() >= giaToiThieu && L.getGiaSP() <= giaToiDa)
				.collect(Collectors.toList());
		return ketQua;

	}
    
     
    
    @Override
    public String toString() {
        String s="";
        for(SanPham sp: this.dsSP)
           s += sp +"=====\n";
        return s;
    }
    public boolean themSanPham(SanPham sanPham) {
		int n = dsSP.size();
		dsSP.add(sanPham);
		if (n < dsSP.size())
			return true;
		else
			return false;
	}
    public void themSP(SanPham sp){
        this.dsSP.add(sp);
    }
    public void themSP(Scanner scanner){
        SanPham sp;
        sp = new SanPham();
        sp.nhapSanPham(scanner);
        this.dsSP.add(sp);
    }

    int check(int maSP){

        for(int i = 0;i< this.dsSP.size();i++){
            if(this.dsSP.get(i).getMaSP() == maSP)
                return i;
        }
        return -1;
    }
    int check(String tenSP){

        for(int i = 0;i< this.dsSP.size();i++){
            if(this.dsSP.get(i).getTenSP().equals(tenSP))
                return i;
        }
        return -1;
    }
    void hienThiKM(int masp) {
        if(check(masp)!= -1){
            dsSP.get(check(masp)).hienThi();
            dsSP.get(check(masp)).hienThiKM();
        }else{
            
        }
    }

    void hienThiKM(String tensp) {
         if(check(tensp)!= -1){
            dsSP.get(check(tensp)).hienThi();
            dsSP.get(check(tensp)).hienThiKM();
        }else{
            
        }       
        
    }
    int search(int maSP){
        for(int i = 0;i<this.dsSP.size();i++){
           if(this.dsSP.get(i).getMaSP() ==  maSP)
               return i;  
        }
        return -1;
    }
    public boolean themKhuyenMaiVaoMotSanPham(int maSP,KhuyenMai km){
        if(search(maSP) != -1)
          this.dsSP.get(search(maSP)).getdSKhuyenMai().add(km);
        return false;
    }
    
    boolean  xoaKhuyenMaiHetHieuLuc(){
        boolean c = false;
        for(SanPham x : dsSP){
            for(int i = 0;i<x.getdSKhuyenMai().size();i++){
                if(x.getdSKhuyenMai().get(i).check()== false){
                    x.getdSKhuyenMai().remove(i);
                    i--;
                    c = true;
                }
            }
        }
        return c;
    }

    void hienThiTheoLoaiKM(char c) {
        String s = "";
        for(SanPham x : this.dsSP){
            for(KhuyenMai y : x.getdSKhuyenMai()){
                if(y.getMaKM().charAt(0) == c){

			s += y.toString() + "\n";
                }
            }
        }
        System.out.println(s);
    }

    void sapXep() {
        for(int  i = 0 ; i< dsSP.size();i++){
            for(int j  = i;j<dsSP.size();j++){
                if(dsSP.get(i).demKMCon() < dsSP.get(j).demKMCon() ){
                    SanPham temp = new SanPham();
                    temp = dsSP.get(i);
                     dsSP.set(i, dsSP.get(j));
                    dsSP.set(j, temp);
                    
                }
            }
        }

    }


    void hienThiSauKhiSapXep() {
        int stt = 0;
        for(SanPham x : this.dsSP){
            System.out.println("Sản Phẩm Thứ "+ (++stt));
            System.out.println("Tên Sản Phẩm :"+x.getTenSP()+" Số Khuyến Mãi Còn Hiệu Lực : "+x.demKMCon());
        }
    }

}

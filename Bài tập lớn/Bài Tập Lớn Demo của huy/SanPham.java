package ChuongTrinhQuanLiKhuyenMai;

import java.util.ArrayList;
import java.util.Scanner;

public class SanPham {
	private static int dem = 0;
	private int maSP;
	private String tenSP;
	private double giaBanSP;
	private String danhMucSP;
	private ArrayList<KhuyenMai> dsKhuyenMai;

	{
		this.maSP = ++dem;
	}

	public boolean isKhuyenMaiLoai(char ktMaKM) {
		for (int i = 0; i < dsKhuyenMai.size(); i++)
			if (dsKhuyenMai.get(i).getMaKM().charAt(0) == ktMaKM)
				return true;
		return false;
	}

	public SanPham() {
		tenSP = "\0";
		giaBanSP = 0;
		danhMucSP = "\0";
		dsKhuyenMai = new ArrayList<>();
	}

	public SanPham(String tenSP, double giaBanSP, String danhMucSP, ArrayList<KhuyenMai> dsKhuyenMai) {
		setTenSP(tenSP);
		setGiaBanSP(giaBanSP);
		setDanhMucSP(danhMucSP);
		this.dsKhuyenMai = new ArrayList<>();
		this.dsKhuyenMai = dsKhuyenMai;
	}

	// nhap them san pham
	public void nhapSanPham(Scanner scanner) {
		System.out.print(" + Nhap ten san pham: ");
		setTenSP(scanner.nextLine());
		System.out.print(" + Nhap gia ban san pham: ");
		setGiaBanSP(scanner.nextInt());
		System.out.print(" + Nhap danh muc san pham: ");
		scanner.nextLine();
		setDanhMucSP(scanner.nextLine());
	}

	// them khuyen mai
	public void themKhuyenMai(KhuyenMai khuyenMai) {
		dsKhuyenMai.add(khuyenMai);
	}

	// xoa khuyen mai het hieu luc
	public boolean xoaKhuyenMaiHetHan() {
		int tam = 0;
		for (int i = 0; i < dsKhuyenMai.size();)
			if (dsKhuyenMai.get(i).kiemTraHieuLucKM() == false) {
				dsKhuyenMai.remove(i);
				tam = 1;
			} else
				i++;
		if (tam == 1)
			return true;
		else
			return false;
	}

	// so luong khuyen mai con hieu luc
	public int soLuongKMConHieuLuc() {
		int dem = 0;
		for (int i = 0; i < dsKhuyenMai.size();)
			if (dsKhuyenMai.get(i).kiemTraHieuLucKM() == true)
				dem++;
		return dem;
	}

	public int getMaSP() {
		return maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public double getGiaBanSP() {
		return giaBanSP;
	}

	public void setGiaBanSP(double giaBanSP) {
		this.giaBanSP = giaBanSP >= 0 ? giaBanSP : this.giaBanSP;
	}

	public String getDanhMucSP() {
		return danhMucSP;
	}

	public void setDanhMucSP(String danhMucSP) {
		this.danhMucSP = danhMucSP;
	}

	public KhuyenMai getDsKhuyenMai(int index) {
		return this.dsKhuyenMai.get(index);
	}

	public void setDsKhuyenMai(int index, KhuyenMai khuyenMai) {
		this.dsKhuyenMai.set(index, khuyenMai);
	}

	// hien thi thong tin san pham
	public void hienThi() {
		System.out.println(" + Ma san pham: " + this.maSP);
		System.out.println(" + Ten san pham: " + this.getTenSP());
		System.out.println(" + Gia san pham: " + this.getGiaBanSP());
		System.out.println(" + Danh muc san pham : " + this.getDanhMucSP());
		System.out.println(" + Danh sach cac khuyen mai:");
		if (dsKhuyenMai.size() > 0)
			dsKhuyenMai.forEach(L -> {
				L.hienThi();
			});
		else
			System.out.println("  !!!Khong co khuyen mai nao!!!\n");
	}

	public void hienThiKhuyenMai() {
		if (dsKhuyenMai.size() > 0)
			dsKhuyenMai.forEach(L -> {
				L.hienThi();
			});
		else
			System.out.println("  !!!Khong co khuyen mai nao!!!\n");
	}

}

package ChuongTrinhQuanLiKhuyenMai;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class QuanLiSanPham {
	private ArrayList<SanPham> dsSanPham;

	public QuanLiSanPham() {
		dsSanPham = new ArrayList<>();
	}

	public QuanLiSanPham(ArrayList<SanPham> dsSanPham) {
		this.dsSanPham = new ArrayList<>();
		this.dsSanPham = dsSanPham;
	}

	// them san pham vao danh sach cac san pham
	public boolean themSanPham(SanPham sanPham) {
		int n = dsSanPham.size();
		dsSanPham.add(sanPham);
		if (n < dsSanPham.size())
			return true;
		else
			return false;
	}

	// tim kiem san pham theo gia tu chi dinh
	public ArrayList<SanPham> timKiemSanPhamTheoGia(double giaToiThieu, double giaToiDa) {
		ArrayList<SanPham> ketQua = (ArrayList<SanPham>) dsSanPham.stream()
				.filter(L -> L.getGiaBanSP() >= giaToiThieu && L.getGiaBanSP() <= giaToiDa)
				.collect(Collectors.toList());

		return ketQua;
	}

	// them khuyen mai bang cach nhap vao ma san pham
	public boolean themKhuyenMaiVaoSanPham(int maSP, KhuyenMai khuyenMai) {
		for (int i = 0; i < dsSanPham.size(); i++)
			if (dsSanPham.get(i).getMaSP() == maSP) {
				dsSanPham.get(i).themKhuyenMai(khuyenMai);
				return true;
			}
		return false;
	}

	// xoa khuyen mai het hieu luc
	public boolean xoaKhuyenMaiHetHieuLuc() {
		int tam = 0;
		for (int i = 0; i < dsSanPham.size(); i++)
			if (dsSanPham.get(i).xoaKhuyenMaiHetHan() == true)
				tam++;
		if (tam == 0)
			return false; // khong co khuyen mai nao het han
		else
			return true; // da xoa thanh cong cac khuyen mai het han
	}

	// hien thi khuyen mai theo ma san pham
	public void hienThiThongTinKhuyenMai(int maSP) {
		dsSanPham.forEach(L -> {
			if (L.getMaSP() == maSP)
				L.hienThiKhuyenMai();
		});
	}

	// hien thi khuyen mai theo ten san pham
	public void hienThiThongTinKhuyenMai(String tenSP) {
		dsSanPham.forEach(L -> {
			if (L.getTenSP().compareTo(tenSP) == 0)
				L.hienThiKhuyenMai();
		});
	}

	// hien thi thong tin san pham theo loai khuyen mai
	public void hienThiThongTinTheoLoaiKhuyenMai(char loaiKM) {
		for (int i = 0; i < dsSanPham.size(); i++)
			if (dsSanPham.get(i).isKhuyenMaiLoai(loaiKM) == true)
				dsSanPham.get(i).hienThi();
	}

	// sap xep san pham giam dan theo thu tu khuyen mai giam dan
	public void sapXep() {
		dsSanPham.sort((SanPham sp1, SanPham sp2) -> {
			return sp1.soLuongKMConHieuLuc() == sp2.soLuongKMConHieuLuc() ? 0
					: sp1.soLuongKMConHieuLuc() < sp2.soLuongKMConHieuLuc() ? 1 : -1;
		});
	}

	public void setDsSanPham(int index, SanPham sanpham) {
		dsSanPham.set(index, sanpham);
	}

	public SanPham getDsSanPham(int index) {
		return dsSanPham.get(index);
	}
}

package ChuongTrinhQuanLiKhuyenMai;

import java.util.Scanner;

public class LoaiSanPhamKhuyenMaiC {
	private String loaiSanPham;
	private double phanTramGiam;

	public LoaiSanPhamKhuyenMaiC() {
		this.loaiSanPham = "\0";
		this.phanTramGiam = 0;
	}

	public LoaiSanPhamKhuyenMaiC(String loaiSanPham, double phanTramGiam) {
		setLoaiSanPham(loaiSanPham);
		setPhanTramGiam(phanTramGiam);
	}

	public String getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(String loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	public double getPhanTramGiam() {
		return phanTramGiam;
	}

	public void setPhanTramGiam(double phanTramGiam) {
		this.phanTramGiam = phanTramGiam >= 0 ? phanTramGiam : this.phanTramGiam;
	}

	public void nhapSPGiamGiaKMC(Scanner scanner) {
		System.out.print("   + Nhap ten san pham khuyen mai: ");
		setLoaiSanPham(scanner.nextLine());
		System.out.print("   + Nhap ti le giam gia san pham khuyen mai nay: ");
		setPhanTramGiam(scanner.nextDouble());
	}

	public String toString() {
		return "  " + getLoaiSanPham() + " - Giam: " + getPhanTramGiam() * 100 + "%";
	}

}

package ChuongTrinhQuanLiKhuyenMai;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class KhuyenMaiC extends KhuyenMai {
	private static int dem = 0;
	private ArrayList<LoaiSanPhamKhuyenMaiC> sanPhamKMMuaKem;

	{
		++dem;
		this.setMaKM(dem > 999 ? "C" + Integer.toString(dem)
				: (dem > 99 ? "C0" + Integer.toString(dem)
						: (dem > 9 ? "C00" + Integer.toString(dem) : "C000" + Integer.toString(dem))));

	}

	public KhuyenMaiC() throws ParseException {
		super();
		sanPhamKMMuaKem = new ArrayList<>();
	}

	public KhuyenMaiC(String maKM, Date ngayTao, Date ngayHet, ArrayList<LoaiSanPhamKhuyenMaiC> sanPhamKMMuaKem) {
		super(maKM, ngayTao, ngayHet);
		this.sanPhamKMMuaKem = new ArrayList<>();
		setSanPhamKMMuaKem(sanPhamKMMuaKem);
	}

	public void nhapKhuyenMai(Scanner scanner) throws ParseException {
		System.out.println("Nhap thong tin khuyen mai Loai C:");
		super.nhapKhuyenMai(scanner);
		System.out.println(" + Nhap thong tin khuyen mai");
		System.out.print(" -> Co bao nhieu san pham giam gia di kem: ");
		int n = scanner.nextInt();
		scanner.nextLine();
		for (int i = 1; i <= n; i++) {
			LoaiSanPhamKhuyenMaiC loaispkm = new LoaiSanPhamKhuyenMaiC();
			if (i > 1)
				scanner.nextLine();
			System.out.println("  - San pham thu " + i + ": ");
			loaispkm.nhapSPGiamGiaKMC(scanner);
			sanPhamKMMuaKem.add(loaispkm);
		}
	}

	public void hienThi() {
		System.out.println(
				"  > Ma khuyen mai: " + this.getMaKM() + "\n  > Thong tin khuyen mai: (Giam gia tren san pham mua kem):");
		sanPhamKMMuaKem.forEach(L -> {
			System.out.println("  +" + L);
		});
		super.hienThi();
	}

	public ArrayList<LoaiSanPhamKhuyenMaiC> getSanPhamKMMuaKem() {
		return sanPhamKMMuaKem;
	}

	public void setSanPhamKMMuaKem(ArrayList<LoaiSanPhamKhuyenMaiC> sanPhamKMMuaKem) {
		this.sanPhamKMMuaKem = sanPhamKMMuaKem;
	}

	public void setSanPhamKMMuaKem(int index, LoaiSanPhamKhuyenMaiC loaiSanPhamKhuyenMaiC) {
		this.sanPhamKMMuaKem.set(index, loaiSanPhamKhuyenMaiC);
	}

	public LoaiSanPhamKhuyenMaiC getSanPhamKMMuaKem(int index) {
		return sanPhamKMMuaKem.get(index);
	}
}

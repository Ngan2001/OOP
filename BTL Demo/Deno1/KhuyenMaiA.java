package ChuongTrinhQuanLiKhuyenMai;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class KhuyenMaiA extends KhuyenMai {
	private static int dem = 0;
	private double tiLeGiamGia;

	{
		++dem;
		this.setMaKM(dem <= 9 ? "A0" + Integer.toString(dem) : "A" + Integer.toString(dem));

	}

	public KhuyenMaiA() throws ParseException {
		super();
		this.tiLeGiamGia = 0;
	}

	public KhuyenMaiA(String maKM, Date ngayTao, Date ngayHet, Double tiLeGiamGia) {
		super(maKM, ngayTao, ngayHet);
		setTiLeGiamGia(tiLeGiamGia);
	}

	public double getTiLeGiamGia() {
		return tiLeGiamGia;
	}

	public void setTiLeGiamGia(double tiLeGiamGia) {
		this.tiLeGiamGia = tiLeGiamGia >= 0 ? tiLeGiamGia : this.tiLeGiamGia;
	}

	public void nhapKhuyenMai(Scanner scanner) throws ParseException {
		System.out.println("Nhap thong tin khuyen mai Loai A:");
		super.nhapKhuyenMai(scanner);
		System.out.print(" + Nhap vao ti le giam gia: ");
		this.tiLeGiamGia = scanner.nextDouble();
	}

	public void hienThi() {
		System.out.println("  > Ma khuyen mai: " + this.getMaKM() + "\n  > Thong tin khuyen mai: Giam " + getTiLeGiamGia() * 100
				+ "% tren san gia tri san pham");
		 super.hienThi();
	}

}

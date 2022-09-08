package ChuongTrinhQuanLiKhuyenMai;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class KhuyenMaiB extends KhuyenMai {
	private static int dem = 0;
	private ArrayList<String> dichVuTangKem;

	{
		dem = (int) (Math.random() * 9999) + 1000;
		this.setMaKM("B" + Integer.toString(dem));
	}

	public KhuyenMaiB() throws ParseException {
		super();
		this.dichVuTangKem = new ArrayList<>();
	}

	public KhuyenMaiB(String maKM, Date ngayTao, Date ngayHet, ArrayList<String> dichVuTangKem) {
		super(maKM, ngayTao, ngayHet);
		this.dichVuTangKem = new ArrayList<>();
		this.setDichVuTangKem(dichVuTangKem);
	}

	public void nhapKhuyenMai(Scanner scanner) throws ParseException {
		System.out.println("Nhap thong tin khuyen mai Loai B:");
		super.nhapKhuyenMai(scanner);
		System.out.println(" + Nhap thong tin khuyen mai");
		System.out.print(" -> Co bao nhieu khuyen mai san pham di kem: ");
		int n = scanner.nextInt();
		scanner.nextLine();
		
		for (int i = 1; i <= n; i++) {
			System.out.print("  - Nhap san pham di kem thu " + i + ": ");
			dichVuTangKem.add(scanner.nextLine());
		}
	}

	public void hienThi() {
		System.out.println(
				"  > Ma khuyen mai: " + this.getMaKM() + "\n  > Thong tin khuyen mai (Gom cac dich vu tang kem):");
		dichVuTangKem.forEach(L -> {
			System.out.println("   + " + L);
		});
		super.hienThi();
	}

	public ArrayList<String> getDichVuTangKem() {
		return dichVuTangKem;
	}

	public void setDichVuTangKem(ArrayList<String> dichVuTangKem) {
		this.dichVuTangKem = dichVuTangKem;
	}

	public void setDichVuTangKem(int index, String dichvu) {
		this.dichVuTangKem.set(index, dichvu);
	}

	public String getDichVuTangKem(int index) {
		return dichVuTangKem.get(index);
	}

}

package ChuongTrinhQuanLiKhuyenMai;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class KhuyenMai {
	private String maKM;
	private Date ngayTao;
	private Date ngayHet;

	public KhuyenMai() throws ParseException {
		maKM = "\0";
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		ngayTao = new Date();
		ngayHet = new Date();
		ngayTao = f.parse("01/01/1900");
		ngayHet = f.parse("01/01/1900");
	}

	public KhuyenMai(String maKM, Date ngayTao, Date ngayHet) {
		this.maKM = maKM;
		this.ngayTao = ngayTao;
		this.ngayHet = ngayHet;
	}

	public boolean kiemTraHieuLucKM() {
		Calendar calendar = Calendar.getInstance();
		Date d = new Date();
		d = calendar.getTime();
		return this.ngayHet.after(d);
	}

	public void nhapKhuyenMai(Scanner scanner) throws ParseException {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print(" + Nhap vao ngay tao khuyen mai: ");
		this.ngayTao = f.parse(scanner.nextLine());
		System.out.print(" + Nhap vao ngay het han khuyen mai: ");
		this.ngayHet = f.parse(scanner.nextLine());
	}

	public void hienThi() {
		System.out.println(kiemTraHieuLucKM() == true ? "  > Khuyen mai con hieu luc\n" : "  > Khuyen mai het hieu luc\n");
	}

	public String getMaKM() {
		return maKM;
	}

	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Date getNgayHet() {
		return ngayHet;
	}

	public void setNgayHet(Date ngayHet) {
		this.ngayHet = ngayHet;
	}

}

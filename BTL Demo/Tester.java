package Demo7;
import java.text.ParseException;
import java.util.ArrayList;
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
public class Tester {
    public static void main(String[] args) throws ParseException {
		QuanLySanPham quanLiSanPham = new QuanLySanPham();
		SanPham sanPham;
		Scanner scanner = new Scanner(System.in);
		int chon, in = 0;
		do {
			System.out.println(" =======================================MENU=====================================");
			System.out.println("|	1. Them san pham vao danh sach                                               |");
			System.out.println("|	2. Tim kiem san pham theo gia chi dinh                                       |");
			System.out.println("|	3. Them khuyen mai vao mot san pham                                          |");
			System.out.println("|	4. Xoa cac khuyen mai het hieu luc khoi san pham                             |");
			System.out.println("|	5. Hien thi thong tin khuyen mai cua san pham                                |");
			System.out.println("|	6. Xem danh sach san pham co chua khuyen mai theo tung loai chi dinh         |");
			System.out.println("|	7. Sap xep danh sach san pham giam dan theo so luong khuyen mai con hieu luc |");
			System.out.println("|	8. Thoat                                                                     |");
			System.out.println(" =================================================================================");

			System.out.print("=>>Chon: ");
			do {

				chon = Integer.parseInt(scanner.nextLine());

				if (chon < 1 || chon > 8)
					System.out.println("=>>Chon lai: ");
			} while (chon < 1 || chon > 8);

			//
			switch (chon) {
			case 1:
				in = 1;
				System.out.println(
						" ===========================THEM SAN PHAM VAO DANH SACH==============================");
				sanPham = new SanPham();
				sanPham.nhapSanPham(scanner);   
                                quanLiSanPham.themSP(sanPham) ;
				if (true)
					System.out.println("                              >>> Them Thanh Cong <<<");
				else
					System.out.println("                          >>> Them Khong Thanh Cong! <<<");

                                System.out.println(sanPham.toString());
				System.out.println(
						" ====================================================================================\n");
				break;
			case 2:
				if (in != 0) {
					double giaToiThieu, giaToiDa;
					System.out.println(
							" ========================TIM KIEM SAN PHAM THEO GIA CHI DINH=========================");
					ArrayList<SanPham> sanPhamTheoGia = new ArrayList<>();

					System.out.print(" >> Nhap gia toi thieu: ");
					do {
						giaToiThieu = Double.parseDouble(scanner.nextLine());
						if (giaToiThieu < 0)
							System.out.println(" >> Nhap lai gia toi thieu: ");
					} while (giaToiThieu < 0);

					System.out.print(" >> Nhap gia toi da: ");
					do {
						giaToiDa = Double.parseDouble(scanner.nextLine());
						if (giaToiDa < 0 || giaToiDa < giaToiThieu)
							System.out.println(" >> Nhap lai gia toi da: ");
					} while (giaToiDa < 0 || giaToiDa < giaToiThieu);

					sanPhamTheoGia = quanLiSanPham.timKiemSanPhamTheoGia(giaToiThieu, giaToiDa);

					if (sanPhamTheoGia.size() != 0) {
						System.out.printf(" >>>>>>>>>>>>>>>>>>>>>>>  Danh Sach San Pham Co Gia Tu %.0f Vnd Den %.0f Vnd%s\n",
								giaToiThieu, giaToiDa, "  <<<<<<<<<<<<<<<");

						for(SanPham x : sanPhamTheoGia){
                                                    x.hienThi();
                                                }
					} else
						System.out.println("                     >>> Khong co san nao trong tam gia nay <<<");
					System.out.println(
							" ====================================================================================\n"
									+ "");
				} else
					System.out.println("                      >>> DANH SACH SAN PHAM TRONG <<<");
				break;
			case 3:
				if (in != 0) {
					int chonKM;
					int flag = 1;
					int maSanPham;
					KhuyenMai khuyenMaiNew = new KhuyenMai();
					System.out.println(
							" =========================THEM KHUYEN MAI VAO MOT SAN PHAM===========================");
					System.out.print("=>> Nhap vao MA SAN PHAM can them khuyen mai: ");
					maSanPham = scanner.nextInt();

					while (flag == 1) {
						System.out.println(
								"  ____________________________MENU THEM KHUYEN MAI__________________________________");
						System.out.println(
								" | 1. Them khuyen mai loai A (Giam truc tiep tren gia san pham)                     |");
						System.out.println(
								" | 2. Them khuyen mai loai B (Tang kem dich vu)                                     |");
						System.out.println(
								" | 3. Them khuyen mai loai C (Giam gia tren mot san pham mua kem theo muc chi dinh) |");
						System.out.println(
								" |__________________________________________________________________________________|");
						System.out.print("=>>Chon: ");
						do {
							chonKM = scanner.nextInt();
							if (chonKM != 1 && chonKM != 2 && chonKM != 3)
								System.out.println("=>> Chon lai: ");
						} while (chonKM != 1 && chonKM != 2 && chonKM != 3);
						scanner.nextLine();

						if (chonKM == 1)
							khuyenMaiNew = new KhuyenMaiA();
						else if (chonKM == 2)
							khuyenMaiNew = new KhuyenMaiB();
						else
							khuyenMaiNew = new KhuyenMaiC();

						khuyenMaiNew.nhapKhuyenMai();
                                                
                                                boolean check = quanLiSanPham.themKhuyenMaiVaoMotSanPham(maSanPham, khuyenMaiNew);
						if (check == true )
							System.out.println("                      >>> Them khuyen mai vao san pham khong thanh cong <<<");
						else
							System.out.println(
									"                   >>> Them thanh cong khuyen mai vao san pham <<<");
						System.out.print(">> Dung them khuyen mai (dung <0> | tiep tuc <1>): ");
						flag = Integer.parseInt(scanner.nextLine());
						System.out.println(
								"                 =====================================================\n" + "");
					}
					;
					System.out.println(
							" ====================================================================================\n"
									+ "");
				} else
					System.out.println("                      >>> DANH SACH SAN PHAM TRONG <<<");
				break;
			case 4:
				System.out.println(
						" =========================XOA KHUYEN MAI HET HAN CUA SAN PHAM===========================");
				if (in != 0) {
					if (quanLiSanPham.xoaKhuyenMaiHetHieuLuc() == true)
						System.out
								.println("                    >>> Xoa thanh cong khuyen mai het han cua san pham <<<<");
					else
						System.out.println("                       >>> Khong co khuyen mai nao het han <<<");
					System.out.println(
							" ====================================================================================\n"
									+ "");
				} else
					System.out.println("                      >>> DANH SACH SAN PHAM TRONG <<<");
				break;
			case 5:
				System.out.println(
						" ===========================HIEN THI THONG TIN KHUYEN MAI============================");
				if (in != 0) {
					int chonHinhThuc;
					int masp;
					String tensp;
					System.out.println("                _____________________________MENU________________________ ");
					System.out.println("               |  1. Hien thi thong tin khuyen mai voi MA SAN PHAM       |");
					System.out.println("               |  2. Hien thi thong tin khuyen mai voi TEN SAN PHAM      |");
					System.out.println("                _________________________________________________________|");
					System.out.print("=>> Chon: ");
					do {
						chonHinhThuc = Integer.parseInt(scanner.nextLine());;
						if (chonHinhThuc != 1 && chonHinhThuc != 2)
							System.out.print("=>> Chon lai: ");
					} while (chonHinhThuc != 1 && chonHinhThuc != 2);
					if (chonHinhThuc == 1) {
						System.out.print(" >> Nhap ma san pham: ");
						masp = Integer.parseInt(scanner.nextLine());
						System.out.println("  >>>>>>>>>>>>>>> Thong Tin Khuyen Mai Cua San Pham Co MA SAN PHAM LA "
								+ masp + " <<<<<<<<<<<<<<");
						quanLiSanPham.hienThiKM(masp);
					} else {
						System.out.print(" >> Nhap ten san pham: ");
						tensp = scanner.nextLine();
						System.out.println("  >>>>>>>>>>>>>>> Thong Tin Khuyen Mai Cua San Pham Co TEN SAN PHAM LA "
								+ tensp + " <<<<<<<<<<<<<<");
						quanLiSanPham.hienThiKM(tensp);
					}

					System.out.println(
							" ====================================================================================\n"
									+ "");
				} else
					System.out.println("                      >>> DANH SACH SAN PHAM TRONG <<<");
				break;
			case 6:
				System.out.println(
						" =========================XEM SAN PHAM THEO LOAI KHUYEN MAI===========================");
				if (in != 0) {
					int chonLoaiKM;
					System.out.println("                _____________________________MENU________________________ ");
					System.out.println("               |  1. Xem san pham theo Loai KHUYEN MAI A                 |");
					System.out.println("               |  2. Xem san pham theo Loai KHUYEN MAI B                 |");
					System.out.println("               |  3. Xem san pham theo Loai KHUYEN MAI C                 |");
					System.out.println("                _________________________________________________________|");
					System.out.print("=>> Chon: ");
					do {
						chonLoaiKM =Integer.parseInt(scanner.nextLine());
						if (chonLoaiKM != 1 && chonLoaiKM != 2 && chonLoaiKM != 3)
							System.out.print("=>> Chon lai: ");
					} while (chonLoaiKM != 1 && chonLoaiKM != 2 && chonLoaiKM != 3);

					if (chonLoaiKM == 1) {
						System.out.println(
								"  >>>>>>>>>>>>>>> Thong Tin San Pham Voi Loai Khuyen Mai A " + " <<<<<<<<<<<<<<");
						try {
							quanLiSanPham.hienThiTheoLoaiKM('A');
						} catch (Exception e) {
							System.out.println("Co loi!!!");
							e.printStackTrace();
						}
					} else if (chonLoaiKM == 2) {
						System.out.println(
								"  >>>>>>>>>>>>>>> Thong Tin San Pham Voi Loai Khuyen Mai B " + " <<<<<<<<<<<<<<");
						try {
							quanLiSanPham.hienThiTheoLoaiKM('B');
						} catch (Exception e) {
							System.out.println("Co loi!!!");
							e.printStackTrace();
						}
					} else {
						System.out.println(
								"  >>>>>>>>>>>>>>> Thong Tin San Pham Voi Loai Khuyen Mai C " + " <<<<<<<<<<<<<<");
						try {
							quanLiSanPham.hienThiTheoLoaiKM('C');
						} catch (Exception e) {
							System.out.println("Co loi!!!");
							e.printStackTrace();
						}

					}

					System.out.println(
							" ====================================================================================\n"
									+ "");
				} else
					System.out.println("                      >>> DANH SACH SAN PHAM TRONG <<<");
				break;
			case 7:
				System.out
						.println(" ===============SAP XEP SAN PHAM THEO KHUYEN MAI GIAM DAN HIEU LUC=================");
				if (in != 0) {
					quanLiSanPham.sapXep();
                                        System.out.println("*****");
					quanLiSanPham.hienThiSauKhiSapXep();
					System.out.println("                        >>> Sap xep thanh cong <<<");
				} else
					System.out.println("                      >>> DANH SACH SAN PHAM TRONG <<<");
				break;
			default:
				System.out.println("                   <<< THOAT >>>>");
			}
			//
		} while (chon >= 1 && chon <= 7);
		scanner.close();
	}
}

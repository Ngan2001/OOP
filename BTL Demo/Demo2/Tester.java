
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
			System.out.println("|	1. Thêm sản phẩm vào danh sách                                               |");
			System.out.println("|	2. Tìm kiếm sản phẩm theo giá chỉ định                                       |");
			System.out.println("|	3. Thêm khuyến mãi vào một sản phẩm                                          |");
			System.out.println("|	4. Xóa các khuyến mãi hết hiệu lực khỏi sản phẩm                             |");
			System.out.println("|	5. Hiển thị thông tin khuyến mãi của sản phẩm                                |");
			System.out.println("|	6. Xem danh sách sản phẩm có chứa khuyến mãi theo từng loại chỉ định         |");
			System.out.println("|	7. Sắp xếp danh sách sản phẩm giảm dần theo số lượng khuyến mãi còn hiệu     |");
			System.out.println("|	8. Thoát                                                                     |");
			System.out.println(" =================================================================================");

			System.out.print("=>>Chọn: ");
			do {

				chon = Integer.parseInt(scanner.nextLine());

				if (chon < 1 || chon > 8)
					System.out.println("=>>Chọn lại: ");
			} while (chon < 1 || chon > 8);

			//
			switch (chon) {
			case 1:
				in = 1;
				System.out.println(
						" ===========================THÊM SẢN PHẨM VÀO DANH SÁCH==============================");
				sanPham = new SanPham();
				sanPham.nhapSanPham(scanner);   
                                quanLiSanPham.themSP(sanPham) ;
				if (true)
					System.out.println("                              >>> Thêm thành công <<<");
				else
					System.out.println("                          >>> Thêm không thành công! <<<");

                                System.out.println(sanPham.toString());
				System.out.println(
						" ====================================================================================\n");
				break;
			case 2:
				if (in != 0) {
					double giaToiThieu, giaToiDa;
					System.out.println(
							" ========================TÌM KIẾM SẢN PHẨM THEO GIÁ CHỈ ĐỊNH=========================");
					ArrayList<SanPham> sanPhamTheoGia = new ArrayList<>();

					System.out.print(" >> Nhập giá tối thiểu: ");
					do {
						giaToiThieu = Double.parseDouble(scanner.nextLine());
						if (giaToiThieu < 0)
							System.out.println(" >> Nhập lại giá tối thiểu: ");
					} while (giaToiThieu < 0);

					System.out.print(" >> Nhập giá tối đa: ");
					do {
						giaToiDa = Double.parseDouble(scanner.nextLine());
						if (giaToiDa < 0 || giaToiDa < giaToiThieu)
							System.out.println(" >> Nhập lại giá tối đa: ");
					} while (giaToiDa < 0 || giaToiDa < giaToiThieu);

					sanPhamTheoGia = quanLiSanPham.timKiemSanPhamTheoGia(giaToiThieu, giaToiDa);

					if (sanPhamTheoGia.size() != 0) {
						System.out.printf(" >>>>>>>>>>>>>>>>>>>>>>>  Danh sách sản phẩm có giá từ %.0f Vnd đến %.0f Vnd%s\n",
								giaToiThieu, giaToiDa, "  <<<<<<<<<<<<<<<");

						for(SanPham x : sanPhamTheoGia){
                                                    x.hienThi();
                                                }
					} else
						System.out.println("                     >>> Không có sản phẩm nào trong tầm giá này <<<");
					System.out.println(
							" ====================================================================================\n"
									+ "");
				} else
					System.out.println("                      >>> DANH SÁCH SẢN PHẨM TRỐNG <<<");
				break;
			case 3:
				if (in != 0) {
					int chonKM;
					int flag = 1;
					int maSanPham;
					KhuyenMai khuyenMaiNew = new KhuyenMai();
					System.out.println(
							" =========================THÊM KHUYẾN MÃI VÀO SẢN PHẨM===========================");
					System.out.print("=>> Nhập vào MÃ SẢN PHẨM cần thêm khuyến mãi: ");
					maSanPham = scanner.nextInt();

					while (flag == 1) {
						System.out.println(
								"  ____________________________MENU THÊM KHUYẾN MÃI__________________________________");
						System.out.println(
								" | 1. Thêm khuyến mãi loại A (Giảm trực tiếp trên giá sản phẩm)                     |");
						System.out.println(
								" | 2. Thêm khuyến mãi loại B (Tặng kèm dịch vụ)                                     |");
						System.out.println(
								" | 3. Thêm khuyến mãi loại C (Giảm giá trên một sản phẩm mua kèm theo giá chỉ định) |");
						System.out.println(
								" |__________________________________________________________________________________|");
						System.out.print("=>>Chọn: ");
						do {
							chonKM = scanner.nextInt();
							if (chonKM != 1 && chonKM != 2 && chonKM != 3)
								System.out.println("=>> Chọn lại: ");
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
							System.out.println("                      >>> Thêm khuyến mãi vào sản phẩm không thành công <<<");
						else
							System.out.println(
									"                   >>> Thêm thành công khuyến mãi vào sản phẩm <<<");
						System.out.print(">> Dừng thêm khuyến mãi (Dừng <0> | Tiếp tục <1>): ");
						flag = Integer.parseInt(scanner.nextLine());
						System.out.println(
								"                 =====================================================\n" + "");
					}
					;
					System.out.println(
							" ====================================================================================\n"
									+ "");
				} else
					System.out.println("                      >>> DANH SÁCH SẢN PHẨM TRONG <<<");
				break;
			case 4:
				System.out.println(
						" =========================XÓA KHUYẾN MÃI HẾT HẠN CỦA SẢN PHẨM===========================");
				if (in != 0) {
					if (quanLiSanPham.xoaKhuyenMaiHetHieuLuc() == true)
						System.out
								.println("                    >>> Xóa thành công khuyến mãi hết hạn của sản phẩm <<<<");
					else
						System.out.println("                       >>> Không có khuyến mãi nào hết hạn <<<");
					System.out.println(
							" ====================================================================================\n"
									+ "");
				} else
					System.out.println("                      >>> DANH SÁCH SẢN PHẨM TRONG <<<");
				break;
			case 5:
				System.out.println(
						" ===========================HIỂN THỊ THÔNG TIN KHUYẾN MÃI============================");
				if (in != 0) {
					int chonHinhThuc;
					int masp;
					String tensp;
					System.out.println("                _____________________________MENU________________________ ");
					System.out.println("               |  1. Hiển thị thông tin khuyến mãi với MÃ SẢN PHẨM       |");
					System.out.println("               |  2. Hiển thị thông tin khuyến mãi với TÊN SẢN PHẨM      |");
					System.out.println("                _________________________________________________________|");
					System.out.print("=>> Chọn: ");
					do {
						chonHinhThuc = Integer.parseInt(scanner.nextLine());;
						if (chonHinhThuc != 1 && chonHinhThuc != 2)
							System.out.print("=>> Chọn lại: ");
					} while (chonHinhThuc != 1 && chonHinhThuc != 2);
					if (chonHinhThuc == 1) {
						System.out.print(" >> Nhập mã sản phẩm: ");
						masp = Integer.parseInt(scanner.nextLine());
						System.out.println("  >>>>>>>>>>>>>>> Thông tin khuyến mãi của sản phẩm có MÃ SẢN PHẨM là "
								+ masp + " <<<<<<<<<<<<<<");
						quanLiSanPham.hienThiKM(masp);
					} else {
						System.out.print(" >> Nhập tên sản phẩm: ");
						tensp = scanner.nextLine();
						System.out.println("  >>>>>>>>>>>>>>> Thông tin khuyến mãi của sản phẩm có TÊN SẢN PHẨM là "
								+ tensp + " <<<<<<<<<<<<<<");
						quanLiSanPham.hienThiKM(tensp);
					}

					System.out.println(
							" ====================================================================================\n"
									+ "");
				} else
					System.out.println("                      >>> DANH SÁCH SẢN PHẨM TRONG <<<");
				break;
			case 6:
				System.out.println(
						" =========================XEM SẢN PHẨM THEO LOẠI KHUYẾN MÃI===========================");
				if (in != 0) {
					int chonLoaiKM;
					System.out.println("                _____________________________MENU________________________ ");
					System.out.println("               |  1. Xem sản phẩm theo Loại KHUYẾN MÃI A                 |");
					System.out.println("               |  2. Xem sản phẩm theo Loại KHUYẾN MÃI B                 |");
					System.out.println("               |  3. Xem sản phẩm theo Loại KHUYẾN MÃI C                 |");
					System.out.println("                _________________________________________________________|");
					System.out.print("=>> Chọn: ");
					do {
						chonLoaiKM =Integer.parseInt(scanner.nextLine());
						if (chonLoaiKM != 1 && chonLoaiKM != 2 && chonLoaiKM != 3)
							System.out.print("=>> Chọn lại: ");
					} while (chonLoaiKM != 1 && chonLoaiKM != 2 && chonLoaiKM != 3);

					if (chonLoaiKM == 1) {
						System.out.println(
								"  >>>>>>>>>>>>>>> Thông tin sản phẩm với Loại KHUYẾN MÃI A " + " <<<<<<<<<<<<<<");
						try {
							quanLiSanPham.hienThiTheoLoaiKM('A');
						} catch (Exception e) {
							System.out.println("Có lỗi!!!");
							e.printStackTrace();
						}
					} else if (chonLoaiKM == 2) {
						System.out.println(
								"  >>>>>>>>>>>>>>> Thông tin sản phẩm với Loại KHUYẾN MÃI B " + " <<<<<<<<<<<<<<");
						try {
							quanLiSanPham.hienThiTheoLoaiKM('B');
						} catch (Exception e) {
							System.out.println("Có lỗi!!!");
							e.printStackTrace();
						}
					} else {
						System.out.println(
								"  >>>>>>>>>>>>>>> Thông tin sản phẩm với Loại KHUYẾN MÃI C " + " <<<<<<<<<<<<<<");
						try {
							quanLiSanPham.hienThiTheoLoaiKM('C');
						} catch (Exception e) {
							System.out.println("Có lỗi!!!");
							e.printStackTrace();
						}

					}

					System.out.println(
							" ====================================================================================\n"
									+ "");
				} else
					System.out.println("                      >>> DANH SÁCH SẢN PHẨM TRONG <<<");
				break;
			case 7:
				System.out
						.println(" ===============SẮP XẾP SẢN PHẨM THEO GIẢM DẦN HIỆU LỰC=================");
				if (in != 0) {
					quanLiSanPham.sapXep();
                                        System.out.println("*****");
					quanLiSanPham.hienThiSauKhiSapXep();
					System.out.println("                        >>> Sắp xếp thành công <<<");
				} else
					System.out.println("                      >>> DANH SÁCH SẢN PHẨM TRONG <<<");
				break;
			default:
				System.out.println("                   <<< THOÁT >>>>");
			}
			//
		} while (chon >= 1 && chon <= 7);
		scanner.close();
	}
}


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Server {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in, "UTF-8");
        System.out.println("==== DÀNH CHO NGƯỜI QUẢN LÝ HỆ THỐNG ====");
        int choose;
        do {
            System.out.println("\n");
            System.out.println("1. XEM DANH SÁCH CÁC CÂU HỎI MULTIPLE CHOICE");
            System.out.println("2. XEM DANH SÁCH CÁC CÂU HỎI INCOMPLETE CHOICE");
            System.out.println("3. XEM DANH SÁCH CÁC CÂU HỎI CONVERSATION");
            System.out.println("4. XEM DANH SÁCH CÁC THÀNH VIÊN");
            System.out.println("5. THOÁT KHỎI HỆ THỐNG");
            
            System.out.print("- NHẬP LỰA CHỌN CỦA BẠN (1, 2, 3, 4, 5): ");
            choose = Integer.parseInt(s.nextLine());
            
            switch(choose) {
                case 1:
                    System.out.println("");
                    System.out.println("1. XEM DANH SÁCH CÁC CÂU HỎI MULTIPLE CHOICE");
                    System.out.println("");
                    QuestionManagement q1 = new QuestionManagement();
                    q1.DataMultipleChoice(q1);
                    q1.xuatCauHoi();
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("2. XEM DANH SÁCH CÁC CÂU HỎI INCOMPLETE CHOICE");
                    System.out.println("");
                    QuestionManagement q2 = new QuestionManagement();
                    q2.DataInCompleteChoice(q2);
                    q2.xuatCauHoi();
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("3. XEM DANH SÁCH CÁC CÂU HỎI CONVERSATION");
                    System.out.println("");
                    QuestionManagement q3 = new QuestionManagement();
                    q3.DataConversation(q3);
                    q3.xuatCauHoi();
                    break;
                case 4:
                    System.out.println("4. XEM DANH SÁCH CÁC THÀNH VIÊN");
                    break;
                case 5: 
                    System.out.println("5. THOÁT KHỎI HỆ THỐNG");
                    break;
                default:
                    System.out.println("NHẬP SAI, HÃY NHẬP LẠI LỰA CHỌN (1, 2, 3, 4, 5)!");
                    break;
            }
        } while(choose != 5);
    }
}
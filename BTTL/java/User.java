
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
public class User {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("==== DÀNH CHO NGƯỜI DÙNG HỆ THỐNG ====");
        System.out.print(" ");
        ThanhVien t1 = new ThanhVien();
        System.out.println("NHẬP THÔNG TIN CÁ NHÂN:");
        t1.nhapThanhVien(s);
        
        

        int choose2;
        do {
            System.out.println("\n1. THỰC HÀNH CÁC CÂU HỎI MULTIPLE CHOICE");
            System.out.println("2. THỰC HÀNH CÁC CÂU HỎI INCOMPLETE CHOICE");
            System.out.println("3. THỰC HÀNH CÁC CÂU HỎI CONVERSATION");
            System.out.println("4. XEM THÔNG TIN CÁ NHÂN");
            System.out.println("5. THOÁT KHỎI HỆ THỐNG");
            System.out.print("- NHẬP LỰA CHỌN CỦA BẠN (1, 2, 3, 4, 5): ");
            choose2 = Integer.parseInt(s.nextLine());
            switch(choose2) {
                case 1:
                    System.out.println("\n1. THỰC HÀNH CÁC CÂU HỎI MULTIPLE CHOICE");
                    System.out.print("- Nhậa"
                            + "p số câu hỏi mà bạn muốn thực hành: ");
                    int n1 = s.nextInt();
                    s.nextLine();
                    
                    QuestionManagement q1 = new QuestionManagement();
                    q1.DataMultipleChoice(q1);
                    
                    q1.practiceMultipleChoice(s, n1);

                    break;
                case 2:
                    System.out.println("\n2. THỰC HÀNH CÁC CÂU HỎI INCOMPLETE CHOICE");
                    System.out.println(" ");
                    System.out.print("\n- Nhập số câu hỏi mà bạn muốn thực hành: ");
                    int n2 = s.nextInt();
                    s.nextLine();
                    System.out.println(" ");

                    QuestionManagement q2 = new QuestionManagement();
                    q2.DataInCompleteChoice(q2);
                    
                    q2.practiceInCompleteQuestion(s, n2);
                   
                    break;
                case 3:
                    System.out.println("\n3. THỰC HÀNH CÁC CÂU HỎI CONVERSATION");
                    System.out.println(" ");
                    System.out.print("\n- Nhập số câu hỏi mà bạn muốn thực hành: ");
                    int n3 = s.nextInt();s.nextLine();
                    System.out.println(" ");
                    
                    QuestionManagement q3 = new QuestionManagement();
                    q3.DataConversation(q3);
                    
                    q3.practiceConversationQuestion(s, n3);
                   
                    break;
                case 4:
                    System.out.println("\n4. XEM LẠI THÔNG TIN CÁ NHÂN");
                    t1.hienThiThanhVien();
                    break;
                case 5: 
                    System.out.println("\n5. THOÁT KHỎI HỆ THỐNG");
                    break;
                default:
                    System.out.println("\nNHẬP SAI, HÃY NHẬP LẠI LỰA CHỌN (1, 2, 3, 4, 5)!");
                    break;
            }  
        } while(choose2 != 5);    
    }
}
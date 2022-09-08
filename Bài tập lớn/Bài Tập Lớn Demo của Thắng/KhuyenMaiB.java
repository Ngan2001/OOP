
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
public class KhuyenMaiB extends KhuyenMai{
    static int dem = -1;
    private ArrayList<String> dichVu;
    { 
        int r = (int)(Math.random()*8999+1000);
        maKM = String.format("B%4d", r);
    }
public KhuyenMaiB(ArrayList<String> dv){
    this.dichVu = dv;
    
}

    KhuyenMaiB() {
   this.maKM = "B";
        dem++;
        for(int i =0;i<4-String.valueOf(dem).length();i++){
            this.maKM += "0";
        }
        this.maKM +=  String.valueOf(dem);
    }
void nhapKhuyenMai() throws ParseException{
    Scanner scanner = new Scanner(System.in);
    super.nhapKhuyenMai();
                
                System.out.print("Số dịch vụ tặng kèm: ");
        int n = Integer.parseInt(scanner.nextLine());
                ArrayList<String> dichCuTawngKem = new ArrayList<String>();
        for(int i = 0;i<n;i++){
            System.out.println("Dịch vụ thứ "+(i+1)+": ");
            String dv = scanner.nextLine();
            dichCuTawngKem.add(dv);
        }
                this.dichVu = dichCuTawngKem;
}
}

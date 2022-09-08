
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class QuanLyThanhVien {
    private List<ThanhVien> tv = new ArrayList<>();
    
    public void themThanhVien(ThanhVien t) {
        this.tv.add(t);
    }
    
//    public void xoaThanhVien(ThanhVien t) {
//        this.tv.
//    }

    public List<ThanhVien> timKiem(String kw) {
        List<ThanhVien> tk = new ArrayList<>();
        this.tv.stream().filter((t) -> (t.getHoTen().contains(kw) == true || 
                t.getGioiTinh().contains(kw) == true ||
                t.getQueQuan().contains(kw) == true)).forEachOrdered((t) -> {
                    tk.add(t);
        });
        return tk;
        
        // TÌM KIẾM THEO TÊN, GIỚI TÍNH, QUÊ QUÁN
    }
    
    public void xuatThanhVien() {
        this.tv.forEach(t -> t.hienThiThanhVien());
    }
    
    public void sapXepTangTheoTen() {
        this.tv.sort((t1, t2) -> t1.getHoTen().compareTo(t2.getHoTen()));
    }
    
    
    
    /**
     * @return the tv
     */
    public List<ThanhVien> getTv() {
        return tv;
    }

    /**
     * @param tv the tv to set
     */
    public void setTv(List<ThanhVien> tv) {
        this.tv = tv;
    }
}
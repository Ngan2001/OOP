
import java.util.ArrayList;
import java.util.Collections;
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
public class MultipleChoice extends Question{ 
    private static String[] LABELS = {"A", "B", "C", "D"};
    private List<Choice> choices;
    
    public MultipleChoice(String content, Level lvl) {
        super(content, lvl);
        
        this.choices = new ArrayList<>();
    }
    
    public void addChoice (Choice c) {
        if (this.getChoices().size() < getLABELS().length)
            this.getChoices().add(c);
    }
    
    public boolean checkAnswer (String ans) {
        
        for (int i = 0; i < this.getChoices().size(); i++)
            if (this.getChoices().get(i).isCorrect() == true && 
                    getLABELS()[i].equals(ans.toUpperCase()) == true)
                return true;
        // KIỂM TRA ĐÁP ÁN CÓ ĐÚNG VỚI ĐÁP ÁN MÀ NGƯỜI DÙNG CHỌN HAY KHÔNG
        
        return false;
    }
    
  
    public void shuffleChoice() {
        Collections.shuffle(this.choices);
    }

    @Override
    public String toString() {
        String s = super.toString(); // NỘI DUNG CÂU HỎI 
        
        for (int i = 0; i < this.getChoices().size(); i++)
            s += String.format("\n%s. %s\n", getLABELS()[i], this.getChoices().get(i));
         
        return s;
    }

    
    
    
    /**
     * @return the LABELS
     */
    public static String[] getLABELS() {
        return LABELS;
    }

    /**
     * @param aLABELS the LABELS to set
     */
    public static void setLABELS(String[] aLABELS) {
        LABELS = aLABELS;
    }

    /**
     * @return the choices
     */
    public List<Choice> getChoices() {
        return choices;
    }

    /**
     * @param choices the choices to set
     */
    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
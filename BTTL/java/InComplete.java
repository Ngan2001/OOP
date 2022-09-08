
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
public class InComplete extends Question{
    private List<MultipleChoice> question;
    
    public InComplete (String content, Level lvl) {
        super(content, lvl);
        
        this.question = new ArrayList<>();
    }
    
    public void addQuestion (MultipleChoice q) {
        this.question.add(q);   
    }
    
    
    
    @Override
    public String toString() {
        String s = super.toString();
        
        for (MultipleChoice q : this.question)
            s += q;
        
        return s;
    }
    
    

    
    
    
    /**
     * @return the question
     */
    public List<MultipleChoice> getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(List<MultipleChoice> question) {
        this.question = question;
    }
    
    
    
}

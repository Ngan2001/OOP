/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public abstract class Question {
    protected String content;
    protected Level level;

    public Question(String content, Level lvl) {
        this.content = content;
        this.level = lvl;
    }

    @Override
    public String toString() {
        return this.content;
    }
    
    public void hienThiCauHoi() {
        System.out.printf("\n+ Nội dung câu hỏi: %s\n+ Mức độ: %s\n",
                this.content, this.level);
    }
    
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(Level level) {
        this.level = level;
    }
    
    
    
}

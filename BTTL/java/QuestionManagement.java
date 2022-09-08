
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
public class QuestionManagement {
    private List<Question> questions;
    
    public QuestionManagement() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion (Question q) {
        this.getQuestions().add(q);
    }
    
    public void xuatCauHoi() {
        this.questions.forEach(q -> q.hienThiCauHoi());
    }
    
    public List<Question> getMultipleChoiceQuestion() {
        List<Question> m = new ArrayList<>();
        this.getQuestions().stream().filter((q) -> (q instanceof MultipleChoice))
                .forEachOrdered((q) -> {
            m.add(q);
        });
//        for (Question q : this.questions)
//            if (q instanceof MultipleChoice)
//                m.add(q);
        return m;
        // LỌC RA DANH SÁCH CÁC CÂU HỎI MULTIPLE CHOICE TRONG DANH SÁCH
        // CÂU HỎI BAN ĐẦU
    }
    
    public List<Question> getInCompleteQuestion() {
        List<Question> ic = new ArrayList<>();
        this.getQuestions().stream().filter((q) -> (q instanceof InComplete))
                .forEachOrdered((q) -> {
            ic.add(q);
        });
        return ic;
        // LỌC RA DANH SÁCH CÁC CÂU HỎI INCOMPLETE TRONG DANH SÁCH
    }
    
    public List<Question> getConversationQuestion() {
        List<Question> c = new ArrayList<>();
        this.getQuestions().stream().filter((q) -> (q instanceof Conversation))
                .forEachOrdered((q) -> {
            c.add(q);
        });
        return c;
        // LỌC RA DANH SÁCH CÁC CÂU HỎI CONVERSATION TRONG DANH SÁCH
    }
    
    public void practiceMultipleChoice(Scanner scanner, int number) {
        List<Question> m = this.getMultipleChoiceQuestion();
        Collections.shuffle(m);// CÂU LỆNH XÁO TRỘN CÁC ĐÁP ÁN
        int n = m.size() > number ? number : m.size();
        for (int i = 0; i < n; i++) {
            MultipleChoice q = (MultipleChoice) m.get(i); // ÉP KIỂU VỀ MULTIPLECHOICE
            System.out.println(" ");
            System.out.println(q);
            
            
            System.out.print("NHẬP ĐÁP ÁN: ");
            String ans = scanner.nextLine();
            
            if (q.checkAnswer(ans) == true) {
                System.out.println("=> ĐÁP ÁN ĐÚNG!");
            }
            else
                System.out.println("=> ĐÁP ÁN SAI!");    
        } 
        // HÀM THỰC HÀNH LỌC VÀ CHECK CÁC ĐÁP ÁN CỦA MULIPLECHOICE
    }
    
    public void practiceInCompleteQuestion(Scanner scanner, int number) {
        List<Question> ic = this.getInCompleteQuestion();
        Collections.shuffle(ic); // CÂU LỆNH XÁO TRỘN CÁC CÂU HỎI
        int n = ic.size() > number ? number : ic.size();
        if (ic.size() >= 0) {
            for (int i = 0; i < n; i++) {
                InComplete q = (InComplete) ic.get(i);
                System.out.println(" ");
                System.out.println(q);
                q.getQuestion().stream().map((mc) -> {  //for (MultipleChoice mc : q.getQuestion())
                    System.out.printf("NHẬP ĐÁP ÁN CHO CÂU %s\n: ", mc.getContent());
                    return mc;
                }).forEachOrdered((mc) -> {
                    String ans = scanner.nextLine();
                    
                    if (mc.checkAnswer(ans) == true)
                        System.out.println("=> ĐÁP ÁN ĐÚNG!");
                    else
                        System.out.println("=> ĐÁP ÁN SAI!");
                });       
            }       
        }
    }
    
    public void practiceConversationQuestion(Scanner scanner, int number) {
    List<Question> c = this.getConversationQuestion();
    Collections.shuffle(c); // CÂU LỆNH XÁO TRỘN CÁC CÂU HỎI
    int n = c.size() > number ? number : c.size();
    if (c.size() >= 0) {
        for (int i = 0; i < n; i++) {
            Conversation q = (Conversation) c.get(i);
            System.out.println(" ");
            System.out.println(q);
            for (MultipleChoice mc : q.getQuestion()) {
                System.out.printf("NHẬP ĐÁP ÁN CHO CÂU %s\n: ", mc.getContent());
                String ans = scanner.nextLine();
                
                if (mc.checkAnswer(ans) == true)
                    System.out.println("=> ĐÁP ÁN ĐÚNG!");
                else
                    System.out.println("=> ĐÁP ÁN SAI!");
            }      
        }       
    }
}
    
    public void DataMultipleChoice(QuestionManagement ql1) {
        // CÂU 1
        MultipleChoice q1 = new MultipleChoice("I’m ..... America.", Level.DỄ);
        Choice c1 = new Choice("in", false);
        Choice c2 = new Choice("a", false);
        Choice c3 = new Choice("from", true);
        Choice c4 = new Choice("too", false);

        q1.addChoice(c1);
        q1.addChoice(c2);
        q1.addChoice(c3);
        q1.addChoice(c4);


        // CÂU 2
        MultipleChoice q2 = new MultipleChoice("There .... two boys in my class.", Level.DỄ);
        Choice c5 = new Choice("is", false);
        Choice c6 = new Choice("many", false);
        Choice c7 = new Choice("are", true);
        Choice c8 = new Choice("isn't", false);

        q2.addChoice(c5);
        q2.addChoice(c6);
        q2.addChoice(c7);
        q2.addChoice(c8);


        // CÂU 3
        MultipleChoice q3 = new MultipleChoice("Hi, my ..... Alan.", Level.DỄ);
        Choice c9 = new Choice("name is", true);
        Choice c10 = new Choice("names’", false);
        Choice c11 = new Choice("names", false);
        Choice c12 = new Choice("is name", false);

        q3.addChoice(c9);
        q3.addChoice(c10);
        q3.addChoice(c11);
        q3.addChoice(c12);


        // CÂU 4
        MultipleChoice q4 = new MultipleChoice("Jimmy is happy because to day is .... birthday.", Level.TRUNG_BÌNH);
        Choice c13 = new Choice("her", true);
        Choice c14 = new Choice("she’", false);
        Choice c15 = new Choice("his", true);
        Choice c16 = new Choice("he", false);

        q4.addChoice(c13);
        q4.addChoice(c14);
        q4.addChoice(c15);
        q4.addChoice(c16);


        // CÂU 5
        MultipleChoice q5 = new MultipleChoice("Mary studies Maths ….. 7 a.m …… 8 a.m on Sunday.", Level.TRUNG_BÌNH);
        Choice c17 = new Choice("to/at", false);
        Choice c18 = new Choice("from/in", false);
        Choice c19 = new Choice("from/to", true);
        Choice c20 = new Choice("on/to", false);

        q5.addChoice(c17);
        q5.addChoice(c18);
        q5.addChoice(c19);
        q5.addChoice(c20);

        // CÂU 6
        MultipleChoice q6 = new MultipleChoice("Choose the odd one out:", Level.TRUNG_BÌNH);
        Choice c21 = new Choice("father", false);
        Choice c22 = new Choice("mother", false);
        Choice c23 = new Choice("teacher", true);
        Choice c24 = new Choice("sister", false);

        q6.addChoice(c21);
        q6.addChoice(c22);
        q6.addChoice(c23);
        q6.addChoice(c24);

        // CÂU 7
        MultipleChoice q7 = new MultipleChoice("A .......... works in a hospital.", Level.TRUNG_BÌNH);
        Choice c25 = new Choice("teacher", false);
        Choice c26 = new Choice("worker", false);
        Choice c27 = new Choice("nurse", true);
        Choice c28 = new Choice("farmer", false);

        q7.addChoice(c25);
        q7.addChoice(c26);
        q7.addChoice(c27);
        q7.addChoice(c28);

        // CÂU 8
        MultipleChoice q8 = new MultipleChoice("What . . . . . does Peter study at school? - He has Maths, English, Art…. ", Level.KHÓ);
        Choice c29 = new Choice("objects", false);
        Choice c30 = new Choice("subjects", true);
        Choice c31 = new Choice("food", false);
        Choice c32 = new Choice("drink", false);

        q8.addChoice(c29);
        q8.addChoice(c30);
        q8.addChoice(c31);
        q8.addChoice(c32);

        // CÂU 9
        MultipleChoice q9 = new MultipleChoice(" .......... you like to play hide and seek with me? ", Level.KHÓ);
        Choice c33 = new Choice("Would", true);
        Choice c34 = new Choice("Could", false);
        Choice c35 = new Choice("Do", false);
        Choice c36 = new Choice("If", false);

        q9.addChoice(c33);
        q9.addChoice(c34);
        q9.addChoice(c35);
        q9.addChoice(c36);

         // CÂU 10
        MultipleChoice q10 = new MultipleChoice(" They are from .......... ", Level.KHÓ);
        Choice c37 = new Choice("Singapore", true);
        Choice c38 = new Choice("Vietnamese", false);
        Choice c39 = new Choice("English", false);
        Choice c40 = new Choice("American", false);

        q10.addChoice(c37);
        q10.addChoice(c38);
        q10.addChoice(c39);
        q10.addChoice(c40);
        

        ql1.addQuestion(q1);
        ql1.addQuestion(q2);
        ql1.addQuestion(q3);
        ql1.addQuestion(q4);
        ql1.addQuestion(q5);
        ql1.addQuestion(q6);
        ql1.addQuestion(q7);
        ql1.addQuestion(q8);
        ql1.addQuestion(q9);
        ql1.addQuestion(q10);
    }
    
    public void DataInCompleteChoice (QuestionManagement ql2) {
        
        // CÂU 1
        InComplete ic1 = new InComplete("Hoang is a (1) ……………. He’s twelve years (2) …………….. He’s tall and (3) ……………. His face "
                + "is (4) ……………… and his hair is (5) ………………. and black. He (6) ……………… at school in the morning and (7) …………….. football"
                + " in the afternoon. He (8) ……………… good marks in class.", Level.DỄ);
        
        // Lựa chọn 1
        MultipleChoice q1 = new MultipleChoice("(1)", Level.DỄ);
        Choice c1 = new Choice("class", false);
        Choice c2 = new Choice("student", true);
        Choice c3 = new Choice("school", false);
        Choice c4 = new Choice("doctor", false);
        q1.addChoice(c1);
        q1.addChoice(c2);
        q1.addChoice(c3);
        q1.addChoice(c4);
        
        // Lựa chọn 2
        MultipleChoice q2 = new MultipleChoice("(2)", Level.DỄ);
        Choice c5 = new Choice("young", false);
        Choice c6 = new Choice("old", true);
        Choice c7 = new Choice("small", false);
        Choice c8 = new Choice("big", false);
        q2.addChoice(c5);
        q2.addChoice(c6);
        q2.addChoice(c7);
        q2.addChoice(c8);
        
        // Lựa chọn 3
        MultipleChoice q3 = new MultipleChoice("(3)", Level.DỄ);
        Choice c9 = new Choice("round", false);
        Choice c10 = new Choice("thin", true);
        Choice c11 = new Choice("oval", false);
        Choice c12 = new Choice("long", false);
        q3.addChoice(c9);
        q3.addChoice(c10);
        q3.addChoice(c11);
        q3.addChoice(c12);
        
        // Lựa chọn 4
        MultipleChoice q4 = new MultipleChoice("(4)", Level.TRUNG_BÌNH);
        Choice c13 = new Choice("long", true);
        Choice c14 = new Choice("heavy", false);
        Choice c15 = new Choice("light", false);
        Choice c16 = new Choice("thick", false);
        q4.addChoice(c13);
        q4.addChoice(c14);
        q4.addChoice(c15);
        q4.addChoice(c16);
        
        // Lựa chọn 5
        MultipleChoice q5 = new MultipleChoice("(5)", Level.TRUNG_BÌNH);
        Choice c17 = new Choice("full", false);
        Choice c18 = new Choice("big", false);
        Choice c19 = new Choice("round", false);
        Choice c20 = new Choice("short", true);
        q5.addChoice(c17);
        q5.addChoice(c18);
        q5.addChoice(c19);
        q5.addChoice(c20);
        
        // Lựa chọn 6
        MultipleChoice q6 = new MultipleChoice("(6)", Level.TRUNG_BÌNH);
        Choice c21 = new Choice("studies", true);
        Choice c22 = new Choice("travels", false);
        Choice c23 = new Choice("walks", false);
        Choice c24 = new Choice("goes", false);
        q6.addChoice(c21);
        q6.addChoice(c22);
        q6.addChoice(c23);
        q6.addChoice(c24);
        
        // Lựa chọn 7
        MultipleChoice q7 = new MultipleChoice("(7)", Level.KHÓ);
        Choice c25 = new Choice("plays", true);
        Choice c26 = new Choice("travels", false);
        Choice c27 = new Choice("works", false);
        Choice c28 = new Choice("goes", false);
        q7.addChoice(c25);
        q7.addChoice(c26);
        q7.addChoice(c27);
        q7.addChoice(c28);
        
        // Lựa chọn 8
        MultipleChoice q8 = new MultipleChoice("(8)", Level.KHÓ);
        Choice c29 = new Choice("plays", false);
        Choice c30 = new Choice("gets", true);
        Choice c31 = new Choice("does", false);
        Choice c32 = new Choice("have", false);
        q8.addChoice(c29);
        q8.addChoice(c30);
        q8.addChoice(c31);
        q8.addChoice(c32);
        
//        ql2.addQuestion(ic1);
        ic1.addQuestion(q1);
        ic1.addQuestion(q2);
        ic1.addQuestion(q3);
        ic1.addQuestion(q4);
        ic1.addQuestion(q5);
        ic1.addQuestion(q6);
        ic1.addQuestion(q7);
        ic1.addQuestion(q8);
        
        ql2.addQuestion(ic1);

    }
    
    public void DataConversation (QuestionManagement ql3) {
        Conversation cq = new Conversation("My best friend is called Tony. We are classmates. We sit in the class on the same bench side by side. We share many things with each other.\n" +
"Tony comes from an educated family. His father is a school principal and his mother is also a teacher. He is punctual, well-educated, and has good manners. He is friendly, clever and "
                + "really hard-working. He is also well-dressed and well-behaved. He is very good in his studies and always does his work attentively in the class. All the teachers have"
                + " a high opinion of him.\n" +
"Tony has a well-built body; he is tall and slim and has straight blonde hair and blue eyes. He takes part in all sports and he also likes to play the guitar. He has a good heart. He is "
                + "honest and obedient. Tony makes his parents very proud of him. He secures good marks and is usually top of his class in examinations. He inspires me to work harder. "
                + "Whenever I need any help in my study, he remains always ready to help me. He helps me by giving his notebook, when I am absent from school. He corrects me whenever I "
                + "commit any mistake. I am happy to have such a friend.", Level.DỄ);
        
        // Lựa chọn 1
        MultipleChoice q1 = new MultipleChoice("What does Tony's mother do?", Level.DỄ);
        Choice c1 = new Choice("A farmer", false);
        Choice c2 = new Choice("A guitar player", false);
        Choice c3 = new Choice("A teacher", true);
        Choice c4 = new Choice("A school principal", false);
        q1.addChoice(c1);
        q1.addChoice(c2);
        q1.addChoice(c3);
        q1.addChoice(c4);
        
        // Lựa chọn 2
        MultipleChoice q2 = new MultipleChoice("What does Tony look like?", Level.DỄ);
        Choice c5 = new Choice("He is tall and slim.", true);
        Choice c6 = new Choice(" He is tall and fat.", false);
        Choice c7 = new Choice("He is friendly and honest.", false);
        Choice c8 = new Choice("He likes to play the guitar.", false);
        q2.addChoice(c5);
        q2.addChoice(c6);
        q2.addChoice(c7);
        q2.addChoice(c8);
        
        // Lựa chọn 3
        MultipleChoice q3 = new MultipleChoice("What does Tony have?", Level.TRUNG_BÌNH);
        Choice c9 = new Choice("Straight blonde hair and blue eyes.", true);
        Choice c10 = new Choice("Green eyes and curly brown hair", true);
        Choice c11 = new Choice("Curly brown hair and blue eyes", false);
        Choice c12 = new Choice("Blue eyes and curly blonde hair", false);
        q3.addChoice(c9);
        q3.addChoice(c10);
        q3.addChoice(c11);
        q3.addChoice(c12);
        
        // Lựa chọn 4
        MultipleChoice q4 = new MultipleChoice("What does Tony like?", Level.TRUNG_BÌNH);
        Choice c13 = new Choice("He is tall and thin.", false);
        Choice c14 = new Choice("He likes sports.", true);
        Choice c15 = new Choice("He is friendly, clever and honest.", false);
        Choice c16 = new Choice("D. He loves to listen to guitar music.", false);
        q4.addChoice(c13);
        q4.addChoice(c14);
        q4.addChoice(c15);
        q4.addChoice(c16);
        
        // Lựa chọn 5
        MultipleChoice q5 = new MultipleChoice("Which adjective is NOT used to describe Tony?", Level.TRUNG_BÌNH);
        Choice c17 = new Choice("Honest", false);
        Choice c18 = new Choice("Humorous", true);
        Choice c19 = new Choice("Well-behaved", false);
        Choice c20 = new Choice("Hard-working", false);
        q5.addChoice(c17);
        q5.addChoice(c18);
        q5.addChoice(c19);
        q5.addChoice(c20);
        
        cq.addQuestion(q1);
        cq.addQuestion(q2);
        cq.addQuestion(q3);
        cq.addQuestion(q4);
        cq.addQuestion(q5);
        
        ql3.addQuestion(cq);
    }

    
    

    
    /**
     * @return the questions
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }           
}  
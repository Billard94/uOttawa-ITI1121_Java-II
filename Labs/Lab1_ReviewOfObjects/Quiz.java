public class Quiz {  
    public static void main(String[] args) {  
        String s = null;  
        if (s.length() > 0) {  
            System.out.println(s);  
        } else {  
            System.out.println("empty string");  
        }  
    }  
}

// Answer:
// 5. Produces a run-time error:
// Exception in thread "main" java.lang.NullPointerException  
// at Quiz.main(Quiz.java:4)
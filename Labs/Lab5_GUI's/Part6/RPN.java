import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Stack; // Java's implementation of a Stack

public class RPN {
  
  public static int eval(String input) throws IOException {
    
    Stack s = new Stack();
    
    StringReader sr = new StringReader(input);
    StreamTokenizer st = new StreamTokenizer(sr);
    
    st.eolIsSignificant(false); // expressions may contain newlines
    st.ordinaryChar('/'); // should not be interpreted as a comment
    
    int token = st.nextToken();
    while (token != StreamTokenizer.TT_EOF) {
      
      switch (token) {
        case StreamTokenizer.TT_NUMBER:
          s.push(new Integer((int) st.nval));
          break;
        default:
          int r = ((Integer) s.pop()).intValue();
          int l = ((Integer) s.pop()).intValue();
          int res = 0;
          
          switch (st.ttype) {
            case '+':
              res = l + r;
              break;
            case '-':
              res = l - r;
              break;
            case '*':
              res = l * r;
              break;
            case '/':
              res = l / r;
              break;
          }
          s.push(new Integer(res));
      }
      token = st.nextToken();
    }
    return ((Integer) s.pop()).intValue();
  }
  
  public static void main(String[] args) throws IOException {
    System.out.println(args[0] + " = " + eval(args[0]));
  }
}
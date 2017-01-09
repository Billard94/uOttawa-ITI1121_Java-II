public class Balanced {

    public static boolean algo1( String s ) {

        int curly = 0;
        int square = 0;
        int round = 0;

        for ( int i=0; i<s.length(); i++ ) {

            char c = s.charAt( i );

            switch ( c ) {
            case '{':
                curly++;
                break;
            case '}':
                curly--;
                break;
            case '[':
                square++;
                break;
            case ']':
                square--;
                break;
            case '(':
                round++;
                break;
            case ')':
                round--;
            }
        }
        return curly == 0 && square == 0 && round == 0;
    }

    public static boolean algo2( String s ) {

        Stack<Character> brackets;
        brackets = new ArrayStack<Character>( 100 );

        for ( int i=0; i<s.length(); i++ ) {

            char current = s.charAt( i );

            if ( current == '(' || current == '[' || current == '{' ) {

                brackets.push( new Character( current ) );

            } else if ( current == ')' || current == ']' || current == '}' ) {

                if (brackets.isEmpty())

                    return false; // (1)

                char top = ( (Character) brackets.pop() ).charValue();

                if ( (current == ')' && top != '(') ||
                     (current == ']' && top != '[') ||
                     (current == '}' && top != '{') )
                    return false; // (2)
            }
        }
        return brackets.isEmpty (); // (3)
    }

    public static void main( String[] args ) {
        for ( int i=0; i<args.length; i++ ) {
            System.out.println( "algo1( \"" + args[ i ] + "\" ) -> " + algo1( args[ i ] ) );
            System.out.println( "algo2( \"" + args[ i ] + "\" ) -> " + algo2( args[ i ] ) );
        }
    }
}

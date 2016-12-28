
import java.util.StringTokenizer;

class Reader {

    private StringTokenizer st;

    Reader( String s ) {
        st = new StringTokenizer( s );
    }

    public boolean hasMoreTokens() {
        return st.hasMoreTokens();
    }

    public Token nextToken() {

        String t = st.nextToken();

        if ( "true".equals( t ) )
            return new Token( true );

        if ( "false".equals( t ) )
            return new Token( false );

        try {
            return new Token( Integer.parseInt( t ) );

        } catch ( NumberFormatException e ) { 

            return new Token( t );

        }
    }
}

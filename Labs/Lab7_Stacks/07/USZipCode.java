public class USZipCode extends PostalCode {

    public USZipCode( String code ) {
        super( code );
    }

    public boolean isValid() {

        String myCode = getCode();

        boolean valid = true;

        if ( myCode.length() != 8 ) {
            valid = false;
        } else if (! Character.isLetter( myCode.charAt( 0 ) ) ) {
            valid = false;
        } else if (! Character.isLetter( myCode.charAt( 1 ) ) ) {
            valid = false;
        } else if (! Character.isWhitespace( myCode.charAt( 2 ) ) ) {
            valid = false;
        } else if (! Character.isDigit( myCode.charAt( 3 ) ) ) {
            valid = false;
        } else if (! Character.isDigit( myCode.charAt( 4 ) ) ) {
            valid = false;
        } else if (! Character.isDigit( myCode.charAt( 5 ) ) ) {
            valid = false;
        } else if (! Character.isDigit( myCode.charAt( 6 ) ) ) {
            valid = false;
        } else if (! Character.isDigit( myCode.charAt( 7 ) ) ) {
            valid = false;
        }

        return valid;
    }
}

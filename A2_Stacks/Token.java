class Token {

    private static final int BOOLEAN = 0;
    private static final int INTEGER = 1;
    private static final int SYMBOL = 2;

    private boolean bValue;
    private int iValue;
    private String sValue;

    private int type;

    Token( boolean bValue ) {
        this.bValue = bValue;
        type = BOOLEAN;
    }

    Token( int iValue ) {
        this.iValue = iValue;
        type = INTEGER;
    }

    Token( String sValue ) {
        this.sValue = sValue;
        type = SYMBOL;
    }

    public boolean bValue() {
        if ( type != BOOLEAN )
            throw new IllegalStateException( "not a boolean" );

        return bValue;
    }

    public int iValue() {
        if ( type != INTEGER )
            throw new IllegalStateException( "not an integer" );

        return iValue;
    }

    public String sValue() {
        if ( type != SYMBOL )
            throw new IllegalStateException( "not a symbol" );

        return sValue;
    }

    public boolean isBoolean() {
        return type == BOOLEAN;
    }

    public boolean isInteger() {
        return type == INTEGER;
    }

    public boolean isSymbol() {
        return type == SYMBOL;
    }

    public String toString() {

        switch ( type ) {
        case BOOLEAN:
            return "BOOLEAN: " + bValue;
        case INTEGER:
            return "INTEGER: " + iValue;
        case SYMBOL:
            return "SYMBOL: " + sValue;
        default:
            return "INVALID";
        }
    }
}

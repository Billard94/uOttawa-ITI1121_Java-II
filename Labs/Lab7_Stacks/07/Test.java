class Test {
    public static void main( String[] args ) {

        PostalCode[] codes = new PostalCode[ 100 ];
        int count=0, n=10;

        codes[ 0 ] = new CanadianPostalCode( "K1N 6N5" );
        codes[ 1 ] = new CanadianPostalCode( "K1N 6N" );
        codes[ 2 ] = new CanadianPostalCode( "K1N6N5" );
        codes[ 3 ] = new CanadianPostalCode( "K1N N65" );
        codes[ 4 ] = new CanadianPostalCode( "K1N 6N55" );

        codes[ 5 ] = new USZipCode( "CA 95014" );
        codes[ 6 ] = new USZipCode( "95014" );
        codes[ 7 ] = new USZipCode( "95014 CA" );
        codes[ 8 ] = new USZipCode( "CA 95O14" );
        codes[ 9 ] = new USZipCode( "CA 950!4" );

        for ( int i=0; i<n; i++ ) {
            if ( codes[ i ].isValid() ) {
                count++;
            }
        }

        System.out.println( count );
    }

}

public class Test {

    public static void main( String[] args ) {

        Combination c1, c2;

        c1 = new Combination( 1, 1, 1 );
        c2 = new Combination( 2, 2, 2 );

        if ( c1.compareTo( c2 ) < 0 ) {
            System.out.println( "test 01: okay" );
        } else {
            System.out.println( "test 01: failed" );
        }

        c1 = new Combination( 1, 1, 1 );
        c2 = new Combination( 2, 2, 1 );

        if ( c1.compareTo( c2 ) <= 0 ) {
            System.out.println( "test 02: okay" );
        } else {
            System.out.println( "test 02: failed" );
        }

        c1 = new Combination( 1, 1, 2 );
        c2 = new Combination( 2, 2, 1 );

        if ( c1.compareTo( c2 ) < 0 ) {
            System.out.println( "test 03: okay" );
        } else {
            System.out.println( "test 03: failed" );
        }

        c1 = new Combination( 1, 1, 1 );
        c2 = new Combination( 2, 1, 2 );

        if ( c1.compareTo( c2 ) < 0 ) {
            System.out.println( "test 04: okay" );
        } else {
            System.out.println( "test 04: failed" );
        }

        c1 = new Combination( 1, 1, 1 );
        c2 = new Combination( 2, 1, 1 );

        if ( c1.compareTo( c2 ) < 0 ) {
            System.out.println( "test 05: okay" );
        } else {
            System.out.println( "test 05: failed" );
        }

        c1 = new Combination( 1, 1, 2 );
        c2 = new Combination( 2, 1, 1 );

        if ( c1.compareTo( c2 ) < 0 ) {
            System.out.println( "test 06: okay" );
        } else {
            System.out.println( "test 06: failed" );
        }

        c1 = new Combination( 1, 2, 1 );
        c2 = new Combination( 2, 1, 2 );

        if ( c1.compareTo( c2 ) < 0 ) {
            System.out.println( "test 07: okay" );
        } else {
            System.out.println( "test 07: failed" );
        }

        c1 = new Combination( 1, 2, 1 );
        c2 = new Combination( 2, 1, 1 );

        if ( c1.compareTo( c2 ) < 0 ) {
            System.out.println( "test 08: okay" );
        } else {
            System.out.println( "test 08: failed" );
        }

        c1 = new Combination( 1, 2, 2 );
        c2 = new Combination( 2, 1, 1 );

        if ( c1.compareTo( c2 ) < 0 ) {
            System.out.println( "test 09: okay" );
        } else {
            System.out.println( "test 09: failed" );
        }

        c1 = new Combination( 1, 1, 1 );
        c2 = new Combination( 1, 2, 2 );

        if ( c1.compareTo( c2 ) < 0 ) {
            System.out.println( "test 10: okay" );
        } else {
            System.out.println( "test 10: failed" );
        }

        c1 = new Combination( 1, 1, 1 );
        c2 = new Combination( 1, 2, 1 );

        if ( c1.compareTo( c2 ) < 0 ) {
            System.out.println( "test 11: okay" );
        } else {
            System.out.println( "test 11: failed" );
        }

        c1 = new Combination( 1, 1, 2 );
        c2 = new Combination( 1, 2, 1 );

        if ( c1.compareTo( c2 ) < 0 ) {
            System.out.println( "test 12: okay" );
        } else {
            System.out.println( "test 12: failed" );
        }

        c1 = new Combination( 1, 1, 1 );
        c2 = new Combination( 1, 1, 2 );

        if ( c1.compareTo( c2 ) < 0 ) {
            System.out.println( "test 13: okay" );
        } else {
            System.out.println( "test 13: failed" );
        }

        c1 = new Combination( 1, 1, 1 );
        c2 = new Combination( 1, 1, 1 );

        if ( c1.compareTo( c2 ) == 0 ) {
            System.out.println( "test 14: okay" );
        } else {
            System.out.println( "test 14: failed" );
        }

        c1 = new Combination( 1, 1, 2 );
        c2 = new Combination( 1, 1, 1 );

        if ( c1.compareTo( c2 ) > 0 ) {
            System.out.println( "test 15: okay" );
        } else {
            System.out.println( "test 15: failed" );
        }

        c1 = new Combination( 1, 2, 1 );
        c2 = new Combination( 1, 1, 2 );

        if ( c1.compareTo( c2 ) > 0 ) {
            System.out.println( "test 16: okay" );
        } else {
            System.out.println( "test 16: failed" );
        }

        c1 = new Combination( 1, 2, 1 );
        c2 = new Combination( 1, 1, 1 );

        if ( c1.compareTo( c2 ) > 0 ) {
            System.out.println( "test 17: okay" );
        } else {
            System.out.println( "test 17: failed" );
        }

        c1 = new Combination( 1, 2, 2 );
        c2 = new Combination( 1, 1, 1 );

        if ( c1.compareTo( c2 ) > 0 ) {
            System.out.println( "test 18: okay" );
        } else {
            System.out.println( "test 18: failed" );
        }

        c1 = new Combination( 2, 1, 1 );
        c2 = new Combination( 1, 2, 2 );

        if ( c1.compareTo( c2 ) > 0 ) {
            System.out.println( "test 19: okay" );
        } else {
            System.out.println( "test 19: failed" );
        }

        c1 = new Combination( 2, 1, 1 );
        c2 = new Combination( 1, 2, 1 );

        if ( c1.compareTo( c2 ) > 0 ) {
            System.out.println( "test 20: okay" );
        } else {
            System.out.println( "test 20: failed" );
        }

        c1 = new Combination( 2, 1, 2 );
        c2 = new Combination( 1, 2, 1 );

        if ( c1.compareTo( c2 ) > 0 ) {
            System.out.println( "test 21: okay" );
        } else {
            System.out.println( "test 21: failed" );
        }

        c1 = new Combination( 2, 1, 1 );
        c2 = new Combination( 1, 1, 2 );

        if ( c1.compareTo( c2 ) > 0 ) {
            System.out.println( "test 22: okay" );
        } else {
            System.out.println( "test 22: failed" );
        }

        c1 = new Combination( 2, 1, 1 );
        c2 = new Combination( 1, 1, 1 );

        if ( c1.compareTo( c2 ) > 0 ) {
            System.out.println( "test 23: okay" );
        } else {
            System.out.println( "test 23: failed" );
        }

        c1 = new Combination( 2, 1, 2 );
        c2 = new Combination( 1, 1, 1 );

        if ( c1.compareTo( c2 ) > 0 ) {
            System.out.println( "test 24: okay" );
        } else {
            System.out.println( "test 24: failed" );
        }

        c1 = new Combination( 2, 2, 1 );
        c2 = new Combination( 1, 1, 2 );

        if ( c1.compareTo( c2 ) > 0 ) {
            System.out.println( "test 25: okay" );
        } else {
            System.out.println( "test 25: failed" );
        }

        c1 = new Combination( 2, 2, 1 );
        c2 = new Combination( 1, 1, 1 );

        if ( c1.compareTo( c2 ) > 0 ) {
            System.out.println( "test 26: okay" );
        } else {
            System.out.println( "test 26: failed" );
        }

        c1 = new Combination( 2, 2, 2 );
        c2 = new Combination( 1, 1, 1 );

        if ( c1.compareTo( c2 ) > 0 ) {
            System.out.println( "test 27: okay" );
        } else {
            System.out.println( "test 27: failed" );
        }

        // Uncomment the following and compile this class

        // if ( c1.compareTo( "puzzle" ) < 0 ) {
        //     System.out.println( "test 28: ?" );
        // }

    }

}

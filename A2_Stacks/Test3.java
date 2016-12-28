

public class Test3 {

    public static void displayStudentInfo( ) {

        System.out.println( "************************************************************" );
        System.out.println( "* Author: Alexandre Billard                                *" );
        System.out.println( "* Student number: 6812210                                  *" );
        System.out.println( "* Course: ITI1121                                          *" );
        System.out.println( "* Assignment: 2                                            *" );
        System.out.println( "************************************************************" );
        System.out.println();

    }

    public static void main( String[] args ) {

        displayStudentInfo();

        Stack s1 = new ArrayStack( 30 );

        Stack s2 = new DynamicArrayStack( 5 );

        for ( int i=0; i<30; i++ ) {

            s1.push( "elem-" + i );
            s2.push( "elem-" + i );

        }

        while ( ! s1.isEmpty() ) {

            Object a = s1.pop();
            Object b = s2.pop();

            if ( ! a.equals( b ) ) {
                System.out.println( a + " is not equals to " + b );
            }

        }

        for ( int i=0; i<30; i++ ) {

            s1.push( "elem-" + i );
            s2.push( "elem-" + i );

        }

        while ( ! s1.isEmpty() ) {

            Object a = s1.pop();
            Object b = s2.pop();

            if ( ! a.equals( b ) ) {
                System.out.println( a + " is not equals to " + b );
            }

        }

        System.out.println( "done." );
    }
}

// > java Test3
// ************************************************************
// *                                                          *
// *                                                          *
// *                                                          *
// *                                                          *
// ************************************************************
// 
// done.

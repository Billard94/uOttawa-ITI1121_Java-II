

public class Test1 {

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

        Stack s = new ArrayStack( 10 );

        for ( int i=0; i<10; i++ ) {
            s.push( "elem-" + i );
        }

        s.clear();

        while ( ! s.isEmpty() ) {
            System.out.println( s.pop() );
        }

        for ( int i=0; i<10; i++ ) {
            s.push( "elem-" + i );
        }

        while ( ! s.isEmpty() ) {
            System.out.println( s.pop() );
        }

    }
}

// > java Test1
// ************************************************************
// *                                                          *
// *                                                          *
// *                                                          *
// *                                                          *
// ************************************************************
// 
// elem-9
// elem-8
// elem-7
// elem-6
// elem-5
// elem-4
// elem-3
// elem-2
// elem-1
// elem-0

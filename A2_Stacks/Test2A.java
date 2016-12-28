

public class Test2A {

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

        Calculator c = new Calculator();

        c.execute( "2 1 5 2 pstack sub exch pstack" );

    }
}

// > java Test2A
// ************************************************************
// *                                                          *
// *                                                          *
// *                                                          *
// *                                                          *
// ************************************************************
//
// -top-
// INTEGER: 2
// INTEGER: 5
// INTEGER: 1
// INTEGER: 2
// -bottom-
// -top-
// INTEGER: 1
// INTEGER: 3
// INTEGER: 2
// -bottom-


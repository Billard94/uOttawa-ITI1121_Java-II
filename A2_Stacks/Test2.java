

public class Test2 {

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

        c.execute( "4 3 add 2 sub dup add pstack" );

    }
}

// > java Test2
// ************************************************************
// *                                                          *
// *                                                          *
// *                                                          *
// *                                                          *
// ************************************************************
// 
// -top-
// INTEGER: 10
// -bottom-

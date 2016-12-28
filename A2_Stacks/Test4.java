

public class Test4 {

    public static void displayStudentInfo( ) {
      
     System.out.println( "************************************************************" );
        System.out.println( "* Author: Alexandre Billard                                *" );
        System.out.println( "* Student number: 6812210                                  *" );
        System.out.println( "* Course: ITI1121                                          *" );
        System.out.println( "* Assignment: 2                                            *" );
        System.out.println( "************************************************************" );
        System.out.println();

    }

    public static void test( Stack s ) {

        if ( ! s.isEmpty() ) {
            System.err.println( "error: use an empty stack" );
            return;
        }
        
        s.push( "elem-0" );

        s.pop();
        
        if ( ! s.isEmpty() ) {
            System.err.println( "error: the stack should be empty" );
            return;
        }

        s.push( "elem-1" );

        if ( ! s.peek().equals( "elem-1" ) ) {
            System.err.println( "error: expecting elem-1" );
            return;
        }

        for ( int i=2; i<10; i++ ) {
            s.push( "elem-" + i );
        }

        for ( int i=9; i>0; i-- ) {

            Object o = s.pop();

            if ( ! o.equals( "elem-" + i ) ) {
                System.err.println( "error: " + o + " not equals to elem-" + i );
                return;
            }
            
        }

        if ( ! s.isEmpty() ) {
            System.err.println( "error: the stack should be empty at the end of test" );
            return;
        }

        System.out.println( "ok" );
    }

    public static void main( String[] args ) {

        displayStudentInfo();

        ArrayStack s1 = new ArrayStack( 10 );

        System.out.println( "Testing ArrayStack" );
        test( s1 );

        DynamicArrayStack s2 = new DynamicArrayStack( 2 );

        System.out.println( "Testing DynamicArrayStack" );
        test( s2 );

        LinkedStack s3 = new LinkedStack();

        System.out.println( "Testing LinkedStack" );
        test( s3 );

        Stack s4 = new DynamicArrayStack( 5 );

        Stack s5 = new LinkedStack();

        for ( int i=0; i<30; i++ ) {

            s4.push( "elem-" + i );
            s5.push( "elem-" + i );

        }

        if ( ! s5.equals( s4 ) ) {
            System.err.println( "error: problem with the first call to equals" );
        }

        if ( s4.isEmpty() ) {
            System.err.println( "error: s4 should not be empty" );
        }

        if ( s5.isEmpty() ) {
            System.err.println( "error: s5 should not be empty" );
        }

        if ( ! s5.equals( s4 ) ) {
            System.err.println( "error: problem with the second call to equals" );
        }

        System.out.println( "done." );
    }

}

// > java Test4
// ************************************************************
// *                                                          *
// *                                                          *
// *                                                          *
// *                                                          *
// ************************************************************
// 
// Testing ArrayStack
// ok
// Testing DynamicArrayStack
// ok
// Testing LinkedStack
// ok
// done.

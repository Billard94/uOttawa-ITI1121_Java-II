
public class Test4A {

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


        LinkedStack s3 = new LinkedStack();

        System.out.println( "Testing LinkedStack" );
        test( s3 );

        System.out.println( "done." );
    }

}

// > java Test4A
// ************************************************************
// *                                                          *
// *                                                          *
// *                                                          *
// *                                                          *
// ************************************************************
// 
// Testing LinkedStack
// ok
// done.

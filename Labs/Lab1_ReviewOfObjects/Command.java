public class Command {
    public static void main( String[] args ) {

        System.out.println( "Start of the program." );
        for ( int i=0; i<args.length; i++ ) {
            System.out.println( "Argument " + i + " is " + args[ i ] );
        }
        System.out.println( "End of the program." );

    }
}
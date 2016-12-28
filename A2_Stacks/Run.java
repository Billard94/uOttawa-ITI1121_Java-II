
public class Run {

    public static void main( String[] args  ) {

        Calculator c = new Calculator();

        for ( int i=0; i<args.length; i++ ) {
            c.execute( args[ i ] );
        }

    }
}

// > java Run "1 dup dup add pstack 3 exch sub pstack"
// -top-
// INTEGER: 2
// INTEGER: 1
// -bottom-
// -top-
// INTEGER: 1
// INTEGER: 1
// -bottom-

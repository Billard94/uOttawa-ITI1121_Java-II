
public class Calculator {

    private Stack operands;

    public Calculator() {
        operands = new ArrayStack( 100 );
    }

    public void execute( String program ) {
        Reader r = new Reader( program );

        while ( r.hasMoreTokens() ) {

            Token t = r.nextToken();

            if ( ! t.isSymbol() ) {

                operands.push( t );

            } else if ( t.sValue().equals( "add" ) ) {

                Token op1 = (Token) operands.pop();
                Token op2 = (Token) operands.pop();
                Token res = new Token( op1.iValue() + op2.iValue() );
                operands.push( res );

            } else if ( t.sValue().equals( "sub" ) ) {

                Token op1 = (Token) operands.pop();
                Token op2 = (Token) operands.pop();
                Token res = new Token( op2.iValue() - op1.iValue() );
                operands.push( res );

            } else if ( t.sValue().equals( "exch" ) ) {

                Token op1 = (Token) operands.pop();
                Token op2 = (Token) operands.pop();
                operands.push( op1 );
                operands.push( op2 );

            } else if ( t.sValue().equals( "dup" ) ) {

                Token op = (Token) operands.pop();

                operands.push( op );
                operands.push( op );

            } else if ( t.sValue().equals( "pstack" ) ) {

                System.out.println( "-top-" );
                Stack tmp = new ArrayStack( 100 );
                while ( ! operands.isEmpty() ) {
                    t = (Token) operands.pop();
                    System.out.println( t );
                    tmp.push( t );
                }
                while (! tmp.isEmpty()) {
                    operands.push( tmp.pop() );
                }
                System.out.println( "-bottom-" );

            } else {

                System.out.println( "not a valid symbol" );

            }
        }
    }
}

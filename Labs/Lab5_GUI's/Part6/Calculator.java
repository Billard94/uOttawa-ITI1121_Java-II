import java.awt.*;
import java.awt.event.*;

import java.io.IOException;

public class Calculator extends Frame implements ActionListener {

    TextArea display = new TextArea( "", 1, 40, TextArea.SCROLLBARS_HORIZONTAL_ONLY );

    Button[] bNums = new Button[10];

    Button bPlus = new Button( "+" );
    Button bMinus = new Button( "-" );
    Button bDiv = new Button( "/" );
    Button bProd = new Button( "*" );

    Button bClear = new Button( "C" );
    Button bEval = new Button( "=" );

    Button bSpace = new Button( "" );

    public Calculator() {

        super( "RPN Calculator" );

        addWindowListener( new MyWindowAdapter() );

        setBackground( Color.WHITE );

        //  ------------------------------------------------------

        display.setBackground( Color.LIGHT_GRAY );
        display.setEditable( false );

        add( display,BorderLayout.NORTH );

        //  ------------------------------------------------------

        for ( int num=0; num<10; num++ ) {
            Button b = new Button( Integer.toString( num ) );
            b.addActionListener( this );
            bNums[num] = b;

        }
        
        Panel keyPanel = new Panel();
        keyPanel.setLayout( new GridLayout( 4,4 ) );

        keyPanel.add( bNums[7] );
        keyPanel.add( bNums[8] );
        keyPanel.add( bNums[9] );
        keyPanel.add( bDiv );

        keyPanel.add( bNums[4] );
        keyPanel.add( bNums[5] );
        keyPanel.add( bNums[6] );
        keyPanel.add( bProd );

        keyPanel.add( bNums[1] );
        keyPanel.add( bNums[2] );
        keyPanel.add( bNums[3] );
        keyPanel.add( bMinus );

        keyPanel.add( bNums[0] );
        keyPanel.add( bClear );
        keyPanel.add( bEval );
        keyPanel.add( bPlus );
        
        bPlus.setBackground( Color.GRAY );
        bMinus.setBackground( Color.GRAY );
        bDiv.setBackground( Color.GRAY );
        bProd.setBackground( Color.GRAY );

        bClear.setBackground( Color.YELLOW );
        bEval.setBackground( Color.GREEN );

        bPlus.addActionListener( this );
        bMinus.addActionListener( this );
        bDiv.addActionListener( this );
        bProd.addActionListener( this );

        bClear.addActionListener( this );
        bEval.addActionListener( this );

        bSpace.addActionListener( this );

        //  ------------------------------------------------------

        add( keyPanel, BorderLayout.CENTER );

        add( bSpace, BorderLayout.SOUTH );

        pack();
        setVisible( true );
    }

    public void actionPerformed( ActionEvent e ) {

        Object src = e.getSource();
        
        for ( int i=0; i<bNums.length; i++ ) {
            if ( src == bNums[i] ) {
                display.append( Integer.toString( i ) );
                break;
            }
        }

        if ( src == bPlus ) {
            display.append( "+" );
        } else if ( src == bMinus ) {
            display.append( "-" );
        } else if ( src == bDiv ) {
            display.append( "/" );
        } else if ( src == bProd ) {
            display.append( "*" );
        } else if ( src == bClear ) {
            display.setText( "" );
        } else if ( src == bSpace ) {
            display.append(" ");
        } else if (src == bEval) {

            String s;
            try {
                s = Integer.toString( RPN.eval( display.getText() ) );
            } catch( IOException exception ) {
                s = "not a valid expression!";
            } 
            
            display.setText( s );
        }
                        
    }

    public static void main( String[] args ) {
        new Calculator();
    }

}

class MyWindowAdapter extends WindowAdapter {

    public void windowClosing( WindowEvent e ) {
        System.out.println( "Bye" );
        System.exit( 0 );
    }
}
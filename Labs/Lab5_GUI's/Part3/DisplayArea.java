import java.awt.*;
import java.awt.event.*;
   
class DisplayArea extends Canvas implements ActionListener {
   
    DisplayArea() {
        setSize( 200,200 );
    }
   
    public void actionPerformed( ActionEvent e ) {

        System.out.println( "actionPerformed was called" );
    }
}
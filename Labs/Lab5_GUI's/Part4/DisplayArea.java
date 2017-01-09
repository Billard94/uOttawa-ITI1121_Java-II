import java.awt.*;
import java.awt.event.*;
   
class DisplayArea extends Canvas implements ActionListener {
   
    private Point center;
   
    DisplayArea() {
        setSize( 200,200 );
        center = new Point( 100,100 );
    }
   
    public void paint( Graphics g ) {
   
        g.setColor( Color.RED );
        g.fillOval( center.x - 5, center.y - 5, 10, 10 );
   
    }
   
    public void actionPerformed( ActionEvent e ) {

        System.out.println( "actionPerformed was called" );
   
    }
}
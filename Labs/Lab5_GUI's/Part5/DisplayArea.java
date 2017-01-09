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
   
        String cmd = e.getActionCommand();
   
        if ( cmd.equals( "Left" ) ) {
            center.x = ( center.x + 190 ) % 200; // subtracts 10
        } else if ( cmd.equals( "Right" ) ) {
            center.x = ( center.x + 10 ) % 200;
        }
   
        repaint();
    }
}
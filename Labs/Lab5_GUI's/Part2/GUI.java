import java.awt.*;
import java.awt.event.*;
   
public class GUI extends Frame {
   
    private Button bLeft = new Button( "Left" );
    private Button bRight = new Button( "Right" );
   
    private DisplayArea display = new DisplayArea();
   
    public GUI() {
   
        super( "DGD - Week 8" );
   
        setBackground( Color.WHITE );
   
        add( display, BorderLayout.CENTER );
   
        Panel p = new Panel();
   
        p.add( bLeft );
        p.add( bRight );
   
        add( p, BorderLayout.SOUTH );
   
        addWindowListener( new MyWindowAdapter() );
   
        pack();
        show();
    }
   
    public static void main(String[] args) {
        new GUI();
    }
}

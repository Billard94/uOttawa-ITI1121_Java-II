import java.awt.event.*;

class MyWindowAdapter extends WindowAdapter {

    public void windowClosing(WindowEvent e) {
    	System.exit(0);
    }

}
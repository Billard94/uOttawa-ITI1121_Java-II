import java.awt.*;
import java.awt.event.*;
public class SudokuBoard extends Canvas implements ActionListener{

	private final int CELLSIZE=50;
	private SudokuMatrix matrix;
	private int[][] cell=new int[9][9];
	private int remainsToFill=81;
	private PopUpDialog pop;
    private SudokuGame frame;
    private int selectedx=-1;
    private int selectedy=-1;
    
    private class MyMouseListener implements MouseListener {
    	public void mouseClicked(MouseEvent e){
            
            int xloc = e.getX()/CELLSIZE;
            int yloc = e.getY()/CELLSIZE;
            selectedx=xloc;
            selectedy=yloc;
            if(pop!=null) pop.dispose();
            if (cell[xloc][yloc]==0) 
               pop = new PopUpDialog(xloc,yloc);
            else selectedx=selectedy=-1;
            repaint();
        }

        public void mouseEntered(MouseEvent arg0) {}
        public void mouseExited(MouseEvent arg0) {}
        public void mousePressed(MouseEvent arg0) {}
        public void mouseReleased(MouseEvent arg0) {}	
    }
	
	public SudokuBoard(SudokuGame g, SudokuMatrix matrix){
		this.setSize(9*CELLSIZE, 9*CELLSIZE);
        this.frame = g;
		this.matrix = matrix;
		initializeCells();
		
		addMouseListener(new MyMouseListener());

	}
	
	private void initializeCells() {
		remainsToFill=0;
		for (int i=0; i<9; i++)
			for (int j=0; j<9; j++) {
				if (matrix.isGiven(i, j)) 
					cell[i][j]=matrix.getPuzzle(i, j);
				else {
					cell[i][j]=0;
					remainsToFill++;
				}
			}
		updateStatus();
	}
	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3));
		g2.setFont(new Font("TimesRoman",Font.PLAIN,30));
		for(int i=0; i<3;i++){
			for(int j=0; j<3;j++){	
				g2.setColor(Color.BLACK);
				g2.drawRect(i*CELLSIZE*3, j*CELLSIZE*3, CELLSIZE*3, CELLSIZE*3);
			}
		}
		g2.setStroke(new BasicStroke(1));
		for(int i=0; i<9;i++)
			for (int j=0; j<9; j++) {
				if(i==selectedx && j== selectedy){
					g2.setColor(Color.GREEN);
					g2.fillRect(i*CELLSIZE, j*CELLSIZE, CELLSIZE, CELLSIZE);
					g2.setColor(Color.BLACK);
				}
				g2.drawRect(i*CELLSIZE, j*CELLSIZE, CELLSIZE, CELLSIZE);
				if(matrix.isGiven(i,j)) g2.setColor(Color.BLUE);
                String value="";		
				if (cell[i][j]!=0) value=value+cell[i][j];
				g2.drawString(value, i*CELLSIZE+15, j*CELLSIZE+35);
				g2.setColor(Color.BLACK);
		}
		 
	}
	
	public void actionPerformed( ActionEvent e ) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Restart")){
				initializeCells();
		}
        repaint();
	}
	
	private void updateStatus(){
		if (this.remainsToFill == 0)
			frame.setStatus("Solved!");
		else
		    frame.setStatus("Remain:"+ this.remainsToFill);
	}

	public void setCell(int i, int j, int val){
		
		if (cell[i][j]==0) {
			if (matrix.getSolution(i, j)==val) {
				cell[i][j]=val;
				remainsToFill--;
				updateStatus();	
				repaint();
			}
			else frame.setStatus("Error!");
		}
		
		pop.dispose();
		selectedx=-1;
		selectedy=-1;
		repaint();
			
	}
	
	private void gameOver() {
		System.out.println("Error completing cell!");
		//System.exit(0);
	}

	public void cancel(){
		pop.dispose();
        selectedx=-1;
        selectedy=-1;
        repaint();
	}

	private class PopUpDialog extends Frame{

		Button ok = new Button("Enter");
		Button cancel = new Button("Cancel");
		TextField tf1 = new TextField("",50);
		
        int posi;
        int posj;
		
		public PopUpDialog(int i, int j){
			super("Enter New Value");
			setBackground( Color.WHITE);
			posi=i;
			posj=j;

			cancel.addActionListener(new ActionListener(){
				public void actionPerformed( ActionEvent e ) {
					cancel();
				}	
			});

			ok.addActionListener(new ActionListener(){
				public void actionPerformed( ActionEvent e ) {
					String s = tf1.getText();
					Integer v = Integer.parseInt(s);
                    if(v>0 && v<=9) setCell(posi,posj,v);
					else cancel();
				}	
			});

			Panel p = new Panel();
			p.add(ok);
			p.add(cancel);
			add(tf1,BorderLayout.NORTH);
			add(p, BorderLayout.SOUTH);
			pack();
			this.setVisible(true);
		}
		
	}
	
}

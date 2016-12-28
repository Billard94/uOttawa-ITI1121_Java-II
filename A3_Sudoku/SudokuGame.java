import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
public class SudokuGame extends Frame {

	private Button restart = new Button("Restart");
	private SudokuBoard sudokuBoard;
    private Label status = new Label("Start");
    
	public SudokuGame(SudokuMatrix puzzle){
		super("SUDOKU");
		setBackground( Color.WHITE);
        sudokuBoard = new SudokuBoard(this,puzzle);
		this.add(sudokuBoard, BorderLayout.CENTER);
		addWindowListener(new MyWindowAdapter());
		
		Panel p = new Panel();
		p.add(restart);
        p.add(status);
		
		add(p, BorderLayout.SOUTH);
		
		restart.addActionListener(sudokuBoard);
		pack();
		this.setVisible(true);
	}
    
    public void setStatus(String s){
        status.setText(s);
    }
	

	//public static void main(String[] args){
	//	SudokuGame g = new SudokuGame();
	//}
}

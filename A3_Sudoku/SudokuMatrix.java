
public interface SudokuMatrix {
 
 /**
  * @param i is a row index 
  * @param j is a column index
  * @return "given" at position i,j of the Sudoku puzzle or -1 if it is an empty cell
  */
 public int getPuzzle(int i, int j);
 
 /**
  * @param i is a row index
  * @param j is a column index
  * @return true if position i,j contains a "given" and false otherwise
  */
 public boolean isGiven(int i, int j);

 /**
  * @param i is a row index 
  * @param j is a column index
  * @return the number that must be at position i,j in the Sudoku puzzle final solution
  */
 public int getSolution(int i, int j);
}

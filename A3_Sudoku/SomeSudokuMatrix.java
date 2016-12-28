
public class SomeSudokuMatrix implements SudokuMatrix {
 
 private static int[][] veryEasyGivens= {
  {-1,5,-1,1,2,6,8,7,9},{9,6,7,5,8,3,4,1,2},{8,1,2,4,9,7,6,5,3},
  {2,4,3,7,6,9,1,8,5},{5,7,8,3,4,1,2,9,6},{6,9,1,2,5,8,3,4,7},
  {1,3,5,8,7,2,9,6,4},{7,2,9,6,1,4,5,3,8},{4,8,6,9,-1,5,-1,2,-1}
 };
 
 private static int[][] veryEasySolution= {
  {3,5,4,1,2,6,8,7,9},{9,6,7,5,8,3,4,1,2},{8,1,2,4,9,7,6,5,3},
  {2,4,3,7,6,9,1,8,5},{5,7,8,3,4,1,2,9,6},{6,9,1,2,5,8,3,4,7},
  {1,3,5,8,7,2,9,6,4},{7,2,9,6,1,4,5,3,8},{4,8,6,9,3,5,7,2,1}
 };
 
 private static int[][] easyGivens= {
  {-1,5,-1,1,-1,6,8,-1,-1},{9,-1,-1,5,8,-1,4,-1,2},{8,-1,2,-1,-1,7,-1,5,-1},
  {2,4,3,-1,6,-1,-1,-1,-1},{-1,-1,-1,3,-1,1,-1,-1,-1},{-1,-1,-1,-1,5,-1,3,4,7},
  {-1,3,-1,8,-1,-1,9,-1,4},{7,-1,9,-1,1,4,-1,-1,8},{-1,-1,6,9,-1,5,-1,2,-1}
 };
 
 private static int[][] easySolution= {
  {3,5,4,1,2,6,8,7,9},{9,6,7,5,8,3,4,1,2},{8,1,2,4,9,7,6,5,3},
  {2,4,3,7,6,9,1,8,5},{5,7,8,3,4,1,2,9,6},{6,9,1,2,5,8,3,4,7},
  {1,3,5,8,7,2,9,6,4},{7,2,9,6,1,4,5,3,8},{4,8,6,9,3,5,7,2,1}
 };
 
 private static int[][] easyGivensB= {
  {6,-1,-1,-1,5,-1,2,-1,-1}, {-1,1,-1,2,-1,3,5,7,-1}, {-1,-1,8,-1,-1,-1,1,-1,9},
  {5,-1,-1,3,2,-1,-1,8,-1}, {9,-1,1,-1,4,-1,6,-1,3}, {-1,7,-1,-1,1,5,-1,-1,4},
  {7,-1,5,-1,-1,-1,8,-1,-1}, {-1,6,2,1,-1,8,-1,9,-1}, {-1,-1,4,-1,9,-1,-1,-1,7}
 };
 
 private static int[][] easySolutionB= {
  {6,3,7,9,5,1,2,4,8}, {4,1,9,2,8,3,5,7,6}, {2,5,8,7,6,4,1,3,9},
  {5,4,6,3,2,9,7,8,1}, {9,2,1,8,4,7,6,5,3}, {8,7,3,6,1,5,9,2,4},
  {7,9,5,4,3,6,8,1,2}, {3,6,2,1,7,8,4,9,5}, {1,8,4,5,9,2,3,6,7}
 };

 private static int[][] mediumGivens= { 
  {-1,-1,3,-1,9,-1,-1,7,8}, {-1,5,-1,8,-1,2,-1,-1,-1}, {-1,-1,9,7,-1,-1,-1,-1,6},
  {2,9,-1,-1,8,-1,-1,-1,-1}, {7,-1,-1,5,-1,9,-1,-1,1}, {-1,-1,-1,-1,6,-1,-1,3,5},
  {3,-1,-1,-1,-1,4,1,-1,-1}, {-1,-1,-1,3,-1,1,-1,9,-1}, {9,4,-1,-1,2,-1,7,-1,-1}
 };
 
 private static int[][] mediumSolution= { 
  {1,2,3,4,9,6,5,7,8}, {6,5,7,8,3,2,4,1,9}, {4,8,9,7,1,5,3,2,6},
  {2,9,5,1,8,3,6,4,7}, {7,3,6,5,4,9,2,8,1}, {8,1,4,2,6,7,9,3,5},
  {3,7,8,9,5,4,1,6,2}, {5,6,2,3,7,1,8,9,4}, {9,4,1,6,2,8,7,5,3}
 };
 
 private int [][] givens;
 
 private int [][] solution;
 

 public SomeSudokuMatrix() {
  this(1);
  
 }
 
 public SomeSudokuMatrix(int i) { 
  // constructors selects one of 4 puzzles
  switch (i) {
  case 1: givens=veryEasyGivens; //only 5 positions to fill
    solution=veryEasySolution;
    break;
     case 2: givens=easyGivens; // realistic easy puzzle (same as above but more positions to fill)
       solution=easySolution;
       break;
     case 3: givens=easyGivensB; // realistic easy puzzle
    solution=easySolutionB;
    break;
     case 4: givens=mediumGivens; // realistic medium puzzle
    solution=mediumSolution;
    break;
     default: givens=veryEasyGivens; // default is the same as 1
     solution=veryEasySolution;
     break;
      
  }
  
 }
 
 public int getPuzzle(int i, int j) {
  // precondition: 0<=i<9, 0<=j<9
  return givens[i][j];
 }
 
 public boolean isGiven(int i, int j) {
  // precondition: 0<=i<9, 0<=j<9
  return (givens[i][j]!=-1);
 }
 
 public int getSolution(int i, int j) {
  // precondition: 0<=i<9, 0<=j<9
  return solution[i][j];
 }
 
}

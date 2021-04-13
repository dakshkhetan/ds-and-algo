/*

Sample Input
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0

Sample Output
3 1 6 5 7 8 4 9 2 
5 2 9 1 3 4 7 6 8 
4 8 7 6 2 9 5 3 1 
2 6 3 4 1 5 9 8 7 
9 7 4 8 6 3 1 2 5 
8 5 1 7 9 2 6 4 3 
1 3 8 9 4 7 2 5 6 
6 9 2 3 5 1 8 7 4 
7 4 5 2 8 6 3 1 9 

*/

import java.util.*;

public class Main {

  public static void solveSudoku(int[][] board) {
    solveSudoku(board, 0, 0);
  }

  private static void solveSudoku(int[][] board, int i, int j) {

    // base case
    if (i == 9) {
      displaySudoku(board);
      return;
    }

    // calculate co-ordinates of next cell
    int nextI, nextJ;

    // if we have reached the last cell of current row
    // then, shift to first cell of next row
    if (j == 8) {
      nextI = i + 1;
      nextJ = 0;
    } else {
      nextI = i;
      nextJ = j + 1;
    }

    // check for the cells to be filled in sudoku

    if (board[i][j] != 0) { // cell is filled
      solveSudoku(board, nextI, nextJ);

    } else { // blank cell

      // check for all possible options i.e. numbers 1 to 9
      for (int n = 1; n <= 9; n++) {
        if (isValid(board, i, j, n)) {
          // assign option to current cell
          board[i][j] = n;

          // call recursion on next cell
          solveSudoku(board, nextI, nextJ);

          // on backtracking, remove the assigned option
          board[i][j] = 0;
        }
      }
    }

  }

  private static boolean isValid(int[][] board, int row, int col, int num) {

    // check if 'num' is already present in corresponding row
    for (int j = 0; j < 9; j++) {
      if (board[row][j] == num) {
        return false;
      }
    }

    // check if 'num' is already present in corresponding column
    for (int i = 0; i < 9; i++) {
      if (board[i][col] == num) {
        return false;
      }
    }

    // check if 'num' is already present inside corresponding sub-matrix

    int matrixStartX = (row / 3) * 3; // important
    int matrixStartY = (col / 3) * 3; // (refer video for explanation)

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[matrixStartX + i][matrixStartY + j] == num) {
          return false;
        }
      }
    }

    // option 'num' is valid for current cell i.e. board[row][col]
    return true;

  }

  private static void displaySudoku(int[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int board[][] = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        board[i][j] = s.nextInt();
      }
    }

    solveSudoku(board);
  }

}

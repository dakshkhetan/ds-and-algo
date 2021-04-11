/*

Reference Video - https://youtu.be/yvt0emtFiIE

Sample Input
4

Sample Output
0-1, 1-3, 2-0, 3-2, .
0-2, 1-0, 2-3, 3-1, .

*/

import java.util.*;

public class Main {

  public static void printNQueens(int n) {

    // boolean board[][] = new boolean[n][n];

    // Note: we don't need board[][] to mark queen's presence since,
    // it will be handled by 'branch and bound' technique using
    // columns and the two diagonals array

    boolean columns[] = new boolean[n];

    // Important: number of diagonals in a square matrix = 2*n - 1
    boolean normalDiagonals[] = new boolean[2 * n - 1]; // descending diagonals (\)
    boolean reversedDiagonals[] = new boolean[2 * n - 1]; // ascending diagonals (/)

    // using Branch and Bound technique
    printNQueens(0, "", columns, normalDiagonals, reversedDiagonals);

  }

  private static void printNQueens(int row, String result, boolean[] columns, boolean[] normalDiagonals,
      boolean[] reversedDiagonals) {

    int boardSize = columns.length; // n

    // base case
    if (row == boardSize) {
      System.out.println(result + ".");
      return;
    }

    // traverse each cell column-wise and call recursion for row-wise
    for (int col = 0; col < boardSize; col++) {

      // check if the cell is safe i.e. it is not blocked by any existing queens
      // refer video for clarification
      if (!columns[col] && !normalDiagonals[row + col] && !reversedDiagonals[row - col + boardSize - 1]) {

        // now, queen is safe to be placed at current cell
        // hence, block the current column and both diagonals
        columns[col] = true;
        normalDiagonals[row + col] = true;
        reversedDiagonals[row - col + boardSize - 1] = true;

        printNQueens(row + 1, result + (row + "-" + col + ", "), columns, normalDiagonals, reversedDiagonals);

        // after backtracking, unblock the current column and both diagonals
        columns[col] = false;
        normalDiagonals[row + col] = false;
        reversedDiagonals[row - col + boardSize - 1] = false;
      }
    }

  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    printNQueens(n);
  }

}

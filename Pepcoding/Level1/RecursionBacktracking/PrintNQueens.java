/*

Sample Input
4

Sample Output
0-1, 1-3, 2-0, 3-2, .
0-2, 1-0, 2-3, 3-1, .

*/

import java.util.*;

public class Main {

  public static void printNQueens(int[][] chess, int row, String result) {
    if (row == chess.length) {
      System.out.println(result + ".");
      return;
    }

    for (int col = 0; col < chess.length; col++) {
      if (chess[row][col] == 0 && isQueenSafe(chess, row, col)) {
        chess[row][col] = 1;
        printNQueens(chess, row + 1, result + (row + "-" + col + ", "));
        chess[row][col] = 0;
      }
    }
  }

  public static boolean isQueenSafe(int[][] chess, int row, int col) {
    // check upward/forward path
    for (int i = row - 1, j = col; i >= 0; i--) {
      if (chess[i][] == 1) {
        return false;
      }
    }

    // check upper-left diagonal path
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (chess[i][j] == 1) {
        return false;
      }
    }

    // check upper-right diagonal path
    for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
      if (chess[i][j] == 1) {
        return false;
      }
    }

    // check left path
    for (int i = row, j = col - 1; j >= 0; j--) {
      if (chess[i][j] == 1) {
        return false;
      }
    }

    // no need to check path to the right & paths lying downwards (top-down approach)

    return true;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    int chess[][] = new int[n][n];

    printNQueens(chess, 0, "");
  }

}

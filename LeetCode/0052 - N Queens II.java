/*

Reference Video - https://youtu.be/yvt0emtFiIE

Sample Input:
n = 4

Sample Output:
2

*/

class Solution {

  // Time Complexity: O(N!)
  // Space Complexity: O(N)

  // Explanation: There is N possibilities to put the first queen,
  // not more than N(N - 2) to put the second one, not more than
  // N(N - 2)(N - 4) for the third one etc...
  // Hence, this result in N! possibilities to place queens.

  int count = 0;

  public int totalNQueens(int n) {

    // using 'Branch and Bound' technique

    // boolean board[][] = new boolean[n][n];

    // Note: we don't need board[][] to mark queen's presence since,
    // it will be handled by 'branch and bound' technique using
    // columns and the two diagonals array

    boolean columns[] = new boolean[n];

    // Important: number of diagonals in a square matrix = 2*n - 1
    boolean normalDiagonals[] = new boolean[2 * n - 1]; // descending diagonals (\)
    boolean reversedDiagonals[] = new boolean[2 * n - 1]; // ascending diagonals (/)

    backtrack(0, columns, normalDiagonals, reversedDiagonals);

    return count;

  }

  private void backtrack(int row, boolean[] columns, boolean[] normalDiagonals, boolean[] reversedDiagonals) {

    int boardSize = columns.length; // n

    // base case
    if (row == boardSize) {
      count++;
      return;
    }

    // traverse each cell column-wise and call recursion for row-wise
    for (int col = 0; col < boardSize; col++) {

      // check if the cell is safe i.e. it is not blocked by any existing queens
      // (refer video for clarification)
      if (!columns[col] && !normalDiagonals[row + col] && !reversedDiagonals[row - col + boardSize - 1]) {

        // queen is safe to be placed at current cell

        // now, block the current column and both diagonals
        columns[col] = true;
        normalDiagonals[row + col] = true;
        reversedDiagonals[row - col + boardSize - 1] = true;

        // call recursion on next row
        backtrack(row + 1, columns, normalDiagonals, reversedDiagonals);

        // on backtracking, unblock the current column and both diagonals
        columns[col] = false;
        normalDiagonals[row + col] = false;
        reversedDiagonals[row - col + boardSize - 1] = false;
      }
    }

  }

}

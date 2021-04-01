/*

Reference Video - https://youtu.be/yvt0emtFiIE

Sample Input:
n = 4

Sample Output:
[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]

*/

class Solution {

  // Time Complexity: O(N! * N)
  // Space Complexity: O(N + (N! * N))

  // Explanation: There is N possibilities to put the first queen,
  // not more than N(N - 2) to put the second one, not more than
  // N(N - 2)(N - 4) for the third one etc...
  // Hence, this result in N! possibilities to place queens.

  public List<List<String>> solveNQueens(int n) {

    // using 'Branch and Bound' technique

    List<List<String>> result = new ArrayList<>();

    // boolean board[][] = new boolean[n][n];

    // Note: we don't need board[][] to mark queen's presence since,
    // it will be handled by 'branch and bound' technique using
    // columns and the two diagonals array

    boolean columns[] = new boolean[n];

    // Important: number of diagonals in a square matrix = 2*n - 1
    boolean normalDiagonals[] = new boolean[2 * n - 1]; // descending diagonals (\)
    boolean reversedDiagonals[] = new boolean[2 * n - 1]; // ascending diagonals (/)

    backtrack(0, result, new ArrayList<>(), columns, normalDiagonals, reversedDiagonals);

    return result;

  }

  private void backtrack(int row, List<List<String>> result, List<String> currentRowResult, boolean[] columns,
      boolean[] normalDiagonals, boolean[] reversedDiagonals) {

    int boardSize = columns.length; // n

    // base case
    if (row == boardSize) {
      result.add(new ArrayList<>(currentRowResult));
      return;
    }

    // traverse each cell column-wise and call recursion for row-wise
    for (int col = 0; col < boardSize; col++) {

      // check if the cell is safe i.e. it is not blocked by any existing queens
      // refer video for clarification
      if (!columns[col] && !normalDiagonals[row + col] && !reversedDiagonals[row - col + boardSize - 1]) {

        // queen is safe to be placed at current cell

        // generate result for the current row as question requires (like "..Q.")
        char[] res = new char[boardSize];
        Arrays.fill(res, '.');
        res[col] = 'Q';

        // add the current result string to 'currentRowResult' list
        currentRowResult.add(new String(res));

        // now, block the current column and both diagonals
        columns[col] = true;
        normalDiagonals[row + col] = true;
        reversedDiagonals[row - col + boardSize - 1] = true;

        // call recursion on next row
        backtrack(row + 1, result, currentRowResult, columns, normalDiagonals, reversedDiagonals);

        // on backtracking, unblock the current column and both diagonals
        // and remove the current row result from 'currentRowResult' list

        columns[col] = false;
        normalDiagonals[row + col] = false;
        reversedDiagonals[row - col + boardSize - 1] = false;

        currentRowResult.remove(currentRowResult.size() - 1);
      }
    }

  }

}

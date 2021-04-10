/*

Sample Input:
[ ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"] ]

Sample Output:
[ ["5","3","4","6","7","8","9","1","2"],
  ["6","7","2","1","9","5","3","4","8"],
  ["1","9","8","3","4","2","5","6","7"],
  ["8","5","9","7","6","1","4","2","3"],
  ["4","2","6","8","5","3","7","9","1"],
  ["7","1","3","9","2","4","8","5","6"],
  ["9","6","1","5","3","7","2","8","4"],
  ["2","8","7","4","1","9","6","3","5"],
  ["3","4","5","2","8","6","1","7","9"] ]

Note: The input board has only ONE solution.

*/

class Solution {

  public void solveSudoku(char[][] board) {
    // we have to make changes in the given 'board[][]'
    solveSudoku(board, 0, 0);
  }

  private boolean solveSudoku(char[][] board, int i, int j) {

    // base case
    if (i == 9) {
      return true;
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

    if (board[i][j] != '.') { // cell is filled
      return solveSudoku(board, nextI, nextJ);

    } else { // blank cell

      // check for all possible options i.e. numbers 1 to 9
      for (char n = '1'; n <= '9'; n++) {
        if (isValid(board, i, j, n)) {
          // assign option to current cell
          board[i][j] = n;

          // call recursion on next cell
          boolean solved = solveSudoku(board, nextI, nextJ);

          // if on backtracking, sudoku is solved i.e. it returns 'true'
          // then, don't remove the assigned option & return true
          // since there is only one correct solution, so we don't need
          // to reset on backtracking (after every recursion call)
          if (solved) {
            return true;
          }

          // on backtracking, remove the assigned option
          board[i][j] = '.';
        }
      }
    }

    return false;

  }

  private boolean isValid(char[][] board, int row, int col, char num) {

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

}

/* 

Sample Input:
[[0,6,0],
 [5,8,7],
 [0,9,0]]

Sample Output:
24

Explanation:
Path to get the maximum gold, 9 -> 8 -> 7.

*/

class Solution {

  public int getMaximumGold(int[][] arr) {

    int rows = arr.length;
    int cols = arr[0].length;

    int maxGoldPathSum = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (arr[i][j] != 0) {
          int currentGoldPathSum = helper(arr, i, j);
          maxGoldPathSum = Math.max(currentGoldPathSum, maxGoldPathSum);
        }
      }
    }

    return maxGoldPathSum;

  }

  private int helper(int[][] arr, int row, int col) {

    if (row < 0 || col < 0 || row >= arr.length || col >= arr[0].length) {
      return 0;
    }

    if (arr[row][col] == 0) {
      return 0;
    }

    int goldAmount = arr[row][col];

    // mark visited i.e. empty the gold from current cell
    // we can also a boolean 'visited' array
    // but it'll increase space complexity
    arr[row][col] = 0;

    int collectUp = helper(arr, row - 1, col);
    int collectRight = helper(arr, row, col + 1);
    int collectDown = helper(arr, row + 1, col);
    int collectLeft = helper(arr, row, col - 1);

    // on backtracking, mark unvisited i.e. restore the current cell gold amount
    arr[row][col] = goldAmount;

    // now, return the sum of current cell's gold amount and the
    // adjacent cell whose gold amount is maximum from all 4 directions

    return goldAmount + maxOf(collectUp, collectRight, collectDown, collectLeft);

  }

  private int maxOf(int value1, int value2, int value3, int value4) {
    return Math.max(value1, Math.max(value2, Math.max(value3, value4)));
  }

}

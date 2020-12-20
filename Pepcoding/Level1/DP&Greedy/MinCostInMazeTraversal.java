/*

Sample Input
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1

Sample Output
23

*/

import java.util.*;

public class Main {

  public static int minCostInMazeTraversal(int[][] arr) {
    int n = arr.length; // rows
    int m = arr[0].length; // columns
    int dp[][] = new int[n][m];

    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        if (i == n - 1 && j == m - 1) { // destination
          dp[i][j] = arr[i][j];
        } else if (i == n - 1) { // last row
          dp[i][j] = arr[i][j] + dp[i][j + 1];
        } else if (j == m - 1) { // last column
          dp[i][j] = arr[i][j] + dp[i + 1][j];
        } else {
          dp[i][j] = arr[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
        }
      }
    }

    return dp[0][0];
  }

  public static int minCostInMazeTraversal2(int[][] arr) {
    int n = arr.length;
    int m = arr[0].length;
    int dp[][] = new int[n][m];

    // last row
    for (int j = m - 1; j >= 0; j--) {
      if (j + 1 == m) {
        dp[n - 1][j] = arr[n - 1][j];
      } else {
        dp[n - 1][j] = arr[n - 1][j] + dp[n - 1][j + 1];
      }
    }

    // last column
    for (int i = n - 1; i >= 0; i--) {
      if (i + 1 == n) {
        dp[i][m - 1] = arr[i][m - 1];
      } else {
        dp[i][m - 1] = arr[i][m - 1] + dp[i + 1][m - 1];
      }
    }

    for (int i = n - 2; i >= 0; i--) {
      for (int j = m - 2; j >= 0; j--) {
        dp[i][j] = arr[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
      }
    }

    return dp[0][0];
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int m = s.nextInt();

    int arr[][] = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = s.nextInt();
      }
    }

    int result = minCostInMazeTraversal(arr);
    // int result = minCostInMazeTraversal2(arr);
    System.out.println(result);
  }

}

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
33

*/

import java.util.*;

public class Main {

  public static int goldmine(int[][] arr) {
    int n = arr.length; // rows
    int m = arr[0].length; // columns
    int dp[][] = new int[n][m];

    for (int j = m - 1; j >= 0; j--) {
      for (int i = n - 1; i >= 0; i--) {
        if (j == m - 1) {
          dp[i][j] = arr[i][j];
        } else if (i == n - 1) {
          dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j + 1], dp[i][j + 1]);
        } else if (i == 0) {
          dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
        } else {
          dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j + 1], Math.max(dp[i][j + 1], dp[i + 1][j + 1]));
        }
      }
    }

    int max = dp[0][0];
    for (int i = 0; i < n; i++) {
      max = Math.max(dp[i][0], max);
    }

    return max;
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

    int result = goldmine(arr);
    System.out.println(result);
  }

}

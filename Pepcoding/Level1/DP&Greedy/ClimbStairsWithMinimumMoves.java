/*

Sample Input
10
3
3
0
2
1
2
4
2
0
0

Sample Output
4

*/

import java.util.*;

public class Main {

  public static int climbStairsWithMinimumMoves(int[] arr, int n) {
    Integer dp[] = new Integer[n + 1]; // fills NULL by default (instead of 0)

    // base case
    dp[n] = 0;

    for (int i = n - 1; i >= 0; i--) {
      int min = Integer.MAX_VALUE;

      for (int j = 1; (j <= arr[i]) && (i + j < dp.length); j++) {
        if (dp[i + j] != null) {
          min = Math.min(dp[i + j], min);
        }
      }

      if (min != Integer.MAX_VALUE) {
        dp[i] = min + 1;
      }
    }

    return dp[0];
  }

  public static int climbStairsWithMinimumMoves2(int[] arr, int n) {
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);

    // base case
    dp[n] = 0;

    for (int i = n - 1; i >= 0; i--) {
      int min = Integer.MAX_VALUE;

      for (int j = 1; (j <= arr[i]) && (i + j < dp.length); j++) {
        if (dp[i + j] != -1) {
          min = Math.min(dp[i + j], min);
        }
      }

      if (min != Integer.MAX_VALUE) {
        dp[i] = min + 1;
      }
    }

    return dp[0];
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int result = climbStairsWithMinimumMoves(arr, n);
    // int result = climbStairsWithMinimumMoves2(arr, n);
    System.out.println(result);
  }

}

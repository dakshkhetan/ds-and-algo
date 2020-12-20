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
5

*/

import java.util.*;

public class Main {

  public static int climbStairsWithVariableJumps(int[] arr, int n) {
    int dp[] = new int[n + 1];

    // base case
    dp[n] = 1;

    // bottom-up approach
    for (int i = n - 1; i >= 0; i--) {
      for (int j = 1; (j <= arr[i]) && (i + j < dp.length); j++) {
        dp[i] += dp[i + j];
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

    int result = climbStairsWithVariableJumps(arr, n);
    System.out.println(result);
  }

}

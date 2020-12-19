/*

Sample Input
4

Sample Output
7

*/

import java.util.*;

public class Main {

  public static int climbStairs1(int n) {
    int dp[] = new int[n + 1];

    // providing answers to only 3 sub-problems
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }

    return dp[n];
  }

  public static int climbStairs2(int n) {
    int dp[] = new int[n + 1];

    // providing answers to only 1 sub-problem
    dp[0] = 1;

    for (int i = 1; i <= n; i++) {
      if (i >= 1) {
        dp[i] += dp[i - 1];
      }

      if (i >= 2) {
        dp[i] += dp[i - 2];
      }

      if (i >= 3) {
        dp[i] += dp[i - 3];
      }
    }

    return dp[n];
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    // int result = climbStairs1(n);
    int result = climbStairs2(n);
    System.out.println(result);

  }

}

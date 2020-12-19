/*

Sample Input
10

Sample Output
55

*/

import java.util.*;

public class Main {

  public static int fibonacciDP(int n) {
    int dp[] = new int[n + 1];

    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;

    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    int result = fibonacciDP(n);
    System.out.println(result);

  }

}

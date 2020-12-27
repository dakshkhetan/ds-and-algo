/*

Sample Input
4

Sample Output
10

*/

import java.util.*;

public class Main {

  public static int friendsPairing(int n) {
    // n = number of friends

    int dp[] = new int[n + 1];

    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) { // i = friendIndex
      int staySingleOption = dp[i - 1];
      int pairUpOption = dp[i - 2] * (i - 1);
      dp[i] = staySingleOption + pairUpOption;
    }

    return dp[n];
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();

    int result = friendsPairing(n);
    System.out.println(result);
  }

}

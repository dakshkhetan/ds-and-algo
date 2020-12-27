/*

Sample Input
39
16

Sample Output
61

*/

import java.util.*;

public class Main {

  public static int tilingWithMX1Tiles(int n, int m) {
    // length of floor = n metre
    // width of floor = m metre

    int dp[] = new int[n + 1];

    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {  // i = lengthOfFloor
      if (i < m) {
        dp[i] = 1;
      } else if (i == m) {
        dp[i] = 2;
      } else {
        dp[i] = dp[i - 1] + dp[i - m];
      }
    }

    return dp[n];
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int m = s.nextInt();

    int result = tilingWithMX1Tiles(n, m);
    System.out.println(result);
  }

}

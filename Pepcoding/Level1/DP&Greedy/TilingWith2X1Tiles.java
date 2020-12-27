/*

Sample Input 1:
3

Sample Output 1:
3


Sample Input 2:
8

Sample Output 2:
34

*/

import java.util.*;

public class Main {

  public static int tilingWith2X1Tiles(int n) {
    // length of floor = n metre
    // width of floor = 2 metre

    int dp[] = new int[n + 1];

    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();

    int result = tilingWith2X1Tiles(n);
    System.out.println(result);
  }

}

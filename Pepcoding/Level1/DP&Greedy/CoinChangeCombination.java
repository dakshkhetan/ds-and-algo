/*

Sample Input
4
2
3
5
6
7

Sample Output
2

*/

import java.util.*;

public class Main {

  public static int coinChangeCombination(int[] coins, int amount) {
    int n = coins.length;
    int dp[] = new int[amount + 1];

    dp[0] = 1;

    for (int i = 0; i < n; i++) {
      for (int j = coins[i]; j <= amount; j++) {
        dp[j] += dp[j - coins[i]];
      }
    }

    // for (int i = 0; i < n; i++) {
    //   int coin = coins[i];
    //   for (int j = 1; j <= amount; j++) {
    //     if (j >= coin) {
    //       dp[j] += dp[j - coin];
    //     }
    //   }
    // }

    return dp[amount];
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();

    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int amount = s.nextInt();

    int result = coinChangeCombination(arr, amount);
    System.out.println(result);
  }

}

/*

Sample Input
4
2
3
5
6
7

Sample Output
5

*/

import java.util.*;

public class Main {

  public static int coinChangePermutations(int[] coins, int amount) {
    int dp[] = new int[amount + 1];

    dp[0] = 1;

    for (int i = 1; i <= amount; i++) { // i = currentAmount
      for (int j = 0; j < coins.length; j++) { // j = index (coins)
        int currentAmount = i;
        int remainingAmount = currentAmount - coins[j];
        if (remainingAmount >= 0) {
          dp[i] += dp[remainingAmount];
        }
      }
    }

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

    int result = coinChangePermutations(arr, amount);
    System.out.println(result);
  }

}

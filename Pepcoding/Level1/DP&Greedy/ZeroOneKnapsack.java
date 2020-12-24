/*

Sample Input
5
15 14 10 45 30
2 5 1 3 4
7

Sample Output
75

*/

import java.util.*;

public class Main {

  public static int ZeroOneKnapsack(int n, int[] values, int[] weights, int capacity) {
    int dp[][] = new int[n + 1][capacity + 1];

    for (int i = 0; i <= n; i++) { // i - 1 = itemIndex
      for (int j = 0; j <= capacity; j++) { // j = currentBagCapacity
        if (i == 0 || j == 0) {
          dp[i][j] = 0; // base case
        } else {
          if (weights[i - 1] > j) {
            dp[i][j] = dp[i - 1][j];
          } else {
            // include current item
            int remainingCapacity = j - weights[i - 1];
            int option1 = values[i - 1] + dp[i - 1][remainingCapacity];

            // not include current item
            int option2 = dp[i - 1][j];

            dp[i][j] = Math.max(option1, option2);
          }
        }
      }
    }

    return dp[n][capacity];
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();

    int values[] = new int[n];
    for (int i = 0; i < n; i++) {
      values[i] = s.nextInt();
    }

    int weights[] = new int[n];
    for (int i = 0; i < n; i++) {
      weights[i] = s.nextInt();
    }

    int capacity = s.nextInt();

    int result = ZeroOneKnapsack(n, values, weights, capacity);
    System.out.println(result);
  }

}

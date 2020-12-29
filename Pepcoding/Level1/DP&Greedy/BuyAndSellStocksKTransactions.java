/*

Sample Input
6
9
6
7
6
3
8
1

Sample Output
5

*/

import java.util.*;

public class Main {

  // O(k*n)
  public static int buyAndSellStocksKTransactionsOptimised(int[] prices, int k) {
    int n = prices.length;

    int dp[][] = new int[k + 1][n];

    for (int i = 0; i <= k; i++) { // i = transactionIndex
      int maxProfit = Integer.MIN_VALUE;

      for (int j = 0; j < n; j++) { // j = dayIndex
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else {
          maxProfit = Math.max(dp[i - 1][j - 1] - prices[j - 1], maxProfit);

          int option1 = dp[i][j - 1];
          int option2 = maxProfit + prices[j];

          dp[i][j] = Math.max(option1, option2);
        }
      }
    }

    return dp[k][n - 1];
  }

  // O(k*n*n)
  public static int buyAndSellStocksKTransactions(int[] prices, int k) {
    int n = prices.length;

    int dp[][] = new int[k + 1][n];

    for (int i = 0; i <= k; i++) { // i = transactionIndex
      for (int j = 0; j < n; j++) { // j = dayIndex
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else {
          int maxProfit = 0;
          for (int t = j - 1; t >= 0; t--) {
            int profitToday = prices[j] - prices[t];
            int possibleOption = dp[i - 1][t] + profitToday;
            maxProfit = Math.max(possibleOption, maxProfit);
          }

          int option1 = maxProfit;
          int option2 = dp[i][j - 1];

          dp[i][j] = Math.max(option1, option2);
        }
      }
    }

    return dp[k][n - 1];
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();

    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int k = s.nextInt();

    // int result = buyAndSellStocksKTransactions(arr, k);
    int result = buyAndSellStocksKTransactionsOptimised(arr, k);
    System.out.println(result);
  }

}

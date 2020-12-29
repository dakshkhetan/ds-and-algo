/*

Sample Input
9
11
6
7
19
4
1
6
18
4

Sample Output
30

*/

import java.util.*;

public class Main {

  public static int buyAndSellStocksTwoTransactions(int[] prices) {
    int n = prices.length;

    int maxProfitIfSoldToday = 0;
    int minPriceSoFar = prices[0];
    int maxProfitIfSoldUptoToday[] = new int[n];

    maxProfitIfSoldUptoToday[0] = 0;

    for (int i = 1; i < n; i++) {
      minPriceSoFar = Math.min(prices[i], minPriceSoFar);
      maxProfitIfSoldToday = prices[i] - minPriceSoFar;

      int option1 = maxProfitIfSoldToday;
      int option2 = maxProfitIfSoldUptoToday[i - 1];
      maxProfitIfSoldUptoToday[i] = Math.max(option1, option2);
    }

    int maxProfitIfBoughtToday = 0;
    int maxPriceSoFar = prices[n - 1];
    int maxProfitIfBoughtAfterToday[] = new int[n];

    maxProfitIfBoughtAfterToday[n - 1] = 0;

    for (int i = n - 2; i >= 0; i--) {
      maxPriceSoFar = Math.max(prices[i], maxPriceSoFar);
      maxProfitIfBoughtToday = maxPriceSoFar - prices[i];

      int option1 = maxProfitIfBoughtToday;
      int option2 = maxProfitIfBoughtAfterToday[i + 1];
      maxProfitIfBoughtAfterToday[i] = Math.max(option1, option2);
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      int firstTransactionProfit = maxProfitIfSoldUptoToday[i];
      int secondTransactionProfit = maxProfitIfBoughtAfterToday[i];
      int totalProfit = firstTransactionProfit + secondTransactionProfit;
      ans = Math.max(totalProfit, ans);
    }

    return ans;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int result = buyAndSellStocksTwoTransactions(arr);
    System.out.println(result);
  }

}

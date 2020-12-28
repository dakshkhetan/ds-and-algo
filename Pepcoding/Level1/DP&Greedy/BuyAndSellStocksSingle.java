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
17

*/

import java.util.*;

public class Main {

  public static int buyAndSellStocksSingle(int[] prices) {
    int minPriceSofar = prices[0];
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < minPriceSofar) {
        minPriceSofar = prices[i];
      }

      int profitIfSoldToday = prices[i] - minPriceSofar;

      if (profitIfSoldToday > maxProfit) {
        maxProfit = profitIfSoldToday;
      }
    }

    return maxProfit;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int result = buyAndSellStocksSingle(arr);
    System.out.println(result);
  }

}

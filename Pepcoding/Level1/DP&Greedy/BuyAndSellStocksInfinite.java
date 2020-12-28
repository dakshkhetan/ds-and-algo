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

  public static int buyAndSellStocksInfinite(int[] prices) {
    int buy = prices[0];
    int sell = prices[0];
    int profit = 0;

    for (int i = 1; i < prices.length; i++) {
      int price = prices[i];
      if (price >= sell) {
        sell = price;
      } else {
        profit += sell - buy;
        buy = sell = price;
      }
    }

    profit += sell - buy;
    return profit;
  }

  public static int buyAndSellStocksInfinite2(int[] prices) {
    int buyingDate = 0;
    int sellingDate = 0;
    int profit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] >= prices[i - 1]) {
        // sellingDate++;
        sellingDate = i;
      } else {
        profit += prices[sellingDate] - prices[buyingDate];
        buyingDate = sellingDate = i;
      }
    }

    profit += prices[sellingDate] - prices[buyingDate];
    return profit;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int result = buyAndSellStocksInfinite(arr);
    // int result = buyAndSellStocksInfinite2(arr);
    System.out.println(result);
  }

}

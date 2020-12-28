/*

Sample Input
12
10
15
17
20
16
18
22
20
22
20
23
25
3

Sample Output
13

*/

import java.util.*;

public class Main {

  public static int buyAndSellStocksTransactionFee(int[] prices, int fee) {
    // BSP - "bought" state profit
    // SSP - "sold" state profit

    int oldBSP = -prices[0];
    int oldSSP = 0;

    for (int i = 1; i < prices.length; i++) {
      int price = prices[i];

      int option1 = oldBSP;
      int option2 = oldSSP - price;
      int newBSP = Math.max(option1, option2);

      option1 = oldSSP;
      option2 = oldBSP + price - fee;
      int newSSP = Math.max(option1, option2);

      oldBSP = newBSP;
      oldSSP = newSSP;
    }

    return oldSSP;
  }

  public static int buyAndSellStocksTransactionFeeWithArray(int[] prices, int fee) {
    int n = prices.length;
    int bsp[] = new int[n]; // "bought" state profit
    int ssp[] = new int[n]; // "sold" state profit

    bsp[0] = -prices[0];
    ssp[0] = 0;

    for (int i = 1; i < n; i++) {
      int option1 = bsp[i - 1];
      int option2 = ssp[i - 1] - prices[i];
      bsp[i] = Math.max(option1, option2);

      option1 = ssp[i - 1];
      option2 = bsp[i - 1] + prices[i] - fee;
      ssp[i] = Math.max(option1, option2);
    }

    return ssp[n - 1];
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();

    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int fee = s.nextInt();

    int result = buyAndSellStocksTransactionFee(arr, fee);
    // int result = buyAndSellStocksTransactionFeeWithArray(arr, fee);
    System.out.println(result);
  }

}

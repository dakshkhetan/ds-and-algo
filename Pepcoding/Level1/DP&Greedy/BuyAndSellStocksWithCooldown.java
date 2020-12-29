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

Sample Output
19

*/

import java.util.*;

public class Main {

  public static int buyAndSellStocksWithCooldown(int[] prices) {
    // BSP - "bought" state profit
    // SSP - "sold" state profit
    // CSP - "cooldown" state profit

    int oldBSP = -prices[0];
    int oldSSP = 0;
    int oldCSP = 0;

    for (int i = 1; i < prices.length; i++) {
      int price = prices[i];

      int option1 = oldBSP;
      int option2 = oldCSP - price;
      int newBSP = Math.max(option1, option2);

      option1 = oldSSP;
      option2 = oldBSP + price;
      int newSSP = Math.max(option1, option2);

      int newCSP = oldSSP;

      oldBSP = newBSP;
      oldSSP = newSSP;
      oldCSP = newCSP;
    }

    return oldSSP;
  }

  public static int buyAndSellStocksWithCooldownWithArray(int[] prices) {
    int n = prices.length;
    int bsp[] = new int[n]; // "bought" state profit
    int ssp[] = new int[n]; // "sold" state profit
    int csp[] = new int[n]; // "cooldown" state profit

    bsp[0] = -prices[0];
    ssp[0] = 0;
    csp[0] = 0;

    for (int i = 1; i < n; i++) {
      int option1 = bsp[i - 1];
      int option2 = csp[i - 1] - prices[i];
      bsp[i] = Math.max(option1, option2);

      option1 = ssp[i - 1];
      option2 = bsp[i - 1] + prices[i];
      ssp[i] = Math.max(option1, option2);

      csp[i] = ssp[i - 1];
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

    int result = buyAndSellStocksWithCooldown(arr);
    // int result = buyAndSellStocksWithCooldownWithArray(arr);
    System.out.println(result);
  }

}

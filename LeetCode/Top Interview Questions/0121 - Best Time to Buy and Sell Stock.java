/*

Sample Input 1:
prices = [7,1,5,3,6,4]

Sample Output 1:
5

Explanation:
Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.


Sample Input 2:
prices = [7,6,4,3,1]

Sample Output 2:
0

Explanation:
In this case, no transactions are done and the max profit = 0.

*/

class Solution {

  public int maxProfit(int[] prices) {
    // return buyAndSellStocksSingleBruteForce(prices);
    return buyAndSellStocksSingleDP(prices);
  }

  // Time Complexity: O(N^2)
  // Space Complexity: O(1)
  public int buyAndSellStocksSingleBruteForce(int[] prices) {
    int n = prices.length;
    int maxProfit = 0;

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int currentProfit = prices[j] - prices[i];
        if (currentProfit > maxProfit) {
          maxProfit = currentProfit;
        }
      }
    }

    return maxProfit;
  }

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  public int buyAndSellStocksSingleDP(int[] prices) {
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

}

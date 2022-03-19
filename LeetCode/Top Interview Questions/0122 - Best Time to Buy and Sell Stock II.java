/*

Sample Input 1:
prices = [7,1,5,3,6,4]

Sample Output 1:
7

Explanation:
Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.


Sample Input 2:
prices = [7,6,4,3,1]

Sample Output 2:
0

Explanation:
There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.

*/

class Solution {

  public int maxProfit(int[] prices) {
    // return buyAndSellStocksInfiniteGreedy1(prices);
    return buyAndSellStocksInfiniteGreedy2(prices);
    // return buyAndSellStocksInfiniteDP(prices);
  }

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  // Reference Video - https://youtu.be/HWJ9kIPpzXs
  public int buyAndSellStocksInfiniteGreedy1(int[] prices) {
    int buyingPrice = prices[0];
    int sellPrice = prices[0];
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      int currentPrice = prices[i];
      if (currentPrice >= sellPrice) {
        // set the sell price to the current day's bigger price
        sellPrice = currentPrice;
      } else {
        // we found a dip, hence calculate the profit with
        // the last sell price and reset
        int profit = sellPrice - buyingPrice;
        maxProfit += profit;
        buyingPrice = sellPrice = currentPrice;
      }
    }

    // calculate the last profit
    maxProfit += (sellPrice - buyingPrice);

    return maxProfit;
  }

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  // same as above but shorter, concise and direct
  public int buyAndSellStocksInfiniteGreedy2(int[] prices) {
    // approach: keep adding the profit whenever stock price increases

    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        maxProfit += (prices[i] - prices[i - 1]);
      }
    }

    return maxProfit;
  }

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  // same as above but with a DP flavour (technique)
  public int buyAndSellStocksInfiniteDP(int[] prices) {
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      maxProfit = Math.max(maxProfit, maxProfit + (prices[i] - prices[i - 1]));
    }

    return maxProfit;
  }

}

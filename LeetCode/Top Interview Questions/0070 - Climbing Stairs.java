/*

Sample Input:
3

Sample Output:
3

Explanation:
There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:
1 <= n <= 45

*/

class Solution {

  public int climbStairs(int n) {
    // return climbStairsRecursive(n);
    // return climbStairsDP(n);
    return climbStairsDPSpaceOptimal(n);

    // NOTE: there also exists a 'Binets' method (using matrix multiplication)
    // which solves the problem with TC: O(logN) and SC: O(1)
  }

  // Time Complexity: O(2^N)
  // Space Complexity: O(N)
  public int climbStairsRecursive(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }

    if (n == 2) {
      return 2;
    }

    return climbStairs(n - 1) + climbStairs(n - 2);
  }

  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public int climbStairsDP(int n) {
    // if (n == 0 || n == 1) {
    // return 1;
    // }

    int dp[] = new int[n + 1];

    dp[0] = 1; // can skip this, since question states n >= 1

    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  public int climbStairsDPSpaceOptimal(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }

    if (n == 2) {
      return 2;
    }

    int previous = 1; // n == 1
    int current = 2; // n == 2

    for (int i = 3; i <= n; i++) {
      int sum = current + previous;
      previous = current;
      current = sum;
    }

    return current;
  }

}

/*

Sample Input
4
3

Sample Output
6

*/

import java.util.*;

public class Main {

  public static long partitionIntoSubsets(int n, int k) {
    if (n == 0 || k == 0 || n < k) {
      return 0;
    }

    long dp[][] = new long[n + 1][k + 1];

    for (int j = 0; j <= k; j++) { // j = subsetSize / teamSize
      for (int i = 0; i <= n; i++) { // i = numberOfElements / teamMembers
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (j == 1) {
          dp[i][j] = 1;
        } else if (i < j) {
          dp[i][j] = 0;
        } else if (i == j) {
          dp[i][j] = 1;
        } else {
          long option1 = dp[i - 1][j] * j; // join other teams
          long option2 = dp[i - 1][j - 1]; // make own team
          dp[i][j] = option1 + option2;
        }
      }
    }

    return dp[n][k];
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int k = s.nextInt();

    long result = partitionIntoSubsets(n, k);
    System.out.println(result);
  }

}

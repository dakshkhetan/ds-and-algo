/*

Sample Input
5
4
2
7
1
3
10

Sample Output
true

*/

import java.util.*;

public class Main {

  public static boolean targetSumSubsets(int[] arr, int target) {
    int n = arr.length;
    boolean dp[][] = new boolean[n + 1][target + 1];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= target; j++) { // j = sum
        if (i == 0 && j == 0) {
          dp[i][j] = true;
        } else if (i == 0) {
          dp[i][j] = false;
        } else if (j == 0) {
          dp[i][j] = true;
        } else {
          if (dp[i - 1][j] == true) {
            dp[i][j] = true;
          } else {
            // including current element
            int element = arr[i - 1];
            int sum = j;
            int remainingSum = sum - element;
            if (remainingSum >= 0) {
              if (dp[i - 1][remainingSum] == true) {
                dp[i][j] = true;
              }
            }
          }
        }
      }
    }

    return dp[n][target];
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();

    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int target = s.nextInt();

    boolean result = targetSumSubsets(arr, target);
    System.out.println(result);
  }

}

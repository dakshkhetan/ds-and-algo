/*

Sample Input
4 5
1 5 7 2 3
5 8 4 3 6
3 2 9 7 2
1 2 4 9 1

Sample Output
7

*/

import java.util.*;

public class Main {

  // O(n^2)
  public static int paintHouseManyColorsOptimised(int[][] arr) {
    int n = arr.length;
    int colors = arr[0].length;

    int dp[][] = new int[n][colors];

    int firstMin = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;

    for (int j = 0; j < colors; j++) {
      dp[0][j] = arr[0][j]; // filling first row

      // calculating min & second-min for first row
      if (arr[0][j] < firstMin) {
        secondMin = firstMin;
        firstMin = arr[0][j];
      } else if (arr[0][j] < secondMin) {
        secondMin = arr[0][j];
      }
    }

    for (int i = 1; i < n; i++) { // i = houseIndex
      int newFirstMin = Integer.MAX_VALUE;
      int newSecondMin = Integer.MAX_VALUE;

      for (int j = 0; j < colors; j++) { // j = colorIndex
        if (dp[i - 1][j] == firstMin) {
          dp[i][j] = secondMin + arr[i][j];
        } else {
          dp[i][j] = firstMin + arr[i][j];
        }

        // calculating min & second-min for i'th row
        if (dp[i][j] < newFirstMin) {
          newSecondMin = newFirstMin;
          newFirstMin = dp[i][j];
        } else if (dp[i][j] < newSecondMin) {
          newSecondMin = dp[i][j];
        }
      }

      firstMin = newFirstMin;
      secondMin = newSecondMin;
    }

    int minCost = firstMin;
    return minCost;
  }

  // O(n^3)
  public static int paintHouseManyColors(int[][] arr) {
    int n = arr.length;
    int colors = arr[0].length;

    int dp[][] = new int[n][colors];

    for (int j = 0; j < colors; j++) {
      dp[0][j] = arr[0][j];
    }

    for (int i = 1; i < n; i++) { // i = houseIndex
      for (int j = 0; j < colors; j++) { // j = colorIndex
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < colors; k++) { // k = colorIndex
          if (k != j) {
            min = Math.min(dp[i - 1][k], min);
          }
        }
        dp[i][j] = min + arr[i][j];
      }
    }

    int minCost = Integer.MAX_VALUE;
    for (int j = 0; j < colors; j++) {
      minCost = Math.min(dp[n - 1][j], minCost);
    }

    return minCost;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int k = s.nextInt();

    int arr[][] = new int[n][k];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k; j++) {
        arr[i][j] = s.nextInt();
      }
    }

    // int result = paintHouseManyColors(arr);
    int result = paintHouseManyColorsOptimised(arr);
    System.out.println(result);
  }

}

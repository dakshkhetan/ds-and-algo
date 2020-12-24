/*

Sample Input
5
15 14 10 45 30
2 5 1 3 4
7

Sample Output
100

*/

import java.util.*;

public class Main {

  public static int unboundedKnapsack(int n, int[] values, int[] weights, int capacity) {
    int dp[] = new int[capacity + 1];

    dp[0] = 0; // baseCase

    for (int i = 1; i <= capacity; i++) { // i = currentBagCapacity
      int max = 0;
      for (int j = 0; j < n; j++) { // j = itemIndex
        int weight = weights[j];
        int value = values[j];
        if (weight <= i) {
          int option = value + dp[i - weight];
          max = Math.max(option, max);
        }
      }
      dp[i] = max;
    }

    return dp[capacity];
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();

    int values[] = new int[n];
    for (int i = 0; i < n; i++) {
      values[i] = s.nextInt();
    }

    int weights[] = new int[n];
    for (int i = 0; i < n; i++) {
      weights[i] = s.nextInt();
    }

    int capacity = s.nextInt();

    int result = unboundedKnapsack(n, values, weights, capacity);
    System.out.println(result);
  }

}

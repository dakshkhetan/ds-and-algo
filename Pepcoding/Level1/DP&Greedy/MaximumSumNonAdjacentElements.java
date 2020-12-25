/*

Sample Input
6
5
10
10
100
5
6

Sample Output
116

*/

import java.util.*;

public class Main {

  public static int maximumSumNonAdjacentElements(int[] arr) {
    // greedy approach

    int include = arr[0];
    int exclude = 0;

    for (int i = 1; i < arr.length; i++) {
      int newInclude = exclude + arr[i];
      int newExclude = Math.max(include, exclude);

      include = newInclude;
      exclude = newExclude;
    }

    int max = Math.max(include, exclude);
    return max;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int result = maximumSumNonAdjacentElements(arr);
    System.out.println(result);
  }

}

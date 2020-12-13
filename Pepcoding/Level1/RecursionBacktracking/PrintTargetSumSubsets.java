/*

Sample Input
5
10
20
30
40
50
60

Sample Output
10, 20, 30, .
10, 50, .
20, 40, .

*/

import java.util.*;

public class Main {

  public static void printTargetSumSubsets(int[] arr, int index, int target, String set, int sumOfSubset) {
    // to prevent TLE
    if (sumOfSubset > target) { // optimise
      return;
    }

    if (index == arr.length) {
      if (sumOfSubset == target) {
        System.out.println(set + ".");
      }
      return;
    }

    printTargetSumSubsets(arr, index + 1, target, set + arr[index] + ", ", sumOfSubset + arr[index]);
    printTargetSumSubsets(arr, index + 1, target, set, sumOfSubset);
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int target = s.nextInt();

    printTargetSumSubsets(arr, 0, target, "", 0);
  }

}

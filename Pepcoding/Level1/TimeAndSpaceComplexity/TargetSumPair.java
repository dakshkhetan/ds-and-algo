/*

Sample Input
12
9 -48 100 43 84 74 86 34 -37 60 -29 44
160

Sample Output
60, 100
74, 86

*/

import java.util.*;

public class Main {

  public static void targetSumPair(int[] arr, int target) {
    Arrays.sort(arr); // O(n*logn)

    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
      if (arr[left] + arr[right] > target) {
        right--;
      } else if (arr[left] + arr[right] < target) {
        left++;
      } else {
        System.out.println(arr[left] + ", " + arr[right]);
        left++;
        right--;
      }
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int target = s.nextInt();

    targetSumPair(arr, target);
  }

}

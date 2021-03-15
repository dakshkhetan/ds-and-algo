/*

Reference Video - https://youtu.be/vF7gk4iaklA

Sample Input
9
15 16 19 21 23 24 1 2 12

Sample Output
1

*/

import java.util.*;

public class Main {

  public static int findPivot(int[] arr) {
    // using binary search

    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
      int mid = (left + right) / 2;
      if (arr[mid] < arr[right]) {
        // pivot will lie on left side (first-half)
        right = mid;
      } else if (arr[mid] > arr[right]) {
        // pivot will lie on right side (second-half)
        left = mid + 1;
      }
    }

    return arr[right]; // or arr[left]
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int pivot = findPivot(arr);
    System.out.println(pivot);
  }

}

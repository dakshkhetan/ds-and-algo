/* 

Sample Input
15
1
5
10
15
22
33
33
33
33
33
40
42
55
66
77
33

Sample Output
5
9

*/

import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {

    // File input = new File("./input.txt");
    // Scanner s = new Scanner(input);

    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int k = s.nextInt();

    int firstIndex = -1;
    int lastIndex = -1;

    // Using Binary Search Algorithm:

    int left = 0;
    int right = n - 1;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (k > arr[mid]) {
        left = mid + 1;
      } else if (k < arr[mid]) {
        right = mid - 1;
      } else {
        firstIndex = mid;
        right = mid - 1;
      }
    }

    left = 0;
    right = n - 1;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (k > arr[mid]) {
        left = mid + 1;
      } else if (k < arr[mid]) {
        right = mid - 1;
      } else {
        lastIndex = mid;
        left = mid + 1;
      }
    }

    // Alternate Approach (Naive):

    // for (int i = 0; i < n; i++) {
    //   if (arr[i] == k) {
    //     firstIndex = i;
    //     break;
    //   }
    // }

    // for (int i = n - 1; i >= 0; i--) {
    //   if (arr[i] == k) {
    //     lastIndex = i;
    //     break;
    //   }
    // }

    System.out.println(firstIndex);
    System.out.println(lastIndex);

  }
}

/* 

Sample Input
10
1
5
10
15
22
33
40
42
55
66
34

Sample Output
40
33

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

    int ceil = Integer.MAX_VALUE;
    int floor = Integer.MIN_VALUE;

    // Using Binary Search Algorithm:

    int left = 0;
    int right = n - 1;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (k > arr[mid]) {
        left = mid + 1;
        floor = arr[mid];
      } else if (k < arr[mid]) {
        right = mid - 1;
        ceil = arr[mid];
      } else {
        floor = arr[mid];
        ceil = arr[mid];
        break;
      }
    }

    // Alternate Approach (Naive): 

    // for (int i = 0; i < n; i++) {
    //   if (arr[i] > k) {
    //     ceil = arr[i];
    //     break;
    //   }
    // }

    // for (int i = n - 1; i >= 0; i--) {
    //   if (arr[i] < k) {
    //     floor = arr[i];
    //     break;
    //   }
    // }

    System.out.println(ceil);
    System.out.println(floor);

  }
}

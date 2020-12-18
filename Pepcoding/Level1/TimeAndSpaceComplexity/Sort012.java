/*

Sample Input:
10
1
0
2
2
1
0
2
1
0
2

Sample Output:
Swapping index 1 and index 0
Swapping index 2 and index 9
Swapping index 2 and index 8
Swapping index 2 and index 1
Swapping index 3 and index 7
Swapping index 5 and index 2
Swapping index 6 and index 6
0
0
0
1
1
1
2
2
2
2

*/

import java.util.*;

public class Main {

  public static void sort012(int[] arr) {
    // i to k-1 -> All Unknowns
    // k to n-1 -> All Two's
    // 0 to j-1 -> All Zeroes'
    // j to i-1 -> All Ones'

    int n = arr.length;
    int i = 0;
    int j = 0;
    int k = n - 1;

    while (i <= k) {
      if (arr[i] == 0) {
        swap(arr, i, j);
        i++;
        j++;
      } else if (arr[i] == 1) {
        i++;
      } else { // arr[i] == 2
        swap(arr, i, k);
        k--;
      }
    }
  }

  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping index " + i + " and index " + j);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    sort012(arr);
    print(arr);
  }

}

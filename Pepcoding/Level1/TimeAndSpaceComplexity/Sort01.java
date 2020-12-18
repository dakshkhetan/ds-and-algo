/*

Sample Input:
5
0
1
0
1
0

Sample Output:
Swapping index 0 and index 0
Swapping index 2 and index 1
Swapping index 4 and index 2
0
0
0
1
1 

*/

import java.util.*;

public class Main {

  public static void sort01(int[] arr) {
    // i to arr.length-1 -> All Unknowns
    // 0 to j-1 -> All Zeroes
    // j to i-1 -> All Ones

    int n = arr.length;
    int i = 0, j = 0;

    while (i < n) {
      if (arr[i] == 0) {
        swap(arr, i, j);
        i++;
        j++;
      } else {
        i++;
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

    sort01(arr);
    print(arr);
  }

}

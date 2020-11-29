/* 

Sample Input
5
1
2
3
4
5

Sample Output
5 4 3 2 1

*/

import java.io.*;
import java.util.*;

public class Main {
  public static void display(int[] a) {
    StringBuilder sb = new StringBuilder();

    for (int val : a) {
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  public static void reverse(int[] arr) {
    int li = 0;
    int ri = arr.length - 1;

    // Swapping till mid index
    while (li < ri) {
      int temp = arr[li];
      arr[li] = arr[ri];
      arr[ri] = temp;

      li++;
      ri--;
    }

    // Alternate Approach:
    // int temp[] = new int[arr.length];
    // for (int i = 0; i < arr.length; i++) {
    //   temp[i] = arr[i];
    // }
    // for (int i = 0, j = arr.length - 1; i < temp.length; i++, j--) {
    //   arr[i] = temp[j];
    // }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    reverse(a);
    display(a);
  }

}

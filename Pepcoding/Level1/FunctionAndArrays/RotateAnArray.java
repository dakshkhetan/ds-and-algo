/* 

Sample Input
5
1
2
3
4
5
3

Sample Output
3 4 5 1 2

*/

import java.io.*;
import java.util.*;

public class Main {

  // Approach 1 (with temp[] array):
  public static void rotate(int[] arr, int k) {
    int n = arr.length;

    k = k % n;

    if (k < 0) {
      k = n + k;
    }

    int temp[] = new int[n];
    int j = 0;

    for (int i = n - k; i < n; i++) {
      temp[j++] = arr[i];
    }

    for (int i = 0; i < n - k; i++) {
      temp[j++] = arr[i];
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i] = temp[i];
    }
  }

  // Approach 2 (without creating temp[] array):

  public static void rotate2(int[] arr, int k) {
    int n = arr.length;

    k = k % n;

    if (k < 0) {
      k = k + n;
    }

    reverse(arr, 0, n - k - 1);
    reverse(arr, n - k, n - 1);
    reverse(arr, 0, n - 1);
  }

  public static void reverse(int[] arr, int li, int ri) {
    while (li < ri) {
      int temp = arr[li];
      arr[li] = arr[ri];
      arr[ri] = temp;

      li++;
      ri--;
    }
  }

  public static void display(int[] a) {
    StringBuilder sb = new StringBuilder();

    for (int val : a) {
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    rotate(a, k);
    display(a);
  }
}

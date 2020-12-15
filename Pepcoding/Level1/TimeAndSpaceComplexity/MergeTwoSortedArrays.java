/*

Sample Input
4
-2 
5 
9 
11
3
4 
6 
8

Sample Output
-2
4
5
6
8
9
11

*/

import java.util.*;

public class Main {

  public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
    int n1 = arr1.length;
    int n2 = arr2.length;
    int n3 = n1 + n2;

    int arr3[] = new int[n3];

    int i = 0, j = 0, k = 0;

    while (i < n1 && j < n2) {
      if (arr1[i] < arr2[j]) {
        arr3[k++] = arr1[i++];
      } else {
        arr3[k++] = arr2[j++];
      }
    }

    while (i < n1) {
      arr3[k++] = arr1[i++];
    }

    while (j < n2) {
      arr3[k++] = arr2[j++];
    }

    return arr3;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int[] arr1 = new int[n];
    for (int i = 0; i < n; i++) {
      arr1[i] = s.nextInt();
    }

    int m = s.nextInt();
    int[] arr2 = new int[m];
    for (int i = 0; i < m; i++) {
      arr2[i] = s.nextInt();
    }

    int[] mergedArray = mergeTwoSortedArrays(arr1, arr2);
    print(mergedArray);
  }

}

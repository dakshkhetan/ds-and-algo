/*

Sample Input
4
3
7
4
5

Sample Output
Comparing 7 and 3
Comparing 4 and 3
Comparing 5 and 3
Swapping 3 and 3
Comparing 4 and 7
Comparing 5 and 4
Swapping 7 and 4
Comparing 5 and 7
Swapping 7 and 5
3
4
5
7

*/

import java.util.*;

public class Main {

  public static void selectionSortAlgo(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[min]) {
          min = j;
        }
      }
      if (min != i) {
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
      }
    }
  }

  // solution
  public static void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++) {
        if (isSmaller(arr, j, min)) {
          min = j;
        }
      }
      // if (min != i) {
        swap(arr, i, min);
      // }
    }
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // return true if ith element is smaller than jth element
  public static boolean isSmaller(int[] arr, int i, int j) {
    System.out.println("Comparing " + arr[i] + " and " + arr[j]);
    if (arr[i] < arr[j]) {
      return true;
    } else {
      return false;
    }
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

    // selectionSortAlgo(arr);
    selectionSort(arr);
    print(arr);
  }

}

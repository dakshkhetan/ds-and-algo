/*

Reference Video - https://youtu.be/fnbImb8lo88

Sample Input
5
7 -2 4 1 3
3

Sample Output
pivot -> 3
Swapping -2 and 7
Swapping 1 and 7
Swapping 3 and 4
pivot index -> 2
3

*/

import java.util.*;

public class Main {

  public static int quickSelect(int[] arr, int start, int end, int k) {
    int pivot = arr[end];
    int pivotIndex = partition(arr, pivot, start, end);

    if (k < pivotIndex) {
      return quickSelect(arr, start, pivotIndex - 1, k);
    } else if (k > pivotIndex) {
      return quickSelect(arr, pivotIndex + 1, end, k);
    } else {
      return pivot;
    }
  }

  public static int partition(int[] arr, int pivot, int start, int end) {
    // i to arr.length-1 -> unknown elements
    // 0 to j-1 -> all elements are equal & smaller than pivot
    // j to i-1 -> all elements are greater than pivot

    System.out.println("pivot -> " + pivot);

    int i = start, j = start;
    while (i <= end) {
      if (arr[i] <= pivot) {
        swap(arr, i, j);
        i++;
        j++;
      } else {
        i++;
      }
    }

    System.out.println("pivot index -> " + (j - 1));

    int pivotIndex = j - 1;
    return pivotIndex;
  }

  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int k = s.nextInt();

    int element = quickSelect(arr, 0, n - 1, k - 1); // passing k-1 (index)
    System.out.println(element);
  }

}

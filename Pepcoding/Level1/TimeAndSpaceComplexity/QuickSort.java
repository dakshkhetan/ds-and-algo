/*

Sample Input:
5
7 -2 4 1 3

Sample Output:
pivot -> 3
Swapping -2 and 7
Swapping 1 and 7
Swapping 3 and 4
pivot index -> 2
pivot -> 1
Swapping -2 and -2
Swapping 1 and 1
pivot index -> 1
pivot -> -2
Swapping -2 and -2
pivot index -> 0
pivot -> 4
Swapping 4 and 7
pivot index -> 3
pivot -> 7
Swapping 7 and 7
pivot index -> 4
-2 1 3 4 7 

*/

import java.util.*;

public class Main {

  public static void quickSort(int[] arr, int start, int end) {
    if (start > end) {
      return;
    }

    int pivot = arr[end]; // taking last element as pivot
    int partitionIndex = partition(arr, pivot, start, end);

    quickSort(arr, start, partitionIndex - 1);
    quickSort(arr, partitionIndex + 1, end);
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

    int partitionIndex = j - 1;
    return partitionIndex;
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

    quickSort(arr, 0, n - 1);
    print(arr);
  }

}

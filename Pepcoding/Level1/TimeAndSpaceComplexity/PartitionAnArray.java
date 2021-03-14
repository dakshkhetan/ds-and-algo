/*

Sample Input
5
7 -2 4 1 3
3

Sample Output
Swapping -2 and 7
Swapping 1 and 7
Swapping 3 and 4
-2 1 3 7 4 

*/

import java.util.*;

public class Main {

  public static void partition(int[] arr, int pivot) {
    // i to arr.length-1 -> unknown elements
    // 0 to j-1 -> all elements are equal & smaller than pivot
    // j to i-1 -> all elements are greater than pivot

    int i = 0, j = 0;
    while (i < arr.length) {
      if (arr[i] <= pivot) {
        swap(arr, i, j);
        i++;
        j++;
      } else {
        i++;
      }
    }
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

    int pivot = s.nextInt();

    partition(arr, pivot);
    print(arr);
  }

}

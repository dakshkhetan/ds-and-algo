/*

Sample Input:
5
7 
-2 
4 
1 
3

Sample Output:
Merging these two arrays 
left array -> 7 
right array -> -2 
Merging these two arrays 
left array -> -2 7 
right array -> 4 
Merging these two arrays 
left array -> 1 
right array -> 3 
Merging these two arrays 
left array -> -2 4 7 
right array -> 1 3 
Sorted Array -> -2 1 3 4 7 

*/

import java.util.*;

public class Main {

  public static int[] mergeSort(int[] arr, int start, int end) {
    if (start == end) {
      int baseCase[] = new int[1];
      baseCase[0] = arr[start];
      return baseCase;
    }

    int mid = (start + end) / 2;

    int leftHalf[] = mergeSort(arr, start, mid);
    int rightHalf[] = mergeSort(arr, mid + 1, end);

    int sortedArray[] = mergeTwoSortedArrays(leftHalf, rightHalf);

    return sortedArray;
  }

  public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
    System.out.println("Merging these two arrays ");
    System.out.print("left array -> ");
    print(arr1);
    System.out.print("right array -> ");
    print(arr2);

    int n1 = arr1.length;
    int n2 = arr2.length;
    int arr3[] = new int[n1 + n2];
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

    int[] sortedArray = mergeSort(arr, 0, n - 1);

    System.out.print("Sorted Array -> ");
    print(sortedArray);
  }

}

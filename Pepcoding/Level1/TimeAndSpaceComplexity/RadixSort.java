/*

Sample Input:
5
37 
162 
74 
341 
9

Sample Output:
After sorting on 1 place -> 341 162 74 37 9 
After sorting on 10 place -> 9 37 341 162 74 
After sorting on 100 place -> 9 37 74 162 341 
9 37 74 162 341 

*/

import java.util.*;

public class Main {

  public static void radixSort(int[] arr) {
    // find the largest element in array
    int max = Integer.MIN_VALUE;
    for (int val : arr) {
      max = Math.max(val, max);
    }

    int exponent = 1; // one's place
    while (exponent <= max) {
      // perform count sorting of nth (exponent) place of all elements
      countSort(arr, exponent);
      exponent *= 10;
    }
  }

  public static void countSort(int[] arr, int exp) {
    int n = arr.length;

    int range = 10; // number of digits
    int freqPrefixArr[] = new int[range];

    // storing frequency of each element in given 'arr'
    for (int i = 0; i < n; i++) {
      int elementIndex = (arr[i] / exp) % 10; // extract digit
      freqPrefixArr[elementIndex]++;
    }

    // converting 'freq' array into prefix-sum array format
    for (int i = 1; i < range; i++) {
      freqPrefixArr[i] += freqPrefixArr[i - 1];
    }

    int sortedArr[] = new int[n];

    // stable sorting (filling 'sortedArr' arr)
    for (int i = n - 1; i >= 0; i--) {
      int elementIndex = (arr[i] / exp) % 10; // extract digit
      int index = freqPrefixArr[elementIndex] - 1;

      sortedArr[index] = arr[i];
      freqPrefixArr[elementIndex]--;
    }

    for (int i = 0; i < n; i++) {
      arr[i] = sortedArr[i];
    }

    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);
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

    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    radixSort(arr);
    print(arr);
  }

}

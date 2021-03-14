/*

Reference Video - https://youtu.be/p-OyKUgIrx4

Sample Input
5
7 -2 4 1 3

Sample Output
-2
1
3
4
7

*/

import java.util.*;

public class Main {

  // count sort is applied when array size is large but range of values is small
  public static void countSort(int[] arr, int min, int max) {
    int n = arr.length;

    int range = max - min + 1;
    int freqPrefixArr[] = new int[range];

    // storing frequency of each element in given 'arr'
    for (int i = 0; i < n; i++) {
      int elementIndex = arr[i] - min;
      freqPrefixArr[elementIndex]++;
    }

    // converting 'freq' array into prefix-sum array format
    for (int i = 1; i < range; i++) {
      freqPrefixArr[i] = freqPrefixArr[i - 1] + freqPrefixArr[i];
    }

    int sortedArr[] = new int[n];

    // stable sorting (filling 'sortedArr' array)
    for (int i = n - 1; i >= 0; i--) {
      int elementIndex = arr[i] - min;
      int index = freqPrefixArr[elementIndex] - 1;

      sortedArr[index] = arr[i];
      freqPrefixArr[elementIndex]--;
    }

    for (int i = 0; i < n; i++) {
      arr[i] = sortedArr[i];
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

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }

    // passing min & max element in arr in order to calculate range
    countSort(arr, min, max);
    
    print(arr);
  }

}

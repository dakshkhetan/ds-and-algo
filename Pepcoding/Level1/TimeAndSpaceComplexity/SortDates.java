/*

Sample Input
5
12041996
20101996
05061997
12041989
09081987

Sample Output
09081987
12041989
12041996
20101996
05061997

*/

import java.util.*;

public class Main {

  public static void sortDates(String[] arr) {
    countSort(arr, 1000000, 100, 32); // day
    countSort(arr, 10000, 100, 13); // month
    countSort(arr, 1, 10000, 2501); // year
  }

  private static void countSort(String[] arr, int div, int mod, int range) {
    int n = arr.length;
    int freqPrefixArr[] = new int[range];

    // storing frequency of each element in given 'arr'
    for (int i = 0; i < n; i++) {
      int val = Integer.parseInt(arr[i], 10); // 'decimal' number system
      int elementIndex = (val / div) % mod;
      freqPrefixArr[elementIndex]++;
    }

    // converting 'freq' array into prefix-sum array format
    for (int i = 1; i < range; i++) {
      freqPrefixArr[i] += freqPrefixArr[i - 1];
    }

    String sortedArr[] = new String[n];

    // stable sorting (filling 'sortedArr' array)
    for (int i = n - 1; i >= 0; i--) {
      int val = Integer.parseInt(arr[i], 10);
      int elementIndex = (val / div) % mod;
      int index = freqPrefixArr[elementIndex] - 1;

      sortedArr[index] = arr[i];
      freqPrefixArr[elementIndex]--;
    }

    for (int i = 0; i < n; i++) {
      arr[i] = sortedArr[i];
    }
  }

  public static void print(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      String str = s.next();
      arr[i] = str;
    }

    sortDates(arr);
    print(arr);
  }

}

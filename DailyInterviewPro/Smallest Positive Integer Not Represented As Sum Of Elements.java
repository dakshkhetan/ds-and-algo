/*

Reference - https://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/

Sample Input:
6
1 2 3 8 9 10

Sample Output:
7

Explanation:
Numbers 1 to 6 can all be summed by a subset of 
the list of numbers, but 7 cannot.

*/

import java.util.*;

public class Main {

  // Time Complexity: O(n)
  public static int findSmallestNumber(int[] arr) {
    int n = arr.length;
    int result = 1;

    // traverse the array & increment 'result' if,
    // arr[i] is smaller than or equal to 'result'
    for (int i = 0; i < n; i++) {
      if (arr[i] <= result) {
        result += arr[i];
      } else {
        break;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int result = findSmallestNumber(arr);
    System.out.println(result);
  }

}

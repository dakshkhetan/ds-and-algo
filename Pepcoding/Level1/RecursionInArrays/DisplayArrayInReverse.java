/* 

Sample Input
5
3
1
0
7
5

Sample Output
5
7
0
1
3

*/

import java.util.*;

public class Main {

  public static void displayArrReverseTopDown(int[] arr, int startIndex) {
    if (startIndex < 0) {
      return;
    }

    System.out.println(arr[startIndex]);
    displayArrReverseTopDown(arr, startIndex - 1);
  }

  public static void displayArrReverseBottomUp(int[] arr, int startIndex) {
    if (startIndex == arr.length) {
      return;
    }

    displayArrReverseBottomUp(arr, startIndex + 1);
    System.out.println(arr[startIndex]);
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int arr[] = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    // displayArrReverseTopDown(arr, n - 1);
    displayArrReverseBottomUp(arr, 0);
  }

}

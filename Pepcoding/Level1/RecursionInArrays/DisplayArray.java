/* 

Sample Input
5
3
1
0
7
5

Sample Output
3
1
0
7
5

*/

import java.util.*;

public class Main {

  public static void displayArr(int[] arr, int startIndex) {
    if (startIndex == arr.length) {
      return;
    }

    System.out.println(arr[startIndex]);
    displayArr(arr, startIndex + 1);
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int arr[] = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    displayArr(arr, 0);
  }

}

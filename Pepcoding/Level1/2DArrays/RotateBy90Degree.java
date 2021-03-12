/* 

Sample Input
4
11 12 13 14
21 22 23 24
31 32 33 34
41 42 43 44

Sample Output
41 31 21 11
42 32 22 12
43 33 23 13
44 34 24 14

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int arr[][] = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = s.nextInt();
      }
    }

    // matrix transpose
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
      }
    }

    // reversing each row elements
    for (int i = 0; i < n; i++) {
      int li = 0;
      int ri = n - 1;

      while (li < ri) {
        int temp = arr[i][li];
        arr[i][li] = arr[i][ri];
        arr[i][ri] = temp;

        li++;
        ri--;
      }
    }

    // display
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

}

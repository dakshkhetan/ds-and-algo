/* 

Sample Input
4
11
12
13
14
21
22
23
24
31
32
33
34
41
42
43
44

Sample Output
41

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

    int ans = saddlePoint(arr);
    // int ans = saddlePointAlternate(arr);

    if (ans == -1) {
      System.out.println("Invalid input");
    } else {
      System.out.println(ans);
    }

  }

  public static int saddlePoint(int[][] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      int minRowElement = arr[i][0];
      int colIndex = 0;
      for (int j = 1; j < n; j++) {
        if (arr[i][j] < minRowElement) {
          minRowElement = arr[i][j];
          colIndex = j;
        }
      }

      boolean flag = true;
      for (int k = 0; k < n; k++) {
        if (arr[k][colIndex] > minRowElement) {
          flag = false;
          break;
        }
      }

      if (flag) {
        return minRowElement;
      }
    }

    return -1;
  }

  // Alternate Approach (almost similar as above):
  public static int saddlePointAlternate(int[][] arr) {
    int n = arr.length;
    int ans = -1;

    for (int i = 0; i < n; i++) {
      int min = arr[i][0];
      int colIndex = 0;
      for (int j = 1; j < n; j++) {
        if (arr[i][j] < min) {
          min = arr[i][j];
          colIndex = j;
        }
      }

      int max = arr[0][colIndex];
      for (int k = 0; k < n; k++) {
        if (arr[k][colIndex] > max) {
          max = arr[k][colIndex];
        }
      }

      if (max == min) {
        ans = max;
      }
    }

    return ans;
  }

}

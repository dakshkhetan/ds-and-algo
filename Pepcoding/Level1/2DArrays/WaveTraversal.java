/* 

Sample Input
3
4
11 12 13 14
21 22 23 24
31 32 33 34

Sample Output
11
21
31
32
22
12
13
23
33
34
24
14

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int m = s.nextInt();
    int n = s.nextInt();

    int arr[][] = new int[m][n];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        arr[i][j] = s.nextInt();
      }
    }

    for (int j = 0; j < n; j++) {
      if (j % 2 == 0) {
        for (int i = 0; i < m; i++) {
          System.out.println(arr[i][j]);
        }
      } else {
        for (int i = m - 1; i >= 0; i--) {
          System.out.println(arr[i][j]);
        }
      }
    }
  }

}

/* 

Sample Input
3
5
11
12
13
14
15
21
22
23
24
25
31
32
33
34
35

Sample Output
11
21
31
32
33
34
35
25
15
14
13
12
22
23
24

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

    int count = 0;
    int limit = m * n;

    int minRow = 0;
    int maxRow = m - 1;
    int minCol = 0;
    int maxCol = n - 1;

    while (count < limit) {

      // left wall
      for (int i = minRow, j = minCol; i <= maxRow && count < limit; i++) {
        System.out.println(arr[i][j]);
        count++;
      }
      minCol++;

      // bottom wall
      for (int i = maxRow, j = minCol; j <= maxCol && count < limit; j++) {
        System.out.println(arr[i][j]);
        count++;
      }
      maxRow--;

      // right wall
      for (int i = maxRow, j = maxCol; i >= minRow && count < limit; i--) {
        System.out.println(arr[i][j]);
        count++;
      }
      maxCol--;

      // top wall
      for (int i = minRow, j = maxCol; j >= minCol && count < limit; j--) {
        System.out.println(arr[i][j]);
        count++;
      }
      minRow++;

    }

  }

}

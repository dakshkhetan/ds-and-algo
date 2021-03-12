/* 

Sample Input
4
4
0 0 1 0
1 0 0 0
0 0 0 0
1 0 1 0

Sample Output
1
3

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

    // Directions:
    // 0 -> East
    // 1 -> South
    // 2 -> West
    // 3 -> North

    int direction = 0;
    int i = 0;
    int j = 0;

    while (true) {
      direction = (direction + arr[i][j]) % 4;

      if (direction == 0) { // east
        j++;
      } else if (direction == 1) { // south
        i++;
      } else if (direction == 2) { // west
        j--;
      } else if (direction == 3) { // north
        i--;
      }

      if (i < 0) {
        i++;
        break;
      } else if (j < 0) {
        j++;
        break;
      } else if (i == m) {
        i--;
        break;
      } else if (j == n) {
        j--;
        break;
      }
    }

    System.out.println(i);
    System.out.println(j);
  }

}

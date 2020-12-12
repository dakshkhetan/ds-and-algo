/* 

Sample Input
3
3

Sample Output
h1h1v1v1
h1h1v2
h1v1h1v1
h1v1v1h1
h1v1d1
h1v2h1
h1d1v1
h2v1v1
h2v2
v1h1h1v1
v1h1v1h1
v1h1d1
v1h2v1
v1v1h1h1
v1v1h2
v1d1h1
v2h1h1
v2h2
d1h1v1
d1v1h1
d1d1
d2

*/

import java.util.*;

public class Main {

  public static void getMazePathsWithJumps(int srcRow, int srcCol, int destRow, int destCol, String path) {
    if (srcRow > destRow || srcCol > destCol) {
      return;
    }

    if (srcRow == destRow && srcCol == destCol) {
      System.out.println(path);
      return;
    }

    for (int jump = 1; jump <= destCol - srcCol; jump++) {
      getMazePathsWithJumps(srcRow, srcCol + jump, destRow, destCol, path + "h" + jump);
    }

    for (int jump = 1; jump <= destRow - srcRow; jump++) {
      getMazePathsWithJumps(srcRow + jump, srcCol, destRow, destCol, path + "v" + jump);
    }

    for (int jump = 1; jump <= destRow - srcRow && jump <= destCol - srcCol; jump++) {
      getMazePathsWithJumps(srcRow + jump, srcCol + jump, destRow, destCol, path + "d" + jump);
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int m = s.nextInt();

    getMazePathsWithJumps(0, 0, n - 1, m - 1, "");
  }

}

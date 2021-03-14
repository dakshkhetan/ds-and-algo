/* 

Sample Input
3
3

Sample Output
hhvv
hvhv
hvvh
vhhv
vhvh
vvhh

*/

import java.util.*;

public class Main {

  public static void getMazePaths(int srcRow, int srcCol, int destRow, int destCol, String path) {
    if (srcRow > destRow || srcCol > destCol) {
      return;
    }

    if (srcRow == destRow && srcCol == destCol) {
      System.out.println(path);
      return;
    }

    getMazePaths(srcRow, srcCol + 1, destRow, destCol, path + "h");
    getMazePaths(srcRow + 1, srcCol, destRow, destCol, path + "v");
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int m = s.nextInt();

    getMazePaths(0, 0, n - 1, m - 1, "");
  }

}

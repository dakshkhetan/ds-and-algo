/* 

Sample Input
3
3

Sample Output
[hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]

*/

import java.util.*;

public class Main {

  public static ArrayList<String> getMazePaths(int srcRow, int srcCol, int destRow, int destCol) {
    if (srcRow > destRow || srcCol > destCol) {
      ArrayList<String> baseCase = new ArrayList<>();
      return baseCase;
    }

    if (srcRow == destRow && srcCol == destCol) {
      ArrayList<String> baseCase = new ArrayList<>();
      baseCase.add("");
      return baseCase;
    }

    ArrayList<String> horizontalPaths = getMazePaths(srcRow, srcCol + 1, destRow, destCol);
    ArrayList<String> verticalPaths = getMazePaths(srcRow + 1, srcCol, destRow, destCol);

    ArrayList<String> paths = new ArrayList<>();
    for (String path : horizontalPaths) {
      paths.add("h" + path);
    }
    for (String path : verticalPaths) {
      paths.add("v" + path);
    }

    return paths;
  }

  // Another way of writing the same code as above
  public static ArrayList<String> getMazePaths2(int srcRow, int srcCol, int destRow, int destCol) {
    if (srcRow == destRow && srcCol == destCol) {
      ArrayList<String> baseCase = new ArrayList<>();
      baseCase.add("");
      return baseCase;
    }

    ArrayList<String> horizontalPaths = new ArrayList<>();
    ArrayList<String> verticalPaths = new ArrayList<>();

    if (srcCol < destCol) {
      horizontalPaths = getMazePaths(srcRow, srcCol + 1, destRow, destCol);
    }

    if (srcRow < destRow) {
      verticalPaths = getMazePaths(srcRow + 1, srcCol, destRow, destCol);
    }

    ArrayList<String> paths = new ArrayList<>();
    for (String path : horizontalPaths) {
      paths.add("h" + path);
    }
    for (String path : verticalPaths) {
      paths.add("v" + path);
    }

    return paths;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int m = s.nextInt();

    ArrayList<String> output = getMazePaths(0, 0, n - 1, m - 1);
    // ArrayList<String> output = getMazePaths(1, 1, n, m);
    System.out.println(output);
  }

}

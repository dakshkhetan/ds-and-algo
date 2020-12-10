/* 

Sample Input
2
2

Sample Output
[h1v1, v1h1, d1]

*/

import java.util.*;

public class Main {

  public static ArrayList<String> getMazePathsWithJumps(int srcRow, int srcCol, int destRow, int destCol) {
    if (srcRow > destRow || srcCol > destCol) {
      ArrayList<String> baseCase = new ArrayList<>();
      return baseCase;
    }

    if (srcRow == destRow && srcCol == destCol) {
      ArrayList<String> baseCase = new ArrayList<>();
      baseCase.add("");
      return baseCase;
    }

    ArrayList<String> totalPossiblePaths = new ArrayList<>();

    for (int jump = 1; jump <= destCol - srcCol; jump++) {
      ArrayList<String> horizontalPaths = getMazePathsWithJumps(srcRow, srcCol + jump, destRow, destCol);
      for (String path : horizontalPaths) {
        totalPossiblePaths.add("h" + jump + path);
      }
    }

    for (int jump = 1; jump <= destRow - srcRow; jump++) {
      ArrayList<String> verticalPaths = getMazePathsWithJumps(srcRow + jump, srcCol, destRow, destCol);
      for (String path : verticalPaths) {
        totalPossiblePaths.add("v" + jump + path);
      }
    }

    for (int jump = 1; jump <= (destRow - srcRow) && jump <= (destCol - srcCol); jump++) {
      ArrayList<String> diagonalPaths = getMazePathsWithJumps(srcRow + jump, srcCol + jump, destRow, destCol);
      for (String path : diagonalPaths) {
        totalPossiblePaths.add("d" + jump + path);
      }
    }

    return totalPossiblePaths;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int m = s.nextInt();

    ArrayList<String> output = getMazePathsWithJumps(0, 0, n - 1, m - 1);
    // ArrayList<String> output = getMazePathsWithJumps(1, 1, n, m);
    System.out.println(output);
  }

}

/*

Sample Input
8
8
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
1 1 1 1 1 1 1 0
1 1 0 0 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 0

Sample Output
3

*/

import java.util.*;

public class Main {

  public static int numberOfIslands(int[][] arr) {
    // 0 -> land
    // 1 -> water

    // number of islands -> number of times 'searchForIslands()' is called

    int m = arr.length;
    int n = arr[0].length;

    boolean visited[][] = new boolean[m][n];
    int count = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // check if the current area/cell is a land & it is not visited
        if (!visited[i][j] && arr[i][j] == 0) {
          searchForIslands(arr, i, j, visited);
          count++;
        }
      }
    }

    return count;
  }

  private static void searchForIslands(int[][] arr, int i, int j, boolean[][] visited) {
    // boundary conditions
    if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) {
      return;
    }

    // return if the area/cell is water and it is already visited
    if (arr[i][j] == 1 || visited[i][j]) {
      return;
    }

    visited[i][j] = true;

    searchForIslands(arr, i - 1, j, visited); // north
    searchForIslands(arr, i, j + 1, visited); // east
    searchForIslands(arr, i, j - 1, visited); // west
    searchForIslands(arr, i + 1, j, visited); // south
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int m = s.nextInt();
    int n = s.nextInt();

    int arr[][] = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = s.nextInt();
      }
    }

    int result = numberOfIslands(arr);
    System.out.println(result);
  }

}

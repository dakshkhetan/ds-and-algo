/*

Sample Input 1:
4
3
0 1 1
0 0 1
1 0 0
0 1 0

Sample Output 1:
drdrd
______________________________

Sample Input 2:
8
8
0 1 0 0 0 0 0 0
0 1 0 1 1 1 1 0
0 1 0 1 0 0 0 0
0 1 0 1 0 1 1 1
0 0 0 0 0 0 0 0
0 1 0 1 1 1 1 0
0 1 0 1 1 1 1 0
0 1 0 0 0 0 0 0

Sample Output 2:
ddddrrttttrrrrrddlllddrrrddd
ddddrrdddrrrrr
ddddrrrrrrrddd

*/

import java.util.*;

public class Main {

  public static void floodFill(int[][] maze, int row, int col, String pathSofar, boolean[][] visited) {
    if (row < 0 || col < 0 || row == maze.length || col == maze[0].length) {
      return;
    }

    if (visited[row][col] == true) {
      return;
    }

    if (maze[row][col] == 1) { // obstacle
      return;
    }

    if (row == maze.length - 1 && col == maze[0].length - 1) {
      System.out.println(pathSofar);
      return;
    }

    visited[row][col] = true;

    floodFill(maze, row - 1, col, pathSofar + "t", visited); // top/up
    floodFill(maze, row, col - 1, pathSofar + "l", visited); // left
    floodFill(maze, row + 1, col, pathSofar + "d", visited); // down
    floodFill(maze, row, col + 1, pathSofar + "r", visited); // right

    visited[row][col] = false;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int m = s.nextInt();

    int maze[][] = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        maze[i][j] = s.nextInt();
      }
    }

    boolean visited[][] = new boolean[n][m];

    floodFill(maze, 0, 0, "", visited);
  }

}

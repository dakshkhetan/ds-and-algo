/*

Reference Video - https://youtu.be/gRo86WqFYSE

Sample Input:
14

Sample Output:
1
10
11
12
13
14
2
3
4
5
6
7
8
9

*/

import java.util.*;

public class Main {

  // Time Complexity: O(n)
  // Space Complexity: O(1)

  public static void printLexographicalNumbersTillN(int n) {
    for (int i = 1; i <= 9; i++) {
      dfs(i, n);
    }
  }

  private static void dfs(int i, int n) {
    if (i > n) {
      return;
    }

    System.out.println(i);

    for (int j = 0; j < 10; j++) {
      dfs(10 * i + j, n); // important
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    printLexographicalNumbersTillN(n);
  }

}

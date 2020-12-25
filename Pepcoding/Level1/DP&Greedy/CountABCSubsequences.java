/*

Sample Input
abcabc

Sample Output
7

*/

import java.util.*;

public class Main {

  public static int countABCSubsequences(String str) {
    int a = 0;
    int ab = 0;
    int abc = 0;

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == 'a') {
        a = 2 * a + 1;
      } else if (ch == 'b') {
        ab = 2 * ab + a;
      } else if (ch == 'c') {
        abc = 2 * abc + ab;
      }
    }

    return abc;
  }

  // for understanding problem's approach
  public static int countABCSubsequencesWithArray(String str) {
    int n = str.length();
    int dp[][] = new int[3][n + 1];

    // dp[0][i] = a+ expressions
    // dp[1][i] = a+b+ expressions
    // dp[2][i] = a+b+c+ expressions

    for (int i = 0; i < 3; i++) {
      dp[i][0] = 0;
    }

    for (int i = 1; i <= n; i++) {
      char ch = str.charAt(i - 1);

      if (ch == 'a') {
        dp[0][i] = 2 * dp[0][i - 1] + 1;
        dp[1][i] = dp[1][i - 1];
        dp[2][i] = dp[2][i - 1];
      } else if (ch == 'b') {
        dp[0][i] = dp[0][i - 1];
        dp[1][i] = 2 * dp[1][i - 1] + dp[0][i];
        dp[2][i] = dp[2][i - 1];
      } else if (ch == 'c') {
        dp[0][i] = dp[0][i - 1];
        dp[1][i] = dp[1][i - 1];
        dp[2][i] = 2 * dp[2][i - 1] + dp[1][i];
      }
    }

    return dp[2][n];
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    String str = s.next();

    int result = countABCSubsequences(str);
    // int result = countABCSubsequencesWithArray(str);
    System.out.println(result);
  }

}

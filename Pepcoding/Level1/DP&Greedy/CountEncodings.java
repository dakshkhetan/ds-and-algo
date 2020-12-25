/*

Sample Input 1:
123

Sample Output 1:
3


Sample Input 2:
90

Sample Output 2:
0

*/

import java.util.*;

public class Main {

  public static int countEncodings(String str) {
    if (str.charAt(0) == '0') {
      return 0;
    }

    int dp[] = new int[str.length()];

    dp[0] = 1;

    for (int i = 1; i < str.length(); i++) {
      char ch1 = str.charAt(i - 1);
      char ch2 = str.charAt(i);

      if (ch1 == '0' && ch2 == '0') {

        // invalid
        return 0;

      } else if (ch1 == '0' && ch2 != '0') {

        dp[i] = dp[i - 1];

      } else if (ch1 != '0' && ch2 == '0') {

        if (ch1 == '1' || ch1 == '2') {
          if (i - 2 >= 0) {
            dp[i] = dp[i - 2];
          } else {
            dp[i] = 1; // the letter itself
          }
        } else {
          dp[i] = 0;
        }

      } else {

        int num = Integer.parseInt(str.substring(i - 1, i + 1));
        if (num <= 26) {
          int option1 = dp[i - 1];
          int option2 = (i - 2 >= 0 ? dp[i - 2] : 1);
          dp[i] = option1 + option2;
        } else {
          dp[i] = dp[i - 1];
        }

      }
    }

    return dp[str.length() - 1];
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    String str = s.next();

    int result = countEncodings(str);
    System.out.println(result);
  }

}

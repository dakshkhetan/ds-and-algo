/* 

Sample Input
620196

Sample Output
ftaif
ftsf

*/

import java.util.*;

public class Main {

  public static void printEncodings(String str, String result) {
    if (str.length() == 0) {
      System.out.println(result);
      return;
    }

    if (str.charAt(0) == '0') {
      return;
    }

    char ch = (char) (str.charAt(0) - '1' + 'a');
    printEncodings(str.substring(1), result + ch);

    if (str.length() >= 2) {
      // int num = 10 * (str.charAt(0) - '0') + (str.charAt(1) - '0');
      int num = Integer.parseInt(str.substring(0, 2));
      if (num <= 26) {
        char c = (char) ('a' + num - 1);
        printEncodings(str.substring(2), result + c);
      }
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String str = s.next();

    printEncodings(str, "");
  }

}

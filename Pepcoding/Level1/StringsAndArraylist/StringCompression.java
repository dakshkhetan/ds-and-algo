/*

Sample Input
wwwwaaadexxxxxx

Sample Output
wadex
w4a3dex6

*/

import java.util.*;

public class Main {

  public static String removeConsecutiveDuplicates(String str) {
    String ans = "";
    for (int i = 0; i < str.length(); i++) {
      while ((i < str.length() - 1) && (str.charAt(i) == str.charAt(i + 1))) {
        i++;
      }
      ans += str.charAt(i);
    }
    return ans;

    // Alternate Approach:
    // String ans = str.substring(0, 1);
    // for (int i = 1; i < str.length(); i++) {
    // if (str.charAt(i) != str.charAt(i - 1)) {
    // ans += str.charAt(i);
    // }
    // }
    // return ans;
  }

  public static String compressString(String str) {
    String ans = "";

    for (int i = 0; i < str.length(); i++) {
      int count = 1;

      while ((i < str.length() - 1) && (str.charAt(i) == str.charAt(i + 1))) {
        count++;
        i++;
      }

      ans += str.charAt(i);

      if (count > 1) {
        ans += count;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String str = s.next();

    System.out.println(removeConsecutiveDuplicates(str));
    System.out.println(compressString(str));
  }

}

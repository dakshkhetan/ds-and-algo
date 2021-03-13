/*

Sample Input
abcc

Sample Output
a
b
c
cc
c

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String str = s.next();

    printAllPalindromicSubstrings(str);
  }

  public static void printAllPalindromicSubstrings(String str) {
    for (int i = 0; i < str.length(); i++) {
      for (int j = i + 1; j <= str.length(); j++) {
        String subString = str.substring(i, j);
        if (isPalindrome(subString)) {
          System.out.println(subString);
        }
      }
    }
  }

  private static boolean isPalindrome(String str) {
    for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
      if (str.charAt(i) != str.charAt(j)) {
        return false;
      }
    }
    return true;
  }

}

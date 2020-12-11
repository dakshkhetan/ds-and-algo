/* 

Sample Input
78

Sample Output
tv
tw
tx
uv
uw
ux

*/

import java.util.*;

public class Main {

  public static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

  public static void printKeypadCombinations(String str, String combination) {
    if (str.length() == 0) {
      System.out.println(combination);
      return;
    }

    char firstChar = str.charAt(0);
    String restOfString = str.substring(1);

    String code = codes[firstChar - '0'];

    for (int i = 0; i < code.length(); i++) {
      char ch = code.charAt(i);
      printKeypadCombinations(restOfString, combination + ch);
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String str = s.next();

    printKeypadCombinations(str, "");
  }

}

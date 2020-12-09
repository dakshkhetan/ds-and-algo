/* 

Sample Input
78

Sample Output
[tv, tw, tx, uv, uw, ux]

*/

import java.util.*;

public class Main {

  public static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

  public static ArrayList<String> keypadCombination(String str) {
    if (str.length() == 0) {
      ArrayList<String> baseCase = new ArrayList<String>();
      baseCase.add("");
      return baseCase;
    }

    char firstChar = str.charAt(0);
    String restOfString = str.substring(1);

    ArrayList<String> recursionResult = keypadCombination(restOfString);
    ArrayList<String> combinations = new ArrayList<>();

    String code = codes[firstChar - '0'];
    for (int i = 0; i < code.length(); i++) {
      char ch = code.charAt(i);
      for (String combination : recursionResult) {
        combinations.add(ch + combination);
      }
    }

    // for (char ch : codes[firstChar - '0'].toCharArray()) {
    //   for (String combination : recursionResult) {
    //     combinations.add(ch + combination);
    //   }
    // }

    return combinations;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String str = s.next();

    ArrayList<String> output = keypadCombination(str);
    System.out.println(output);
  }

}

/*

Sample Input:
pep

Sample Output:
pep
pe1
p1p
p2
1ep
1e1
2p
3

*/

import java.util.*;

public class Main {

  public static void printAllAbbreviations(String str) {
    printAllAbbreviations(str, "", 0, 0);
  }

  private static void printAllAbbreviations(String str, String abbreviationSoFar, int count, int index) {
    if (index == str.length()) {
      if (count != 0) {
        System.out.println(abbreviationSoFar + count);
      } else {
        System.out.println(abbreviationSoFar);
      }

      return;
    }

    // include current character in abbreviation
    if (count != 0) {
      printAllAbbreviations(str, abbreviationSoFar + count + str.charAt(index), 0, index + 1);
    } else {
      printAllAbbreviations(str, abbreviationSoFar + str.charAt(index), count, index + 1);
    }

    // NOT include current character in abbreviation
    printAllAbbreviations(str, abbreviationSoFar, count + 1, index + 1);
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    String str = s.nextLine();

    printAllAbbreviations(str);
  }

}

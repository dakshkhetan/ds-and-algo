/*

Sample Input
pepCODinG

Sample Output
p-11e11p-45C12O-11D37i5n-39G

*/

import java.util.*;

public class Main {

  public static String consecutiveCharactersDifference(String str) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
      if (i + 1 < str.length()) {
        int diff = str.charAt(i + 1) - str.charAt(i);
        sb.append(str.charAt(i));
        sb.append(diff);
      } else {
        sb.append(str.charAt(i));
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String str = s.next();

    System.out.println(consecutiveCharactersDifference(str));
  }

}

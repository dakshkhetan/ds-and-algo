/*

Reference Video - https://youtu.be/K5xJXbnYMBc

Sample Input
abc

Sample Output
abc
acb
bac
bca
cab
cba

*/

import java.util.*;

public class Main {

  public static void printPermutations(String str, String permutation) {
    if (str.length() == 0) {
      System.out.println(permutation);
      return;
    }

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      String restOfString = str.substring(0, i) + str.substring(i + 1);
      printPermutations(restOfString, permutation + ch);
    }

    // for (int i = 0; i < str.length(); i++) {
    //   char ch = str.charAt(i);
    //   StringBuilder sb = new StringBuilder(str);
    //   sb.deleteCharAt(i);
    //   String restOfString = sb.toString();
    //   printPermutations(restOfString, permutation + ch);
    // }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String str = s.next();

    printPermutations(str, "");
  }

}

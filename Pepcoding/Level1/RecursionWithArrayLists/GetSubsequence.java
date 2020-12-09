/* 

Sample Input
abc

Sample Output
[, c, b, bc, a, ac, ab, abc]

*/

import java.util.*;

public class Main {

  public static ArrayList<String> getSubsequence(String str) {
    if (str.length() == 0) {
      ArrayList<String> al = new ArrayList<>();
      al.add("");
      return al;
    }

    char firstChar = str.charAt(0);
    String restOfString = str.substring(1);

    ArrayList<String> smallAns = getSubsequence(restOfString);
    ArrayList<String> subsequences = new ArrayList<>();

    // for (String ss : smallAns) {
    //   subsequences.add(ss);
    //   subsequences.add(firstChar + ss);
    // }

    for (String ss : smallAns) {
      subsequences.add(ss);
    }
    for (String ss : smallAns) {
      subsequences.add(firstChar + ss);
    }

    return subsequences;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String str = s.next();

    ArrayList<String> output = getSubsequence(str);
    System.out.println(output);
  }

}

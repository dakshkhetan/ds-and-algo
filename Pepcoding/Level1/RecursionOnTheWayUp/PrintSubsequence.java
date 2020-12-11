/* 

Sample Input
yvTA

Sample Output
yvTA
yvT
yvA
yv
yTA
yT
yA
y
vTA
vT
vA
v
TA
T
A


*/

import java.util.*;

public class Main {

  public static void printSubsequence(String str, String result) {
    if (str.length() == 0) {
      System.out.println(result);
      return;
    }

    char ch = str.charAt(0);
    String restOfString = str.substring(1);

    printSubsequence(restOfString, result + ch);
    printSubsequence(restOfString, result + "");
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String str = s.next();

    printSubsequence(str, "");
  }

}

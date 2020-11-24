/* 

Sample Input
5 3 4

Sample Output
true

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int a = s.nextInt();
    int b = s.nextInt();
    int c = s.nextInt();

    int max = a;
    if (b > max) {
      max = b;
    }
    if (c > max) {
      max = c;
    }

    if (max == a) {
      if (a * a == (b * b + c * c)) {
        System.out.println(true);
      } else {
        System.out.println(false);
      }
    } else if (max == b) {
      boolean check = (b * b == (a * a + c * c));
      System.out.println(check);
    } else {
      boolean check = (c * c == (a * a + b * b));
      System.out.println(check);
    }
  }
}

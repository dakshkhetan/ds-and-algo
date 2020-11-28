/* 

Sample Input
8
1
100

Sample Output
77

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    int d = getDifference(b, n1, n2);
    System.out.println(d);
  }

  public static int getDifference(int b, int n1, int n2) {
    int ans = 0;
    int p = 0;
    int carry = 0;

    while (n2 > 0) {
      int d1 = n1 % 10;
      int d2 = n2 % 10;

      d2 = d2 + carry;
      int unit = 0;

      if (d2 >= d1) {
        carry = 0;
        unit = d2 - d1;
      } else {
        carry = -1;
        unit = d2 + b - d1;
      }

      ans += unit * Math.pow(10, p++);

      n1 /= 10;
      n2 /= 10;
    }

    return ans;
  }
}

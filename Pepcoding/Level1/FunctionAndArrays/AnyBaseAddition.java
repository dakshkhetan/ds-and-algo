/* 

Sample Input
8
777
1

Sample Output
1000

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    int d = getSum(b, n1, n2);
    System.out.println(d);
  }

  public static int getSum(int b, int n1, int n2) {
    int ans = 0;
    int p = 0;
    int carry = 0;

    while (n1 != 0 || n2 != 0) {
      int d1 = n1 % 10;
      int d2 = n2 % 10;

      int sum = d1 + d2 + carry;
      int unit = sum % b;
      carry = sum / b;

      ans += unit * Math.pow(10, p++);
      
      n1 /= 10;
      n2 /= 10;
    }

    if (carry != 0) {
      ans += carry * Math.pow(10, p++);
    }

    return ans;
  }
}

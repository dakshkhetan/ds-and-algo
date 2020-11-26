/* 

Sample Input
111001
2
3

Sample Output
2010

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int num = scn.nextInt();
    int b1 = scn.nextInt();
    int b2 = scn.nextInt();

    // base b1 to decimal
    int p = 0;
    int n = num;
    int ans = 0;
    while (n != 0) {
      int r = n % 10;
      n /= 10;
      ans += r * Math.pow(b1, p++);
    }

    // decimal to base b2
    p = 0;
    n = ans;
    ans = 0;
    while (n != 0) {
      int r = n % b2;
      n /= b2;
      ans += r * Math.pow(10, p++);
    }

    System.out.println(ans);
  }
}

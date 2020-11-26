/* 

Sample Input
57
2

Sample Output
111001

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int b = scn.nextInt();

    int p = 0, ans = 0;

    while (n != 0) {
      int r = n % b;
      n /= b;
      ans += r * Math.pow(10, p++);
    }

    System.out.println(ans);
  }
}

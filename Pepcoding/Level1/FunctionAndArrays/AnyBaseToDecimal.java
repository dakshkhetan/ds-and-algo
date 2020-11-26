/* 

Sample Input
111001
2

Sample Output
57

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int b = scn.nextInt();

    int p = 0, ans = 0;

    while (n != 0) {
      int r = n % 10;
      n /= 10;
      ans += r * Math.pow(b, p++);
    }

    System.out.println(ans);
  }
}

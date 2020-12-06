/* 

Sample Input
2
5

Sample Output
32

*/

import java.util.*;

public class Main {

  // Time Complexity: O(log(n))
  public static int powerLogarithmic(int x, int n) {
    if (n == 0) {
      return 1;
    }

    if (n == 1) {
      return x;
    }

    int smallAns = powerLogarithmic(x, n / 2);
    int ans = smallAns * smallAns;

    if (n % 2 != 0) {
      ans = ans * x;
    }

    return ans;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int x = s.nextInt();
    int n = s.nextInt();
    System.out.println(powerLogarithmic(x, n));
  }

}

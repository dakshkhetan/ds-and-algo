/* 

Sample Input
2
5

Sample Output
32

*/

import java.util.*;

public class Main {

  // Time Complexity: O(n)
  public static int powerLinear(int x, int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return x;
    }
    int smallAns = x * powerLinear(x, n - 1);
    return smallAns;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int x = s.nextInt();
    int n = s.nextInt();
    System.out.println(powerLinear(x, n));
  }

}

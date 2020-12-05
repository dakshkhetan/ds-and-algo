/* 

Sample Input
5

Sample Output
120

*/

import java.util.*;

public class Main {

  public static int factorial(int n) {
    if (n == 1) {
      return 1;
    }
    int smallAns = n * factorial(n - 1);
    return smallAns;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    System.out.println(factorial(n));
  }

}

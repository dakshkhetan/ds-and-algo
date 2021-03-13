/*

Sample Input
1440

Sample Output
2 2 2 2 2 3 3 5

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    for (int div = 2; div <= Math.sqrt(n); div++) {
      while (n % div == 0) {
        System.out.print(div + " ");
        n /= div;
      }
    }

    // special case (eg: 23)
    if (n != 1) {
      System.out.print(n);
    }
  }

}

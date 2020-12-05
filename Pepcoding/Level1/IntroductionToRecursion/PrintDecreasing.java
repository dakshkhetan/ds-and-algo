/* 

Sample Input
5

Sample Output
5
4
3
2
1

*/

import java.util.*;

public class Main {

  public static void printDecreasing(int n) {
    if (n == 0) {
      return;
    }

    System.out.println(n);
    printDecreasing(n - 1);
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    printDecreasing(n);
  }

}

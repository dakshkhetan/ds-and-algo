/* 

Sample Input
3

Sample Output
3 2 1 1 1 2 1 1 1 2 3 2 1 1 1 2 1 1 1 2 3

*/

import java.util.*;

public class Main {

  public static void printZigZag(int n) {
    if (n == 0) {
      return;
    }

    // if (n == 1) {
    //   System.out.print("1 1 1 ");
    //   return;
    // }

    System.out.print(n + " ");
    printZigZag(n - 1);
    System.out.print(n + " ");
    printZigZag(n - 1);
    System.out.print(n + " ");
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    printZigZag(n);
  }

}

/* 

Sample Input
65784383

Sample Output
3
8
3
4
8
7
5
6

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    while (n > 0) {
      int digit = n % 10;
      System.out.println(digit);
      n /= 10;
    }
  }
}

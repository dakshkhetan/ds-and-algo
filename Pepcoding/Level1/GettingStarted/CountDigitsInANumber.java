/* 

Sample Input
65784383

Sample Output
8

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    int count = 0;
    while (n > 0) {
      n = n / 10;
      count++;
    }

    System.out.println(count);
  }
}

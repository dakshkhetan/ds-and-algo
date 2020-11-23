/* 

Sample Input
426135

Sample Output
416253

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    int inverse = 0;
    int position = 1;

    while (n > 0) {
      int digit = n % 10;
      int multiplier = (int) Math.pow(10, digit - 1);
      inverse += (position++ * multiplier);
      n /= 10;
    }

    System.out.println(inverse);
  }
}

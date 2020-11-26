/* 

Sample Input
994543234
4

Sample Output
3

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int d = scn.nextInt();
    int f = getDigitFrequency(n, d);
    System.out.println(f);
  }

  public static int getDigitFrequency(int n, int d) {
    int freq = 0;
    while (n > 0) {
      int digit = n % 10;
      if (digit == d) {
        freq++;
      }
      n /= 10;
    }
    return freq;
  }
  
}

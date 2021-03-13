/*

Reference Video - https://youtu.be/39SKIuA-ieY

Sample Input
abc

Sample Output
abc
bac
cab
acb
bca
cba

*/

import java.util.*;

public class Main {

  public static void printAllPermutations(String str) {
    int n = str.length();
    int limit = factorial(n);

    for (int i = 0; i < limit; i++) {
      StringBuilder sb = new StringBuilder(str);
      int num = i;
      for (int div = n; div >= 1; div--) {
        int index = num % div;
        num /= div;
        System.out.print(sb.charAt(index));
        sb.deleteCharAt(index);
      }
      System.out.println();
    }
  }

  private static int factorial(int n) {
    int fact = 1;
    while (n > 0) {
      fact *= n;
      n--;
    }
    return fact;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String str = s.next();

    printAllPermutations(str);
  }

}

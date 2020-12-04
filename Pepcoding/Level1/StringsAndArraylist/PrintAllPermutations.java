import java.util.*;

/*

Input:
abc

Output:
abc
bac
cab
acb
bca
cba 

*/

public class PrintAllPermutations {

  public static void printAllPermutations(String str) {
    int n = str.length();
    int limit = factorial(n);

    for (int i = 0; i < limit; i++) {
      StringBuilder sb = new StringBuilder(str);
      int temp = i;
      for (int div = n; div >= 1; div--) {
        int index = temp % div;
        System.out.print(sb.charAt(index));
        sb.deleteCharAt(index);
        temp /= div;
      }
      System.out.println();
    }
  }

  public static int factorial(int n) {
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
/* 

Sample Input
562984
2

Sample Output
845629

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int k = s.nextInt();

    int noOfDigits = 0;

    int temp = n;
    while (temp > 0) {
      noOfDigits++;
      temp /= 10;
    }

    k = k % noOfDigits;

    if (k < 0) {
      k = noOfDigits + k;
    }

    int divisor = (int) Math.pow(10, k);
    int multiplier = (int) (Math.pow(10, noOfDigits - k));

    int quotient = n / divisor;
    int remainder = n % divisor;

    int x = remainder * multiplier;
    int ans = x + quotient;

    System.out.println(ans);
  }
}

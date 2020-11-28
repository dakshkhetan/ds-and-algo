/* 

Sample Input
5
1220
31

Sample Output
43320

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int b = s.nextInt();
    int n1 = s.nextInt();
    int n2 = s.nextInt();

    int d = getProduct(b, n1, n2);
    System.out.println(d);
  }

  public static int getProduct(int b, int n1, int n2) {
    int ans = 0;
    int p = 0;

    while (n2 > 0) {
      int d2 = n2 % 10;

      int singleDigitFromN2Product = getProductCorrespondingToSingleDigit(b, n1, d2);
      ans = getSum(b, ans, singleDigitFromN2Product * (int) Math.pow(10, p++));

      n2 /= 10;
    }

    return ans;
  }

  public static int getProductCorrespondingToSingleDigit(int b, int n1, int d2) {
    int ans = 0;
    int carry = 0;
    int p = 0;

    while (n1 > 0 || carry > 0) {
      int d1 = n1 % 10;

      int product = (d1 * d2) + carry;

      int unit = product % b;
      carry = product / b;
      ans += unit * Math.pow(10, p++);

      n1 /= 10;
    }

    return ans;
  }

  public static int getSum(int b, int n1, int n2) {
    int ans = 0;
    int p = 0;
    int carry = 0;

    while (n1 != 0 || n2 != 0) {
      int d1 = n1 % 10;
      int d2 = n2 % 10;

      int sum = d1 + d2 + carry;
      int unit = sum % b;
      carry = sum / b;

      ans += unit * Math.pow(10, p++);

      n1 /= 10;
      n2 /= 10;
    }

    if (carry != 0) {
      ans += carry * Math.pow(10, p++);
    }

    return ans;
  }
}

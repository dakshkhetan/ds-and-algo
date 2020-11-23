/* 

Sample Input
65784383

Sample Output
6
5
7
8
4
3
8
3

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {

    // Approach 1:
    
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    int num = n;
    int noOfDigits = 0;

    while (n > 0) {
      n = n / 10;
      noOfDigits++;
    }

    int divisor = (int) Math.pow(10, noOfDigits - 1);

    n = num;
    while (divisor != 0) {
      int leftMostDigit = n / divisor;
      System.out.println(leftMostDigit);
      n = n % divisor;
      divisor /= 10;
    }

    // while (n > 0) {
    //   int leftMostDigit = n / divisor;
    //   System.out.println(leftMostDigit);
    //   n = n % divisor;
    //   divisor /= 10;
    // }

    // if (num % 10 == 0) {
    //   System.out.println(0);
    // }

    
    
    // Approach 2:

    // Scanner s = new Scanner(System.in);
    // int n = s.nextInt();

    // int power = 1;
    // int temp = n;
    // while (temp >= 10) {
    //   temp /= 10;
    //   power *= 10;
    // }

    // temp = n;
    // while (power != 0) {
    //   int digit = temp / power;
    //   System.out.println(digit);

    //   temp = temp % power;
    //   power = power / 10;
    // }
  }
}

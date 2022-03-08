/* 

Reference Video - https://youtu.be/ZtDeDD1VYLk

Sample Input
36
24

Sample Output
12
72

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int num1 = s.nextInt();
    int num2 = s.nextInt();

    int n1 = num1;
    int n2 = num2;

    while (n1 % n2 != 0) {
      int r = n1 % n2;
      n1 = n2;
      n2 = r;
    }

    int hcf = n2;
    int lcm = (num1 * num2) / hcf;

    System.out.println(hcf);
    System.out.println(lcm);
  }
}

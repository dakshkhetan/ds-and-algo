/* 

Sample Input
5

Sample Output
1
2
3
4
5

*/

import java.util.*;

public class Main {

  public static void printIncreasing(int n) {
    if (n == 0) {
      return;
    }
    
    printIncreasing(n - 1);
    System.out.println(n);
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    printIncreasing(n);
  }

}

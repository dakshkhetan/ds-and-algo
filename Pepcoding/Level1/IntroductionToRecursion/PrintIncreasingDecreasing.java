/* 

Sample Input
3

Sample Output
3
2
1
1
2
3

*/

import java.util.*;

public class Main {
    
  public static void printDecreasingIncreasing(int n) {
    if(n == 0){
      return;
    }
    
    System.out.println(n);
    printDecreasingIncreasing(n - 1);
    System.out.println(n);
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    printDecreasingIncreasing(n);
  }

}

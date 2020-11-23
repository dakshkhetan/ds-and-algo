import java.util.*;

/* 

Sample Input
6 
24

Sample Output
7
11
13
17
19
23

*/

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int start = s.nextInt();
    int end = s.nextInt();
    for (int n = start; n <= end; n++) {
      boolean flag = false;
      for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) {
          flag = true;
          break;
        }
      }
      if (!flag) {
        System.out.println(n);
      }
    }
  }

}

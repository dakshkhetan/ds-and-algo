/* 

Sample Input
3

Sample Output
111
12
21
3

*/

import java.util.*;

public class Main {

  public static void printStairPaths(int n, String path) {
    // if (n <= 0) {
    //   if (n == 0) {
    //     System.out.println(path);
    //   }
    //   return;
    // }

    if (n < 0) {
      return;
    }

    if (n == 0) {
      System.out.println(path);
      return;
    }

    printStairPaths(n - 1, path + "1");
    printStairPaths(n - 2, path + "2");
    printStairPaths(n - 3, path + "3");
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    printStairPaths(n, "");
  }

}

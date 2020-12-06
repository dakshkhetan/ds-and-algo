/* 

Sample Input
3
10
11
12

Sample Output
1[10 -> 11]
2[10 -> 12]
1[11 -> 12]
3[10 -> 11]
1[12 -> 10]
2[12 -> 11]
1[10 -> 11]

*/

import java.util.*;

public class Main {

  public static void towerOfHanoi(int n, int src, int dest, int aux) {
    if (n == 0) {
      return;
    }

    // if (n == 1) {
    //   System.out.println(n + "[" + src + " -> " + dest + "]");
    //   return;
    // }

    towerOfHanoi(n - 1, src, aux, dest); // src -> aux
    System.out.println(n + "[" + src + " -> " + dest + "]"); // nth plate from src -> dest
    towerOfHanoi(n - 1, aux, dest, src); // aux -> dest
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int src = s.nextInt();
    int dest = s.nextInt();
    int aux = s.nextInt();
    towerOfHanoi(n, src, dest, aux);
  }

}

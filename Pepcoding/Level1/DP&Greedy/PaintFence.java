/*

Sample Input
6
4

Sample Output
3276

*/

import java.util.*;

public class Main {

  public static int paintFence(int n, int k) {
    // n = number of fences
    // k = number of paints

    if (n == 1) {
      return k;
    }

    // n = 2
    int sameColorCount = k * 1;
    int diffColorCount = k * (k - 1);
    int totalCount = sameColorCount + diffColorCount;

    for (int i = 3; i <= n; i++) {
      sameColorCount = diffColorCount * 1;
      diffColorCount = totalCount * (k - 1);
      totalCount = sameColorCount + diffColorCount;
    }

    return totalCount;
  }

  public static int paintFence2(int n, int k) {
    // n = 1
    int sameColorCount = 0;
    int diffColorCount = k;
    int totalCount = sameColorCount + diffColorCount;

    for (int i = 2; i <= n; i++) {
      sameColorCount = diffColorCount * 1;
      diffColorCount = totalCount * (k - 1);
      totalCount = sameColorCount + diffColorCount;
    }

    return totalCount;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int k = s.nextInt();

    int result = paintFence(n, k);
    // int result = paintFence2(n, k);
    System.out.println(result);
  }

}

/*

Sample Input
6

Sample Output
21

*/

import java.util.*;

public class Main {

  public static int countBinaryStrings(int n) {
    int oldZeroes = 1;
    int oldOnes = 1;

    for (int i = 2; i <= n; i++) {
      int newZeroes = oldOnes;
      int newOnes = oldZeroes + oldOnes;

      oldZeroes = newZeroes;
      oldOnes = newOnes;
    }

    int totalCount = oldZeroes + oldOnes;
    return totalCount;
  }

  public static int countBinaryStringsUsingArray(int n) {
    int dp_zeroes[] = new int[n + 1];
    int dp_ones[] = new int[n + 1];

    dp_zeroes[0] = 0;
    dp_ones[0] = 0;

    dp_zeroes[1] = 1;
    dp_ones[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp_zeroes[i] = dp_ones[i - 1];
      dp_ones[i] = dp_zeroes[i - 1] + dp_ones[i - 1];
    }

    int totalCount = dp_zeroes[n] + dp_ones[n];
    return totalCount;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();

    int result = countBinaryStrings(n);
    // int result = countBinaryStringsUsingArray(n);
    System.out.println(result);
  }

}

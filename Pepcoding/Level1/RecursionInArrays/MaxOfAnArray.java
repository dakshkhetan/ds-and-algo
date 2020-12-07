/* 

Sample Input
6
15
30
40
4
11
9

Sample Output
40

*/

import java.util.*;

public class Main {

  public static int maxOfArray(int[] arr, int idx) {
    if (idx == arr.length - 1) {
      return arr[idx];
    }

    int smallAns = maxOfArray(arr, idx + 1);
    int max = Math.max(arr[idx], smallAns);
    return max;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int arr[] = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    System.out.println(maxOfArray(arr, 0));
  }

}

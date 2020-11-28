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
36

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int arr[] = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int max = arr[0];
    int min = arr[0];

    for (int i = 1; i < n; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
      if (arr[i] < min) {
        min = arr[i];
      }
    }

    System.out.println(max - min);
  }
}

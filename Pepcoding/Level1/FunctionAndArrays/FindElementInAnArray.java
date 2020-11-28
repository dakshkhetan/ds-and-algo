/* 

Sample Input
6
15
30
40
4
11
9
40

Sample Output
2

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

    int element = s.nextInt();

    int index = -1;

    for (int i = 0; i < n; i++) {
      if (arr[i] == element) {
        index = i;
        break;
      }
    }

    System.out.println(index);
  }
}

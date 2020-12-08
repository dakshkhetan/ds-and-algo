/* 

Sample Input
6
15
11
40
4
4
9
4

Sample Output
4

*/

import java.util.*;

public class Main {

  public static int lastIndex(int[] arr, int index, int element) {
    if (index == arr.length) {
      return -1;
    }

    int smallAns = lastIndex(arr, index + 1, element);

    if (smallAns == -1) {
      if (arr[index] == element) {
        return index;
      } else {
        return -1;
      }
    } else {
      return smallAns;
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int arr[] = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int element = s.nextInt();

    System.out.println(lastIndex(arr, 0, element));
  }

}

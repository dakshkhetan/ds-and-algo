/* 

Sample Input
4
11
12
13
14
21
22
23
24
31
32
33
34
41
42
43
44
43

Sample Output
3
2

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int arr[][] = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = s.nextInt();
      }
    }

    int element = s.nextInt();

    searchElementInSortedMatrix(arr, element);

  }

  public static void searchElementInSortedMatrix(int[][] arr, int element) {
    int n = arr.length;

    // beginning from top-right corner of matrix:
    int i = 0;
    int j = n - 1;

    while (i < n && j >= 0) {
      if (arr[i][j] == element) {
        System.out.println(i);
        System.out.println(j);
        return;
      } else if (arr[i][j] < element) {
        i++;
      } else {
        j--;
      }
    }

    System.out.println("Not Found");
  }

}

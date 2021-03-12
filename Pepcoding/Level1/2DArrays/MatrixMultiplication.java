/* 

Sample Input
2 3
10 0 0
0 20 0
3 4
1 0 1 0
0 1 1 2
1 1 0 0

Sample Output
10 0 10 0
0 20 20 40

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int m1 = s.nextInt();
    int n1 = s.nextInt();

    int arr1[][] = new int[m1][n1];
    for (int i = 0; i < m1; i++) {
      for (int j = 0; j < n1; j++) {
        arr1[i][j] = s.nextInt();
      }
    }

    int m2 = s.nextInt();
    int n2 = s.nextInt();

    int arr2[][] = new int[m2][n2];
    for (int i = 0; i < m2; i++) {
      for (int j = 0; j < n2; j++) {
        arr2[i][j] = s.nextInt();
      }
    }

    if (n1 != m2) {
      System.out.println("Invalid input");
      return;
    }

    int arr3[][] = new int[m1][n2];

    for (int i = 0; i < m1; i++) {
      for (int j = 0; j < n2; j++) {
        arr3[i][j] = 0;
        for (int k = 0; k < n1; k++) {
          arr3[i][j] += arr1[i][k] * arr2[k][j];
        }
      }
    }

    for (int i = 0; i < arr3.length; i++) {
      for (int j = 0; j < arr3[0].length; j++) {
        System.out.print(arr3[i][j] + " ");
      }
      System.out.println();
    }
  }
  
}

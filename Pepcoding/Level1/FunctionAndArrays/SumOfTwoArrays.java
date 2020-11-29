/* 

Sample Input
5
3
1
0
7
5
6
1
1
1
1
1
1

Sample Output
1
4
2
1
8
6

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n1 = s.nextInt();
    int arr1[] = new int[n1];
    for (int i = 0; i < n1; i++) {
      arr1[i] = s.nextInt();
    }

    int n2 = s.nextInt();
    int arr2[] = new int[n2];
    for (int i = 0; i < n2; i++) {
      arr2[i] = s.nextInt();
    }

    int n3 = Math.max(n1, n2);
    int arr3[] = new int[n3];
    int carry = 0;
    int i = n1 - 1, j = n2 - 1, k = n3 - 1;

    while (i >= 0 || j >= 0) {
      int sum = carry;

      if (i >= 0) {
        sum += arr1[i];
      }

      if (j >= 0) {
        sum += arr2[j];
      }

      arr3[k--] = sum % 10;
      carry = sum / 10;

      i--;
      j--;
    }

    if (carry > 0) {
      System.out.println(carry);
    }

    for (i = 0; i < n3; i++) {
      System.out.println(arr3[i]);
    }
  }
}

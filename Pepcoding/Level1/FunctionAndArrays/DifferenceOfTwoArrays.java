/* 

Sample Input
3
2
6
7
4
1
0
0
0

Sample Output
7
3
3

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

    int n3 = n2;
    int arr3[] = new int[n3];
    int carry = 0;
    int i = n1 - 1, j = n2 - 1, k = n3 - 1;

    while (j >= 0) {
      int diff = arr2[j] + carry;

      // Approach 1:
      int arr1_value = (i >= 0) ? arr1[i] : 0;
      if (diff >= arr1_value) {
        diff = diff - arr1_value;
        carry = 0;
      } else {
        diff = diff + 10 - arr1_value;
        carry = -1;
      }

      // Approach 2:
      // if (i >= 0) {
      //   if (diff >= arr1[i]) {
      //     diff = diff - arr1[i];
      //     carry = 0;
      //   } else {
      //     diff = diff + 10 - arr1[i];
      //     carry = -1;
      //   }
      // } else {
      //   carry = 0;
      // }

      arr3[k--] = diff;

      i--;
      j--;
    }

    // important - skipping preceding zero(s) in arr3
    int index = 0;
    while (index < n3) {
      if (arr3[index] == 0) {
        index++;
      } else {
        break;
      }
    }

    for (int x = index; x < n3; x++) {
      System.out.println(arr3[x]);
    }
  }
}

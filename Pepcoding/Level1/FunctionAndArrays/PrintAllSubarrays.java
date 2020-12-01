/* 

Sample Input
3
10
20
30

Sample Output
10	
10	20	
10	20	30	
20	
20	30	
30	

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

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        for (int k = i; k <= j; k++) {
          System.out.print(arr[k] + "	");
        }
        System.out.println();
      }
    }
  }
}

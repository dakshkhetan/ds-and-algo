/* 

Sample Input
3
10
20
30

Sample Output
-	-	-	
-	-	30	
-	20	-	
-	20	30	
10	-	-	
10	-	30	
10	20	-	
10	20	30	

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

    int subsetCount = (int) Math.pow(2, n);

    for (int i = 0; i < subsetCount; i++) {
      int num = i;
      String subset = "";

      for (int j = n - 1; j >= 0; j--) {
        int r = num % 2;

        if (r == 0) {
          subset = "-" + "	" + subset;
        } else {
          subset = arr[j] + "	" + subset;
        }

        num /= 2;
      }

      System.out.println(subset);
    }
  }
}

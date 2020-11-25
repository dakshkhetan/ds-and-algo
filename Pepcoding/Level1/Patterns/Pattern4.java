/* 

Sample Input
5

Sample Output
*	*	*	*	*	
	*	*	*	*	
		*	*	*	
			*	*	
        *
        
*/

import java.util.*;

public class Main {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    for (int i = 1; i <= n; i++) {
      for (int k = 1; k < i; k++) {
        System.out.print("	");
      }

      for (int j = 1; j <= n - i + 1; j++) {
        System.out.print("*	");
      }
      System.out.println();
    }
  }
}

/*

Sample Input
3

Sample Output
1.(1) (2) (3) 
2.(1) (2,3) 
3.(1,2) (3) 
4.(1,3) (2) 

*/

import java.util.*;

public class Main {

  public static void friendsPairing2(int n) {

    // keep track of used friends
    boolean[] used = new boolean[n + 1];

    // now, begin solving from the first friend i.e. number '1'
    solve(n, used, 1, "");

  }

  static int counter = 1;

  private static void solve(int n, boolean[] used, int index, String resultSoFar) {

    // here, 'index' -> current friend

    // base case
    if (index > n) {
      System.out.println(counter + "." + resultSoFar);
      counter++;
      return;
    }

    // check if the current num (friend) is already used
    // if yes, then solve for next friend
    if (used[index]) {
      solve(n, used, index + 1, resultSoFar);
      return;
    }

    // case 1: remain single and don't pair up with any friend
    used[index] = true;
    solve(n, used, index + 1, resultSoFar + "(" + index + ") ");

    // case 2: pair up with a friend
    for (int i = index + 1; i <= n; i++) { // important: 'i' should start from 'index + 1'
      // 'i' -> friend
      if (!used[i]) {
        used[i] = true;
        solve(n, used, index + 1, resultSoFar + "(" + index + "," + i + ") ");
        used[i] = false;
      }
    }

    // backtrack work corresponding to case 1
    used[index] = false;

  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();

    friendsPairing2(n);
  }

}

/* 

You are given n number of bulbs. They are all switched off. A weird
fluctuation in voltage hits the circuit n times. In the 1st fluctuation all
bulbs are toggled, in the 2nd fluctuation every 2nd bulb is toggled, in the
3rd fluctuation every 3rd bulb is toggled and so on. You've to find which
bulbs will be switched on after n fluctuations.

Sample Input
6

Sample Output
1
4

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    // solution: all perfect squares lying in range 1 to n

    for (int i = 1; i * i <= n; i++) {
      System.out.println(i * i);
    }
  }
}

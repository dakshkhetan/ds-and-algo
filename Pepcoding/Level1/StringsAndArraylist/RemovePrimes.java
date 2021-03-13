/*

Sample Input
4
3 12 13 15

Sample Output
[12, 15]

*/

import java.util.*;

public class Main {

  public static void removePrimes(ArrayList<Integer> arr) {
    // iterate from the back of arraylist
    for (int i = arr.size() - 1; i >= 0; i--) {
      if (isPrime(arr.get(i))) {
        arr.remove(i);
      }
    }
  }

  private static boolean isPrime(int n) {
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    ArrayList<Integer> al = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      al.add(s.nextInt());
    }

    removePrimes(al);
    System.out.println(al);
  }

}

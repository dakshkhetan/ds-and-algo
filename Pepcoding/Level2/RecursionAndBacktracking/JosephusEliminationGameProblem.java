/*

Reference Video - https://youtu.be/dzYq5VEMZIg

Sample Input:
5
3

Sample Output:
3

*/

import java.util.*;

public class Main {

  public static int josephusProblem(int n, int k) {
    // return josephusProblemBruteForce(n, k);
    return josephusProblemConstantSpace(n, k);
  }

  // Time Complexity: O(n)
  // Space Complexity: O(n)

  public static int josephusProblemBruteForce(int n, int k) {

    // create an arraylist or a linkedlist containing 'n' elements
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(i);
    }

    // Important: pass 'k - 1' inside function
    return josephusProblemBruteForce(list, k - 1, 0);
  }

  private static int josephusProblemBruteForce(List<Integer> list, int k, int start) {

    // if size of list is one then,
    // return its value (i.e. index)
    if (list.size() == 1) {
      return list.get(0);
    }

    // update start point of list to k'th element
    start = (start + k) % list.size();

    // remove the k'th element
    list.remove(start);

    // call recursion for remaining elements
    return josephusProblemBruteForce(list, k, start);
  }

  // Time Complexity: O(n)
  // Space Complexity: O(1)

  public static int josephusProblemConstantSpace(int n, int k) {
    if (n == 1) {
      // if single element is left then, return its index
      // i.e. 0, since we have no other choice to eliminate
      return 0;
    }

    int x = josephusProblemConstantSpace(n - 1, k);
    int y = (x + k) % n;

    // where,
    // x = index of eliminated element from recursion i.e. n - 1 elements
    // y = index of eliminated element from current n elements
    // (refer video for explanation [timestamp -> 11:33])

    return y;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int k = s.nextInt();

    int result = josephusProblem(n, k);
    System.out.println(result);
  }

}

/*

Sample Input 1:
n = 19

Sample Output 1:
true

Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1


Sample Input 2:
n = 4

Sample Output 2:
false

Explanation:
Since it loops endlessly in a cycle which does not include 1.

*/

class Solution {

  public boolean isHappy(int n) {
    return isHappyNumberUsingHashSet(n);
    // return isHappyNumberConstantSpace(n);
  }

  // helper function used in solutions below
  private int getNext(int n) {
    int totalSum = 0;

    while (n > 0) {
      int digit = n % 10;
      totalSum += digit * digit;
      n = n / 10;
    }

    return totalSum;
  }

  // Time Complexity: O(log(N))
  // Space Complexity: O(log(N))
  public boolean isHappyNumberUsingHashSet(int n) {
    Set<Integer> seen = new HashSet<>();

    while (n != 1 && !seen.contains(n)) {
      seen.add(n);
      n = getNext(n);
    }

    return n == 1;
  }

  // Time Complexity: O(log(N))
  // Space Complexity: O(1)
  public boolean isHappyNumberConstantSpace(int n) {
    // Important: '4' is the special case which loops endlessly

    while (n != 1 && n != 4) {
      n = getNext(n);
    }

    return n == 1;
  }

}

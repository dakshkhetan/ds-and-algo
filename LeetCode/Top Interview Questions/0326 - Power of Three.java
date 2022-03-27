/*

Sample Input 1:
n = 27

Sample Output 1:
true


Sample Input 2:
n = 1

Sample Output 2:
true

*/

class Solution {

  public boolean isPowerOfThree(int n) {
    return isPowerOfThreeNaive(n);
    // return isPowerOfThreeOptimal(n);
  }

  // Time Complexity: O(log3(N)) -> no. of divisions (by 3) is given by this logarithm (Important)
  // Space Complexity: O(1)
  public boolean isPowerOfThreeNaive(int n) {
    if (n < 1) {
      return false;
    }

    while (n % 3 == 0) {
      n /= 3;
    }

    return n == 1;
  }

  // Time Complexity: O(1)
  // Space Complexity: O(1)
  public boolean isPowerOfThreeOptimal(int n) {
    /*
     * NOTE: this approach involves complex math,
     * hence feel free to skip.
     * For explanation, refer approach 4 at:
     * https://leetcode.com/problems/power-of-three/solution
     */
    return n > 0 && 1162261467 % n == 0;
  }

}

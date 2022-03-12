/*

Sample Input:
8

Sample Output:
2

Explanation:
The square root of 8 is 2.82842, but return only the decimal part

*/

class Solution {

  public int mySqrt(int x) {
    // return mySqrtBruteForce(x);
    return mySqrtOptimal(x);
  }

  // Time Complexity: O(N^1/2)
  // Space Complexity: O(1)
  public int mySqrtBruteForce(int x) {
    if (x == 0) {
      return x;
    }

    int ans = 0;

    for (int i = 1; i <= x / i; i++) { // i*i <= x can overflow, hence rearrange expression
      ans = i;
    }

    return ans;
  }

  // Time Complexity: O(log(N))
  // Space Complexity: O(1)
  public int mySqrtOptimal(int x) {
    // using binary search algorithm:

    if (x == 0) { // to avoid division by 0
      return 0;
    }

    int start = 1;
    int end = x / 2 + 1; // Important: square-root can only lie in this range

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (mid < x / mid) { // mid * mid < x can overflow, hence rearrange expression
        start = mid + 1;
      } else if (mid > x / mid) { // mid * mid > x
        end = mid - 1;
      } else { // mid * mid == x
        return mid;
      }
    }

    // 'end' will be the largest integer such that: end * end < x
    return end;
  }

}

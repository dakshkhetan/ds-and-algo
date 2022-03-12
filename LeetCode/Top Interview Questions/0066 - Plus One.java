/*

Sample Input 1:
[4,3,2,1]

Sample Output 1:
[4,3,2,2]

Sample Input 2:
[9]

Sample Output 2:
[1,0]

Constraints:
The digits does not contain any leading 0's

*/

class Solution {

  // Time Complexity: O(N)
  // Space Complexity: O(1) -> no extra space required
  public int[] plusOne(int[] digits) {
    int n = digits.length;

    for (int i = n - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      } else {
        digits[i] = 0;
      }
    }

    int result[] = new int[n + 1];
    result[0] = 1;

    return result;
  }

}

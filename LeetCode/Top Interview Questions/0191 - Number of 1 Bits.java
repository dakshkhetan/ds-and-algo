/*

Sample Input 1:
n = 00000000000000000000000000001011

Sample Output 1:
3

Explanation:
The input binary string 00000000000000000000000000001011 has a total of three '1' bits.


Sample Input 2:
n = 11111111111111111111111111111101

Sample Output 2:
31

Explanation:
The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.


Constraints:
The input must be a binary string of length 32.

NOTE: You need to treat 'n' as an unsigned value

*/

class Solution {

  public int hammingWeight(int n) {
    // return hammingWeightDirectMethod(n);
    return hammingWeightBruteForce(n);

    // return hammingWeightBitManipulation1(n);
    // return hammingWeightBitManipulation2(n);
    // return hammingWeightBitManipulation3(n);
  }

  // Time Complexity: O(1)
  // Space Complexity: O(1)
  public int hammingWeightDirectMethod(int n) {
    // here you simply call bitCount method to count no of 1
    int count = Integer.bitCount(n);
    return count;
  }

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  public int hammingWeightBruteForce(int n) {
    // first we need to convert no to binary string
    String str = Integer.toBinaryString(n); // using in-built method

    int count = 0;

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '1') {
        count++;
      }
    }

    return count;
  }

  // Time Complexity: O() ??
  // Space Complexity: O(1)
  public int hammingWeightBitManipulation1(int n) {
    int count = 0;

    while (n != 0) {
      count += (n & 1);
      n = n >>> 1;
    }

    return count;
  }

  public int hammingWeightBitManipulation2(int n) {
    int count = 0;

    for (int i = 0; i < 32; i++) {
      if ((n & 1) == 1) {
        count++;
      }

      // right shift n
      n = n >> 1;
    }

    return count;
  }

  public int hammingWeightBitManipulation3(int n) {
    // using Kerninghan's Algorithm:

    int count = 0;

    while (n != 0) {
      int bitMask = n & -n;
      n -= bitMask;
      count++;
    }

    return count;
  }

}

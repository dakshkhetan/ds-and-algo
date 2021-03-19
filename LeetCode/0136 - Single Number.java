class Solution {

  // If we take XOR (^) of zero and some bit, it will return that bit:
  // a ^ 0 = a

  // If we take XOR of two same bits, it will return 0:
  // a ^ a = 0

  // So we can XOR all bits together to find the unique number:
  // a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b

  // Time complexity : O(n)
  // Space complexity : O(1)

  public int singleNumber(int[] arr) {

    int ans = 0;

    for (int num : arr) {
      ans = ans ^ num;
    }

    return ans;

  }

}

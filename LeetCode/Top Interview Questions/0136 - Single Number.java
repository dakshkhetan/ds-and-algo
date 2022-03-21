/*

Sample Input:
[1,4,2,1,7,7,2]

Sample Output:
4

Constraints:
Each element in the array appears twice except for one element which appears only once.

*/

class Solution {

  public int singleNumber(int[] nums) {
    // return singleNumberBruteForce(nums);
    // return singleNumberHashMap(nums);
    return singleNumberBitManipulation(nums); // optimal
  }

  // Time Complexity: O(N*log(N))
  // Space Complexity: O(1)
  public int singleNumberBruteForce(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 1; i += 2) {
      if (nums[i] != nums[i + 1]) {
        return nums[i];
      }
    }

    return nums[nums.length - 1];
  }

  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public int singleNumberHashMap(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    Map<Integer, Integer> map = new HashMap<>(); // num vs. frequency

    for (int num : nums) {
      // map.put(num, map.getOrDefault(num, 0) + 1);

      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }

    // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //   if (entry.getValue() == 1) {
    //     return entry.getKey();
    //   }
    // }

    for (int num : map.keySet()) {
      if (map.get(num) == 1) {
        return num;
      }
    }

    // unreachable code due to given input contraints
    return 0;
  }

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  public int singleNumberBitManipulation(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    int ans = nums[0];

    for (int i = 1; i < nums.length; i++) {
      ans ^= nums[i]; // using XOR
    }

    return ans;

    /*
     * Approach Explanation:
     * 
     * If we take XOR (^) of zero and some bit, it will return that bit:
     * a ^ 0 = a
     * 
     * If we take XOR of two same bits, it will return 0:
     * a ^ a = 0
     * 
     * So we can XOR all bits together to find the unique number:
     * a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b
     */
  }

}

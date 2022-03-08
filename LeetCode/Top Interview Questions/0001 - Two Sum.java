/*

Sample Input 1:
nums = [2,7,11,15]
target = 9

Sample Output 1:
[0,1]

Explanation:
Because nums[0] + nums[1] == 9, we return [0, 1]


Sample Input 2:
nums = [3,3]
target = 6

Sample Output 2:
[0,1]


Constraints:
Only ONE valid answer exists

*/

class Solution {

  public int[] twoSum(int[] nums, int target) {
    // return twoSumBruteForce(nums, target);
    return twoSumOptimal(nums, target);
  }

  // Time Complexity: O(N^2)
  // Space Complexity: O(1)
  private int[] twoSumBruteForce(int[] nums, int target) {
    int n = nums.length;
    int ans[] = new int[2];

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (nums[i] + nums[j] == target) {
          ans[0] = i;
          ans[1] = j;
          return ans; // no need to check further since only one solution exists
        }
      }
    }

    return ans;
  }

  // Time Complexity: O(N)
  // Space Complexity: O(N)
  private int[] twoSumOptimal(int[] nums, int target) {
    int n = nums.length;
    int ans[] = new int[2];
    Map<Integer, Integer> map = new HashMap<>(); // num vs. its index

    for (int i = 0; i < n; i++) {
      int currentNum = nums[i];
      int difference = target - currentNum;

      if (map.containsKey(difference)) {
        ans[1] = i;
        ans[0] = map.get(difference);
        return ans; // no need to check further since only one solution exists
      }

      map.put(currentNum, i);
    }

    return ans;
  }

}

/*

Sample Input:
nums = [1,1,1,3,3,4,3,2,4,2]

Sample Output:
true

*/

class Solution {

  public boolean containsDuplicate(int[] nums) {
    return containsDuplicateUsingHashSet(nums);
    // return containsDuplicateUsingSorting(nums);
  }

  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public boolean containsDuplicateUsingHashSet(int[] nums) {
    Set<Integer> set = new HashSet<>();

    for (int num : nums) {
      if (set.contains(num)) {
        return true;
      }

      set.add(num);
    }

    return false;
  }

  // Time Complexity: O(N*log(N))
  // Space Complexity: O(1)
  public boolean containsDuplicateUsingSorting(int[] nums) {
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        return true;
      }
    }

    return false;
  }

}

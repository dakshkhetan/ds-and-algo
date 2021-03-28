/*

Reference Video - https://youtu.be/RIn3gOkbhQE

Sample Input:
nums = [1,2,2]

Sample Output:
[[],[1],[1,2],[1,2,2],[2],[2,2]]

*/

class Solution {

  // Time Complexity: O(N*logN) + O(2^N * N)
  // Space Complexity: O(2^N * Avg length of each subset)

  public List<List<Integer>> subsetsWithDup(int[] nums) {

    // sort the given array first to identify duplicate elements
    Arrays.sort(nums);

    List<List<Integer>> subsets = new ArrayList<>();
    backtrack(nums, subsets, new ArrayList<>(), 0);
    return subsets;

  }

  private void backtrack(int[] nums, List<List<Integer>> subsets, List<Integer> currentSubset, int startIndex) {

    subsets.add(new ArrayList<>(currentSubset));

    for (int i = startIndex; i < nums.length; i++) {
      if (i != startIndex && nums[i] == nums[i - 1]) {
        continue; // skip duplicates
      }

      currentSubset.add(nums[i]);
      backtrack(nums, subsets, currentSubset, i + 1);
      currentSubset.remove(currentSubset.size() - 1);
    }

  }

}

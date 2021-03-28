/*

Reference Video - https://youtu.be/taIvqOIT3cM

Sample Input:
nums = [1,2,3]

Sample Output:
[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

*/

class Solution {

  public List<List<Integer>> subsets(int[] nums) {
    return subsetsBacktracking(nums);
    // return subsetsBacktrackingAlternate(nums);
    // return subsetsUsingBitMasking(nums);
  }


  public List<List<Integer>> subsetsBacktracking(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    backtrack(nums, subsets, new ArrayList<>(), 0);
    return subsets;
  }

  private void backtrack(int[] nums, List<List<Integer>> subsets, List<Integer> currentSubset, int startIndex) {

    if (startIndex == nums.length) {
      subsets.add(new ArrayList<>(currentSubset));
      return;
    }

    // including current num in subset
    currentSubset.add(nums[startIndex]);
    backtrack(nums, subsets, currentSubset, startIndex + 1);

    // NOT including current num in subset
    currentSubset.remove(currentSubset.size() - 1);
    backtrack(nums, subsets, currentSubset, startIndex + 1);

  }


  // same principle approach as above, but different way of writing code
  public List<List<Integer>> subsetsBacktrackingAlternate(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    _backtrack(nums, subsets, new ArrayList<>(), 0);
    return subsets;
  }

  private void _backtrack(int[] nums, List<List<Integer>> subsets, List<Integer> currentSubset, int startIndex) {

    subsets.add(new ArrayList<>(currentSubset));

    for (int i = startIndex; i < nums.length; i++) {
      currentSubset.add(nums[i]);
      _backtrack(nums, subsets, currentSubset, i + 1);
      currentSubset.remove(currentSubset.size() - 1);
    }

  }


  public List<List<Integer>> subsetsUsingBitMasking(int[] nums) {

    List<List<Integer>> subsets = new ArrayList<>();

    int n = nums.length;
    int totalSubsets = 1 << n;
    int i = 0;

    while (i < totalSubsets) {
      int current = i;
      int pos = 0;
      List<Integer> currentSubset = new ArrayList<>();

      while (current != 0) {
        if ((current & 1) == 1) {
          currentSubset.add(nums[pos]);
        }

        current = current >> 1;
        pos++;
      }

      subsets.add(currentSubset);
      i++;
    }

    return subsets;

  }

}

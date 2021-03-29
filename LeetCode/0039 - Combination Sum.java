/*

Reference Video - https://youtu.be/OyZFFqQtu98

Sample Input:
candidates = [2,3,6,7]
target = 7

Sample Output:
[[2,2,3],[7]]

Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7.
Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

*/

class Solution {

  // Time Complexity: O(2^t * k) // refer video
  // Space Complexity: O(k * x)
  // where,
  // t = target
  // k = avg. length of each combination
  // x = total no. of combinations

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    return combinationSum1(candidates, target); // easy
    // return combinationSum2(candidates, target); // similar but generic to other backtracking problems
  }


  public List<List<Integer>> combinationSum1(int[] candidates, int target) {
    List<List<Integer>> combinations = new ArrayList<>();
    traverse(candidates, combinations, new ArrayList<>(), target, 0);
    return combinations;
  }

  private void traverse(int[] nums, List<List<Integer>> combinations, List<Integer> currentCombination,
      int remainingTarget, int startIndex) {

    if (remainingTarget == 0) {
      combinations.add(new ArrayList<>(currentCombination));
      return;
    }

    if (startIndex == nums.length) {
      if (remainingTarget == 0) {
        combinations.add(new ArrayList<>(currentCombination));
      }
      return;
    }

    // check if current num is not greater than remaining target
    if (nums[startIndex] <= remainingTarget) {
      // include the current num into combination
      currentCombination.add(nums[startIndex]);

      // Important: don't increment 'startIndex' since
      // we can pick same element multiple times
      traverse(nums, combinations, currentCombination, remainingTarget - nums[startIndex], startIndex);

      // now, remove the current num from combination
      currentCombination.remove(currentCombination.size() - 1);
    }

    // NOT include the current num into combination
    traverse(nums, combinations, currentCombination, remainingTarget, startIndex + 1);

  }


  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> combinations = new ArrayList<>();
    _traverse(candidates, combinations, new ArrayList<>(), target, 0);
    return combinations;
  }

  private void _traverse(int[] nums, List<List<Integer>> combinations, List<Integer> currentCombination,
      int remainingTarget, int startIndex) {

    if (remainingTarget < 0) {
      return;
    }

    if (remainingTarget == 0) {
      combinations.add(new ArrayList<>(currentCombination));
      return;
    }

    for (int i = startIndex; i < nums.length; i++) {
      // include the current num into combination
      currentCombination.add(nums[i]);

      // Important: don't increment 'i' because we can pick the same element multiple times
      _traverse(nums, combinations, currentCombination, remainingTarget - nums[i], i);

      // now, remove the current num from combination
      currentCombination.remove(currentCombination.size() - 1);
    }

  }

}

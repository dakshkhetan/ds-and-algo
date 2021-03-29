/*

Reference Video - https://youtu.be/G1fRTGRxXU8

Sample Input:
candidates = [10,1,2,7,6,1,5]
target = 8

Sample Output:
[[1,1,6],[1,2,5],[1,7],[2,6]]

*/

class Solution {

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    return combinationSum(candidates, target); // generic solution to other bracktracking problems
    // return combinationSumAlternate(candidates, target); // very SLOW but easy
  }


  // Time Complexity: O(2^n * k)
  // Space Complexity: O(k * x)
  // where,
  // n = no. of elements in given array
  // k = avg. length of each combination
  // x = total no. of combinations

  public List<List<Integer>> combinationSum(int[] candidates, int target) {

    // sort the given array first to identify duplicate elements
    Arrays.sort(candidates);

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

    for (int i = startIndex; i < nums.length; i++) {
      // Important: check and skip duplicates
      if (i > startIndex && nums[i] == nums[i - 1]) {
        continue;
      }

      // stop recursion if current num is greater than remaining target
      if (nums[i] > remainingTarget) {
        break;
      }

      // include the current num into combination
      currentCombination.add(nums[i]);

      traverse(nums, combinations, currentCombination, remainingTarget - nums[i], i + 1);

      // now, remove the current num from combination
      currentCombination.remove(currentCombination.size() - 1);
    }

  }


  public List<List<Integer>> combinationSumAlternate(int[] candidates, int target) {

    // sort the given array first to identify duplicate elements
    Arrays.sort(candidates);

    // define a HashSet to eleminite any duplicate combinations
    Set<List<Integer>> combinations = new HashSet<>();
    _traverse(candidates, combinations, new ArrayList<>(), target, 0);

    // convert HashSet to List
    List<List<Integer>> result = new ArrayList<>(combinations);
    return result;

  }

  private void _traverse(int[] nums, Set<List<Integer>> combinations, List<Integer> currentCombination,
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

      _traverse(nums, combinations, currentCombination, remainingTarget - nums[startIndex], startIndex + 1);

      // now, remove the current num from combination
      currentCombination.remove(currentCombination.size() - 1);
    }

    // NOT include the current num into combination
    _traverse(nums, combinations, currentCombination, remainingTarget, startIndex + 1);

  }

}

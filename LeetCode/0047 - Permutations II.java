/*

Sample Input:
nums = [1,1,2]

Sample Output:
[[1,1,2],[1,2,1],[2,1,1]]

*/

class Solution {

  // Time Complexity: O(N*logN) + O(N! * N)
  // Space Complexity: O(N + (N! * N))

  public List<List<Integer>> permuteUnique(int[] nums) {

    // sort the given array first to identify duplicate elements
    Arrays.sort(nums);

    List<List<Integer>> permutations = new ArrayList<>();
    boolean visited[] = new boolean[nums.length];

    backtrack(nums, permutations, new ArrayList<>(), visited);

    return permutations;

  }

  private void backtrack(int[] nums, List<List<Integer>> permutations, List<Integer> currentPermutation,
      boolean[] visited) {

    if (currentPermutation.size() == nums.length) {
      permutations.add(new ArrayList<>(currentPermutation));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      // check if current num is visited or not to prevent infinite loop
      if (visited[i]) {
        continue;
      }

      // skip duplicates
      if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {  // important
        continue;
      }

      // add current num and mark it as visited
      currentPermutation.add(nums[i]);
      visited[i] = true;

      backtrack(nums, permutations, currentPermutation, visited);

      // now, remove current num (by removing the last added element from the list)
      // and mark it as unvisited
      currentPermutation.remove(currentPermutation.size() - 1);
      visited[i] = false;
    }

  }

}

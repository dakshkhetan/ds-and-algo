/*

Reference Video - https://youtu.be/R3Sm9V2OSCo

Sample Input:
nums = [1,2,3]

Sample Output:
[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

*/

class Solution {

  public List<List<Integer>> permute(int[] nums) {

    List<List<Integer>> permutations = new ArrayList<>();
    boolean visited[] = new boolean[nums.length];

    backtrack(nums, permutations, new ArrayList<>(), visited);

    return permutations;

  }

  private void backtrack(int[] nums, List<List<Integer>> permutations, List<Integer> currentPermutation,
      boolean[] visited) {

    if (currentPermutation.size() == nums.length) {
      permutations.add(new ArrayList<>(currentPermutation)); // Important: add using the 'new' keyword
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      // check if current num is visited or not to prevent infinite loop
      if (visited[i] == true) {
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

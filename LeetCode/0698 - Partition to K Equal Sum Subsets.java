/* 

Sample Input:
nums = [4, 3, 2, 3, 5, 2, 1]
k = 4

Sample Output:
True

Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

*/

class Solution {

  // Time Complexity : 0(N + N!)
  // Space Complexity: O(N)

  public boolean canPartitionKSubsets(int[] nums, int k) {

    // Using backtracking:

    // calculate sum of all given numbers
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }

    // each subset should have equal sum
    if (sum % k > 0) {
      return false;
    }

    int targetSum = sum / k;
    int[] visited = new int[nums.length];

    boolean isFound = solve(nums, k, targetSum, 0, 0, visited);

    // printing the partitioned subsets
    // for (int i = 0; i < k; i++) {
    //   System.out.print("Partition " + i + " is: ");

    //   for (int j = 0; j < nums.length; j++) {
    //     if (visited[j] == i + 1) {
    //       System.out.print(nums[j] + " ");
    //     }
    //     System.out.println();
    //   }
    // }

    return isFound;

  }

  private boolean solve(int[] nums, int k, int targetSum, int index, int subsetSumSoFar, int[] visited) {

    // base case, when required subsets have been made
    if (k == 0) {
      return true;
    }

    // subset found, now reset everything & search for next subset
    if (subsetSumSoFar == targetSum) {
      return solve(nums, k - 1, targetSum, 0, 0, visited);
    }

    for (int i = index; i < nums.length; i++) {
      if (visited[i] == 0 && subsetSumSoFar + nums[i] <= targetSum) {

        // mark current num as visited and store its
        // corresponding subset/partition index
        visited[i] = k;

        boolean selecting = solve(nums, k, targetSum, i + 1, subsetSumSoFar + nums[i], visited);
        if (selecting) {
          return true;
        }

        // on backtacking, mark current num as unvisited
        visited[i] = 0;
      }
    }

    return false;

  }

}

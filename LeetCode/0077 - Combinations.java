/*

Sample Input:
n = 4
k = 2

Sample Output:
[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4],]

*/

class Solution {

  // Time Complexity: O(C(n,k) * k)
  // Space Complexity: O(C(n,k) * k)

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> combinations = new ArrayList<>();
    traverse(n, k, combinations, new ArrayList<>(), 1);
    return combinations;
  }

  private void traverse(int n, int combinationSize, List<List<Integer>> combinations, List<Integer> currentCombination,
      int startNum) {

    if (currentCombination.size() == combinationSize) {
      combinations.add(new ArrayList<>(currentCombination));
      return;
    }

    for (int num = startNum; num <= n; num++) {
      // add current num to current combination
      currentCombination.add(num);

      traverse(n, combinationSize, combinations, currentCombination, num + 1);

      // backtrack and remove current num from current combination
      currentCombination.remove(currentCombination.size() - 1);
    }

  }


  public List<List<Integer>> combineOptimised(int n, int k) {

    List<List<Integer>> combinations = new ArrayList<>();

    if (n < k || k == 0) {
      return combinations;
    }

    // include number 'n' in current combination
    combinations = combineOptimised(n - 1, k - 1);

    // base case
    if (combinations.isEmpty()) {
      combinations.add(new ArrayList<>());
    }

    for (List<Integer> combination : combinations) {
      combination.add(n); // add 'n' to each combination
    }

    // NOT include number 'n' in current combination
    combinations.addAll(combineOptimised(n - 1, k));

    return combinations;

  }

}

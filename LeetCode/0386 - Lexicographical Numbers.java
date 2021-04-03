/*

Reference Video - https://youtu.be/gRo86WqFYSE

Sample Input:
n = 13

Sample Output:
[1,10,11,12,13,2,3,4,5,6,7,8,9]

*/

class Solution {

  // Time Complexity: O(n)
  // Space Complexity: O(1)

  public List<Integer> lexicalOrder(int n) {
    // return lexicalOrder1(n);
    return lexicalOrder2(n); // slightly faster
  }


  public List<Integer> lexicalOrder1(int n) {
    List<Integer> result = new ArrayList<>();

    for (int i = 1; i <= 9; i++) {
      dfs(n, result, i);
    }

    return result;
  }

  private void dfs(int n, List<Integer> result, int i) {
    if (i > n) {
      return;
    }

    result.add(i);

    for (int j = 0; j < 10; j++) {
      dfs(n, result, 10 * i + j); // important
    }
  }


  public List<Integer> lexicalOrder2(int n) {

    // pre-assign the capacity to save expansion time
    List<Integer> result = new ArrayList<>(n);

    helper(n, result, 0);
    return result;
  }

  private void helper(int n, List<Integer> result, int prefix) {

    // if the prefix is 0 and appending starts from 0 then,
    // recursive (0 * 10 + 0) will lead to stack overflow
    int start = prefix == 0 ? 1 : 0;

    for (int i = start; i <= 9; i++) {
      int val = prefix * 10 + i;

      if (val > n) {
        return;
      }

      result.add(val);

      if (val * 10 <= n) {
        helper(n, result, prefix * 10 + i);
      }
    }

  }

}

/*

Sample Input:
numRows = 5

Sample Output:
[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Explanation:
In Pascal's triangle, each number is the sum of the two numbers directly above it.

Constraints:
1 <= numRows <= 30

*/

class Solution {

  public List<List<Integer>> generate(int numRows) {
    return pascalTriangle(numRows);
  }

  // Time Complexity: O(N^2)
  // Space Complexity: O(N) -> extra space used
  public List<List<Integer>> pascalTriangle(int noOfRows) {
    List<List<Integer>> result = new ArrayList<>();

    List<Integer> previousRow = new ArrayList<>();
    List<Integer> currentRow = new ArrayList<>();

    for (int i = 0; i < noOfRows; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          currentRow.add(1);
        } else {
          currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
        }
      }

      result.add(currentRow);

      previousRow = currentRow;
      currentRow = new ArrayList<>();
    }

    return result;
  }

}

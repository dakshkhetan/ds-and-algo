/*

Sample Input:
rowIndex = 3

Sample Output:
[1,3,3,1]

Constraints:
0 <= rowIndex <= 33

*/

class Solution {

  public List<Integer> getRow(int rowIndex) {
    // return getRowBruteForce(rowIndex);
    return getRowBetter(rowIndex);
    // return getRowOptimal(rowIndex);
  }

  // Time Complexity: O(N^2)
  // Space Complexity: O(N^2) ??
  public List<Integer> getRowBruteForce(int rowIndex) {
    List<List<Integer>> result = new ArrayList<>();

    List<Integer> previousRow = new ArrayList<>();
    List<Integer> currentRow = new ArrayList<>();

    for (int i = 0; i <= rowIndex; i++) {
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

    return result.get(rowIndex);
  }

  // Time Complexity: O(N^2)
  // Space Complexity: O(1)
  // Reference Video: https://youtu.be/IWXZAvBIuyE?t=313 (Important)
  public List<Integer> getRowBetter(int rowIndex) {
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < rowIndex + 1; i++) {
      result.add(1);
    }

    for (int i = 0; i < rowIndex; i++) {
      for (int j = i; j >= 1; j--) {
        result.set(j, result.get(j) + result.get(j - 1));
      }
    }

    return result;
  }

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  // Reference Video: https://youtu.be/LgLcWJrfLmQ (Important)
  public List<Integer> getRowOptimal(int rowIndex) {
    // using nCr formula approach:

    List<Integer> result = new ArrayList<>();
    long value = 1;

    for (int i = 0; i < rowIndex + 1; i++) {
      result.add((int) value);
      value = (value * (rowIndex - i)) / (i + 1); // formula derived
    }

    return result;
  }

}

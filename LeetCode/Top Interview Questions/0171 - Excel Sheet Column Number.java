/*

Sample Input 1:
columnTitle = "A"

Sample Output 1:
1

Sample Input 2:
columnTitle = "AB"

Sample Output 2:
28

Constraints:
- 1 <= columnTitle.length <= 7
- columnTitle consists only of uppercase English letters.
- columnTitle is in the range ["A", "FXSHRXW"].

*/

class Solution {

  public int titleToNumber(String columnTitle) {
    return titleToNumber1(columnTitle);
    // return titleToNumber2(columnTitle);
  }

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  public int titleToNumber1(String columnTitle) {
    // Formula: 'BCD' -> 2*(26^2) + 3*(26^1) + 4*(26^0) = 1434

    int columnNum = 0;
    int multipler = 1; // 26^0 = 1

    for (int i = columnTitle.length() - 1; i >= 0; i--) {
      int correspondingNum = columnTitle.charAt(i) - 'A' + 1;
      columnNum += (correspondingNum * multipler);
      multipler *= 26;
    }

    return columnNum;
  }

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  public int titleToNumber2(String columnTitle) {
    int columnNum = 0;

    for (int i = 0; i < columnTitle.length(); i++) {
      int correspondingNum = columnTitle.charAt(i) - 'A' + 1;
      columnNum = (columnNum * 26) + correspondingNum;
    }

    return columnNum;

    /*
     * Dry run for input 'BCD':
     * Iteration 1. 'B' -> 0*26 + 2 = 2
     * Iteration 2. 'C' -> 2*26 + 3 = 55
     * Iteration 3. 'D' -> 55*26 + 4 = 1434 <- ans
     */
  }

}

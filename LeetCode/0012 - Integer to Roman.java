/* 

Sample Input:
1994

Sample Output:
"MCMXCIV"

Explanation:
M = 1000, CM = 900, XC = 90 and IV = 4

Range constraint:
[1, 3999]

*/

class Solution {

  final static int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
  final static String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

  public String intToRoman(int num) {
    StringBuilder ans = new StringBuilder();

    for (int i = 0; num > 0; i++) {
      while (num >= values[i]) {
        ans.append(symbols[i]);
        num -= values[i];
      }
    }

    return ans.toString();
  }

}

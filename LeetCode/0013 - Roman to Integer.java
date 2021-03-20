/*

Sample Input:
"MCMXCIV"

Sample Output:
1994

Explanation:
M = 1000, CM = 900, XC = 90 and IV = 4

Range constraint:
[1, 3999]

*/

class Solution {

  public int romanToInt(String str) {
    int num = 0;
    int i = 0;

    while (i < str.length()) {
      char currentChar = str.charAt(i);

      if (i + 1 == str.length()) { // single digit left
        num += toInt(currentChar);
        i++;
      } else {
        char nextChar = str.charAt(i + 1);

        // Important: subtraction is used for 6 instances
        if (currentChar == 'I' && (nextChar == 'V' || nextChar == 'X')) {
          num += toInt(nextChar) - 1;
          i += 2;
        } else if (currentChar == 'X' && (nextChar == 'L' || nextChar == 'C')) {
          num += toInt(nextChar) - 10;
          i += 2;
        } else if (currentChar == 'C' && (nextChar == 'D' || nextChar == 'M')) {
          num += toInt(nextChar) - 100;
          i += 2;
        } else {
          num += toInt(currentChar);
          i++;
        }
      }
    }

    return num;
  }

  private int toInt(char num) {
    switch (num) {
    case 'I':
      return 1;
    case 'V':
      return 5;
    case 'X':
      return 10;
    case 'L':
      return 50;
    case 'C':
      return 100;
    case 'D':
      return 500;
    default:
      return 1000;
    }
  }

}

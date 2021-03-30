/*

Sample Input:
"abccbc"

Sample Output:
9

Explanation:
9 palindromic strings are: ["a", "b", "c", "c", "b", "c", "cc", "cbc", "bccb"]

*/

class Solution {

  public int countSubstrings(String str) {
    // return countPalindromicSubstringsUsingDP(str);
    return countPalindromicSubstringsBetter(str);
  }


  // Time Complexity: O(n^2)
  // Space Complexity: O(n^2)
  public int countPalindromicSubstringsUsingDP(String str) {

    // Reference Video - https://youtu.be/XmSOWnL6T_I

    int n = str.length();
    int count = 0;

    boolean dp[][] = new boolean[n][n];

    for (int gap = 0; gap < n; gap++) {
      for (int i = 0, j = gap; j < n; i++, j++) {
        if (gap == 0) { // substring has single character
          dp[i][j] = true;
        } else if (gap == 1) { // substring has 2 characters
          dp[i][j] = str.charAt(i) == str.charAt(j);
        } else {

          // first check if the extreme substring
          // characters are equal or not
          if (str.charAt(i) != str.charAt(j)) {
            dp[i][j] = false;
          } else {
            // now, check if the middle substring (i.e. excluding extreme characters)
            // is palindrome or not
            boolean isMiddleSubtringPalindrome = dp[i + 1][j - 1];
            if (isMiddleSubtringPalindrome) {
              dp[i][j] = true;
            } else {
              dp[i][j] = false;
            }
          }
        }

        if (dp[i][j] == true) {
          count++;
        }
      }
    }

    return count;

  }


  // Time Complexity: O(n^2)
  // Space Complexity: O(1)
  public int countPalindromicSubstringsBetter(String str) {

    int count = 0;

    for (int i = 0; i < str.length(); i++) {
      // odd-length palindromes -> single character at center of substring
      count += countPalindromicSubstringsAroundCenter(str, i, i);

      // even-length palindromes -> two characters at center of substring
      count += countPalindromicSubstringsAroundCenter(str, i, i + 1);
    }

    return count;

  }

  private int countPalindromicSubstringsAroundCenter(String str, int start, int end) {

    int count = 0;

    while (start >= 0 && end < str.length()) {
      if (str.charAt(start) != str.charAt(end)) {
        break;
      }

      // expand from the center (middle of string)
      start--;
      end++;

      count++;
    }

    return count;

  }

}

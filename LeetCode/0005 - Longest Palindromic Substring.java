/*

Sample Input:
"babad"

Sample Output:
"bab"

Note:
"aba" is also a valid answer.

*/

class Solution {

  public String longestPalindrome(String str) {
    // return longestPalindromicSubstringBruteForce(str);
    // return longestPalindromicSubstringUsingDP(str);
    return longestPalindromicSubstringBetter(str);
    // return longestPalindromicSubstringUsingManacherAlgo(str);
  }


  // Time Complexity: O(n^3)
  // Space Complexity: O(1)
  public String longestPalindromicSubstringBruteForce(String str) {

    int n = str.length();

    String longestPalindromicSubstring = "";
    int longestPalindromicSubstringLength = 0;

    for (int start = 0; start < n; start++) {
      for (int end = start; end < n; end++) {
        if (str.charAt(start) == str.charAt(end) && isPalindrome(str, start + 1, end - 1)) {
          int currentSubstringLength = end - start + 1;
          if (currentSubstringLength > longestPalindromicSubstringLength) {
            longestPalindromicSubstringLength = currentSubstringLength;
            longestPalindromicSubstring = str.substring(start, end + 1);
          }
        }
      }
    }

    return longestPalindromicSubstring;

  }

  private boolean isPalindrome(String str, int left, int right) {
    for (int i = left, j = right; i < j; i++, j--) {
      if (str.charAt(i) != str.charAt(j)) {
        return false;
      }
    }
    return true;
  }


  // Time Complexity: O(n^2)
  // Space Complexity: O(n^2)
  public String longestPalindromicSubstringUsingDP(String str) {

    int n = str.length();

    if (n < 1) {
      return "";
    }

    String longestPalindromicSubstring = "";
    int longestPalindromicSubstringLength = 0;

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

        int currentSubstringLength = gap + 1;
        // int currentSubstringLength = j - i + 1;

        if (dp[i][j] == true && currentSubstringLength > longestPalindromicSubstringLength) {
          longestPalindromicSubstringLength = currentSubstringLength;
          longestPalindromicSubstring = str.substring(i, j + 1);
        }
      }
    }

    return longestPalindromicSubstring;

  }


  // Expand around center approach
  // Time Complexity: O(n^2)
  // Space Complexity: O(1)
  public String longestPalindromicSubstringBetter(String str) {

    // Reference Video - https://youtu.be/y2BD4MJqV20
    // (check comments by Ajay Singh for amazing explanation)

    int n = str.length();

    if (n < 1) {
      return "";
    }

    int start = 0;
    int end = 0;

    for (int i = 0; i < n; i++) {
      // odd-length palindromes -> single character at center of substring
      int oddLengthPalindrome = calculateLongestPalindromeFromMiddle(str, i, i);

      // even-length palindromes -> two characters at center of substring
      int evenLengthPalindrome = calculateLongestPalindromeFromMiddle(str, i, i + 1);

      int longestLengthPalindrome = Math.max(oddLengthPalindrome, evenLengthPalindrome);

      // Important: update start and end pointers corresponding to
      // the new longest palindromic substring (if found)
      if (longestLengthPalindrome > end - start + 1) {
        start = i - (longestLengthPalindrome - 1) / 2;
        end = i + longestLengthPalindrome / 2;
      }
    }

    String longestPalindromicSubstring = str.substring(start, end + 1);
    return longestPalindromicSubstring;

  }

  private int calculateLongestPalindromeFromMiddle(String str, int start, int end) {

    while (start >= 0 && end < str.length()) {
      if (str.charAt(start) != str.charAt(end)) {
        break;
      }

      // expand from the center (middle of string)
      start--;
      end++;
    }

    // Important: move start and end back to last iteration
    // position before exiting out of loop (dry run to understand better)
    start++;
    end--;

    // calculate length of longest palindrome substring encountered
    int length = end - start + 1;

    return length;

  }


  // Using Manacher's Algorithm
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public String longestPalindromicSubstringUsingManacherAlgo(String str) {

    int strLen = 2 * str.length() + 3;
    char strChars[] = new char[strLen];

    // To ignore special cases at the beginning and end of the array "abc" -> @ # a
    // # b # c # $ "" -> @#$ "a" -> @ # a # $

    strChars[0] = '@';
    strChars[strLen - 1] = '$';

    int k = 1;
    for (char ch : str.toCharArray()) {
      strChars[k++] = '#';
      strChars[k++] = ch;
    }

    strChars[k] = '#';

    int maxLen = 0;
    int start = 0;
    int maxRight = 0;
    int center = 0;

    int p[] = new int[strLen]; // i's radius, which not includes i

    for (int i = 1; i < strLen - 1; i++) {
      if (i < maxRight) {
        p[i] = Math.min(maxRight - i, p[2 * center - i]);
      }

      // expand center
      while (strChars[i + p[i] + 1] == strChars[i - p[i] - 1]) {
        p[i]++;
      }

      // update center and its bound
      if (i + p[i] > maxRight) {
        center = i;
        maxRight = i + p[i];
      }

      // update ans
      if (p[i] > maxLen) {
        start = (i - p[i] - 1) / 2;
        maxLen = p[i];
      }
    }

    return str.substring(start, start + maxLen);

  }

}

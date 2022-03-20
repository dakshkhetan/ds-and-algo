/*

Sample Input 1:
"A man, a plan, a canal: Panama"

Sample Output 1:
true

Explanation:
"amanaplanacanalpanama" is a palindrome.


Sample Input 2:
" "

Sample Output 2:
true

*/

class Solution {

  public boolean isPalindrome(String str) {
    // return isPalindromeBruteForce(str);
    // return isPalindromeRegex(str);
    return isPalindromeOptimal(str);
  }

  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public boolean isPalindromeBruteForce(String str) {
    int n = str.length();

    if (n == 0 || n == 1) {
      return true;
    }

    str = str.toLowerCase();

    // remove special characters
    String cleanStr = "";
    for (int i = 0; i < n; i++) {
      if (Character.isLetterOrDigit(str.charAt(i))) {
        cleanStr += str.charAt(i);
      }
    }

    // reverse the cleaned string
    String reverseStr = "";
    for (int i = cleanStr.length() - 1; i >= 0; i--) {
      reverseStr += cleanStr.charAt(i);
    }

    // compare
    if (cleanStr.equals(reverseStr)) {
      return true;
    }

    return false;
  }

  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public boolean isPalindromeRegex(String str) {
    int n = str.length();

    if (n == 0 || n == 1) {
      return true;
    }

    String reverseStr = "";
    String cleanedStr = str.toLowerCase().replaceAll(
        "[^a-z0-9]", "");

    for (int i = cleanedStr.length() - 1; i >= 0; i--) {
      reverseStr += cleanedStr.charAt(i);
    }

    if (cleanedStr.equals(reverseStr)) {
      return true;
    }

    return false;
  }

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  public boolean isPalindromeOptimal(String str) {
    int n = str.length();

    if (n == 0 || n == 1) {
      return true;
    }

    // using two pointer approach:

    int i = 0;
    int j = n - 1;

    while (i < j) {
      boolean isLeftCharAlphaNum = Character.isLetterOrDigit(str.charAt(i));
      boolean isRightCharAlphaNum = Character.isLetterOrDigit(str.charAt(j));

      if (isLeftCharAlphaNum && isRightCharAlphaNum) {
        // compare
        if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))) {
          return false;
        } else {
          i++;
          j--;
        }
      } else if (isLeftCharAlphaNum && !isRightCharAlphaNum) {
        j--;
      } else if (!isLeftCharAlphaNum && isRightCharAlphaNum) {
        i++;
      } else {
        i++;
        j--;
      }
    }

    return true;
  }

}

/*

NOTE: `indexOf()` in C is equivalent to `indexOf()` in Java

Sample Input 1:
haystack = "hello", needle = "ll"

Sample Output 1:
2

Sample Input 2:
haystack = "aaaaa", needle = "bba"

Sample Output 2:
-1

*/

class Solution {

  public int strStr(String haystack, String needle) {
    // return indexOfBruteForce(haystack, needle);
    // return indexOfBetter(haystack, needle);
    return KMP_StringMatchingAlgo(haystack, needle);
    // return KMP_StringMatchingAlgo2(haystack, needle);
  }

  // Time Complexity: O(M*N)
  // Space Complexity: O(1)
  // where, M = length of haystack string & N = length of needle string
  public int indexOfBruteForce(String str, String target) {
    if (target.length() == 0 || str.equals(target)) {
      return 0;
    }

    if (target.length() > str.length()) {
      return -1;
    }

    int limit = str.length() - target.length();

    for (int i = 0; i <= limit; i++) {
      String currentSubstring = str.substring(i, i + target.length()); // O(N) in worst case
      if (currentSubstring.equals(target)) { // O(N) in worst case
        return i;
      }
    }

    return -1;
  }

  // Time Complexity: O(M*N) -> but significantly faster than above
  // Space Complexity: O(1)
  // where, M = length of haystack string & N = length of needle string
  public int indexOfBetter(String str, String target) {
    int targetLen = target.length();

    // if target string is empty or equal to given string
    if (targetLen == 0 || str.equals(target)) {
      return 0;
    }

    // if target string's length exceeds the given string's length
    if (targetLen > str.length()) {
      return -1;
    }

    int limit = str.length() - targetLen;

    for (int i = 0; i <= limit; i++) {
      // search for target string's last character inside given string
      // and hence, skip (don't check) the targetLen-1 characters in given string
      if (str.charAt((targetLen - 1) + i) != target.charAt(targetLen - 1)) {
        continue;
      }

      // now, match the remaining target from beginning to second-last character
      int j = 0;
      while (j < targetLen && str.charAt(i + j) == target.charAt(j)) {
        j++;
      }

      // if whole target is matched i.e. pointer j == target string's length
      // then, return the initial index i.e. pointer i
      if (j == targetLen) {
        return i;
      }
    }

    return -1;
  }

  // Time Complexity: O(M+N)
  // Space Complexity: O(N)
  // where, M = length of text (haystack) & N = length of pattern (needle)
  // Breakdown: O(N) time to create LPS table, O(M) time to find the
  // pattern in text, and O(N) space required to store LPS table
  // Reference Video - https://youtu.be/4jY57Ehc14Y (important)
  public int KMP_StringMatchingAlgo(String text, String pattern) {
    int textLen = text.length();
    int patternLen = pattern.length();

    // if pattern string is empty or equal to given text
    if (patternLen == 0 || text.equals(pattern)) {
      return 0;
    }

    // if pattern's length exceeds the given text's length
    if (patternLen > textLen) {
      return -1;
    }

    int lps[] = computeLPSArray(pattern);

    int i = 0; // pointer for text
    int j = 0; // pointer for pattern

    while (i < textLen) {
      if (text.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;
      } else {
        // if there is a mismatch, just go to the previous character's LPS index
        if (j != 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }

      if (j == patternLen) {
        // occurrence found at index i-j
        // System.out.println(i - j);

        // to find other occurrences, reset j and continue the process
        // j = lps[j - 1];

        // since we only want first occurence, we simply return its corresponding index
        return i - j;
      }
    }

    return -1;
  }

  // computing Longest Prefix that is also a Suffix (LPS) array for given string
  private int[] computeLPSArray(String pattern) {
    int lps[] = new int[pattern.length()];

    lps[0] = 0;
    int prefixLen = 0;
    int i = 1; // beginning from 2nd character

    while (i < pattern.length()) {
      if (pattern.charAt(prefixLen) == pattern.charAt(i)) {
        // lps[i++] = ++prefixLen;
        lps[i] = prefixLen + 1;
        prefixLen++;
        i++;
      } else {
        if (prefixLen != 0) {
          prefixLen = lps[prefixLen - 1]; // important
        } else {
          lps[i] = 0;
          i++;
        }
      }
    }

    return lps;
  }

}

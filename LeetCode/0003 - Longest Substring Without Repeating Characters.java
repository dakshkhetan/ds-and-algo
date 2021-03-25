/*

Reference Video - https://youtu.be/qtVh-XEpsJo

Sample Input 1:
"pwwkew"

Sample Output 1:
3

Explanation:
The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Sample Input 2:
"bbbbb"

Sample Output 2:
1

*/

class Solution {

  public int lengthOfLongestSubstring(String str) {

    // Time Complexity: O(2n)
    // return lengthOfLongestSubstringUsingSet(str); // easy

    // Time Complexity: O(n)
    return lengthOfLongestSubstringUsingHashMap(str); // bit complex
    // return lengthOfLongestSubstringUsingFreqArray(str); // fastest

  }

  public int lengthOfLongestSubstringUsingSet(String str) {

    // using slow and fast pointer technique
    int left = 0;
    int right = 0;

    int maxLength = 0;

    Set<Character> set = new HashSet<>();

    while (right < str.length()) {
      // if set does not contain character at fast pointer,
      // then add it to the hashset and increment fast pointer
      // finally calculate/update the max-length of subtring
      if (!set.contains(str.charAt(right))) {
        set.add(str.charAt(right));
        right++;

        // update max substring length
        maxLength = Math.max(maxLength, set.size());
      } else {
        // if set already contains the character, then
        // delete from the head/beginning of string using
        // a slow pointer until character at fast pointer's
        // index can be added to the hash set
        set.remove(str.charAt(left));
        left++;
      }
    }

    return maxLength;

  }

  public int lengthOfLongestSubstringUsingHashMap(String str) {

    int n = str.length();

    if (n < 2) {
      return n;
    }

    // HashMap to keep track of the latest index of each character in string
    Map<Character, Integer> map = new HashMap<>();

    int maxLength = 0;

    int left = 0;
    int right = 0;

    while (right < n) {
      char currentChar = str.charAt(right);

      if (map.containsKey(currentChar)) {
        int lastSeenIndex = map.get(currentChar);
        left = Math.max(lastSeenIndex + 1, left); // important
      }

      map.put(currentChar, right); // store character's latest index in map
      maxLength = Math.max(right - left + 1, maxLength); // update max length

      right++;
    }

    return maxLength;

  }

  public int lengthOfLongestSubstringUsingFreqArray(String str) {

    // ASCII range is [0,126] for English letters, digits, symbols and spaces.
    int charset[] = new int[128];

    int maxLength = 0;

    int left = 0;
    int right = 0;

    while (right < str.length()) {
      char currentChar = str.charAt(right);

      // character has been already seen before
      if (charset[currentChar] != 0) {
        left = Math.max(charset[currentChar] + 1, left); // important
      }

      charset[currentChar] = right; // store character's latest index in map
      maxLength = Math.max(right - left + 1, maxLength); // update max length

      right++;
    }

    return maxLength;

  }

}

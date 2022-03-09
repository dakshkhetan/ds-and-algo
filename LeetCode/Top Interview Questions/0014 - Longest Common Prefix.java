/*

Sample Input 1:
["flower","flow","flight"]

Sample Output 1:
"fl"

Sample Input 2:
["dog","racecar","car"]

Sample Output 2:
""

Constraints:
The string(s) consists of only lower-case english letters

*/

class Solution {

  // Time Complexity: O(S), where S is the sum of all characters in all strings
  // Space Complexity: O(1)
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }

    if (strs.length == 1) {
      return strs[0];
    }

    String prefix = strs[0]; // taking the first string as the prefix

    // beginning from second string in the list
    for (int i = 1; i < strs.length; i++) {

      // if prefix doesn't exist in current string, we'll
      // keep removing last character from that prefix
      // until it matches, and repeat the process for other
      // strings in the list
      while (strs[i].indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length() - 1);
      }
    }

    return prefix;
  }

}

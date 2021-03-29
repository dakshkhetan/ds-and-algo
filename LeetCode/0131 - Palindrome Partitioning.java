/*

Sample Input:
s = "aab"

Sample Output:
[["a","a","b"],["aa","b"]]

Constraint:
s contains only lowercase English letters

*/

class Solution {

  // Time Complexity: O(2^N * (N + N))
  // Space Complexity: O(2^N * N)
  // where N = length of given string

  public List<List<String>> partition(String str) {
    List<List<String>> result = new ArrayList<>();
    traverse(str, result, new ArrayList<>(), 0);
    return result;
  }

  private void traverse(String str, List<List<String>> result, List<String> currentPartitionList, int startIndex) {

    if (startIndex == str.length()) {
      result.add(new ArrayList<>(currentPartitionList));
      return;
    }

    for (int i = startIndex; i < str.length(); i++) {

      // check if the substring for current recursive call
      // (i.e. from 'startIndex' to 'i') is palindrome or not

      String currentSubstring = str.substring(startIndex, i + 1);

      if (isPalindrome(currentSubstring)) {

        // add current substring in the current partition list
        currentPartitionList.add(currentSubstring);

        traverse(str, result, currentPartitionList, i + 1);

        // backtrack and remove the current substring from current partition list
        currentPartitionList.remove(currentPartitionList.size() - 1);
      }
    }

  }

  private boolean isPalindrome(String str) {
    for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
      if (str.charAt(i) != str.charAt(j)) {
        return false;
      }
    }
    return true;
  }

}

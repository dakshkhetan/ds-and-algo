/* 

Problem Link - https://www.lintcode.com/problem/917

Reference Video - https://youtu.be/DwdWafLsGm0

Sample Input:
s = "aabb"

Sample Output:
["abba","baab"]

*/

class Solution {

  public List<String> generatePalindromes(String str) {

    Map<Character, Integer> freqMap = new HashMap<>(); // character vs it's frequency

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
    }

    Character oddChar = null;
    int noOfOddFreqChar = 0;
    int length = 0;

    for (char ch : freqMap.keySet()) {
      int charFreq = freqMap.get(ch);

      if (charFreq % 2 != 0) { // odd
        oddChar = ch;
        noOfOddFreqChar++;
      }

      // important (refer video for approach explanation)
      freqMap.put(ch, charFreq / 2);
      length += (charFreq / 2);
    }

    if (noOfOddFreqChar > 1) {
      // palindrome permutation(s) not possible
      return new ArrayList<>();
    }

    List<String> result = new ArrayList<>();

    solve(result, freqMap, oddChar, length, 0, "");

    return result;

  }

  private void solve(List<String> result, Map<Character, Integer> freqMap, Character oddChar, int length, int counter,
      String resultSoFar) {

    // base case
    if (counter == length) {

      String palindromicPermutation;
      if (oddChar != null) {
        palindromicPermutation = resultSoFar + oddChar + reverseOfString(resultSoFar);
      } else {
        palindromicPermutation = resultSoFar + reverseOfString(resultSoFar);
      }

      result.add(palindromicPermutation);
      return;
    }

    // iterate over each character in hashmap
    for (char currentChar : freqMap.keySet()) {
      int charFreq = freqMap.get(currentChar);

      if (charFreq > 0) {
        freqMap.put(currentChar, charFreq - 1);
        solve(result, freqMap, oddChar, length, counter + 1, resultSoFar + currentChar);
        freqMap.put(currentChar, charFreq);
      }
    }

  }

  private String reverseOfString(String str) {
    // String reversedString = "";
    // for (int i = str.length() - 1; i >= 0; i--) {
    //   reversedString += str.charAt(i);
    // }
    // return reversedString;

    return new StringBuffer(str).reverse().toString();
  }

}

/* 

Problem Link - https://www.lintcode.com/problem/779

Reference Video - https://youtu.be/LliQjLnbhx8

Sample Input:
"pep"

Sample Output:
["1e1","1ep","2p","3","p1p","p2","pe1","pep"]

*/

class Solution {

  public List<String> generateAbbreviations(String word) {
    List<String> allAbbreviations = new ArrayList<>();
    generateAbbreviations(word, allAbbreviations, "", 0, 0);
    return allAbbreviations;
  }

  private void generateAbbreviations(String word, List<String> result, String abbreviationSoFar, int count, int index) {

    if (index == word.length()) {
      if (count != 0) {
        result.add(abbreviationSoFar + count);
      } else {
        result.add(abbreviationSoFar);
      }

      return;
    }

    // include current character in abbreviation
    if (count != 0) {
      generateAbbreviations(word, result, abbreviationSoFar + count + word.charAt(index), 0, index + 1);
    } else {
      generateAbbreviations(word, result, abbreviationSoFar + word.charAt(index), count, index + 1);
    }

    // NOT include current character in abbreviation
    generateAbbreviations(word, result, abbreviationSoFar, count + 1, index + 1);

  }

}

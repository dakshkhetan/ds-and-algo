/*

Sample Input
4

Sample Output
"1211"


1           //
11          // one 1's
21          // two 1's
1211        // one 2, and one 1.
111221      // one 1, one 2, and two 1's.
  ... so on

*/

class Solution {

  public String countAndSay(int n) {

    if (n <= 0) {
      return null;
    }

    if (n == 1) {
      return "1";
    }

    String answer = "1";

    for (int i = 2; i <= n; i++) {
      answer = countAndSayHelper(answer);
    }

    return answer;

  }

  private String countAndSayHelper(String previousNum) {

    // use stringbuilder for faster performance
    StringBuilder ans = new StringBuilder();

    char n = previousNum.charAt(0);
    int count = 1;

    for (int i = 1; i < previousNum.length(); i++) {
      char currentDigit = previousNum.charAt(i);

      if (currentDigit == n) {
        count++;
      } else {
        ans.append(count).append(n);
        n = currentDigit;
        count = 1;
      }
    }

    ans.append(count).append(n);

    return ans.toString();

  }

}

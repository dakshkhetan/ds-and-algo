/*

Sample Input
"1.1.1.1"

Sample Output
"1[.]1[.]1[.]1"

*/

class Solution {

  public String defangIPaddr(String str) {

    // int n = str.length();
    // String result = "";

    // for (int i = 0; i < n; i++) {
    //   char ch = str.charAt(i);

    //   if (ch == '.') {
    //     result += "[.]";
    //   } else {
    //     result += ch;
    //   }
    // }

    // return result;

    str = str.replace(".", "[.]");
    return str;

  }

}

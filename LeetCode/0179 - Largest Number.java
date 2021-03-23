/* 

Sample Input 1:
[3, 30, 34, 5, 9]

Sample Output 1:
"9534330"


Sample Input 2:
[0, 0]

Sample Output 2:
"0"

*/

class Solution {

  public String largestNumber(int[] nums) {

    int n = nums.length;

    if (n == 0) {
      return "";
    }

    String strNums[] = new String[n];

    for (int i = 0; i < n; i++) {
      strNums[i] = Integer.toString(nums[i]);
    }

    // sort the strings (nums) in strNums[] in descending order (lexographically)
    Arrays.sort(strNums, new Comparator<String>() {
      public int compare(String a, String b) {
        String s1 = a + b;
        String s2 = b + a;

        // compareTo() compares 2 strings lexographically
        return s2.compareTo(s1);
      }
    });

    // or, we can also write like this:
    // Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

    // handle sample input 2 (multiple 0 as input)
    if (strNums[0].equals("0")) {
      return "0";
    }

    StringBuilder sb = new StringBuilder();
    for (String num : strNums) {
      sb.append(num);
    }

    return sb.toString();

  }

}

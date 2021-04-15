/*

Reference Video - https://youtu.be/RG5rWV6in38

Sample Input
team
pep
toppr

Sample Output
a-3 e-9 m-4 o-1 p-2 r-6 t-0 
a-3 e-9 m-5 o-1 p-2 r-7 t-0 
a-3 e-9 m-6 o-1 p-2 r-8 t-0 
a-4 e-9 m-2 o-1 p-3 r-5 t-0 
a-4 e-9 m-5 o-1 p-3 r-8 t-0 
a-5 e-9 m-2 o-1 p-4 r-6 t-0 
a-5 e-9 m-3 o-1 p-4 r-7 t-0 
a-6 e-9 m-2 o-1 p-5 r-7 t-0 
a-6 e-9 m-3 o-1 p-5 r-8 t-0 
a-7 e-9 m-2 o-1 p-6 r-8 t-0 

*/

import java.util.*;

public class Main {

  public static void cryptarithmetic(String str1, String str2, String str3) {

    // first, find all the unique characters/letters from all 3 strings
    // and store them in separate string with the help of a 'char vs int' hashmap
    // which would later store the number assigned to corresponding letter

    String uniqueLetters = "";
    Map<Character, Integer> charIntMap = new HashMap<>();

    for (int i = 0; i < str1.length(); i++) {
      char ch = str1.charAt(i);
      if (!charIntMap.containsKey(ch)) {
        uniqueLetters += ch;
        charIntMap.put(ch, -1); // initially set -1 as number
      }
    }

    for (int i = 0; i < str2.length(); i++) {
      char ch = str2.charAt(i);
      if (!charIntMap.containsKey(ch)) {
        uniqueLetters += ch;
        charIntMap.put(ch, -1);
      }
    }

    for (int i = 0; i < str3.length(); i++) {
      char ch = str3.charAt(i);
      if (!charIntMap.containsKey(ch)) {
        uniqueLetters += ch;
        charIntMap.put(ch, -1);
      }
    }

    boolean[] usedNumbers = new boolean[10];

    solve(str1, str2, str3, uniqueLetters, 0, charIntMap, usedNumbers);

  }

  private static void solve(String str1, String str2, String str3, String uniqueLetters, int index,
      Map<Character, Integer> charIntMap, boolean[] usedNumbers) {

    // base case
    if (index == uniqueLetters.length()) {

      int num1 = getNum(str1, charIntMap);
      int num2 = getNum(str2, charIntMap);
      int num3 = getNum(str3, charIntMap);

      // check if sum of first 2 strings' number mapping equals to 3rd string
      if (num1 + num2 == num3) {

        // print answer in alphabetical order
        for (char ch = 'a'; ch <= 'z'; ch++) {
          if (charIntMap.containsKey(ch)) {
            int num = charIntMap.get(ch);
            System.out.print(ch + "-" + num + " ");
          }
        }
        System.out.println();
      }

      return;
    }

    char currentLetter = uniqueLetters.charAt(index);

    for (int n = 0; n <= 9; n++) {

      // check if current num 'n' is not used before
      if (!usedNumbers[n]) {

        // assign current num 'n' as current letter's corresponding number
        // and mark the num 'n' as used/visited
        charIntMap.put(currentLetter, n);
        usedNumbers[n] = true;

        // solve for next character/letter in unique letters' string
        solve(str1, str2, str3, uniqueLetters, index + 1, charIntMap, usedNumbers);

        // on backtrack, mark current number 'n' back to being unused
        // and assign current letter's corresponding number back to -1
        usedNumbers[n] = false;
        charIntMap.put(currentLetter, -1);
      }
    }

  }

  private static int getNum(String str, Map<Character, Integer> charIntMap) {

    String num = "";

    for (int i = 0; i < str.length(); i++) {
      int currentDigit = charIntMap.get(str.charAt(i));
      num += currentDigit;
    }

    // parse number as integer from string
    return Integer.parseInt(num);

  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    String str1 = s.nextLine();
    String str2 = s.nextLine();
    String str3 = s.nextLine();

    cryptarithmetic(str1, str2, str3);
  }

}

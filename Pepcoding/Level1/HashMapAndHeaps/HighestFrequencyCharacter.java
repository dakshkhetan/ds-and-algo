/*

Sample Input
zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc

Sample Output
q

*/

import java.util.*;

public class Main {

  public static char highestFrequencyCharacter(String str) {
    Map<Character, Integer> map = new HashMap<>(); // char vs frequency

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (map.containsKey(ch)) {
        int frequency = map.get(ch);
        map.put(ch, frequency + 1);
      } else {
        map.put(ch, 1);
      }
    }

    int maxFreq = 0;
    char maxFreqChar = str.charAt(0);

    // for (int i = 0; i < str.length(); i++) {
    //   char ch = str.charAt(i);
    //   int frequency = map.get(ch);

    //   if (frequency > maxFreq) {
    //     maxFreq = frequency;
    //     maxFreqChar = ch;
    //   }
    // }

    for (Character ch : map.keySet()) {
      int frequency = map.get(ch);

      if (frequency > maxFreq) {
        maxFreq = frequency;
        maxFreqChar = ch;
      }
    }

    return maxFreqChar;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String str = s.nextLine();

    char ch = highestFrequencyCharacter(str);
    System.out.println(ch);
  }

}

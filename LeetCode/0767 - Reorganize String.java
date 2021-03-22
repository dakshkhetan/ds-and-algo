/*

Sample Input 1:
"aab"

Sample Output 1:
"aba"


Sample Input 2:
"aaab"

Sample Output 2:
""

*/

class Solution {

  public String reorganizeString(String str) {
    HashMap<Character, Integer> map = new HashMap<>(); // char vs frequency

    for (char ch : str.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

    // add all keys (unique characters in given string) to max-heap
    maxHeap.addAll(map.keySet());

    // the approach is to print the most-frequent character in the given string first,
    // then print the next most-frequent character... and so on (refer code below)

    StringBuilder sb = new StringBuilder();

    while (maxHeap.size() >= 2) { // atleast 2 unique characters should be present
      char currentChar = maxHeap.poll(); // max frequency character
      char nextChar = maxHeap.poll(); // second-max frequency character

      // add both characters alternatively
      sb.append(currentChar);
      sb.append(nextChar);

      // decrease frequency of both characters
      map.put(currentChar, map.get(currentChar) - 1);
      map.put(nextChar, map.get(nextChar) - 1);

      // if their frequency is still greater than 0, add them back to heap
      if (map.get(currentChar) > 0) {
        maxHeap.add(currentChar);
      }
      if (map.get(nextChar) > 0) {
        maxHeap.add(nextChar);
      }
    }

    if (!maxHeap.isEmpty()) {
      char remainingChar = maxHeap.poll();

      if (map.get(remainingChar) > 1) {
        // for eg: "aaab"
        return "";
      } else {
        // for eg: "aab"
        sb.append(remainingChar);
      }
    }

    return sb.toString();
  }

  // slightly faster than above approach (but almost identical)
  public String reorganizeString2(String str) {
    int frequency[] = new int[26];

    for (char ch : str.toCharArray()) {
      frequency[ch - 'a']++;
    }

    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

    // a[0] -> character
    // a[1] -> character's frequency

    for (int i = 0; i < 26; i++) {
      if (frequency[i] > 0) {
        maxHeap.add(new int[] { i, frequency[i] }); // char, freq
      }
    }

    StringBuilder sb = new StringBuilder();

    while (maxHeap.size() >= 2) {
      int maxFreqChar[] = maxHeap.poll();
      int nextMaxFreqChar[] = maxHeap.poll();

      sb.append((char) (maxFreqChar[0] + 'a'));
      sb.append((char) (nextMaxFreqChar[0] + 'a'));

      maxFreqChar[1]--;
      nextMaxFreqChar[1]--;

      if (maxFreqChar[1] > 0) {
        maxHeap.add(new int[] { maxFreqChar[0], maxFreqChar[1] });
      }

      if (nextMaxFreqChar[1] > 0) {
        maxHeap.add(new int[] { nextMaxFreqChar[0], nextMaxFreqChar[1] });
      }
    }

    if (!maxHeap.isEmpty()) {
      int remainingChar[] = maxHeap.poll();

      if (remainingChar[1] > 1) {
        return "";
      } else {
        sb.append((char) (remainingChar[0] + 'a'));
      }
    }

    return sb.toString();
  }

}

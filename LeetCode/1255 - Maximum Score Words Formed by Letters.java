/*

Sample Input:
words = ["dog","cat","dad","good"]
letters = ["a","a","c","d","d","d","g","o","o"]
score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]

Sample Output:
23

Explanation:
Scores: a=1, c=9, d=5, g=3, o=2
From the given letters, we can form the words "dad" (5+1+5) and "good" (3+2+2+5) 
with a score of 23, whereas words "dad" and "dog" only get a score of 21.

*/

class Solution {

  // Time Complexity: O(L + C(N,2) * K)
  // Space Complexity: O(S)
  // where,
  // N = number of given words
  // L = number of letters provided
  // K = average length of a word
  // S = length of scores array

  public int maxScoreWords(String[] words, char[] letters, int[] scores) {

    if (words == null || words.length == 0 || letters == null || letters.length == 0 || scores == null
        || scores.length == 0) {
      return 0;
    }

    // calculate and store frequency of each letter
    int freqOfLetters[] = new int[scores.length];
    for (char letter : letters) {
      int letterIndex = letter - 'a';
      freqOfLetters[letterIndex]++;
    }

    // use backtracking to solve
    return findMaxScoreOfWord(words, freqOfLetters, scores, 0);

  }

  private int findMaxScoreOfWord(String[] words, int[] freqOfLetters, int[] scores, int index) {

    // base case
    if (index == words.length) {
      return 0;
    }

    String currentWord = words[index];

    // include current word

    int currentWordScore = 0;
    boolean includeCurrentWord = true;
    int lastIteration = -1;

    for (int i = 0; i < currentWord.length(); i++) {
      char letter = currentWord.charAt(i);
      int letterIndex = letter - 'a';

      // check if the current letter in word is available to choose
      // if not, then don't include the word
      if (freqOfLetters[letterIndex] <= 0) {
        includeCurrentWord = false;
        lastIteration = i;
        break;
      }

      // decrease current letter's frequency by 1 and,
      // add its score to the sum of current word's score
      freqOfLetters[letterIndex]--;
      currentWordScore += scores[letterIndex];
    }

    // if current word can be included then, add its score and remaining
    // words score (using recursion) to result ('wordIncludedScore')
    // otherwise, set the result as zero

    int wordIncludedScore;
    if (includeCurrentWord) {
      wordIncludedScore = currentWordScore + findMaxScoreOfWord(words, freqOfLetters, scores, index + 1);
    } else {
      wordIncludedScore = 0;
    }

    // on backtracking, restore the frequency of letters in 'freqOfLetters[]'
    for (int i = 0; i < currentWord.length(); i++) {
      if (lastIteration != -1 && i >= lastIteration) {
        break;
      }

      char letter = currentWord.charAt(i);
      int letterIndex = letter - 'a';

      freqOfLetters[letterIndex]++;
    }

    // NOT include current word
    int wordNotIncludedScore = findMaxScoreOfWord(words, freqOfLetters, scores, index + 1);

    // take the max score of both cases
    int maxScore = Math.max(wordIncludedScore, wordNotIncludedScore);

    return maxScore;

  }

}

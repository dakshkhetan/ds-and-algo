/*

Reference Video - https://youtu.be/fUAZS-sdP2Q

Sample Input
+-++++++++
+-++++++++
+-++++++++
+-----++++
+-+++-++++
+-+++-++++
+++++-++++
++------++
+++++-++++
+++++-++++
4
LONDON
DELHI 
ICELAND 
ANKARA

Sample Output
+L++++++++
+O++++++++
+N++++++++
+DELHI++++
+O+++C++++
+N+++E++++
+++++L++++
++ANKARA++
+++++N++++
+++++D++++

*/

import java.util.*;

public class Main {

  public static void crosswordPuzzle(char[][] crosswordBoard, String[] words) {
    crosswordPuzzle(crosswordBoard, words, 0);
  }

  private static void crosswordPuzzle(char[][] crosswordBoard, String[] words, int wordIndex) {

    int noOfRows = crosswordBoard.length;
    int noOfColumns = crosswordBoard[0].length;
    int noOfWords = words.length;

    // base case
    if (wordIndex == noOfWords) {
      display(crosswordBoard);
      return;
    }

    String currentWord = words[wordIndex];

    for (int i = 0; i < noOfRows; i++) {
      for (int j = 0; j < noOfColumns; j++) {

        // only try to insert word if current cell is empty, or
        // it contains the first letter of that word
        if (crosswordBoard[i][j] == '-' || crosswordBoard[i][j] == currentWord.charAt(0)) {

          // now, we have two cases, to place the word horizontally or vertically
          // for both cases, first check if the word can be inserted beginning
          // from current cell
          // if yes, then insert the word in that direction
          // then, call recursion to insert the next word
          // finally, on backtracking, remove/unplace the current word (this is required
          // to try other possible combinations if current placement is invalid)

          // case 1: inserting word horizontally
          if (canWordBePlacedHorizontally(crosswordBoard, currentWord, i, j)) {

            // we'll use a boolean[] to track the insertion of letters of current word
            // this is required because, it may happen that few cells are already filled
            // with letters of other words that matches the correct placement with the
            // letters of current word
            boolean[] letterPlaced = placeWordHorizontally(crosswordBoard, currentWord, i, j);

            // solve for next word
            crosswordPuzzle(crosswordBoard, words, wordIndex + 1);

            // Important: on backtrack, remove/unplace only those letters of
            // current word that were inserted above
            unplaceWordHorizontally(crosswordBoard, letterPlaced, currentWord, i, j);
          }

          // case 2: inserting word vertically
          // similar process as above
          if (canWordBePlacedVertically(crosswordBoard, currentWord, i, j)) {
            boolean[] letterPlaced = placeWordVertically(crosswordBoard, currentWord, i, j);
            crosswordPuzzle(crosswordBoard, words, wordIndex + 1);
            unplaceWordVertically(crosswordBoard, letterPlaced, currentWord, i, j);
          }
        }
      }
    }

  }

  private static boolean canWordBePlacedHorizontally(char[][] crosswordBoard, String word, int i, int j) {

    int noOfColumns = crosswordBoard[0].length;

    // check if left side exists i.e. is there a cell on the left
    // if yes, then it should be blocked ('+')
    if (j - 1 >= 0 && crosswordBoard[i][j - 1] != '+') {
      return false;
    }

    // 'j + word.length()' -> the index just after inserting word

    // check if the word can be placed within board's dimensions
    if (j + word.length() - 1 >= noOfColumns) {
      return false;
    }

    // the next cell after inserting word should be blocked ('+')
    if (j + word.length() < noOfColumns && crosswordBoard[i][j + word.length()] != '+') {
      return false;
    }

    // finally, iterate over the length of given word,
    // and check if cell is empty to place the corresponding letter or already
    // contains the letter that matches with the corresponding letter of given word
    for (int k = 0; k < word.length(); k++) {
      if (crosswordBoard[i][j + k] == '-' || crosswordBoard[i][j + k] == word.charAt(k)) {
        continue;
      } else {
        return false;
      }
    }

    return true;

  }

  private static boolean[] placeWordHorizontally(char[][] crosswordBoard, String word, int i, int j) {

    // a boolean[] is required to track which letters of given word
    // has been inserted and which letters were already present
    boolean[] letterPlaced = new boolean[word.length()];

    for (int k = 0; k < word.length(); k++) {
      // only insert in empty cells
      if (crosswordBoard[i][j + k] == '-') {
        crosswordBoard[i][j + k] = word.charAt(k);
        letterPlaced[k] = true;
      }
    }

    return letterPlaced;

  }

  private static void unplaceWordHorizontally(char[][] crosswordBoard, boolean[] letterPlaced, String word, int i,
      int j) {

    for (int k = 0; k < word.length(); k++) {
      // remove only those letters that we inserted/placed for the given word
      if (letterPlaced[k]) {
        crosswordBoard[i][j + k] = '-';
      }
    }

  }

  private static boolean canWordBePlacedVertically(char[][] crosswordBoard, String word, int i, int j) {

    int noOfRows = crosswordBoard.length;

    if (i - 1 >= 0 && crosswordBoard[i - 1][j] != '+') {
      return false;
    }

    if (i + word.length() > noOfRows) {
      return false;
    }

    if (i + word.length() < noOfRows && crosswordBoard[i + word.length()][j] != '+') {
      return false;
    }

    for (int k = 0; k < word.length(); k++) {
      if (crosswordBoard[i + k][j] == '-' || crosswordBoard[i + k][j] == word.charAt(k)) {
        continue;
      } else {
        return false;
      }
    }

    return true;

  }

  private static boolean[] placeWordVertically(char[][] crosswordBoard, String word, int i, int j) {

    boolean[] letterPlaced = new boolean[word.length()];

    for (int k = 0; k < word.length(); k++) {
      // only insert in empty cells
      if (crosswordBoard[i + k][j] == '-') {
        crosswordBoard[i + k][j] = word.charAt(k);
        letterPlaced[k] = true;
      }
    }

    return letterPlaced;

  }

  private static void unplaceWordVertically(char[][] crosswordBoard, boolean[] letterPlaced, String word, int i,
      int j) {

    for (int k = 0; k < word.length(); k++) {
      // remove only those letters that we inserted/placed for the given word
      if (letterPlaced[k]) {
        crosswordBoard[i + k][j] = '-';
      }
    }

  }

  private static void display(char[][] crosswordBoard) {
    for (int i = 0; i < crosswordBoard.length; i++) {
      for (int j = 0; j < crosswordBoard[0].length; j++) {
        System.out.print(crosswordBoard[i][j]);
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    char[][] crosswordBoard = new char[10][10];
    for (int i = 0; i < 10; i++) {
      String str = s.next();
      crosswordBoard[i] = str.toCharArray();
    }

    int numOfWords = s.nextInt();
    String[] words = new String[numOfWords];
    for (int i = 0; i < numOfWords; i++) {
      words[i] = s.next();
    }

    crosswordPuzzle(crosswordBoard, words);
  }

}

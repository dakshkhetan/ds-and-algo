/* 

Sample Input
6
15
11
40
4
4
9
4

Sample Output
3
4

*/

import java.util.*;

public class Main {

  public static int[] allIndices(int[] arr, int element, int index, int foundSoFar) {
    if (index == arr.length) {
      return new int[foundSoFar];
    }

    if (arr[index] == element) {
      int indexArray[] = allIndices(arr, element, index + 1, foundSoFar + 1);
      indexArray[foundSoFar] = index;
      return indexArray;
    } else {
      int indexArray[] = allIndices(arr, element, index + 1, foundSoFar);
      return indexArray;
    }
  }

  public static void displayIndexArray(int[] arr) {
    if (arr.length == 0) {
      System.out.println();
      return;
    }

    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int arr[] = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int element = s.nextInt();

    int[] indexArray = allIndices(arr, element, 0, 0);
    displayIndexArray(indexArray);
  }

}

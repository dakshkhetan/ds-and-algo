/* 

Sample Input
5
7
11
12
13
14
15
16
17
21
22
23
24
25
26
27
31
32
33
34
35
36
37
41
42
43
44
45
46
47
51
52
53
54
55
56
57
2
3

Sample Output
11 12 13 14 15 16 17
21 25 26 36 46 45 27
31 24 33 34 35 44 37
41 23 22 32 42 43 47
51 52 53 54 55 56 57

*/

import java.util.*;

public class Main {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    int m = s.nextInt();
    int n = s.nextInt();

    int arr[][] = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = s.nextInt();
      }
    }

    int shell = s.nextInt();
    int rotation = s.nextInt();

    shellRotate(arr, shell, rotation);
    display(arr);

  }

  public static void shellRotate(int[][] arr, int shell, int rotation) {
    int oneDArray[] = covertShellToArray(arr, shell);
    rotateArray(oneDArray, rotation);
    convertArrayToShell(arr, shell, oneDArray);
  }

  public static int[] covertShellToArray(int[][] arr, int shell) {
    int minRow = shell - 1;
    int minCol = shell - 1;
    int maxRow = arr.length - shell;
    int maxCol = arr[0].length - shell;

    // shellSize = topWallElements + bottomWallElements + leftWallElements +
    // rightWallElements - allCornerElements
    // int shellSize = 2 * (maxRow - minRow + 1) + 2 * (maxCol - minCol + 1) - 4;
    int shellSize = 2 * (maxRow - minRow + maxCol - minCol);

    int oneDArray[] = new int[shellSize];
    int index = 0;

    // left wall
    for (int i = minRow, j = minCol; i <= maxRow; i++) {
      oneDArray[index] = arr[i][j];
      index++;
    }

    // bottom wall
    for (int i = maxRow, j = minCol + 1; j <= maxCol; j++) {
      oneDArray[index] = arr[i][j];
      index++;
    }

    // right wall
    for (int i = maxRow - 1, j = maxCol; i >= minRow; i--) {
      oneDArray[index] = arr[i][j];
      index++;
    }

    // top wall
    for (int i = minRow, j = maxCol - 1; j >= minCol + 1; j--) {
      oneDArray[index] = arr[i][j];
      index++;
    }

    return oneDArray;
  }

  public static void convertArrayToShell(int[][] arr, int shell, int[] oneDArray) {
    int minRow = shell - 1;
    int minCol = shell - 1;
    int maxRow = arr.length - shell;
    int maxCol = arr[0].length - shell;
    int index = 0;

    // left wall
    for (int i = minRow, j = minCol; i <= maxRow; i++) {
      arr[i][j] = oneDArray[index];
      index++;
    }

    // bottom wall
    for (int i = maxRow, j = minCol + 1; j <= maxCol; j++) {
      arr[i][j] = oneDArray[index];
      index++;
    }

    // right wall
    for (int i = maxRow - 1, j = maxCol; i >= minRow; i--) {
      arr[i][j] = oneDArray[index];
      index++;
    }

    // top wall
    for (int i = minRow, j = maxCol - 1; j >= minCol + 1; j--) {
      arr[i][j] = oneDArray[index];
      index++;
    }
  }

  public static void rotateArray(int[] arr, int k) {
    int n = arr.length;

    k = k % n;

    if (k < 0) {
      k = k + n;
    }

    reverseArray(arr, 0, n - k - 1);
    reverseArray(arr, n - k, n - 1);
    reverseArray(arr, 0, n - 1);
  }

  public static void reverseArray(int[] arr, int li, int ri) {
    while (li < ri) {
      int temp = arr[li];
      arr[li] = arr[ri];
      arr[ri] = temp;

      li++;
      ri--;
    }
  }

  public static void display(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

}

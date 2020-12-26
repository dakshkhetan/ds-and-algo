/*

Sample Input
4
1 5 7
5 8 4
3 2 9
1 2 4

Sample Output
8

*/

import java.util.*;

public class Main {

  public static int paintHouse(int[][] arr) {
    int redCost = arr[0][0];
    int greenCost = arr[0][1];
    int blueCost = arr[0][2];

    for (int i = 1; i < arr.length; i++) {
      int newRedCost = Math.min(greenCost, blueCost) + arr[i][0];
      int newGreenCost = Math.min(redCost, blueCost) + arr[i][1];
      int newBlueCost = Math.min(redCost, greenCost) + arr[i][2];

      redCost = newRedCost;
      greenCost = newGreenCost;
      blueCost = newBlueCost;
    }

    int minCost = Math.min(redCost, Math.min(greenCost, blueCost));
    return minCost;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();

    int arr[][] = new int[n][3];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 3; j++) {
        arr[i][j] = s.nextInt();
      }
    }

    int result = paintHouse(arr);
    System.out.println(result);
  }

}

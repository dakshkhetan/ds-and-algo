/*

Sample Input
6

Sample Output
441

*/

import java.util.*;

public class Main {

  public static long arrangeBuildings(int n) {
    int building = 1;
    int emptyPlot = 1;

    for (int i = 2; i <= n; i++) {
      int newBuilding = emptyPlot;
      int newEmptyPlot = building + emptyPlot;

      building = newBuilding;
      emptyPlot = newEmptyPlot;
    }

    long requiredWaysForOneSide = building + emptyPlot;
    long requiredWaysForBothSides = requiredWaysForOneSide * requiredWaysForOneSide;

    return requiredWaysForBothSides;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();

    long result = arrangeBuildings(n);
    System.out.println(result);
  }

}

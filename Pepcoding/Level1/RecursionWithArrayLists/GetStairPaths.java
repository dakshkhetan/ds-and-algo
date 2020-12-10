/* 

Sample Input
3

Sample Output
[111, 12, 21, 3]

*/

import java.util.*;

public class Main {

  public static ArrayList<String> getStairPaths(int n) {
    if (n < 0) {
      ArrayList<String> baseCase = new ArrayList<>();
      return baseCase;
    }

    if (n == 0) {
      ArrayList<String> baseCase = new ArrayList<>();
      baseCase.add("");
      return baseCase;
    }

    ArrayList<String> pathsWithStep1 = getStairPaths(n - 1);
    ArrayList<String> pathsWithStep2 = getStairPaths(n - 2);
    ArrayList<String> pathsWithStep3 = getStairPaths(n - 3);

    ArrayList<String> totalPaths = new ArrayList<>();

    for (String path : pathsWithStep1) {
      totalPaths.add("1" + path);
    }
    for (String path : pathsWithStep2) {
      totalPaths.add("2" + path);
    }
    for (String path : pathsWithStep3) {
      totalPaths.add("3" + path);
    }

    return totalPaths;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    ArrayList<String> output = getStairPaths(n);
    System.out.println(output);
  }

}

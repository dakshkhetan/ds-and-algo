/*

Sample Input
17
12 5 1 2 10 2 13 7 11 8 9 11 8 9 5 6 11

Sample Output
5
6
7
8
9
10
11
12
13

*/

import java.util.*;

public class Main {

  public static int[] LCSofElements(int[] arr) {
    Map<Integer, Boolean> map = new HashMap<>(); // element vs isStartingPoint

    for (int key : arr) {
      map.put(key, true);
    }

    for (int num : arr) {
      int previousNum = num - 1;
      if (map.containsKey(previousNum)) {
        map.put(num, false);
      }
    }

    int lcsLength = 0;
    int lcsStartingPoint = arr[0];

    for (int num : arr) {
      if (map.get(num) == true) {
        // 'num' is starting point of one of the sequence(s) present in 'arr'

        int length = 1;
        int nextNum = num + 1;

        while (map.containsKey(nextNum)) {
          length++;
          nextNum++;
        }

        if (length > lcsLength) {
          lcsLength = length;
          lcsStartingPoint = num;
        }
      }
    }

    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < lcsLength; i++) {
      // System.out.println(lcsStartingPoint + i);
      list.add(lcsStartingPoint + i);
    }

    return list.stream().mapToInt(i -> i).toArray();
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int result[] = LCSofElements(arr);
    for (int element : result) {
      System.out.println(element);
    }
  }

}

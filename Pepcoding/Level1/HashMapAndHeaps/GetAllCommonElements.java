/*

Sample Input
7
1 1 2 2 2 3 5
7
1 1 1 2 2 4 5

Sample Output
1
1
2
2
5

*/

import java.util.*;

public class Main {

  public static int[] getAllCommonElements(int[] arr1, int[] arr2) {
    Map<Integer, Integer> map = new HashMap<>(); // element vs frequency

    for (int element : arr1) {
      // int frequency = map.get(element);
      // if (map.containsKey(element)) {
      //   map.put(element, frequency + 1);
      // } else {
      //   map.put(element, 1);
      // }

      int frequency = map.getOrDefault(element, 0);
      map.put(element, frequency + 1);
    }

    ArrayList<Integer> list = new ArrayList<>();

    for (int element : arr2) {
      if (map.containsKey(element) && map.get(element) > 0) {
        // System.out.println(element);
        list.add(element);
        map.put(element, map.get(element) - 1);
      }
    }

    return list.stream().mapToInt(i -> i).toArray();
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n1 = s.nextInt();
    int arr1[] = new int[n1];
    for (int i = 0; i < n1; i++) {
      arr1[i] = s.nextInt();
    }

    int n2 = s.nextInt();
    int arr2[] = new int[n2];
    for (int i = 0; i < n2; i++) {
      arr2[i] = s.nextInt();
    }

    int result[] = getAllCommonElements(arr1, arr2);
    for (int element : result) {
      System.out.println(element);
    }
  }

}

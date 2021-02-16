/*

Sample Input
9
5 5 9 8 5 5 8 0 3
18
9 7 1 0 3 6 5 9 1 1 8 0 2 4 2 9 1 5

Sample Output
9
0
3
5
8

*/

import java.util.*;

public class Main {

  public static int[] getCommonElements(int[] arr1, int[] arr2) {
    Map<Integer, Integer> map = new HashMap<>(); // element vs _

    for (int element : arr1) {
      map.put(element, 0);
    }

    ArrayList<Integer> list = new ArrayList<>();

    for (int element : arr2) {
      if (map.containsKey(element)) {
        // System.out.println(element);
        list.add(element);
        map.remove(element);
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

    int result[] = getCommonElements(arr1, arr2);
    for (int element : result) {
      System.out.println(element);
    }
  }

}

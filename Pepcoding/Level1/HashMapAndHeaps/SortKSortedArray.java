/*

Sample Input
9
3 2 4 1 6 5 7 9 8
3

Sample Output
1
2
3
4
5
6
7
8
9

*/

import java.util.*;

public class Main {

  public static ArrayList<Integer> sortKSortedArray(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i <= k; i++) {
      pq.add(arr[i]);
    }

    for (int i = k + 1; i < arr.length; i++) {
      list.add(pq.poll());
      pq.add(arr[i]);
    }

    while (!pq.isEmpty()) {
      list.add(pq.poll());
    }

    return list;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }
    int k = s.nextInt();

    ArrayList<Integer> result = sortKSortedArray(arr, k);
    for (int element : result) {
      System.out.println(element);
    }
  }

}

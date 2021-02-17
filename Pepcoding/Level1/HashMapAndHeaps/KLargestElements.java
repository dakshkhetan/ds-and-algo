/*

Sample Input
13
12 62 22 15 37 99 11 37 98 67 31 84 99
4

Sample Output
84
98
99
99

*/

import java.util.*;

public class Main {

  public static ArrayList<Integer> KLargestElements(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int num : arr) {
      pq.add(num);
    }

    while (pq.size() > k) {
      pq.poll();
    }

    ArrayList<Integer> output = new ArrayList<>();

    while (!pq.isEmpty()) {
      output.add(pq.poll());
    }

    return output;
  }

  // Alternate Approach:
  public static ArrayList<Integer> KLargestElements2(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < k; i++) {
      pq.add(arr[i]);
    }

    for (int i = k; i < arr.length; i++) {
      if (arr[i] > pq.peek()) {
        pq.poll();
        pq.add(arr[i]);
      }
    }

    ArrayList<Integer> output = new ArrayList<>();

    while (!pq.isEmpty()) {
      output.add(pq.poll());
    }

    return output;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }
    int k = s.nextInt();

    ArrayList<Integer> result = KLargestElements(arr, k);
    // ArrayList<Integer> result = KLargestElements2(arr, k);

    for (int element : result) {
      System.out.println(element);
    }
  }

}

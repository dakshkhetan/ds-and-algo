/*

Sample Input
4
5
10 20 30 40 50
7
5 7 9 11 19 55 57
3
1 2 3
2
32 39

Sample Output
1 2 3 5 7 9 10 11 19 20 30 32 39 40 50 55 57 

*/

import java.util.*;

class Pair implements Comparable<Pair> {
  int listIndex;
  int dataIndex;
  int data;

  public int compareTo(Pair otherPair) {
    // if +ve value is returned -> currentPair > otherPair
    // if -ve value is returned -> currentPair < otherPair
    // if 0 is returned -> currentPair = otherPair

    return this.data - otherPair.data;
  }
}

/*

class PairComparator implements Comparator<Pair> {
  public int compare(Pair p1, Pair p2) {
    // if +ve value is returned -> p1 > p2
    // if -ve value is returned -> p1 < p2
    // if 0 is returned -> p1 = p2

    // return p1.num - p2.num;

    if (p1.data >= p2.data) {
      return 1;
    } else {
      return -1;
    }
  }
}

*/

public class Main {

  public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
    if (lists.size() == 0) {
      return null;
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>();
    // PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());

    for (int i = 0; i < lists.size(); i++) {
      Pair pair = new Pair();
      pair.listIndex = i;
      pair.dataIndex = 0;
      pair.data = lists.get(i).get(0);

      pq.add(pair);
    }

    ArrayList<Integer> sortedList = new ArrayList<>();

    while (!pq.isEmpty()) {
      Pair pair = pq.poll();
      sortedList.add(pair.data);
      pair.dataIndex++;

      ArrayList<Integer> list = lists.get(pair.listIndex);
      if (pair.dataIndex < list.size()) {
        pair.data = list.get(pair.dataIndex);
        pq.add(pair);
      }
    }

    return sortedList;
  }

  // Alternate Approach:
  public static ArrayList<Integer> mergeKSortedLists2(ArrayList<ArrayList<Integer>> lists) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    int maxListSize = -1;
    for (ArrayList<Integer> list : lists) {
      maxListSize = Math.max(list.size(), maxListSize);
    }

    for (int i = 0; i < maxListSize; i++) {
      for (ArrayList<Integer> list : lists) {
        if (i < list.size()) {
          pq.add(list.get(i));
        }
      }
    }

    ArrayList<Integer> sortedList = new ArrayList<>();
    while (!pq.isEmpty()) {
      sortedList.add(pq.poll());
    }

    return sortedList;
  }

  // Naive Approach:
  public static ArrayList<Integer> mergeKSortedLists3(ArrayList<ArrayList<Integer>> lists) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (ArrayList<Integer> list : lists) {
      for (int value : list) {
        pq.add(value);
      }
    }

    ArrayList<Integer> sortedList = new ArrayList<>();
    while (!pq.isEmpty()) {
      sortedList.add(pq.poll());
    }

    return sortedList;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int k = s.nextInt();
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      ArrayList<Integer> list = new ArrayList<>();
      int n = s.nextInt();
      for (int j = 0; j < n; j++) {
        list.add(s.nextInt());
      }
      lists.add(list);
    }

    ArrayList<Integer> result = mergeKSortedLists(lists);
    // ArrayList<Integer> result = mergeKSortedLists2(lists);
    // ArrayList<Integer> result = mergeKSortedLists3(lists);

    for (int element : result) {
      System.out.print(element + " ");
    }
  }

}

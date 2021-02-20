/*

Sample Input
7
10 2 17 3 18 9 22

Sample Output
2
3
9
10
17
18
22

*/

import java.util.*;

class PriorityQueue {
  ArrayList<Integer> data;

  /* O(n*logn) */
  // public PriorityQueue(int[] arr) {
  //   data = new ArrayList<>();

  //   for (int num : arr) {
  //     this.add(num); // calling add() for every element
  //   }
  // }

  /* O(n) */
  public PriorityQueue(int[] arr) {
    data = new ArrayList<>();

    for (int num : arr) {
      data.add(num);
    }

    // lastParentIndex -> index of last (right-most) node on second-last level
    int lastParentIndex = data.size() / 2 - 1;
    for (int i = lastParentIndex; i >= 0; i--) {
      downHeapify(i);
    }
  }

  public int size() {
    return data.size();
  }

  public boolean isEmpty() {
    if (data.size() == 0) {
      return true;
    } else {
      return false;
    }
  }

  public void add(int num) {
    data.add(num);
    upHeapify(data.size() - 1);
  }

  private void upHeapify(int childIndex) {
    if (childIndex == 0) {
      return;
    }

    int parentIndex = (childIndex - 1) / 2;

    if (data.get(childIndex) < data.get(parentIndex)) {
      swapElementsAtIndices(childIndex, parentIndex);
      upHeapify(parentIndex);
    }
  }

  private void swapElementsAtIndices(int i, int j) {
    int ith = data.get(i);
    int jth = data.get(j);
    data.set(i, jth);
    data.set(j, ith);
  }

  public int remove() {
    if (data.size() == 0) {
      System.out.println("Underflow");
      return -1;
    }

    int min = data.get(0);

    swapElementsAtIndices(0, data.size() - 1);
    data.remove(data.size() - 1);
    downHeapify(0);

    return min;
  }

  private void downHeapify(int parentIndex) {
    int minValueIndex = parentIndex;

    int leftChildIndex = 2 * parentIndex + 1;
    int rightChildIndex = 2 * parentIndex + 2;

    if ((leftChildIndex < data.size()) && (data.get(leftChildIndex) < data.get(minValueIndex))) {
      minValueIndex = leftChildIndex;
    }

    if ((rightChildIndex < data.size()) && (data.get(rightChildIndex) < data.get(minValueIndex))) {
      minValueIndex = rightChildIndex;
    }

    if (parentIndex != minValueIndex) {
      swapElementsAtIndices(parentIndex, minValueIndex);
      downHeapify(minValueIndex);
    }
  }

  public int peek() {
    if (data.size() == 0) {
      System.out.println("Underflow");
      return -1;
    }

    return data.get(0);
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    PriorityQueue pq = new PriorityQueue(arr);

    while (!pq.isEmpty()) {
      System.out.println(pq.remove());
    }
  }

}

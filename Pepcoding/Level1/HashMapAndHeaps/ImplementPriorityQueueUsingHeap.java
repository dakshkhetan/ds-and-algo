/*

Sample Input
add 10
add 20
add 30
size
peek
add 40
remove
peek
remove
peek
quit

Sample Output
3
10
10
20
20
30

*/

import java.util.*;

class PriorityQueue {
  ArrayList<Integer> data;

  public PriorityQueue() {
    data = new ArrayList<>();
  }

  public int size() {
    return data.size();
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

    PriorityQueue pq = new PriorityQueue();

    String str = s.nextLine();
    while (!str.equals("quit")) {
      if (str.startsWith("add")) {
        int value = Integer.parseInt(str.split(" ")[1]);
        pq.add(value);
      } else if (str.startsWith("remove")) {
        int val = pq.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = pq.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(pq.size());
      }
      str = s.nextLine();
    }
  }

}

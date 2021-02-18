/*

Sample Input
add 10
add 20
add 30
peek
add 40
peek
remove
remove
peek
quit

Sample Output
20
20
20
30
10

*/

import java.util.*;

class MedianPriorityQueue {
  PriorityQueue<Integer> leftHeap; // max PQ
  PriorityQueue<Integer> rightHeap; // min PQ

  public MedianPriorityQueue() {
    leftHeap = new PriorityQueue<>(Collections.reverseOrder());
    rightHeap = new PriorityQueue<>();
  }

  public int size() {
    return leftHeap.size() + rightHeap.size();
  }

  public void add(int num) {
    if (leftHeap.isEmpty()) {
      leftHeap.add(num);
    } else if (leftHeap.size() > rightHeap.size()) {
      if (num > leftHeap.peek()) {
        rightHeap.add(num);
      } else {
        leftHeap.add(num);
        rightHeap.add(leftHeap.poll());
      }
    } else {
      if (num > leftHeap.peek()) {
        rightHeap.add(num);
        leftHeap.add(rightHeap.poll());
      } else {
        leftHeap.add(num);
      }
    }
  }

  public int remove() {
    if (leftHeap.isEmpty()) {
      System.out.println("Underflow");
      return -1;
    } else if (leftHeap.size() == rightHeap.size()) {
      int median = leftHeap.poll();
      leftHeap.add(rightHeap.poll());
      return median;
    } else {
      return leftHeap.poll();
    }
  }

  public int peek() {
    if (leftHeap.isEmpty()) {
      System.out.println("Underflow");
      return -1;
    } else {
      return leftHeap.peek();
    }
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    MedianPriorityQueue pq = new MedianPriorityQueue();

    String str = s.nextLine();
    while (!str.equals("quit")) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        pq.add(val);
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

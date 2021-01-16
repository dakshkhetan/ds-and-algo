/*

Sample Input
add 10
add 20
add 30
add 40
peek
remove
peek
remove
peek
remove
peek
remove
quit

Sample Output
10
10
20
20
30
30
40
40

*/

import java.util.*;

class LinkedListToQueue {
  LinkedList<Integer> list;

  public LinkedListToQueue() {
    list = new LinkedList<>();
  }

  int size() {
    return list.size();
  }

  void add(int val) {
    list.addLast(val);
  }

  int remove() {
    if (size() == 0) {
      System.out.println("Queue underflow");
      return -1;
    } else {
      return list.removeFirst();
    }
  }

  int peek() {
    if (size() == 0) {
      System.out.println("Queue underflow");
      return -1;
    } else {
      return list.getFirst();
    }
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    LinkedListToQueue queue = new LinkedListToQueue();

    String str = s.nextLine();
    while (!str.equals("quit")) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        queue.add(val);
      } else if (str.startsWith("remove")) {
        int val = queue.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = queue.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(queue.size());
      }
      str = s.nextLine();
    }
  }

}

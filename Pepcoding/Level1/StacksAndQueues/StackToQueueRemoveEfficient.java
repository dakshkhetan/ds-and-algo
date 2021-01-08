/*

Sample Input
add 10
add 20
add 30
remove
remove
add 40
add 50
peek
remove
peek
remove
remove
remove
quit

Sample Output
10
20
30
30
40
40
50
Queue underflow

*/

import java.util.*;

class StackToQueue {
  Stack<Integer> stack;
  Stack<Integer> helperStack;

  public StackToQueue() {
    stack = new Stack<>();
    helperStack = new Stack<>();
  }

  int size() {
    return stack.size();
  }

  void add(int val) {
    while (!stack.isEmpty()) {
      helperStack.push(stack.pop());
    }

    stack.push(val);

    while (!helperStack.isEmpty()) {
      stack.push(helperStack.pop());
    }
  }

  int remove() {
    if (stack.isEmpty()) {
      System.out.println("Queue underflow");
      return -1;
    } else {
      return stack.pop();
    }
  }

  int peek() {
    if (stack.isEmpty()) {
      System.out.println("Queue underflow");
      return -1;
    } else {
      return stack.peek();
    }
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    StackToQueue queue = new StackToQueue();

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

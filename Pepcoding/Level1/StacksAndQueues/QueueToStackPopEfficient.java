/*

Sample Input
push 10
push 20
push 5
push 8
push 2
push 4
push 11
top
size
pop
top
size
pop
top
size
pop
top
size
quit

Sample Output
11
7
11
4
6
4
2
5
2
8
4

*/

import java.util.*;

class QueueToStack {
  Queue<Integer> queue;
  Queue<Integer> helperQueue;

  public QueueToStack() {
    queue = new ArrayDeque<>();
    helperQueue = new ArrayDeque<>();
  }

  int size() {
    return queue.size();
  }

  void push(int val) {
    if (queue.isEmpty()) {
      queue.add(val);
    } else {
      while (!queue.isEmpty()) {
        helperQueue.add(queue.remove());
      }

      queue.add(val);

      while (!helperQueue.isEmpty()) {
        queue.add(helperQueue.remove());
      }
    }
  }

  int pop() {
    if (!queue.isEmpty()) {
      return queue.remove();
    } else {
      System.out.println("Stack underflow");
      return -1;
    }
  }

  int top() {
    if (!queue.isEmpty()) {
      return queue.peek();
    } else {
      System.out.println("Stack underflow");
      return -1;
    }
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    QueueToStack st = new QueueToStack();

    String str = s.nextLine();
    while (!str.equals("quit")) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      }
      str = s.nextLine();
    }
  }

}

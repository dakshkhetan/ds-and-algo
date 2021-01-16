/*

Sample Input
push 10
push 20
push 5
push 8
push 3
top
size
pop
top
size
pop
top
size
pop
quit

Sample Output
3
5
3
8
4
8
5
3
5

*/

import java.util.*;

class LinkedListToStack {
  LinkedList<Integer> list;

  public LinkedListToStack() {
    list = new LinkedList<>();
  }

  int size() {
    return list.size();
  }

  void push(int val) {
    list.addFirst(val);
  }

  int pop() {
    if (size() == 0) {
      System.out.println("Stack underflow");
      return -1;
    } else {
      return list.removeFirst();
    }
  }

  int top() {
    if (size() == 0) {
      System.out.println("Stack underflow");
      return -1;
    } else {
      return list.getFirst();
    }
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    LinkedListToStack st = new LinkedListToStack();

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

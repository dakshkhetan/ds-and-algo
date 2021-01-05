/*

Sample Input
push 4
push 12
push 10
push 8
top
min
pop
push 5
pop
min
quit

Sample Output
8
4
8
5
4

*/

import java.util.*;

class MinStack {

  Stack<Integer> allStack;
  Stack<Integer> minStack;

  public MinStack() {
    allStack = new Stack<>();
    minStack = new Stack<>();
  }

  int size() {
    return allStack.size();
  }

  void push(int val) {
    allStack.push(val);
    if (minStack.isEmpty() || val <= minStack.peek()) {
      minStack.push(val);
    }
  }

  int pop() {
    if (!allStack.isEmpty()) {
      int val = allStack.pop();
      if (val == minStack.peek()) {
        minStack.pop();
      }
      return val;
    } else {
      return -1;
    }
  }

  int top() {
    if (!allStack.isEmpty()) {
      return allStack.peek();
    } else {
      return -1;
    }
  }

  int min() {
    if (!minStack.isEmpty()) {
      return minStack.peek();
    } else {
      return -1;
    }
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    MinStack st = new MinStack();

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
      } else if (str.startsWith("min")) {
        int val = st.min();
        if (val != -1) {
          System.out.println(val);
        }
      }
      str = s.nextLine();
    }
  }

}

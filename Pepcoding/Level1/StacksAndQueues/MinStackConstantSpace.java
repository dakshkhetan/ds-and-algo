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

  Stack<Integer> stack;
  int min;

  public MinStack() {
    stack = new Stack<>();
  }

  int size() {
    return stack.size();
  }

  void push(int val) {
    if (stack.isEmpty()) {
      stack.push(val);
      min = val;
    } else if (val >= min) {
      stack.push(val);
    } else {
      stack.push(val + val - min); // important
      min = val;
    }
  }

  int pop() {
    if (!stack.isEmpty()) {
      int val = stack.pop();
      if (val >= min) {
        return val;
      } else {
        int originalValue = min;
        min = 2 * min - val; // important
        return originalValue;
      }
    } else {
      return -1;
    }
  }

  int top() {
    if (!stack.isEmpty()) {
      int val = stack.peek();
      if (val >= min) {
        return val;
      } else {
        return min;
      }
    } else {
      return -1;
    }
  }

  int min() {
    if (!stack.isEmpty()) {
      return min;
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

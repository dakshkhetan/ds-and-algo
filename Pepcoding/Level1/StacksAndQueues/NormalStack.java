/*

Sample Input
4
push 10
display
push 20
display
push 30
display
push 40
top
pop
display
pop
pop
pop
display
pop
quit

Sample Output
10 
20 10 
30 20 10 
40
40
30 20 10 
30
20
10

Stack underflow

*/

import java.util.*;

class NormalStack {

  int data[];
  int topOfStack;

  public NormalStack(int capacity) {
    data = new int[capacity];
    topOfStack = -1;
  }

  int size() {
    return topOfStack + 1;
  }

  void display() {
    for (int i = topOfStack; i >= 0; i--) {
      System.out.print(data[i] + " ");
    }
    System.out.println();
  }

  void push(int val) {
    if (topOfStack == data.length - 1) {
      System.out.println("Stack overflow");
    } else {
      topOfStack++;
      data[topOfStack] = val;
    }
  }

  int pop() {
    if (topOfStack == -1) {
      System.out.println("Stack underflow");
      return -1;
    } else {
      int val = data[topOfStack];
      topOfStack--;
      return val;
    }
  }

  int top() {
    if (topOfStack == -1) {
      System.out.println("Stack underflow");
      return -1;
    } else {
      return data[topOfStack];
    }
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    NormalStack st = new NormalStack(n);

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
      } else if (str.startsWith("display")) {
        st.display();
      }
      str = s.nextLine();
    }
  }

}

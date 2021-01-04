/*

Sample Input
3
push 10
display
push 20
display
push 30
display
push 40
display
top
pop
display
top
pop
display
quit

Sample Output
10 
20 10 
30 20 10 
40 30 20 10 
40
40
30 20 10 
30
30
20 10

*/

import java.util.*;

class DynamicStack {

  int data[];
  int topOfStack;

  public DynamicStack(int capacity) {
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
      int newData[] = new int[2 * data.length];
      for (int i = 0; i < data.length; i++) {
        newData[i] = data[i];
      }
      data = newData;
    }

    topOfStack++;
    data[topOfStack] = val;
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
    DynamicStack st = new DynamicStack(n);

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

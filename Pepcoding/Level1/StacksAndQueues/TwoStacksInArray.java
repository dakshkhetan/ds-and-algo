/*

Sample Input:
5
push1 10
push1 20
push2 30
push2 40
push2 50
push1 60
top1
pop1
top1
pop1
top2
pop2
top2
pop2
top1
pop1
top2
pop2
quit

Sample Output:
Stack overflow
20
20
10
10
50
50
40
40
Stack underflow
Stack underflow
30
30

*/

import java.util.*;

class TwoStacksInArray {

  int data[];
  int topOfStack1;
  int topOfStack2;

  public TwoStacksInArray(int capacity) {
    data = new int[capacity];
    topOfStack1 = -1; // bottom
    topOfStack2 = capacity; // top
  }

  int size1() {
    return topOfStack1 + 1;
  }

  int size2() {
    return data.length - topOfStack2;
  }

  void push1(int val) {
    if (topOfStack1 + 1 == topOfStack2) {
      System.out.println("Stack overflow");
    } else {
      topOfStack1++;
      data[topOfStack1] = val;
    }
  }

  void push2(int val) {
    if (topOfStack2 - 1 == topOfStack1) {
      System.out.println("Stack overflow");
    } else {
      topOfStack2--;
      data[topOfStack2] = val;
    }
  }

  int pop1() {
    if (topOfStack1 == -1) {
      System.out.println("Stack underflow");
      return -1;
    } else {
      int val = data[topOfStack1];
      topOfStack1--;
      return val;
    }
  }

  int pop2() {
    if (topOfStack2 == data.length) {
      System.out.println("Stack underflow");
      return -1;
    } else {
      int val = data[topOfStack2];
      topOfStack2++;
      return val;
    }
  }

  int top1() {
    if (topOfStack1 == -1) {
      System.out.println("Stack underflow");
      return -1;
    } else {
      return data[topOfStack1];
    }
  }

  int top2() {
    if (topOfStack2 == data.length) {
      System.out.println("Stack underflow");
      return -1;
    } else {
      return data[topOfStack2];
    }
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    TwoStacksInArray st = new TwoStacksInArray(n);

    String str = s.nextLine();
    while (!str.equals("quit")) {
      if (str.startsWith("push1")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push1(val);
      } else if (str.startsWith("pop1")) {
        int val = st.pop1();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top1")) {
        int val = st.top1();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size1")) {
        System.out.println(st.size1());
      } else if (str.startsWith("push2")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push2(val);
      } else if (str.startsWith("pop2")) {
        int val = st.pop2();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top2")) {
        int val = st.top2();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size2")) {
        System.out.println(st.size2());
      }
      str = s.nextLine();
    }
  }

}

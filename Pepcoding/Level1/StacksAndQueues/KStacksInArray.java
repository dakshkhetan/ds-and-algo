/*

Reference Video (GFG): https://youtu.be/S5cYO9k1Ja8

Sample Input:
3
8
push(15, 2)
push(45, 2)
push(17, 1)
push(49, 1)
push(39, 1)
push(11, 0)
push(9, 0)
push(7, 0)
pop(2)
pop(1)
pop(0)
quit

Sample Output:
Popped element from stack 2 : 45
Popped element from stack 1 : 39
Popped element from stack 0 : 7

*/

import java.util.*;

class KStacksInArray {

  int stackData[];
  int topOfStack[];
  int nextSpaceOrPrevTop[]; // next available free space index and/or previous top element's index in stackData[]
  int nextFreeSpaceIndex;

  public KStacksInArray(int k, int capacity) {
    stackData = new int[capacity];
    topOfStack = new int[k];
    nextSpaceOrPrevTop = new int[capacity];
    nextFreeSpaceIndex = 0;

    for (int i = 0; i < k; i++) {
      topOfStack[i] = -1; // -1 denotes empty
    }

    for (int i = 0; i < capacity - 1; i++) {
      nextSpaceOrPrevTop[i] = i + 1;
    }
    nextSpaceOrPrevTop[capacity - 1] = -1; // -1 denotes no space left
  }

  boolean isEmpty(int stackNum) {
    return (topOfStack[stackNum] == -1);
  }

  boolean isFull() {
    return (nextFreeSpaceIndex == -1);
  }

  void push(int element, int stackNum) {
    if (stackNum < 0 || stackNum >= topOfStack.length) {
      System.out.println("Invalid Stack");
      return;
    } else if (isFull()) {
      System.out.println("Stack Overflow");
      return;
    } else {
      int index = nextFreeSpaceIndex;
      stackData[index] = element;

      nextFreeSpaceIndex = nextSpaceOrPrevTop[index];
      nextSpaceOrPrevTop[index] = topOfStack[stackNum];
      topOfStack[stackNum] = index;
    }
  }

  int pop(int stackNum) {
    if (stackNum < 0 || stackNum >= topOfStack.length) {
      System.out.println("Invalid Stack");
      return -1;
    } else if (isEmpty(stackNum)) {
      System.out.println("Stack Underflow");
      return -1;
    } else {
      int index = topOfStack[stackNum];
      int element = stackData[index];

      topOfStack[stackNum] = nextSpaceOrPrevTop[index];
      nextSpaceOrPrevTop[index] = nextFreeSpaceIndex;
      nextFreeSpaceIndex = index;

      return element;
    }
  }

  int top(int stackNum) {
    if (stackNum < 0 || stackNum >= topOfStack.length) {
      System.out.println("Invalid Stack");
      return -1;
    } else if (isEmpty(stackNum)) {
      System.out.println("Stack Underflow");
      return -1;
    } else {
      int index = topOfStack[stackNum];
      int element = stackData[index];
      return element;
    }
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int k = s.nextInt();
    int n = s.nextInt();
    KStacksInArray st = new KStacksInArray(k, n);

    String str = s.nextLine();
    while (!str.equals("quit")) {
      if (str.startsWith("push")) {
        int element = Integer.parseInt(str.substring(str.indexOf("(") + 1, str.indexOf(",")));
        int stackNum = Integer.parseInt(str.substring(str.indexOf(" ") + 1, str.indexOf(")")));
        st.push(element, stackNum);
      } else if (str.startsWith("pop")) {
        int stackNum = Integer.parseInt(str.substring(str.indexOf("(") + 1, str.indexOf(")")));
        int element = st.pop(stackNum);
        if (element != -1) {
          System.out.println("Popped element from stack " + stackNum + " : " + element);
        }
      } else if (str.startsWith("top")) {
        int stackNum = Integer.parseInt(str.substring(str.indexOf("(") + 1, str.indexOf(")")));
        int element = st.top(stackNum);
        if (element != -1) {
          System.out.println("Top element of stack " + stackNum + " : " + element);
        }
      }
      str = s.nextLine();
    }
  }

}

/*

Sample Input
5
add 10
display
add 20
display
add 30
display
add 40
display
add 50
display
add 60
display
peek
remove
display
peek
remove
display
peek
remove
display
peek
remove
display
peek
remove
display
peek
remove
quit

Sample Output
10 
10 20 
10 20 30 
10 20 30 40 
10 20 30 40 50 
Queue overflow
10 20 30 40 50 
10
10
20 30 40 50 
20
20
30 40 50 
30
30
40 50 
40
40
50 
50
50

Queue underflow
Queue underflow

*/

import java.util.*;

class NormalQueue {

  int data[];
  int front;
  int size;

  public NormalQueue(int capacity) {
    data = new int[capacity];
    front = 0;
    size = 0;
  }

  int size() {
    return size;
  }

  void add(int val) {
    if (size == data.length) {
      System.out.println("Queue overflow");
    } else {
      int rear = (front + size) % data.length;
      data[rear] = val;
      size++;
    }
  }

  int remove() {
    if (size == 0) {
      System.out.println("Queue underflow");
      return -1;
    } else {
      int val = data[front];
      front = (front + 1) % data.length;
      size--;
      return val;
    }
  }

  int peek() {
    if (size == 0) {
      System.out.println("Queue underflow");
      return -1;
    } else {
      return data[front];
    }
  }

  void display() {
    for (int i = 0; i < size; i++) {
      int index = (i + front) % data.length;
      System.out.print(data[index] + " ");
    }
    System.out.println();
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    NormalQueue queue = new NormalQueue(n);

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
      } else if (str.startsWith("display")) {
        queue.display();
      }
      str = s.nextLine();
    }
  }

}

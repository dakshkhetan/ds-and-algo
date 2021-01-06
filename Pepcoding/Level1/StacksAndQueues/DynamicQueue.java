/*

Sample Input
3
add 10
display
add 20
display
add 30
display
add 40
display
peek
remove
display
remove
remove
remove
remove
quit

Sample Output
10 
10 20 
10 20 30 
10 20 30 40 
10
10
20 30 40 
20
30
40
Queue underflow

*/

import java.util.*;

class DynamicQueue {

  int data[];
  int front;
  int size;

  public DynamicQueue(int capacity) {
    data = new int[capacity];
    front = 0;
    size = 0;
  }

  int size() {
    return size;
  }

  void add(int val) {
    if (size == data.length) {
      int newData[] = new int[2 * data.length];
      for (int i = 0; i < size; i++) {
        int index = (i + front) % data.length;
        newData[i] = data[index];
      }
      data = newData;

      front = 0;
    }

    int rear = (front + size) % data.length;
    data[rear] = val;
    size++;
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
    DynamicQueue queue = new DynamicQueue(n);

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

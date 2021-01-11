/*

Sample Input
addLast 10
addLast 20
addLast 30
addLast 40
addLast 50
quit

Sample Output
10
20
30
40
50
5
50

*/

import java.util.*;

class Node<T> {
  T data;
  Node<T> next;

  public Node(T data) {
    this.data = data;
  }
}

class LinkedList<T> {
  Node<T> head;
  Node<T> tail;
  int size;

  void addLast(T val) {
    Node<T> newNode = new Node<>(val);
    size++;

    if (head == null) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
  }
}

public class Main {

  public static void testList(LinkedList<Integer> list) {
    Node<Integer> temp = list.head;

    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }

    System.out.println(list.size);

    if (list.size > 0) {
      System.out.println(list.tail.data);
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    LinkedList<Integer> list = new LinkedList<>();

    String str = s.nextLine();
    while (!str.equals("quit")) {
      if (str.startsWith("addLast")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        list.addLast(val);
      }
      str = s.nextLine();
    }

    testList(list);
  }

}

/*

Sample Input
7
2 8 9 1 5 4 3
10
100

Sample Output
2 8 9 1 5 4 3 
9 1 5 3 2 8 4 
10 9 1 5 3 2 8 4 100 

*/

import java.util.*;

class Node {
  int data;
  Node next;

  public Node(int data) {
    this.data = data;
  }
}

class LinkedList {
  Node head;
  Node tail;
  int size;

  public int size() {
    return size;
  }

  public void addFirst(int val) {
    Node newNode = new Node(val);

    if (size == 0 || head == null) {
      head = tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }

    size++;
  }

  public void addLast(int val) {
    Node newNode = new Node(val);

    if (size == 0 || head == null) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }

    size++;
  }

  public void removeFirst() {
    if (size == 0 || head == null) {
      System.out.println("List is empty");
    } else if (size == 1) {
      head = tail = null;
      size = 0;
    } else {
      head = head.next;
      size--;
    }
  }

  public int getFirst() {
    if (size == 0 || head == null) {
      System.out.println("List is empty");
      return -1;
    } else {
      return head.data;
    }
  }

  public void oddEven() {
    LinkedList odd = new LinkedList();
    LinkedList even = new LinkedList();

    while (this.size > 0) {
      int val = this.getFirst();
      this.removeFirst();

      if (val % 2 == 0) {
        even.addLast(val);
      } else {
        odd.addLast(val);
      }
    }

    if (odd.size > 0 && even.size > 0) {
      odd.tail.next = even.head;

      this.head = odd.head;
      this.tail = even.tail;
      this.size = odd.size + even.size;
    } else if (odd.size > 0) {
      this.head = odd.head;
      this.tail = odd.tail;
      this.size = odd.size;
    } else if (even.size > 0) {
      this.head = even.head;
      this.tail = even.tail;
      this.size = even.size;
    }
  }

  public void display() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    LinkedList list = new LinkedList();
    for (int i = 0; i < n; i++) {
      int data = s.nextInt();
      list.addLast(data);
    }

    int val1 = s.nextInt();
    int val2 = s.nextInt();

    list.display();
    list.oddEven();
    list.display();
    list.addFirst(val1);
    list.addLast(val2);
    list.display();
  }

}

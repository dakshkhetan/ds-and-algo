/*

Sample Input
11
1 2 3 4 5 6 7 8 9 10 11
3
100
200

Sample Output
1 2 3 4 5 6 7 8 9 10 11 
3 2 1 6 5 4 9 8 7 10 11 
100 3 2 1 6 5 4 9 8 7 10 11 200 

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

  public void kReverse(int k) {
    LinkedList previous = null;

    while (this.size > 0) {
      LinkedList current = new LinkedList();

      if (this.size >= k) {
        for (int i = 0; i < k; i++) {
          int val = this.getFirst();
          this.removeFirst();
          current.addFirst(val);
        }
      } else {
        int size = this.size;
        for (int i = 0; i < size; i++) {
          int val = this.getFirst();
          this.removeFirst();
          current.addLast(val);
        }
      }

      if (previous == null) {
        previous = current;
      } else {
        previous.tail.next = current.head;
        previous.tail = current.tail;
        previous.size += current.size;
      }
    }

    this.head = previous.head;
    this.tail = previous.tail;
    this.size = previous.size;
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

    int k = s.nextInt();
    int val1 = s.nextInt();
    int val2 = s.nextInt();

    list.display();
    list.kReverse(k);
    list.display();
    list.addFirst(val1);
    list.addLast(val2);
    list.display();
  }

}

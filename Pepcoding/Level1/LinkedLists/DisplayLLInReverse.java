/*

Sample Input
11
1 2 3 4 5 6 7 8 9 10 11
100
200

Sample Output
1 2 3 4 5 6 7 8 9 10 11 
11 10 9 8 7 6 5 4 3 2 1 
200 1 2 3 4 5 6 7 8 9 10 11 100 

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

  private void displayReverseHelper(Node head) {
    if (head == null) {
      return;
    }
    displayReverseHelper(head.next);
    System.out.print(head.data + " ");
  }

  public void displayReverse() {
    displayReverseHelper(head);
    System.out.println();
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
    list.displayReverse();
    list.addLast(val1);
    list.addFirst(val2);
    list.display();
  }

}

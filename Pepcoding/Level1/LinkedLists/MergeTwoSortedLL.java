/*

Sample Input
5
10 20 30 40 50
10
7 9 12 15 37 43 44 48 52 56

Sample Output
7 9 10 12 15 20 30 37 40 43 44 48 50 52 56 
10 20 30 40 50 
7 9 12 15 37 43 44 48 52 56

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

  public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
    LinkedList list = new LinkedList();

    Node head1 = l1.head;
    Node head2 = l2.head;
    while (head1 != null && head2 != null) {
      if (head1.data < head2.data) {
        list.addLast(head1.data);
        head1 = head1.next;
      } else {
        list.addLast(head2.data);
        head2 = head2.next;
      }
    }

    while (head1 != null) {
      list.addLast(head1.data);
      head1 = head1.next;
    }

    while (head2 != null) {
      list.addLast(head2.data);
      head2 = head2.next;
    }

    return list;
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

    int n1 = s.nextInt();
    LinkedList l1 = new LinkedList();
    for (int i = 0; i < n1; i++) {
      int d = s.nextInt();
      l1.addLast(d);
    }

    int n2 = s.nextInt();
    LinkedList l2 = new LinkedList();
    for (int i = 0; i < n2; i++) {
      int d = s.nextInt();
      l2.addLast(d);
    }

    LinkedList merged = LinkedList.mergeTwoSortedLists(l1, l2);
    merged.display();
    l1.display();
    l2.display();
  }

}

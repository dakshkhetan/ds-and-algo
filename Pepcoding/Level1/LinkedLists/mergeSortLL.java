/*

Sample Input
6
10 2 19 22 3 7

Sample Output
2 3 7 10 19 22 
10 2 19 22 3 7

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

  public static LinkedList mergeSort(Node head, Node tail) {
    if (head == tail) {
      LinkedList list = new LinkedList();
      list.addLast(head.data);
      return list;
    }

    Node mid = midNode(head, tail);

    LinkedList leftHalf = mergeSort(head, mid);
    LinkedList righthalf = mergeSort(mid.next, tail);

    LinkedList sortedList = mergeTwoSortedLists(leftHalf, righthalf);

    return sortedList;
  }

  private static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
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

  private static Node midNode(Node head, Node tail) {
    Node slow = head;
    Node fast = head;

    while (fast != tail && fast.next != tail) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
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

    LinkedList sorted = LinkedList.mergeSort(list.head, list.tail);
    sorted.display();
    list.display();
  }

}

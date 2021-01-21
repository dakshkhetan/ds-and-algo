/*

Sample Input
5
1 2 3 2 1

Sample Output
true

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

  public static boolean isPalindrome(Node head) {
    if (head == null || head.next == null) {
      return true;
    }

    // find mid of list
    Node midNode = findMid(head);

    // divide list at its mid point
    Node secondHead = midNode.next;
    midNode.next = null;

    secondHead = reverseLL(secondHead);

    // compare two sublists now

    Node firstSubList = secondHead;
    Node secondSubList = head;

    while (firstSubList != null) {
      if (firstSubList.data != secondSubList.data) {
        return false;
      }

      firstSubList = firstSubList.next;
      secondSubList = secondSubList.next;
    }

    // Now, rejoin the two sublists to restore the input list to its original form

    firstSubList = head;
    secondSubList = reverseLL(secondHead);

    while (firstSubList.next != null) {
      firstSubList = firstSubList.next;
    }

    firstSubList.next = secondSubList;

    return true;
  }

  public static Node findMid(Node head) {
    Node slow = head;
    Node fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  private static Node reverseLL(Node head) {
    Node curr = head;
    Node prev = null;
    Node next = null;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    LinkedList list = new LinkedList();

    for (int i = 0; i < n; i++) {
      int data = s.nextInt();
      list.addLast(data);
    }

    System.out.println(isPalindrome(list.head));
  }

}

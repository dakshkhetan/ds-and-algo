/*

Sample Input
10
2 2 2 3 3 5 5 5 5 5

Sample Output
2 2 2 3 3 5 5 5 5 5 
2 3 5 

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

  public void removeDuplicates() {
    LinkedList res = new LinkedList();

    while (this.size() > 0) {
      int val = this.getFirst();
      this.removeFirst();

      if (res.size() == 0 || val != res.tail.data) {
        res.addLast(val);
      }
    }

    this.head = res.head;
    this.tail = res.tail;
    this.size = res.size;
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

    list.display();
    list.removeDuplicates();
    list.display();
  }

}

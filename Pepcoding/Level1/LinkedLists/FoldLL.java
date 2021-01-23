/*

Sample Input
5
1 2 3 4 5
10
20

Sample Output
1 2 3 4 5 
1 5 2 4 3 
10 1 5 2 4 3 20 

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

  static Node left;

  public void foldLLHelper(Node node, int idx) {
    if (node == null) {
      return;
    }
    foldLLHelper(node.next, idx + 1);
    Node right = node;

    if (idx > this.size / 2) {

      Node tmp = left.next;
      left.next = right;
      right.next = tmp;

      left = tmp;
    } else if (idx == this.size / 2) {
      right.next = null;
      this.tail = right;
    }
  }

  public void foldLL() {
    left = head;
    foldLLHelper(head, 0);
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
    list.foldLL();
    list.display();
    list.addFirst(val1);
    list.addLast(val2);
    list.display();
  }

}

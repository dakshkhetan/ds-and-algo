/*

Sample Input
5
1 2 3 4 5
8
11 22 33 44 55 66 77 88
2
3

Sample Output
44

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

  public Node getNodeAt(int index) {
    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp;
  }

  public static int findIntersectionNode(LinkedList list1, LinkedList list2) {
    Node head1 = list1.head;
    Node head2 = list2.head;

    int size1 = list1.size;
    int size2 = list2.size;

    int ans = 0;

    if (size1 - size2 > 0) {
      int gap = size1 - size2;
      while (gap > 0) {
        head1 = head1.next;
        gap--;
      }
    } else if (size2 - size1 > 0) {
      int gap = size2 - size1;
      while (gap > 0) {
        head2 = head2.next;
        gap--;
      }
    }

    while (head1 != null && head2 != null) {
      if (head1.data == head2.data) {
        ans = head1.data;
        break;
      }
      head1 = head1.next;
      head2 = head2.next;
    }

    return ans;
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
    LinkedList list1 = new LinkedList();

    for (int i = 0; i < n1; i++) {
      int data = s.nextInt();
      list1.addLast(data);
    }

    int n2 = s.nextInt();
    LinkedList list2 = new LinkedList();

    for (int i = 0; i < n2; i++) {
      int data = s.nextInt();
      list2.addLast(data);
    }

    int listNum = s.nextInt();
    int nodeIndex = s.nextInt();

    if (listNum == 1) {
      Node node = list1.getNodeAt(nodeIndex);
      list2.tail.next = node;
      list2.tail = list1.tail;
      list2.size += list1.size - nodeIndex;
    } else {
      Node node = list2.getNodeAt(nodeIndex);
      list1.tail.next = node;
      list1.tail = list2.tail;
      list1.size += list2.size - nodeIndex;
    }

    int intersectionNodeValue = LinkedList.findIntersectionNode(list1, list2);
    System.out.println(intersectionNodeValue);
  }

}

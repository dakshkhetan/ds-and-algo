/*

Sample Input
1
1
3
9 9 9
10
20

Sample Output
1 
9 9 9 
1 0 0 0 
10 1 0 0 0 20 

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

  private static int addTwoListsHelper(Node list1, int pv1, Node list2, int pv2, LinkedList res) {
    if (list1 == null && list2 == null) {
      return 0;
    }

    int data = 0;
    if (pv1 > pv2) {
      int carry = addTwoListsHelper(list1.next, pv1 - 1, list2, pv2, res);
      data = list1.data + carry;
    } else if (pv1 < pv2) {
      int carry = addTwoListsHelper(list1, pv1, list2.next, pv2 - 1, res);
      data = list2.data + carry;
    } else {
      int carry = addTwoListsHelper(list1.next, pv1 - 1, list2.next, pv2 - 1, res);
      data = list1.data + list2.data + carry;
    }

    int newData = data % 10;
    int newCarry = data / 10;
    res.addFirst(newData);

    return newCarry;
  }

  public static LinkedList addTwoLists(LinkedList list1, LinkedList list2) {
    LinkedList result = new LinkedList();

    int lastCarry = addTwoListsHelper(list1.head, list1.size, list2.head, list2.size, result);

    if (lastCarry > 0) {
      result.addFirst(lastCarry);
    }

    return result;
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

    LinkedList sum = LinkedList.addTwoLists(list1, list2);

    int val1 = s.nextInt();
    int val2 = s.nextInt();

    list1.display();
    list2.display();
    sum.display();
    sum.addFirst(val1);
    sum.addLast(val2);
    sum.display();
  }

}

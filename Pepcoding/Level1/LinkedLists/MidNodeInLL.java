/*

Sample Input
addLast 10
addLast 20
addLast 30
addLast 40
mid
addLast 50
removeFirst
mid
quit

Sample Output
20
30

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

  public void addAt(int index, int val) {
    if (index < 0 || index > size) {
      System.out.println("Invalid arguments");
    } else if (index == 0) {
      addFirst(val);
    } else if (index == size) {
      addLast(val);
    } else {
      Node newNode = new Node(val);

      Node temp = head;
      for (int i = 0; i < index - 1; i++) {
        temp = temp.next;
      }

      newNode.next = temp.next;
      temp.next = newNode;

      size++;
    }
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

  public void removeLast() {
    if (size == 0 || head == null) {
      System.out.println("List is empty");
    } else if (size == 1) {
      head = tail = null;
      size = 0;
    } else {
      Node temp = head;
      while (temp.next.next != null) {
        temp = temp.next;
      }
      tail = temp;
      tail.next = null;
      size--;
    }
  }

  public void removeAt(int index) {
    if (index < 0 || index >= size) {
      System.out.println("Invalid arguments");
    } else if (index == 0) {
      removeFirst();
    } else if (index == size - 1) {
      removeLast();
    } else {
      Node temp = head;
      for (int i = 0; i < index - 1; i++) {
        temp = temp.next;
      }
      temp.next = temp.next.next;
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

  public int getLast() {
    if (size == 0 || tail == null) {
      System.out.println("List is empty");
      return -1;
    } else {
      return tail.data;
    }
  }

  public int getAt(int index) {
    if (size == 0 || head == null) {
      System.out.println("List is empty");
      return -1;
    } else if (index < 0 || index >= size) {
      System.out.println("Invalid arguments");
      return -1;
    } else {
      Node temp = head;
      for (int i = 0; i < index; i++) {
        temp = temp.next;
      }
      return temp.data;
    }
  }

  public int kthFromLast(int k) {
    Node slow = head;
    Node fast = head;

    for (int i = 0; i < k; i++) {
      fast = fast.next;
    }

    // while (fast != tail) {
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow.data;
  }

  public int mid() {
    Node slow = head;
    Node fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow.data;
  }

  private Node getNodeAt(int index) {
    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp;
  }

  // O(n^2)
  public void reverseDataIterative() {
    int leftIndex = 0;
    int rightIndex = size - 1;

    while (leftIndex < rightIndex) {
      Node leftNode = getNodeAt(leftIndex);
      Node rightNode = getNodeAt(rightIndex);

      int temp = leftNode.data;
      leftNode.data = rightNode.data;
      rightNode.data = temp;

      leftIndex++;
      rightIndex--;
    }
  }

  public void reverseIterative() {
    Node current = head;
    Node previous = null;
    Node next = null;

    while (current != null) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    tail = head;
    head = previous;
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

    LinkedList list = new LinkedList();

    String str = s.nextLine();
    while (!str.equals("quit")) {
      if (str.startsWith("addLast")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        list.addLast(val);
      } else if (str.startsWith("size")) {
        System.out.println(list.size());
      } else if (str.startsWith("display")) {
        list.display();
      } else if (str.startsWith("removeFirst")) {
        list.removeFirst();
      } else if (str.startsWith("getFirst")) {
        int val = list.getFirst();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("getLast")) {
        int val = list.getLast();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("getAt")) {
        int idx = Integer.parseInt(str.split(" ")[1]);
        int val = list.getAt(idx);
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("addFirst")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        list.addFirst(val);
      } else if (str.startsWith("addAt")) {
        int idx = Integer.parseInt(str.split(" ")[1]);
        int val = Integer.parseInt(str.split(" ")[2]);
        list.addAt(idx, val);
      } else if (str.startsWith("removeLast")) {
        list.removeLast();
      } else if (str.startsWith("removeAt")) {
        int idx = Integer.parseInt(str.split(" ")[1]);
        list.removeAt(idx);
      } else if (str.startsWith("reverseDI")) {
        list.reverseDataIterative();
      } else if (str.startsWith("reversePI")) {
        list.reverseIterative();
      } else if (str.startsWith("kthFromEnd")) {
        int idx = Integer.parseInt(str.split(" ")[1]);
        System.out.println(list.kthFromLast(idx));
      } else if (str.startsWith("mid")) {
        System.out.println(list.mid());
      }
      str = s.nextLine();
    }
  }

}

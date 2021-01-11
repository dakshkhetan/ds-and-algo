/*

Sample Input
addLast 10
addLast 20
addLast 30
display
size
addLast 40
addLast 50
display
size
quit

Sample Output
10 20 30 
3
10 20 30 40 50 
5

*/

import java.util.*;

class Node<T> {
  T data;
  Node<T> next;

  public Node(T data) {
    this.data = data;
  }
}

class LinkedList<T> {
  Node<T> head;
  Node<T> tail;
  int size;

  public int size() {
    return size;
  }

  public void addLast(T val) {
    Node<T> newNode = new Node<>(val);
    size++;

    if (head == null) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
  }

  public void display() {
    Node<T> temp = head;
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

    LinkedList<Integer> list = new LinkedList<>();

    String str = s.nextLine();
    while (!str.equals("quit")) {
      if (str.startsWith("addLast")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        list.addLast(val);
      } else if (str.startsWith("size")) {
        System.out.println(list.size());
      } else if (str.startsWith("display")) {
        list.display();
      }
      str = s.nextLine();
    }
  }

}

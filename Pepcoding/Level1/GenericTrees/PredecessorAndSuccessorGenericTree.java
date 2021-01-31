/*

Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
120

Sample Output
Predecessor = 110
Successor = 90

*/

import java.util.*;

class TreeNode {
  int data;
  ArrayList<TreeNode> children;

  TreeNode(int data) {
    this.data = data;
    children = new ArrayList<>();
  }
}

public class Main {

  public static void display(TreeNode root) {
    String str = root.data + " -> ";
    for (TreeNode child : root.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (TreeNode child : root.children) {
      display(child);
    }
  }

  public static TreeNode construct(int[] arr) {
    TreeNode root = null;
    Stack<TreeNode> st = new Stack<>();

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        TreeNode node = new TreeNode(arr[i]);

        if (st.size() > 0) {
          st.peek().children.add(node);
        } else {
          root = node;
        }

        st.push(node);
      }
    }

    return root;
  }

  static TreeNode predecessor;
  static TreeNode successor;
  static int state;

  public static void predecessorAndSuccessor(TreeNode root, int value) {
    predecessor = null;
    successor = null;
    state = 0;

    predecessorAndSuccessorHelper(root, value);

    if (predecessor == null) {
      System.out.println("Predecessor = Not found");
    } else {
      System.out.println("Predecessor = " + predecessor.data);
    }

    if (successor == null) {
      System.out.println("Successor = Not found");
    } else {
      System.out.println("Successor = " + successor.data);
    }
  }

  private static void predecessorAndSuccessorHelper(TreeNode root, int value) {
    if (state == 0) {
      if (root.data == value) {
        state = 1;
      } else {
        predecessor = root;
      }
    } else if (state == 1) {
      successor = root;
      state = 2;
      return;
    }

    for (TreeNode child : root.children) {
      predecessorAndSuccessorHelper(child, value);
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int value = s.nextInt();

    TreeNode root = construct(arr);

    predecessorAndSuccessor(root, value);

    // display(root);
  }

}

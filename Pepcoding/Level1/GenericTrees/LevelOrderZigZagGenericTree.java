/*

Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

Sample Output
10 
40 30 20 
50 60 70 80 90 100 
120 110

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

  public static void levelOrderZigZag(TreeNode root) {
    if (root == null) {
      return;
    }

    if (root.children.isEmpty()) {
      System.out.println(root.data);
      return;
    }

    Stack<TreeNode> rootStack = new Stack<>();
    Stack<TreeNode> childStack = new Stack<>();

    int level = 0; // root is at level 0
    rootStack.push(root);

    while (!rootStack.isEmpty()) {
      TreeNode node = rootStack.pop();
      System.out.print(node.data + " ");

      if (level % 2 == 0) { // even level -> left to right
        for (TreeNode child : node.children) {
          childStack.push(child);
        }
      } else { // odd level -> right to left
        for (int i = node.children.size() - 1; i >= 0; i--) {
          TreeNode child = node.children.get(i);
          childStack.push(child);
        }
      }

      if (rootStack.isEmpty()) {
        rootStack = childStack;
        childStack = new Stack<>();

        level++;

        System.out.println();
      }
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    TreeNode root = construct(arr);

    levelOrderZigZag(root);

    // display(root);
  }

}

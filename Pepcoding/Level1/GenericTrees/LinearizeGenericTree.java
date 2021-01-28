/*

Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

Sample Output
10 -> 20, .
20 -> 50, .
50 -> 60, .
60 -> 30, .
30 -> 70, .
70 -> 80, .
80 -> 110, .
110 -> 120, .
120 -> 90, .
90 -> 40, .
40 -> 100, .
100 -> .

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

  public static void linearize(TreeNode root) {
    if (root == null) {
      return;
    }

    for (TreeNode child : root.children) {
      linearize(child);
    }

    while (root.children.size() > 1) {
      // store & remove the last child node
      TreeNode lastChild = root.children.remove(root.children.size() - 1);

      // get the second-last child node
      TreeNode secondLastChild = root.children.get(root.children.size() - 1);

      // add the last child to the tail (very last level) of second-last child
      TreeNode secondLastChildTail = findTailOfLinearTreeNode(secondLastChild);
      secondLastChildTail.children.add(lastChild);
    }
  }

  private static TreeNode findTailOfLinearTreeNode(TreeNode node) {
    while (node.children.size() == 1) {
      node = node.children.get(0);
    }

    return node;
  }

  public static void linearizeEfficient(TreeNode root) {
    if (root == null) {
      return;
    }

    while (root.children.size() >= 2) {
      // store & remove the second child node
      TreeNode secondChild = root.children.remove(1);

      // get the first child node
      TreeNode firstChild = root.children.get(0);

      // add the second child node as a child of first child node
      firstChild.children.add(secondChild);
    }

    for (TreeNode child : root.children) {
      linearizeEfficient(child);
    }
  }

  public static TreeNode linearizeEfficient2(TreeNode root) {
    if (root == null) {
      return null;
    }

    if (root.children.size() == 0) {
      return root;
    }

    TreeNode lastChild = root.children.get(root.children.size() - 1);
    TreeNode lastChildTail = linearizeEfficient2(lastChild);

    while (root.children.size() >= 2) {
      // store & remove the last child node
      lastChild = root.children.remove(root.children.size() - 1);

      // get the second-last child node
      TreeNode secondLastChild = root.children.get(root.children.size() - 1);

      // add the last child to the tail (very last level) of second-last child
      TreeNode secondLastChildTail = linearizeEfficient2(secondLastChild);
      secondLastChildTail.children.add(lastChild);
    }

    return lastChildTail;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    TreeNode root = construct(arr);

    /* O(n^2) */
    // linearize(root);

    /* O(n) */
    linearizeEfficient(root);
    // linearizeEfficient2(root);

    display(root);
  }

}

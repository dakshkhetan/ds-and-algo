/*

Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

Sample Output
10 -> 20, 30, 40, .
20 -> .
30 -> 80, .
80 -> .
40 -> .

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

  public static void removeLeaves(TreeNode root) {
    if (root == null) {
      return;
    }

    if (root.children.size() == 0) {
      root = null;
      return;
    }

    for (int i = root.children.size() - 1; i >= 0; i--) {
      TreeNode child = root.children.get(i);
      if (child.children.size() == 0) {
        root.children.remove(i);
      }
    }

    // for (int i = 0; i < root.children.size(); i++) {
    //   TreeNode child = root.children.get(i);
    //   if (child.children.size() == 0) {
    //     root.children.remove(i);
    //     i--; // important
    //   }
    // }

    for (TreeNode child : root.children) {
      removeLeaves(child);
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

    removeLeaves(root);
    display(root);
  }

}

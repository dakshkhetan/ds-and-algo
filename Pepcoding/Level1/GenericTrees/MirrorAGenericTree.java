/*

Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

Sample Output
10 -> 20, 30, 40, .
20 -> 50, 60, .
50 -> .
60 -> .
30 -> 70, 80, 90, .
70 -> .
80 -> 110, 120, .
110 -> .
120 -> .
90 -> .
40 -> 100, .
100 -> .
10 -> 40, 30, 20, .
40 -> 100, .
100 -> .
30 -> 90, 80, 70, .
90 -> .
80 -> 120, 110, .
120 -> .
110 -> .
70 -> .
20 -> 60, 50, .
60 -> .
50 -> .

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

  public static void mirror(TreeNode root) {
    if (root == null) {
      return;
    }

    if (root.children.size() == 0 || root.children.size() == 1) {
      return;
    }

    Collections.reverse(root.children);

    for (TreeNode child : root.children) {
      mirror(child);
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

    display(root);
    mirror(root);
    display(root);
  }

}

/*

Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
120

Sample Output
[120, 80, 30, 10]

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

  public static ArrayList<Integer> nodeToRootPath(TreeNode root, int value) {
    if (root == null) {
      return new ArrayList<>();
    }

    if (root.data == value) {
      ArrayList<Integer> path = new ArrayList<>();
      path.add(root.data);
      return path;
    }

    for (TreeNode child : root.children) {
      ArrayList<Integer> childPath = nodeToRootPath(child, value);

      if (!childPath.isEmpty()) {
        childPath.add(root.data);
        return childPath;
      }
    }

    return new ArrayList<>();
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

    ArrayList<Integer> path = nodeToRootPath(root, value);
    System.out.println(path);

    // display(root);
  }

}

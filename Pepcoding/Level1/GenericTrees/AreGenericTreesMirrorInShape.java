/*

Sample Input
12
10 20 -1 30 50 -1 60 -1 -1 40 -1 -1
12
100 200 -1 300 500 -1 600 -1 -1 400 -1 -1

Sample Output
true

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

  public static boolean areMirror(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    }

    if (root1 == null || root2 == null) {
      return false;
    }

    if (root1.children.size() != root2.children.size()) {
      return false;
    }

    int size = root1.children.size();

    for (int i = 0; i < size; i++) {
      TreeNode child1 = root1.children.get(size - 1 - i);
      TreeNode child2 = root2.children.get(i);

      boolean childMirror = areMirror(child1, child2);
      if (!childMirror) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n1 = s.nextInt();
    int[] arr1 = new int[n1];
    for (int i = 0; i < n1; i++) {
      arr1[i] = s.nextInt();
    }

    int n2 = s.nextInt();
    int[] arr2 = new int[n2];
    for (int i = 0; i < n2; i++) {
      arr2[i] = s.nextInt();
    }

    TreeNode root1 = construct(arr1);
    TreeNode root2 = construct(arr2);

    boolean result = areMirror(root1, root2);
    System.out.println(result);

    // display(root1);
    // display(root2);
  }

}

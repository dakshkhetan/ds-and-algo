/*

Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
120
80

Sample Output
80

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

  private static ArrayList<Integer> nodeToRootPath(TreeNode root, int value) {
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

  public static int lca(TreeNode root, int value1, int value2) {
    if (root == null) {
      return -1;
    }

    ArrayList<Integer> path1 = nodeToRootPath(root, value1);
    ArrayList<Integer> path2 = nodeToRootPath(root, value2);

    if (path1.isEmpty() || path2.isEmpty()) {
      return -1;
    }

    if (value1 == value2) {
      return value1;
    }

    int prevMatchingNodeData = -1;

    // start matching nodes' data from root to target nodes' path

    int i = path1.size() - 1;
    int j = path2.size() - 1;

    while (i >= 0 && j >= 0) {
      if (path1.get(i) == path2.get(j)) {
        prevMatchingNodeData = path1.get(i);
        i--;
        j--;
      } else {
        break;
      }
    }

    return prevMatchingNodeData;
  }

  public static int lca2(TreeNode root, int value1, int value2) {
    if (root == null) {
      return -1;
    }

    ArrayList<Integer> path1 = nodeToRootPath(root, value1);
    ArrayList<Integer> path2 = nodeToRootPath(root, value2);

    if (path1.isEmpty() || path2.isEmpty()) {
      return -1;
    }

    if (value1 == value2) {
      return value1;
    }

    // start matching nodes' data from root to target nodes' path

    int i = path1.size() - 1;
    int j = path2.size() - 1;

    while (i >= 0 && j >= 0) {
      if (path1.get(i) == path2.get(j)) {
        i--;
        j--;
      } else {
        break;
      }
    }

    // move i and j back to diverging node (LCA)
    i++;
    j++;

    int lcaValue = path1.get(i); // or, path2.get(j);

    return lcaValue;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int value1 = s.nextInt();
    int value2 = s.nextInt();

    TreeNode root = construct(arr);

    int result = lca(root, value1, value2);
    // int result = lca2(root, value1, value2);

    System.out.println(result);

    // display(root);
  }

}

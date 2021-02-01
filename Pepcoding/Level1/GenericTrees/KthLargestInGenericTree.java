/*

Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
5

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

  static int floor;

  private static void findFloor(TreeNode root, int value) {
    // floor -> largest amongst smaller nodes

    if (root.data < value) {
      if (root.data > floor) {
        floor = root.data;
      }
    }

    for (TreeNode child : root.children) {
      findFloor(child, value);
    }
  }

  public static int kthLargest(TreeNode root, int k) {
    int res = Integer.MAX_VALUE;

    for (int i = 0; i < k; i++) {
      floor = Integer.MIN_VALUE;

      findFloor(root, res);
      res = floor;
    }

    return res;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int k = s.nextInt();

    TreeNode root = construct(arr);

    int result = kthLargest(root, k);
    System.out.println(result);

    // display(root);
  }

}

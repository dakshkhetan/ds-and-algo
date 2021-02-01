/*

Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
70

Sample Output
CEIL = 80
FLOOR = 60

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

  static int ceil;
  static int floor;

  public static void ceilAndFloor(TreeNode root, int value) {
    ceil = Integer.MAX_VALUE;
    floor = Integer.MIN_VALUE;

    ceilAndFloorHelper(root, value);

    System.out.println("CEIL = " + ceil);
    System.out.println("FLOOR = " + floor);
  }

  private static void ceilAndFloorHelper(TreeNode root, int value) {
    // ceil -> smallest amongst larger nodes
    // floor -> largest amongst smaller nodes

    if (root.data > value) {
      if (root.data < ceil) {
        ceil = root.data;
      }
    } else if (root.data < value) {
      if (root.data > floor) {
        floor = root.data;
      }
    }

    for (TreeNode child : root.children) {
      ceilAndFloorHelper(child, value);
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

    ceilAndFloor(root, value);

    // display(root);
  }

}

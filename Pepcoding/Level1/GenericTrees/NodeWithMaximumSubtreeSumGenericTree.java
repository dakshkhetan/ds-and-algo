/*

Sample Input
20
10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1

Sample Output
30@130

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

  static int maxSubtreeSum;
  static TreeNode maxSubtreeSumNode;

  public static void maxSubtreeSum(TreeNode root) {
    maxSubtreeSum = Integer.MIN_VALUE;
    maxSubtreeSumNode = null;

    maxSubtreeSumHelper(root);

    System.out.println(maxSubtreeSumNode.data + "@" + maxSubtreeSum);
  }

  private static int maxSubtreeSumHelper(TreeNode root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }

    int subtreeSum = root.data;

    for (TreeNode child : root.children) {
      int childSubtreeSum = maxSubtreeSumHelper(child);
      subtreeSum += childSubtreeSum;
    }

    if (subtreeSum > maxSubtreeSum) {
      maxSubtreeSum = subtreeSum;
      maxSubtreeSumNode = root;
    }

    return subtreeSum;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    TreeNode root = construct(arr);

    maxSubtreeSum(root);

    // display(root);
  }

}

/*

Sample Input
21
50 25 12 n n 37 30 n n 51 n n 75 62 60 n n 70 n n n

Sample Output
false

*/

import java.util.*;
import java.io.*;

class BinaryTreeNode {
  int data;
  BinaryTreeNode left;
  BinaryTreeNode right;

  BinaryTreeNode(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

class Pair {
  boolean isBalanced;
  int height;
}

public class Main {

  public static boolean isBalanced(BinaryTreeNode root) {
    Pair pair = isBalancedHelper(root);
    return pair.isBalanced;
  }

  private static Pair isBalancedHelper(BinaryTreeNode root) {
    if (root == null) {
      Pair pair = new Pair();
      pair.isBalanced = true;
      pair.height = 0; // in terms of nodes (NOT edges)
      return pair;
    }

    Pair leftSubtreeAns = isBalancedHelper(root.left);
    Pair rightSubtreeAns = isBalancedHelper(root.right);

    int heightDiff = Math.abs(leftSubtreeAns.height - rightSubtreeAns.height);
    boolean isNodeBalanced = heightDiff <= 1;

    Pair ans = new Pair();
    ans.isBalanced = leftSubtreeAns.isBalanced && rightSubtreeAns.isBalanced && isNodeBalanced;
    ans.height = Math.max(leftSubtreeAns.height, rightSubtreeAns.height) + 1;

    return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (!values[i].equals("n")) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    BinaryTreeNode root = construct(arr);

    boolean result = isBalanced(root);
    System.out.println(result);

    // display(root);
  }

  /* Binary Tree Construct & Display functions: */

  static class ConstructPair {
    BinaryTreeNode node;
    int state;

    ConstructPair(BinaryTreeNode node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static BinaryTreeNode construct(Integer[] arr) {
    BinaryTreeNode root = new BinaryTreeNode(arr[0]);
    Stack<ConstructPair> st = new Stack<>();

    ConstructPair pair = new ConstructPair(root, 1);
    st.push(pair);

    int i = 0;
    while (!st.isEmpty()) {
      ConstructPair top = st.peek();

      if (top.state == 1) {
        i++;

        if (arr[i] != null) {
          top.node.left = new BinaryTreeNode(arr[i]);
          ConstructPair leftNodePair = new ConstructPair(top.node.left, 1);
          st.push(leftNodePair);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        i++;

        if (arr[i] != null) {
          top.node.right = new BinaryTreeNode(arr[i]);
          ConstructPair rightNodePair = new ConstructPair(top.node.right, 1);
          st.push(rightNodePair);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(BinaryTreeNode root) {
    if (root == null) {
      // System.out.println(".");
      return;
    }

    String str = "";

    str += root.left == null ? "." : root.left.data + "";
    str += " <- " + root.data + " -> ";
    str += root.right == null ? "." : root.right.data + "";

    System.out.println(str);

    display(root.left);
    display(root.right);
  }

}

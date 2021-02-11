/*

Sample Input
15
50 25 12 n n 37 n n 75 62 n n 87 n n

Sample Output
50@7

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

class BSTPair {
  boolean isBST;
  int min;
  int max;
  BinaryTreeNode largestBSTRoot;
  int largestBSTSize;
}

public class Main {

  public static void largestBST(BinaryTreeNode root) {
    BSTPair ans = isBST(root);
    System.out.println(ans.largestBSTRoot.data + "@" + ans.largestBSTSize);
  }

  private static BSTPair isBST(BinaryTreeNode root) {
    if (root == null) {
      BSTPair ans = new BSTPair();
      ans.isBST = true;
      ans.min = Integer.MAX_VALUE;
      ans.max = Integer.MIN_VALUE;
      ans.largestBSTRoot = null;
      ans.largestBSTSize = 0;
      return ans;
    }

    BSTPair leftSubtreeAns = isBST(root.left);
    BSTPair rightSubtreeAns = isBST(root.right);

    boolean isCurrentNodeValid = (leftSubtreeAns.max < root.data) && (root.data < rightSubtreeAns.min);

    BSTPair ans = new BSTPair();
    ans.isBST = leftSubtreeAns.isBST && rightSubtreeAns.isBST && isCurrentNodeValid;
    ans.min = Math.min(root.data, Math.min(leftSubtreeAns.min, rightSubtreeAns.min));
    ans.max = Math.max(root.data, Math.max(leftSubtreeAns.max, rightSubtreeAns.max));

    if (ans.isBST) {
      ans.largestBSTRoot = root;
      ans.largestBSTSize = leftSubtreeAns.largestBSTSize + rightSubtreeAns.largestBSTSize + 1;
    } else {
      if (leftSubtreeAns.largestBSTSize > rightSubtreeAns.largestBSTSize) {
        // largest BST lies in left-subtree
        ans.largestBSTRoot = leftSubtreeAns.largestBSTRoot;
        ans.largestBSTSize = leftSubtreeAns.largestBSTSize;
      } else {
        // largest BST lies in right-subtree
        ans.largestBSTRoot = rightSubtreeAns.largestBSTRoot;
        ans.largestBSTSize = rightSubtreeAns.largestBSTSize;
      }
    }

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
    largestBST(root);

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

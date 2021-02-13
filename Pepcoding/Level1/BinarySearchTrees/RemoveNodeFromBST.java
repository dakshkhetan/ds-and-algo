/*

Sample Input
15
50 25 12 n n 37 n n 75 62 n n 87 n n
62

Sample Output
25 <- 50 -> 75
12 <- 25 -> 37
. <- 12 -> .
. <- 37 -> .
. <- 75 -> 87
. <- 87 -> .

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

public class Main {

  public static BinaryTreeNode removeNode(BinaryTreeNode root, int nodeData) {
    if (root == null) {
      return null;
    }

    if (root.data == nodeData) {
      if (root.left == null && root.right == null) {
        // no child exists (leaf node)
        return null;
      } else if (root.right == null) {
        // only left child exists
        return root.left;
      } else if (root.left == null) {
        // only right child exists
        return root.right;
      } else {
        // both child exists
        BinaryTreeNode leftMaxNode = findMaxInBST(root.left); // max node from left-subtree
        root.data = leftMaxNode.data;
        root.left = removeNode(root.left, leftMaxNode.data);
      }
    } else if (nodeData < root.data) {
      root.left = removeNode(root.left, nodeData);
    } else {
      root.right = removeNode(root.right, nodeData);
    }

    return root;
  }

  private static BinaryTreeNode findMaxInBST(BinaryTreeNode root) {
    if (root == null) {
      return null;
    }

    /* Iterative Approach: */
    // while (root.right != null) {
    //   root = root.right;
    // }
    // return root;

    /* Recursive Approach: */
    if (root.right == null) {
      return root;
    } else {
      return findMaxInBST(root.right);
    }
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
    int data = Integer.parseInt(br.readLine());

    BinaryTreeNode root = construct(arr);
    root = removeNode(root, data);
    display(root);
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

/*

Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n

Sample Output
6

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
  int height;
  int diameter;

  Pair(int height, int diameter) {
    this.height = height;
    this.diameter = diameter;
  }
}

public class Main {

  // O(n)
  public static int findDiameterEfficient(BinaryTreeNode root) {
    Pair pair = diameterHelper(root);
    return pair.diameter;
  }

  private static Pair diameterHelper(BinaryTreeNode root) {
    // diameter -> on the basis of number of edges (NOT nodes)

    if (root == null) {
      return (new Pair(-1, 0));
    }

    if (root.left == null && root.right == null) {
      return (new Pair(0, 0));
    }

    Pair leftAns = diameterHelper(root.left);
    Pair rightAns = diameterHelper(root.right);

    int diameterThroughRoot = leftAns.height + rightAns.height + 2;

    int height = Math.max(leftAns.height, rightAns.height) + 1;
    int diameter = Math.max(diameterThroughRoot, Math.max(leftAns.diameter, rightAns.diameter));

    Pair pair = new Pair(height, diameter);
    return pair;
  }

  // O(n * height)
  public static int findDiameter(BinaryTreeNode root) {
    // diameter -> on the basis of number of edges (NOT nodes)

    if (root == null) {
      return 0;
    }

    if (root.left == null && root.right == null) {
      return 0;
    }

    int diameterThroughRoot = height(root.left) + height(root.right) + 2; // option 1

    int leftAns = findDiameter(root.left); // option 2
    int rightAns = findDiameter(root.right); // option 3

    int diameter = Math.max(diameterThroughRoot, Math.max(leftAns, rightAns));

    return diameter;
  }

  private static int height(BinaryTreeNode root) {
    if (root == null) {
      return -1;
    }

    if (root.left == null && root.right == null) {
      return 0; // as per question
    }

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    return Math.max(leftHeight, rightHeight) + 1;
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

    // int diameter = findDiameter(root);
    int diameter = findDiameterEfficient(root);
    System.out.println(diameter);

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

/*

Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n

Sample Output
50 25 12 37 30 75 62 70 87 
12 25 30 37 50 62 70 75 87 
12 30 37 25 70 62 87 75 50 

*/

import java.util.*;
import java.io.*;

class BinaryTreeNode {
  int data;
  BinaryTreeNode left;
  BinaryTreeNode right;

  BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
}

class Pair {
  BinaryTreeNode node;
  int state;

  Pair(BinaryTreeNode node, int state) {
    this.node = node;
    this.state = state;
  }
}

public class Main {

  public static void iterativePrePostInorderTraversal(BinaryTreeNode root) {
    if (root == null) {
      return;
    }

    // state 1 -> PreOrder (Initial State)
    // state 2 -> InOrder
    // state 3 -> PostOrder

    String preOrder = "";
    String inOrder = "";
    String postOrder = "";

    Stack<Pair> st = new Stack<>();

    Pair rootPair = new Pair(root, 1);
    st.push(rootPair);

    while (!st.isEmpty()) {
      Pair top = st.peek();

      if (top.state == 1) { // preOrder
        preOrder += top.node.data + " ";
        top.state++;

        if (top.node.left != null) {
          Pair leftChildPair = new Pair(top.node.left, 1);
          st.push(leftChildPair);
        }
      } else if (top.state == 2) { // inOrder
        inOrder += top.node.data + " ";
        top.state++;

        if (top.node.right != null) {
          Pair rightChildPair = new Pair(top.node.right, 1);
          st.push(rightChildPair);
        }
      } else if (top.state == 3) { // postOrder
        postOrder += top.node.data + " ";
        st.pop();
      }
    }

    System.out.println(preOrder);
    System.out.println(inOrder);
    System.out.println(postOrder);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    BinaryTreeNode root = construct(arr);
    iterativePrePostInorderTraversal(root);

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
    BinaryTreeNode root = new BinaryTreeNode(arr[0], null, null);
    Stack<ConstructPair> st = new Stack<>();

    ConstructPair pair = new ConstructPair(root, 1);
    st.push(pair);

    int i = 0;
    while (!st.isEmpty()) {
      ConstructPair top = st.peek();

      if (top.state == 1) {
        i++;

        if (arr[i] != null) {
          top.node.left = new BinaryTreeNode(arr[i], null, null);
          ConstructPair leftNodePair = new ConstructPair(top.node.left, 1);
          st.push(leftNodePair);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        i++;

        if (arr[i] != null) {
          top.node.right = new BinaryTreeNode(arr[i], null, null);
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
      System.out.println(".");
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

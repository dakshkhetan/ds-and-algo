/*

Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
30

Sample Output
[30, 37, 25, 50]

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

public class Main {

  public static ArrayList<Integer> nodeToRootPath(BinaryTreeNode root, int x) {
    if (root == null) {
      return new ArrayList<>();
    }

    if (root.data == x) {
      ArrayList<Integer> path = new ArrayList<>();
      path.add(root.data);
      return path;
    }

    ArrayList<Integer> leftAns = nodeToRootPath(root.left, x);

    if (!leftAns.isEmpty()) {
      leftAns.add(root.data);
      return leftAns;
    }

    ArrayList<Integer> rightAns = nodeToRootPath(root.right, x);

    if (!rightAns.isEmpty()) {
      rightAns.add(root.data);
      return rightAns;
    }

    return new ArrayList<>();
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
    int x = Integer.parseInt(br.readLine());

    BinaryTreeNode root = construct(arr);

    ArrayList<Integer> path = nodeToRootPath(root, x);
    System.out.println(path);

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

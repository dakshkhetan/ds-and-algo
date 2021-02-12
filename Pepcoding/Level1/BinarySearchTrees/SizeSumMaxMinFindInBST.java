/*

Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
70

Sample Output
9
448
87
12
true

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

  public static int findSize(BinaryTreeNode root) {
    if (root == null) {
      return 0;
    }

    if (root.left == null && root.right == null) {
      return 1;
    }

    int leftAns = findSize(root.left);
    int rightAns = findSize(root.right);

    return leftAns + rightAns + 1;
  }

  public static int findSum(BinaryTreeNode root) {
    if (root == null) {
      return 0;
    }

    if (root.left == null && root.right == null) {
      return root.data;
    }

    int leftAns = findSum(root.left);
    int rightAns = findSum(root.right);

    int sum = leftAns + rightAns + root.data;

    return sum;
  }

  public static int findMax(BinaryTreeNode root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }

    if (root.right == null) {
      return root.data;
    } else {
      return findMax(root.right);
    }
  }

  public static int findMin(BinaryTreeNode root) {
    if (root == null) {
      return Integer.MAX_VALUE;
    }

    if (root.left == null) {
      return root.data;
    } else {
      return findMin(root.left);
    }
  }

  public static boolean findNode(BinaryTreeNode root, int value) {
    if (root == null) {
      return false;
    }

    if (value == root.data) {
      return true;
    } else if (value < root.data) {
      return findNode(root.left, value);
    } else {
      return findNode(root.right, value);
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
    int value = Integer.parseInt(br.readLine());

    BinaryTreeNode root = construct(arr);

    System.out.println(findSize(root));
    System.out.println(findSum(root));
    System.out.println(findMax(root));
    System.out.println(findMin(root));
    System.out.println(findNode(root, value));

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

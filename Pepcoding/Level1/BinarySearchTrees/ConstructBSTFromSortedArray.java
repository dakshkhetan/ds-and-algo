/*

Sample Input
7
12 25 37 50 62 75 87

Sample Output
25 <- 50 -> 75
12 <- 25 -> 37
. <- 12 -> .
. <- 37 -> .
62 <- 75 -> 87
. <- 62 -> .
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

  public static BinaryTreeNode constructBST(int input[], int low, int high) {
    // using binary search approach:

    if (low > high) {
      return null;
    }

    int mid = (low + high) / 2;
    int nodeData = input[mid];

    BinaryTreeNode leftChild = constructBST(input, low, mid - 1);
    BinaryTreeNode rightChild = constructBST(input, mid + 1, high);

    BinaryTreeNode node = new BinaryTreeNode(nodeData);
    node.left = leftChild;
    node.right = rightChild;

    return node;
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

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    BinaryTreeNode root = constructBST(arr, 0, n - 1);
    display(root);
  }

}

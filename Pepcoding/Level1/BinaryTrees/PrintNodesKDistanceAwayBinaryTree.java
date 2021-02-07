/*

Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
37
2

Sample Output
12
50

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

  public static void printKNodesFar(BinaryTreeNode root, int target, int k) {
    if (root == null || k < 0) {
      return;
    }

    ArrayList<BinaryTreeNode> path = nodeToRootPath(root, target);

    for (int level = 0; level < path.size() && level <= k; level++) {
      BinaryTreeNode node = path.get(level);

      BinaryTreeNode blockerNode;
      if (level == 0) {
        blockerNode = null;
      } else {
        blockerNode = path.get(level - 1); // important
      }

      printKLevelsDown(node, k - level, blockerNode);
    }
  }

  private static ArrayList<BinaryTreeNode> nodeToRootPath(BinaryTreeNode root, int target) {
    if (root == null) {
      return new ArrayList<>();
    }

    if (root.data == target) {
      ArrayList<BinaryTreeNode> path = new ArrayList<>();
      path.add(root);
      return path;
    }

    ArrayList<BinaryTreeNode> leftAns = nodeToRootPath(root.left, target);

    if (!leftAns.isEmpty()) {
      leftAns.add(root);
      return leftAns;
    }

    ArrayList<BinaryTreeNode> rightAns = nodeToRootPath(root.right, target);

    if (!rightAns.isEmpty()) {
      rightAns.add(root);
      return rightAns;
    }

    return new ArrayList<>();
  }

  private static void printKLevelsDown(BinaryTreeNode root, int k, BinaryTreeNode blockerNode) {
    if (root == null || k < 0) {
      return;
    }

    if (root == blockerNode) {
      return;
    }

    if (k == 0) {
      System.out.println(root.data);
      return;
    }

    printKLevelsDown(root.left, k - 1, blockerNode);
    printKLevelsDown(root.right, k - 1, blockerNode);
  }

  /************************************************/

  public static void printKNodesFar2(BinaryTreeNode root, int targetNode, int k) {
    returnDistanceAndPrintNodes(root, targetNode, k);
  }

  private static int returnDistanceAndPrintNodes(BinaryTreeNode root, int target, int k) {
    // this function RETURNS the distance between root & target node
    // and prints the nodes at distance 'k'

    if (root == null) {
      return -1;
    }

    if (root.data == target) {
      printNodesKLevelsDown(root, k);
      return 0;
    }

    int leftDistance = returnDistanceAndPrintNodes(root.left, target, k);

    if (leftDistance != -1) {
      int distancefromRoot = leftDistance + 1;

      if (distancefromRoot == k) {
        System.out.println(root.data);
      } else {
        printNodesKLevelsDown(root.right, k - distancefromRoot - 1);
      }

      return distancefromRoot;
    }

    int rightDistance = returnDistanceAndPrintNodes(root.right, target, k);

    if (rightDistance != -1) {
      int distancefromRoot = rightDistance + 1;

      if (distancefromRoot == k) {
        System.out.println(root.data);
      } else {
        printNodesKLevelsDown(root.left, k - distancefromRoot - 1);
      }

      return distancefromRoot;
    }

    return -1;
  }

  private static void printNodesKLevelsDown(BinaryTreeNode root, int k) {
    if (root == null) {
      return;
    }

    if (k == 0) {
      System.out.println(root.data);
      return;
    }

    printNodesKLevelsDown(root.left, k - 1);
    printNodesKLevelsDown(root.right, k - 1);
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
    int targetNode = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());

    BinaryTreeNode root = construct(arr);

    printKNodesFar(root, targetNode, k);
    // printKNodesFar2(root, targetNode, k);

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

/*

Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

Sample Output
10 20 50 60 30 70 80 110 120 90 40 100 
50 60 20 70 110 120 80 90 30 100 40 10

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

class Pair {
  TreeNode node;
  int state;

  Pair(TreeNode node, int state) {
    this.node = node;
    this.state = state;
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

  public static void iterativePreAndPostOrder(TreeNode root) {
    if (root == null) {
      return;
    }

    if (root.children.isEmpty()) {
      System.out.println(root.data);
      System.out.println(root.data);
      return;
    }

    ArrayList<TreeNode> preOrder = new ArrayList<>();
    ArrayList<TreeNode> postOrder = new ArrayList<>();

    Stack<Pair> st = new Stack<>();

    Pair pair = new Pair(root, -1);
    st.push(pair);

    while (!st.isEmpty()) {
      Pair top = st.peek();

      if (top.state == -1) {
        // pre order
        preOrder.add(top.node);
        top.state++;
      } else if (top.state >= 0 && top.state < top.node.children.size()) {
        int childIndex = top.state;
        TreeNode node = top.node.children.get(childIndex);
        int initialState = -1;

        Pair childPair = new Pair(node, initialState);
        st.push(childPair);

        // st.push(new Pair(top.node.children.get(childIndex), -1));

        top.state++;
      } else if (top.state == top.node.children.size()) {
        // post order
        Pair p = st.pop();
        postOrder.add(p.node);
      }
    }

    for (TreeNode node : preOrder) {
      System.out.print(node.data + " ");
    }
    System.out.println();

    for (TreeNode node : postOrder) {
      System.out.print(node.data + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    TreeNode root = construct(arr);

    iterativePreAndPostOrder(root);

    // display(root);
  }

}

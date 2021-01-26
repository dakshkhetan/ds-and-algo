/*

Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

Sample Output
10 
20 30 40 
50 60 70 80 90 100 
110 120

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

  public static void levelOrderLinewise(TreeNode root) {
    if (root == null) {
      return;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        System.out.print(node.data + " ");

        // queue.addAll(node.children);
        for (TreeNode child : node.children) {
          queue.offer(child);
        }
      }
      System.out.println();
    }
  }

  public static void levelOrderLinewise2(TreeNode root) {
    if (root == null) {
      return;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    queue.offer(null);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      if (node != null) {
        System.out.print(node.data + " ");

        for (TreeNode child : node.children) {
          queue.offer(child);
        }
      } else {
        if (!queue.isEmpty()) {
          System.out.println();
          queue.offer(null);
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    TreeNode root = construct(arr);

    levelOrderLinewise(root);
    // levelOrderLinewise2(root);

    // display(root);
  }

}

/*

Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
24
1 2 5 -1 6 -1 -1 3 7 -1 8 11 -1 12 -1 -1 9 -1 -1 4 10 -1 -1 -1

Sample Output
true

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

  public static boolean areSimilar(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    }

    if (root1 == null || root2 == null) {
      return false;
    }

    if (root1.children.size() != root2.children.size()) {
      return false;
    }

    for (int i = 0; i < root1.children.size(); i++) {
      TreeNode child1 = root1.children.get(i);
      TreeNode child2 = root2.children.get(i);

      boolean childSimilar = areSimilar(child1, child2);
      if (!childSimilar) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n1 = s.nextInt();
    int[] arr1 = new int[n1];
    for (int i = 0; i < n1; i++) {
      arr1[i] = s.nextInt();
    }

    int n2 = s.nextInt();
    int[] arr2 = new int[n2];
    for (int i = 0; i < n2; i++) {
      arr2[i] = s.nextInt();
    }

    TreeNode root1 = construct(arr1);
    TreeNode root2 = construct(arr2);

    boolean result = areSimilar(root1, root2);
    System.out.println(result);

    // display(root1);
    // display(root2);
  }

}

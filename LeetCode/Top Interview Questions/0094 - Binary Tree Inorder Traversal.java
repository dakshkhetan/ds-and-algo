/*

Sample Input 1:
root = [1,null,2,3]

Sample Output 1:
[1,3,2]

Sample Input 2:
root = []

Sample Output 2:
[]

*/

class Solution {

  public List<Integer> inorderTraversal(TreeNode root) {
    return inorderTraversalRecursive(root);
    // return inorderTraversalIterative(root);

    // NOTE: there also exists a 'Morris Traversal' method (using Threaded
    // Binary Tree) which solves the problem with TC: O(N) and SC: O(1)
  }

  // Time Complexity: O(N) -> T(n) = 2 * T(n/2) + 1
  // Space Complexity: O(N) in worst case & O(log(N)) in average case
  public List<Integer> inorderTraversalRecursive(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inorderTraversalRecursive(root, result);
    return result;
  }

  private void inorderTraversalRecursive(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }

    inorderTraversalRecursive(root.left, result);
    result.add(root.val);
    inorderTraversalRecursive(root.right, result);
  }

  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public List<Integer> inorderTraversalIterative(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;

    while (current != null || !stack.isEmpty()) {
      while (current != null) {
        stack.push(current);
        current = current.left;
      }

      TreeNode node = stack.pop();
      result.add(node.val);

      current = node.right;
    }

    return result;
  }

}

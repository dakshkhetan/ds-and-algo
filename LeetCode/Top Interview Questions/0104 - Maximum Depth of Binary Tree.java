/*

Sample Input:
root = [3,9,20,null,null,15,7]

Sample Output:
3

Explanation:
A binary tree's maximum depth is the number of nodes along the 
longest path from the root node down to the farthest leaf node.

*/

class Solution {

  public int maxDepth(TreeNode root) {
    return maxDepthRecursive(root);
    // return maxDepthIterative(root);
  }

  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public int maxDepthRecursive(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftSubtreeDepth = maxDepthRecursive(root.left);
    int rightSubtreeDepth = maxDepthRecursive(root.right);

    return Math.max(leftSubtreeDepth, rightSubtreeDepth) + 1;
  }

  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public int maxDepthIterative(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int depth = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      depth++;

      // number of nodes at current depth/level
      int counter = queue.size();

      for (int i = 0; i < counter; i++) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
    }

    return depth;
  }

}

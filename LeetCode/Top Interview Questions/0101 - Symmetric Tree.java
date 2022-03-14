/*

Sample Input 1:
root = [1,2,2,3,4,4,3]

Sample Output 1:
true

Sample Input 2:
root = [1,2,2,null,3,null,3]

Sample Output 2:
false

*/

class Solution {

  public boolean isSymmetric(TreeNode root) {
    return isSymmetricRecursive(root);
    // return isSymmetricIterative(root);
  }

  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public boolean isSymmetricRecursive(TreeNode root) {
    if (root == null) {
      return true;
    }

    return isSymmetricRecursive(root.left, root.right);
  }

  private static boolean isSymmetricRecursive(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    }

    if (root1 == null || root2 == null) {
      return false;
    }

    if (root1.val != root2.val) {
      return false;
    }

    return isSymmetricRecursive(root1.left, root2.right)
        && isSymmetricRecursive(root1.right, root2.left);
  }

  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public boolean isSymmetricIterative(TreeNode root) {
    if (root == null) {
      return true;
    }

    if (root.left == null && root.right == null) {
      return true;
    }

    if (root.left == null || root.right == null) {
      return false;
    }

    Queue<TreeNode> queueLeftSubtree = new LinkedList<>();
    Queue<TreeNode> queueRightSubtree = new LinkedList<>();

    queueLeftSubtree.offer(root.left);
    queueRightSubtree.offer(root.right);

    while (!queueLeftSubtree.isEmpty() && !queueRightSubtree.isEmpty()) {
      TreeNode node1 = queueLeftSubtree.poll();
      TreeNode node2 = queueRightSubtree.poll();

      // there are 3 cases:
      // - one of two nodes is null -> exit
      // - both of them are NOT null -> check & add its children
      // - both of them are null -> do nothing & continue checking
      // remaining nodes in the queue

      if ((node1 != null && node2 == null) || (node1 == null && node2 != null)) {
        return false;
      } else if (node1 != null && node2 != null) {
        if (node1.val != node2.val) {
          return false;
        }

        queueLeftSubtree.offer(node1.left);
        queueRightSubtree.offer(node2.right);

        queueLeftSubtree.offer(node1.right);
        queueRightSubtree.offer(node2.left);
      } else {
        // node1 == null && node2 == null
        continue;
      }
    }

    return true;
  }

}

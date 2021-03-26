/*

Sample Input:
root = [5,4,8,11,null,13,4,7,2,null,null,null,1]
targetSum = 22

Sample Output:
true

Explanation:
# (* denotes the sum path)
#        *5
#       /  \
#     *4    8
#     /    / \
#   *11   13  4
#   /  \       \
#  7   *2       1

*/

class Solution {

  public boolean hasPathSum(TreeNode root, int targetSum) {

    if (root == null) {
      return false;
    }

    if (root.left == null && root.right == null) {
      if (targetSum == root.val) {
        return true;
      }
    }

    boolean leftAns = hasPathSum(root.left, targetSum - root.val);
    boolean rightAns = hasPathSum(root.right, targetSum - root.val);

    return leftAns || rightAns;

    // slightly faster than above since right subtree calls won't happen unnecessary
    // return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

  }

}

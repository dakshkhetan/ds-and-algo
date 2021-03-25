/*

Reference Video - https://youtu.be/TO5zsKtc1Ic

Sample Input:
[10,2,10,20,1,null,-25,null,null,null,null,3,4]

Sample Output:
42

Explanation:
# (* denotes the max path)
#       *10
#       /  \
#     *2   *10
#     / \     \
#   *20  1    -25
#             /  \
#            3    4
Thus, max path sum = 20 + 2 + 10 + 10 = 42

*/

class Solution {

  int maxSum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    maxPathSumHelper(root);
    return maxSum;
  }

  // this func() does 2 things:
  // 1. calculates and updates the maxPathSum (global variable)
  // 2. returns the sum of current node's value and
  // left or right subtree branch's max path sum (whichever is greater)
  private int maxPathSumHelper(TreeNode root) {

    if (root == null) {
      return 0;
    }

    // for negative values, we need to cap it to 0 (thats why're comparing with 0)
    // eg: for tree [2, -1], the output is 2
    int leftSubtreeMaxPathSum = Math.max(0, maxPathSumHelper(root.left));
    int rightSubtreeMaxPathSum = Math.max(0, maxPathSumHelper(root.right));

    maxSum = Math.max(maxSum, root.val + leftSubtreeMaxPathSum + rightSubtreeMaxPathSum);

    return root.val + Math.max(leftSubtreeMaxPathSum, rightSubtreeMaxPathSum);

  }

}

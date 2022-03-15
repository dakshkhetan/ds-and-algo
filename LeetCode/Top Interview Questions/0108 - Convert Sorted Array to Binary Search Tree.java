/*

Sample Input 1:
nums = [-10,-3,0,5,9]

Sample Output 1:
[0,-3,9,-10,null,5] or [0,-10,5,null,-3,null,9]

Sample Input 2:
nums = [1,3]

Sample Output 2:
[3,1] or [1,null,3]

Note:
A height-balanced binary tree is a binary tree in which the depth 
of the two subtrees of every node never differs by more than one.

*/

class Solution {

  // Time Complexity: O(N)
  // Space Complexity: O(log(N))
  public TreeNode sortedArrayToBST(int[] nums) {
    return sortedArrayToBST(nums, 0, nums.length - 1);
  }

  private TreeNode sortedArrayToBST(int[] arr, int start, int end) {
    if (start > end) {
      return null;
    }

    // find the middle element of given array make it as the root node
    int mid = start + (end - start) / 2;
    TreeNode root = new TreeNode(arr[mid]);

    root.left = sortedArrayToBST(arr, start, mid - 1);
    root.right = sortedArrayToBST(arr, mid + 1, end);

    return root;
  }

}

/*

Sample Input:
nums = [0,0,1,1,1,2,2,3,3,4]

Sample Output:
5, nums = [0,1,2,3,4,_,_,_,_,_]

Explanation:
Your function should return k = 5, with the first five elements 
of nums being 0, 1, 2, 3, and 4 respectively. It does not matter 
what you leave beyond the returned k (hence they are underscores).

*/

class Solution {

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  public int removeDuplicates(int[] nums) {
    if (nums.length < 2) {
      return 1;
    }

    // first element remains untouched since array is sorted,
    // hence, we begin from second position (first index)
    int insertIndex = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[insertIndex - 1] != nums[i]) {
        nums[insertIndex] = nums[i]; // modifying the original array
        insertIndex++;
      }
    }

    return insertIndex; // insertIndex == count of total elements
  }

}

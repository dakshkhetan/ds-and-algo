/*

Sample Input:
nums = [0,1,0,3,12]

Sample Output:
[1,3,12,0,0]

NOTE: You must do this in-place without making a copy of the array.

*/

class Solution {

  public void moveZeroes(int[] nums) {
    // moveZeroesTwoPointersUsingAuxiliarySpace(nums);
    // moveZeroesUsingSwapping(nums);
    moveZeroesSinglePointer1(nums);
    // moveZeroesSinglePointer2(nums);
  }

  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public void moveZeroesTwoPointersUsingAuxiliarySpace(int[] nums) {
    int n = nums.length;
    int temp[] = new int[n];

    int left = 0;
    int right = n - 1;

    for (int i = 0; i < n; i++) {
      int currentNum = nums[i];
      if (currentNum != 0) {
        temp[left++] = currentNum;
      } else {
        temp[right--] = 0;
      }
    }

    // copy changes to original array
    for (int i = 0; i < n; i++) {
      nums[i] = temp[i];
    }
  }

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  public void moveZeroesUsingSwapping(int[] nums) {
    // perform a dry run for better understanding of this approach
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;

        j++;
      }
    }
  }

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  public void moveZeroesSinglePointer1(int[] nums) {
    int n = nums.length;
    int nonZeroCounter = 0; // last non-zero num found at index

    // finding & storing non-zero nums first
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[nonZeroCounter++] = nums[i];
      }
    }

    // storing 0's in remaining array
    for (int i = nonZeroCounter; i < n; i++) {
      nums[i] = 0;
    }
  }

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  public void moveZeroesSinglePointer2(int[] nums) {
    int nonZeroCounter = 0; // last non-zero num found at index

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[nonZeroCounter] = nums[i];

        if (i != nonZeroCounter) {
          nums[i] = 0;
        }

        nonZeroCounter++;
      }
    }
  }

}

/*

Sample Input 1:
nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3

Sample Output 1:
[1,2,2,3,5,6]

Explanation: 
The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.


Sample Input 2:
nums1 = [0], m = 0, nums2 = [1], n = 1

Sample Output 2:
[1]

Explanation:
The arrays we are merging are [] and [1]. The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

*/

class Solution {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    // solve using 3-pointer approach:

    // mergeOptimal1(nums1, m, nums2, n);
    mergeOptimal2(nums1, m, nums2, n); // space optimised
  }

  // Time Complexity: O(M+N)
  // Space Complexity: O(M+N)
  public void mergeOptimal1(int[] nums1, int m, int[] nums2, int n) {
    int ans[] = new int[m + n];

    int i = 0;
    int j = 0;
    int k = 0;

    while (i < m && j < n) {
      if (nums1[i] < nums2[j]) {
        ans[k++] = nums1[i++];
      } else {
        ans[k++] = nums2[j++];
      }
    }

    while (i < m) {
      ans[k++] = nums1[i++];
    }

    while (j < n) {
      ans[k++] = nums2[j++];
    }

    // since the question asks to perform in-place
    for (int x = 0; x < m + n; x++) {
      nums1[x] = ans[x];
    }
  }

  // Time Complexity: O(M+N)
  // Space Complexity: O(1)
  public void mergeOptimal2(int[] nums1, int m, int[] nums2, int n) {
    // start filling the numbers from right-side so that nums1[] elements
    // are not disturbed

    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;

    while (i >= 0 && j >= 0) {
      if (nums1[i] > nums2[j]) {
        nums1[k--] = nums1[i--];
      } else {
        nums1[k--] = nums2[j--];
      }
    }

    // now, if 1st array was not completely traversed, then we don't need to do
    // anything because the question asks to make in-place changes to nums1[], and
    // the elements are already present in sorted order

    // however, if 2nd array traversal is not completed, then just copy all the
    // remaining numbers to 1st array
    while (j >= 0) {
      nums1[k--] = nums2[j--];
    }
  }

}

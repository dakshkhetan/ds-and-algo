/*

Sample Input:
nums = [1,3,-1,-3,5,3,6,7]
k = 3

Sample Output:
[3,3,5,5,6,7]

Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

*/

class Solution {

  public int[] maxSlidingWindow(int[] nums, int k) {

    int n = nums.length;
    int windowSize = k;

    if (n <= 1) {
      return nums;
    }

    int ans[] = new int[n - windowSize + 1];
    int windowIndex = 0;

    Deque<Integer> window = new LinkedList<>(); // ArrayDeque is slower

    for (int i = 0; i < n; i++) {
      // Important: remove all previous window indices from deque
      // Reference Video - https://youtu.be/X-9CN-SeVF8?t=339 (timestamp - 5:39)
      if (!window.isEmpty() && window.peekFirst() <= i - windowSize) {
        window.removeFirst();
      }

      // remove all smaller nums' index
      while (!window.isEmpty() && nums[i] >= nums[window.peekLast()]) {
        window.removeLast();
      }

      // add current num's index
      window.addLast(i);

      if (i + 1 >= windowSize) {
        // add current window's max to result
        ans[windowIndex++] = nums[window.peekFirst()];
      }
    }

    return ans;

  }

}

/*

Sample Input:
[-2,1,-3,4,-1,2,1,-5,4]

Sample Output:
6

Explanation: 
[4,-1,2,1] has the largest sum = 6

*/

class Solution {

  public int maxSubArray(int[] nums) {
    // assuming nums[] is not empty

    // return maxSubArrayBruteForce(nums);
    return maxSubArrayKadaneAlgo(nums);
    // return printAndFindMaxSubArrayKadaneAlgo(nums);
    // return maxSubArrayDivideAndConquer(nums);
  }

  // Time Complexity: O(N^2)
  // Space Complexity: O(1)
  public static int maxSubArrayBruteForce(int[] nums) {
    int n = nums.length;
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      int currentSum = nums[i];
      maxSum = Math.max(maxSum, currentSum);

      for (int j = i + 1; j < n; j++) {
        currentSum += nums[j];
        maxSum = Math.max(maxSum, currentSum);
      }
    }

    return maxSum;
  }

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  public static int maxSubArrayKadaneAlgo(int[] nums) {
    int maxSum = nums[0];
    int currentSum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      currentSum = Math.max(currentSum + nums[i], nums[i]);
      maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
  }

  public static int printAndFindMaxSubArrayKadaneAlgo(int[] nums) {
    int maxSum = nums[0];
    int currentSum = nums[0];

    int startIndex = 0;
    int endIndex = 0;

    for (int i = 1; i < nums.length; i++) {
      if (currentSum >= 0) {
        currentSum += nums[i];
      } else {
        currentSum = nums[i];
        startIndex = i;
      }

      if (currentSum >= maxSum) {
        maxSum = currentSum;
        endIndex = i;
      }
    }

    for (int i = startIndex; i <= endIndex; i++) {
      System.out.print(nums[i] + ", ");
    }

    return maxSum;
  }

  // Time Complexity: O(N*log(N))
  // Space Complexity: O(log(N)) ??
  public int maxSubArrayDivideAndConquer(int[] nums) {
    // there are 3 cases to consider:
    // - sub-array with max sum is on the left
    // - sub-array with max sum is on the right
    // - sub-array with max sum is crossing the middle element

    // Reference Video - https://youtu.be/3GD-3UZGsVI

    return findMaxSumRecursive(nums, 0, nums.length - 1);
  }

  private int findMaxSumRecursive(int[] nums, int low, int high) {
    // base case -> single number is present
    if (low == high) {
      return nums[low];
    }

    // divide
    int mid = low + (high - low) / 2;

    // conquer
    int leftMaxSum = findMaxSumRecursive(nums, low, mid);
    int rightMaxSum = findMaxSumRecursive(nums, mid + 1, high);

    // find cross sum -> sum of nums from both halves (starting from middle element)
    int crossMaxSum = findMaxCrossSum(nums, low, mid, high); // important

    // result is the max of all 3 cases
    return Math.max(crossMaxSum, Math.max(leftMaxSum, rightMaxSum));
  }

  private int findMaxCrossSum(int[] nums, int low, int mid, int high) {
    int leftMaxSum = Integer.MIN_VALUE;
    int leftCurrentSum = 0;

    for (int i = mid; i >= low; i--) {
      leftCurrentSum += nums[i];
      leftMaxSum = Math.max(leftMaxSum, leftCurrentSum);
    }

    int rightMaxSum = Integer.MIN_VALUE;
    int rightCurrentSum = 0;

    for (int i = mid + 1; i <= high; i++) {
      rightCurrentSum += nums[i];
      rightMaxSum = Math.max(rightMaxSum, rightCurrentSum);
    }

    return leftMaxSum + rightMaxSum;
  }

}

/*

Sample Input:
nums = [2,2,1,1,1,2,2]

Sample Output:
2

Note: The majority element is the element that appears more than ⌊n / 2⌋ times.

*/

class Solution {

  public int majorityElement(int[] nums) {
    // return majorityElementBruteForce(nums);
    // return majorityElementHashMap(nums);
    // return majorityElementSorting(nums);
    return majorityElementOptimal(nums);
  }

  // Time Complexity: O(N^2)
  // Space Complexity: O(1)
  public int majorityElementBruteForce(int[] nums) {
    int majorityCount = nums.length / 2;

    for (int i = 0; i < nums.length; i++) {
      int currentNum = nums[i];
      int frequency = 0;

      for (int j = 0; j < nums.length; j++) {
        if (nums[j] == currentNum) {
          frequency++;
        }
      }

      if (frequency > majorityCount) {
        return currentNum;
      }
    }

    return -1; // unreachable code since there'll always be an answer
  }

  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public int majorityElementHashMap(int[] nums) {
    Map<Integer, Integer> numsFreqMap = new HashMap<>();

    for (int num : nums) {
      // map.put(num, map.getOrDefault(num, 0) + 1);
      if (numsFreqMap.containsKey(num)) {
        numsFreqMap.put(num, numsFreqMap.get(num) + 1);
      } else {
        numsFreqMap.put(num, 1);
      }
    }

    Map.Entry<Integer, Integer> majorityNumEntry = null;

    for (Map.Entry<Integer, Integer> entry : numsFreqMap.entrySet()) {
      if (majorityNumEntry == null || entry.getValue() > majorityNumEntry.getValue()) {
        majorityNumEntry = entry;
      }
    }

    int majorityNum = majorityNumEntry.getKey();
    return majorityNum;
  }

  // Time Complexity: O(N*log(N))
  // Space Complexity: O(1)
  public int majorityElementSorting(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2]; // important concept
  }

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  public int majorityElementOptimal(int[] nums) {
    // using Boyer-Moore Voting algorithm:

    // Important: majority element's count is cancelled out by minority
    // elements' count and after this process whichever num remains at
    // the end, is the majority element

    int majorityNum = nums[0];
    int count = 0;

    for (int num : nums) {
      if (num == majorityNum) {
        count++;
      } else {
        count--;
      }

      if (count == 0) {
        majorityNum = num;
        count++;
      }
    }

    return majorityNum;
  }

}

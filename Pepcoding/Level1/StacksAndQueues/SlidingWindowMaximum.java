/* 

Sample Input
17
2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6
4

Sample Output
9
9
8
12
12
14
14
32
32
32
32
19
19
19

*/

import java.util.*;

public class Main {

  public static int[] slidingWindowMaximum(int[] nums, int k) {
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

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int k = s.nextInt();

    int result[] = slidingWindowMaximum(arr, k);
    for (int num : result) {
      System.out.println(num);
    }
  }

}

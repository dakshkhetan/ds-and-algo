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

  public static int[] slidingWindowMaximum(int[] arr, int k) {
    int n = arr.length;

    int nextGreaterElementIndices[] = nextGreaterElementToRight(arr);

    int ans[] = new int[n - k + 1];
    int j = 0;

    for (int i = 0; i <= n - k; i++) {
      int windowSize = i + k;
      int index = i;

      while (nextGreaterElementIndices[index] < windowSize) {
        index = nextGreaterElementIndices[index];
      }

      ans[j++] = arr[index];
    }

    return ans;
  }

  public static int[] nextGreaterElementToRight(int[] arr) {
    int n = arr.length;
    int ans[] = new int[n];

    Stack<Integer> st = new Stack<>();

    ans[n - 1] = Integer.MAX_VALUE;
    st.push(n - 1); // storing index in stack

    for (int i = n - 2; i >= 0; i--) {
      while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
        st.pop(); // pop all smaller elements
      }

      if (!st.isEmpty()) {
        ans[i] = st.peek();
      } else {
        ans[i] = Integer.MAX_VALUE;
      }

      st.push(i);
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
    for (int e : result) {
      System.out.println(e);
    }
  }

}

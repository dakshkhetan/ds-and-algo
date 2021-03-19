/*

Reference Video - https://youtu.be/rSf9vPtKcmI

Sample Input
5
5 3 8 -2 7

Sample Output
8
8
-1
7
-1

*/

import java.util.*;

public class Main {

  // Time Complexity: O(n)  [refer video for explanation]
  public static int[] nextGreaterElementToRight(int[] arr) {
    int n = arr.length;
    int ans[] = new int[n];

    Stack<Integer> st = new Stack<>();

    ans[n - 1] = -1;
    st.push(arr[n - 1]);

    for (int i = n - 2; i >= 0; i--) {
      int element = arr[i];

      while (!st.isEmpty() && element >= st.peek()) {
        st.pop();
      }

      if (!st.isEmpty()) {
        ans[i] = st.peek();
      } else {
        ans[i] = -1;
      }

      st.push(element);
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

    int result[] = nextGreaterElementToRight(arr);
    for (int e : result) {
      System.out.println(e);
    }
  }

}

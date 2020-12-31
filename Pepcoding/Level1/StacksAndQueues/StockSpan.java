/*

Sample Input
9
2
5
9
3
1
12
6
8
7

Sample Output
1
2
3
1
1
6
1
2
1

*/

import java.util.*;

public class Main {

  public static int[] stockSpan(int[] prices) {
    int n = prices.length;
    int ans[] = new int[n];

    Stack<Integer> st = new Stack<>();

    ans[0] = 1;
    st.push(0);

    for (int i = 1; i < n; i++) {
      while (!st.isEmpty() && prices[i] >= prices[st.peek()]) {
        st.pop();
      }

      if (!st.isEmpty()) {
        ans[i] = i - st.peek();
      } else {
        ans[i] = i + 1;
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

    int result[] = stockSpan(arr);
    for (int e : result) {
      System.out.println(e);
    }
  }

}

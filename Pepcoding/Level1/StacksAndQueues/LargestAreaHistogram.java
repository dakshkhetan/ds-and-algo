/*

Reference Video - https://youtu.be/0do2734xhnU

Sample Input
7
6 2 5 4 5 1 6

Sample Output
12

*/

import java.util.*;

public class Main {

  public static int largestAreaHistogram(int[] arr) {
    int n = arr.length;

    // next smaller element index on the right

    int rightBound[] = new int[n];
    Stack<Integer> st = new Stack<>();

    rightBound[n - 1] = n;
    st.push(n - 1);

    for (int i = n - 2; i >= 0; i--) {
      while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
        st.pop();
      }

      if (!st.isEmpty()) {
        rightBound[i] = st.peek();
      } else {
        rightBound[i] = n;
      }

      st.push(i);
    }

    // next smaller element index on the left

    int leftBound[] = new int[n];
    st = new Stack<>();

    leftBound[0] = -1;
    st.push(0);

    for (int i = 1; i < n; i++) {
      while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
        st.pop();
      }

      if (!st.isEmpty()) {
        leftBound[i] = st.peek();
      } else {
        leftBound[i] = -1;
      }

      st.push(i);
    }

    // area

    int maxArea = 0;
    for (int i = 0; i < n; i++) {
      int height = arr[i];
      int width = rightBound[i] - leftBound[i] - 1;
      int area = height * width;
      maxArea = Math.max(area, maxArea);
    }

    return maxArea;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    int result = largestAreaHistogram(arr);
    System.out.println(result);
  }

}

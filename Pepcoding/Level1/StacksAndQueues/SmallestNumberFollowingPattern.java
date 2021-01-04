/*

Sample Input
ddddiiii

Sample Output
543216789

*/

import java.util.*;

public class Main {

  public static int smallestNumberFollowingPattern(String pattern) {
    int n = pattern.length();

    // as per given problem statement
    if (n > 8) {
      return -1;
    }

    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> result = new ArrayList<>();
    int num = 1;

    for (int i = 0; i < n; i++) {
      char ch = pattern.charAt(i);

      if (ch == 'd') {
        st.push(num++);
      } else if (ch == 'i') {
        st.push(num++);
        while (!st.isEmpty()) {
          result.add(st.pop());
        }
      }
    }

    st.push(num);
    while (!st.isEmpty()) {
      result.add(st.pop());
    }

    // convert list to single integer
    int number = 0;
    for (Integer digit : result) {
      number = 10 * number + digit;
    }

    return number;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    String str = s.next();

    int result = smallestNumberFollowingPattern(str);
    System.out.println(result);
  }

}

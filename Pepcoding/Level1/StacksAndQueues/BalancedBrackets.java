/*

Sample Input
[(a + b) + {(c + d) * (e / f)}]

Sample Output
true

*/

import java.util.*;

public class Main {

  public static boolean balancedBrackets(String str) {
    Stack<Character> st = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (ch == '(' || ch == '[' || ch == '{') {
        st.push(ch);
      } else if (ch == ')') {
        if (!st.isEmpty() && st.peek() == '(') {
          st.pop();
        } else {
          return false;
        }
      } else if (ch == ']') {
        if (!st.isEmpty() && st.peek() == '[') {
          st.pop();
        } else {
          return false;
        }
      } else if (ch == '}') {
        if (!st.isEmpty() && st.peek() == '{') {
          st.pop();
        } else {
          return false;
        }
      }
    }

    if (st.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    String str = s.nextLine();

    boolean result = balancedBrackets(str);
    System.out.println(result);
  }

}

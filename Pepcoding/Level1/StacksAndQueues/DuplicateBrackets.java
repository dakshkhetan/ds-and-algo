/*

Sample Input 1:
(a + b) + ((c + d))

Sample Output 1:
true


Sample Input 2:
a + (b) + c

Sample Output 2:
true

*/

import java.util.*;

public class Main {

  private static boolean isOperator(char ch) {
    if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
      return true;
    }
    return false;
  }

  public static boolean checkRedundantBrackets(String str) {
    Stack<Character> st = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (ch == '(' || isOperator(ch)) {
        st.push(ch);
      } else if (ch == ')') {
        boolean hasOperator = false;

        while (!st.isEmpty() && st.peek() != '(') {
          st.pop();
          hasOperator = true;
        }

        if (!hasOperator) {
          return true; // redundant
        }

        if (!st.isEmpty()) {
          st.pop();
        }
      }
    }

    return false;
  }

  // basic approach (does not cover Sample Input 2)
  public static boolean duplicateBrackets(String str) {
    Stack<Character> st = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (ch != ')') {
        st.push(ch);
      } else {
        if (st.peek() == '(') {
          return true; // redundant
        }

        while (st.peek() != '(') {
          st.pop();
        }
        st.pop();
      }
    }

    return false;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    String str = s.nextLine();

    // boolean result = duplicateBrackets(str);
    boolean result = checkRedundantBrackets(str);
    System.out.println(result);
  }

}

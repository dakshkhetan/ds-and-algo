/*

Sample Input:
"({})[]"

Sample Output:
true

*/

class Solution {

  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public boolean isValid(String str) {
    return isValid1(str);
    // return isValid2(str);
  }

  public boolean isValid1(String str) {
    if (str.length() % 2 != 0) {
      return false;
    }

    Stack<Character> stack = new Stack<>();

    for (char ch : str.toCharArray()) {
      if (ch == '(') {
        stack.push(')');
      } else if (ch == '{') {
        stack.push('}');
      } else if (ch == '[') {
        stack.push(']');
      } else if (stack.isEmpty() || stack.pop() != ch) {
        return false;
      }
    }

    return stack.isEmpty();
  }

  public boolean isValid2(String str) {
    if (str.length() % 2 != 0) {
      return false;
    }

    Stack<Character> stack = new Stack<>();

    for (char ch : str.toCharArray()) {
      if (ch == '(' || ch == '[' || ch == '{') {
        stack.push(ch);
      } else {
        if (stack.isEmpty()) {
          return false;
        }

        char top = stack.pop();

        if ((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{')) {
          continue;
        } else {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }

}

/* 

Sample Input 1:
"(1+(4+5+2)-3)+(6+8)"

Sample Output 1:
23


Sample Input 2:
"37258"

Sample Output 2:
37258


Constraints:
Expression consists of digits (0-9), +, -, (, ), and spaces.

*/

class Solution {

  public int calculate(String expression) {

    // First 2 approaches are iterative, efficient and almost identical
    // Third approach is recursive and even faster than first 2 approaches

    // return calculateUnderstand(expression);
    // return calculateSlightlyBetter(expression);
    return calculateBestRecursive(expression); // fastest & supports (*, /) as well

  }

  public int calculateUnderstand(String expression) {

    int result = 0;
    int sign = 1;
    int num = 0;

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < expression.length(); i++) {
      char ch = expression.charAt(i);

      if (Character.isDigit(ch)) {
        // num = (num * 10) + (ch - '0');
        num = (10 * num) + Character.getNumericValue(ch);
      } else if (ch == '+') {
        result += sign * num;
        num = 0;
        sign = 1;
      } else if (ch == '-') {
        result += sign * num;
        num = 0;
        sign = -1;
      } else if (ch == '(') {
        // push the result first and then sign
        stack.push(result);
        stack.push(sign);
        // reset the sign and result for the value in the parenthesis
        sign = 1;
        result = 0;
      } else if (ch == ')') {
        result += sign * num;
        num = 0;
        result *= stack.pop(); // stack.pop() is the sign before the parenthesis
        result += stack.pop(); // stack.pop() now is the result calculated before the parenthesis
      }
    }

    if (num != 0) {
      result += sign * num;
    }

    return result;

  }

  public int calculateSlightlyBetter(String expression) {

    int result = 0;
    int num = 0;
    int sign = 1; // 1 -> +ve and -1 -> -ve

    Stack<Integer> stack = new Stack<>();
    stack.push(sign);

    for (int i = 0; i < expression.length(); i++) {
      char ch = expression.charAt(i);

      if (Character.isDigit(ch)) {
        // num = (10 * num) + (ch - '0');
        num = (10 * num) + Character.getNumericValue(ch);
      } else if (ch == '+' || ch == '-') {
        // add result of last context (i.e. before this sign)
        result += sign * num;

        // reset num for next evaluation
        num = 0;

        int lastContextSign = stack.peek();
        // sign = lastContextSign * (ch == '+' ? 1 : -1);
        if (ch == '+') {
          sign = lastContextSign * 1;
        } else { // ch == '-'
          sign = lastContextSign * -1;
        }
      } else if (ch == '(') {
        stack.push(sign); // store current context sign into stack
      } else if (ch == ')') {
        stack.pop(); // remove current context sign from stack
      }
    }

    // add last num to result
    result += sign * num;

    return result;

  }

  // Recursive Solution:
  // Time and Space: O(N)
  // Expression can contain digits (0-9), +, -, *, /, (, ), and spaces.

  int i = 0;

  public int calculateBestRecursive(String expression) {

    if (expression == null || expression.length() == 0) {
      return 0;
    }

    int result = 0;
    int num = 0;
    int value = 0;

    char operator = '+';

    for (; i < expression.length();) {
      char ch = expression.charAt(i);

      i++; // if we increment 'i' inside 'for' loop and NOT here then,
           // when we call recursion below, i would not be incremented,
           // and it will result in infinite calls (Stack Overflow Error)

      if (Character.isDigit(ch)) {
        // num = (10 * num) + (ch - '0');
        num = (10 * num) + Character.getNumericValue(ch);
      } else if (ch == '(') {
        // start new context for new set of paranthesis
        num = calculateBestRecursive(expression);
      } else if (ch == ')') {
        // stop current context
        break;
      } else if (ch == ' ') {
        // skip spaces
        continue;
      } else {
        // ch is an operator (+, -, * or /)

        // compute the value of last context (i.e. before this operator 'ch')
        value = compute(value, num, operator);

        if (ch == '+' || ch == '-') {
          result += value;
          value = 0;
        }

        num = 0; // reset num
        operator = ch; // update operator
      }
    }

    // add last value to result
    value = compute(value, num, operator);
    result += value;

    return result;

  }

  private int compute(int value, int num, char operator) {
    if (operator == '+') {
      return value + num;
    } else if (operator == '-') {
      return value - num;
    } else if (operator == '*') {
      return value * num;
    } else { // operator == '/'
      return value / num;
    }
  }

}

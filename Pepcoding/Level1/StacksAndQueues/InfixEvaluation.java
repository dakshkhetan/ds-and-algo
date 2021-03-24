/*

Sample Input 1:
2 * (5+ 5*2) / 3+(6/2+8)

Sample Output 1:
21


Sample Input 2:
( 15-4 / 2 )

Sample Output 2:
13

*/

import java.util.*;

public class Main {

  // Recursive Solution:
  // Time and Space: O(N)

  static int i = 0;

  public static int infixEvaluation(String expression) {
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
        num = infixEvaluation(expression);
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

  private static int compute(int value, int num, char operator) {
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

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    String str = s.nextLine();

    int result = infixEvaluation(str);
    System.out.println(result);
  }

}

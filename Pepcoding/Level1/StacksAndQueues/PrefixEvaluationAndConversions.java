/*

Sample Input
-+2/*6483

Sample Output
2
((2+((6*4)/8))-3)
264*8/+3-

*/

import java.util.*;

public class Main {

  private static boolean isOperator(char ch) {
    return ch == '/' || ch == '*' || ch == '+' || ch == '-';
  }

  private static int operation(int v1, int v2, char operator) {
    if (operator == '/') {
      return v1 / v2;
    } else if (operator == '*') {
      return v1 * v2;
    } else if (operator == '+') {
      return v1 + v2;
    } else { // operator == '-'
      return v1 - v2;
    }
  }

  private static void evaluate(Stack<Integer> operands, char operator) {
    int v1 = operands.pop();
    int v2 = operands.pop();

    int result = operation(v1, v2, operator);
    operands.push(result);
  }

  private static void process(Stack<String> infix, Stack<String> postfix, char operator) {
    String v1_infix = infix.pop();
    String v2_infix = infix.pop();

    String v1_postfix = postfix.pop();
    String v2_postfix = postfix.pop();

    String infixResult = "(" + v1_infix + operator + v2_infix + ")";
    String postfixResult = v1_postfix + v2_postfix + operator;

    infix.push(infixResult);
    postfix.push(postfixResult);
  }

  public static void prefixEvaluationAndConversions(String expression) {
    Stack<Integer> operands = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> postfix = new Stack<>();

    // iterating from back
    for (int i = expression.length() - 1; i >= 0; i--) {
      char ch = expression.charAt(i);

      if (Character.isDigit(ch)) {
        int num = Character.getNumericValue(ch);
        String c = Character.toString(ch);
        // int num = ch - '0';
        // String c = ch + "";

        operands.push(num);
        infix.push(c);
        postfix.push(c);
      } else if (isOperator(ch)) {
        // Note: here, v1 = stack's top element since we are iterating from back
        // (unlike postfix, where v2 = stack's top element)

        evaluate(operands, ch); // evaluation
        process(infix, postfix, ch); // conversions
      }
    }

    System.out.println(operands.peek());
    System.out.println(infix.peek());
    System.out.println(postfix.peek());
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String str = s.nextLine();

    prefixEvaluationAndConversions(str);
  }

}

/*

Sample Input
264*8/+3-

Sample Output
2
((2+((6*4)/8))-3)
-+2/*6483

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
    int v2 = operands.pop();
    int v1 = operands.pop();

    int result = operation(v1, v2, operator);
    operands.push(result);
  }

  private static void process(Stack<String> infix, Stack<String> prefix, char operator) {
    String v2_infix = infix.pop();
    String v1_infix = infix.pop();

    String v2_prefix = prefix.pop();
    String v1_prefix = prefix.pop();

    String infixResult = "(" + v1_infix + operator + v2_infix + ")";
    String prefixResult = operator + v1_prefix + v2_prefix;

    infix.push(infixResult);
    prefix.push(prefixResult);
  }

  public static void postfixEvaluationAndConversions(String expression) {
    Stack<Integer> operands = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> prefix = new Stack<>();

    for (int i = 0; i < expression.length(); i++) {
      char ch = expression.charAt(i);

      if (Character.isDigit(ch)) {
        int num = Character.getNumericValue(ch);
        String c = Character.toString(ch);
        // int num = ch - '0';
        // String c = ch + "";

        operands.push(num);
        infix.push(c);
        prefix.push(c);
      } else if (isOperator(ch)) {
        evaluate(operands, ch); // evaluation
        process(infix, prefix, ch); // conversions
      }
    }

    System.out.println(operands.peek());
    System.out.println(infix.peek());
    System.out.println(prefix.peek());
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String str = s.nextLine();

    postfixEvaluationAndConversions(str);
  }

}

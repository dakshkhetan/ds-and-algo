/*

Sample Input
a*(b-c+d)/e

Sample Output
abc-d+*e/
/*a+-bcde

*/

import java.util.*;

public class Main {

  private static boolean isOperator(char ch) {
    if (ch == '/' || ch == '*' || ch == '+' || ch == '-') {
      return true;
    }
    return false;
  }

  private static int priority(char ch) {
    if (ch == '/') {
      return 2;
    } else if (ch == '*') {
      return 2;
    } else if (ch == '+') {
      return 1;
    } else { // ch == '-'
      return 1;
    }
  }

  private static void compute(Stack<String> prefix, Stack<String> postfix, Stack<Character> operators) {
    String v2_pre = prefix.pop();
    String v1_pre = prefix.pop();

    String v2_post = postfix.pop();
    String v1_post = postfix.pop();

    char operator = operators.pop();

    String prefixResult = operator + v1_pre + v2_pre;
    String postfixResult = v1_post + v2_post + operator;

    prefix.push(prefixResult);
    postfix.push(postfixResult);
  }

  public static void infixConversions(String expression) {
    Stack<String> prefix = new Stack<>();
    Stack<String> postfix = new Stack<>();
    Stack<Character> operators = new Stack<>();

    for (int i = 0; i < expression.length(); i++) {
      char ch = expression.charAt(i);

      if (ch == '(') {
        operators.push(ch);
      } else if (Character.isLetterOrDigit(ch)) {
        String operand = Character.toString(ch);
        // String operand = ch + "";
        prefix.push(operand);
        postfix.push(operand);
      } else if (ch == ')') {
        while (operators.peek() != '(') {
          compute(prefix, postfix, operators);
        }
        operators.pop();
      } else if (isOperator(ch)) {
        while (!operators.isEmpty() && operators.peek() != '(' && priority(ch) <= priority(operators.peek())) {
          compute(prefix, postfix, operators);
        }
        operators.push(ch);
      }
    }

    while (!operators.isEmpty()) {
      compute(prefix, postfix, operators);
    }

    System.out.println(postfix.peek());
    System.out.println(prefix.peek());
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String str = s.nextLine();

    infixConversions(str);
  }

}

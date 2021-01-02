/*

Sample Input
2 + (5 - 3 * 6 / 2)

Sample Output
-2

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

  private static void compute(Stack<Integer> operands, Stack<Character> operators) {
    char operator = operators.pop();
    int v2 = operands.pop();
    int v1 = operands.pop();

    int result = operation(v1, v2, operator);
    operands.push(result);
  }

  public static int infixEvaluation(String expression) {
    Stack<Integer> operands = new Stack<>();
    Stack<Character> operators = new Stack<>();

    for (int i = 0; i < expression.length(); i++) {
      char ch = expression.charAt(i);

      if (ch == '(') {
        operators.push(ch);
      } else if (Character.isDigit(ch)) {
        // int num = ch - '0';
        int num = Character.getNumericValue(ch);
        operands.push(num);
      } else if (ch == ')') {
        while (operators.peek() != '(') {
          compute(operands, operators);
        }
        operators.pop();
      } else if (isOperator(ch)) {
        while (!operators.isEmpty() && operators.peek() != '(' && priority(ch) <= priority(operators.peek())) {
          compute(operands, operators);
        }
        operators.push(ch);
      }
    }

    while (!operators.isEmpty()) {
      compute(operands, operators);
    }

    int result = operands.peek();
    return result;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    String str = s.nextLine();

    int result = infixEvaluation(str);
    System.out.println(result);
  }

}

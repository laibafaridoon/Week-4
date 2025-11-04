

package infixtopostfix;
import java.util.Stack;
import java.util.Scanner;

public class Infinixtopostfix {

    // Function to check precedence
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Function to convert infix to postfix
    static String infixToPostfix(String exp) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // skip spaces
            if (c == ' ')
                continue;

            // If operand, add to result
            if (Character.isLetterOrDigit(c)) {
                result += c + " ";
            }
            // If '(' push to stack
            else if (c == '(') {
                stack.push(c);
            }
            // If ')' pop till '('
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop() + " ";
                }
                stack.pop(); // remove '('
            }
            // Operator
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result += stack.pop() + " ";
                }
                stack.push(c);
            }
        }

        // Pop all remaining
        while (!stack.isEmpty()) {
            result += stack.pop() + " ";
        }

        return result.trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String exp = sc.nextLine();

        String postfix = infixToPostfix(exp);
        System.out.println("Postfix: " + postfix);
    }
}





package infixtoprefix;

import java.util.Stack;
import java.util.Scanner;

public class Infixtoprefix {

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

    // Helper to reverse a string
    static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    // Infix to Postfix (same as before)
    static String infixToPostfix(String exp) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (c == ' ')
                continue;

            if (Character.isLetterOrDigit(c)) {
                result += c + " ";
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop() + " ";
                }
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result += stack.pop() + " ";
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop() + " ";
        }
        return result.trim();
    }

    // Infix to Prefix
    static String infixToPrefix(String infix) {
        // 1. Reverse infix
        infix = reverse(infix);

        // 2. Swap brackets
        char[] chars = infix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(')
                chars[i] = ')';
            else if (chars[i] == ')')
                chars[i] = '(';
        }

        // 3. Convert to postfix
        String postfix = infixToPostfix(new String(chars));

        // 4. Reverse postfix to get prefix
        String prefix = reverse(postfix);
        return prefix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String exp = sc.nextLine();

        String prefix = infixToPrefix(exp);
        System.out.println("Prefix: " + prefix);
    }
}

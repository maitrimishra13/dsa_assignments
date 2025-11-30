package assignment3;
import java.util.Scanner;

public class Question4 {
    static class Stack {
        private int top;
        private final char[] arr;
        private final int size;

        Stack(int n) {
            size = n;
            arr = new char[size];
            top = -1;
        }

        public void push(char ch) {
            if (top == size - 1) {
                System.out.println("Stack Overflow!");
            } else {
                arr[++top] = ch;
            }
        }

        public char pop() {
            if (top == -1) {
                System.out.println("Stack Underflow!");
                return '\0';
            } else {
                return arr[top--];
            }
        }

        public char peek() {
            if (top == -1) {
                return '\0';
            } else {
                return arr[top];
            }
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    public static int precedence(char ch) {
        if (ch == '^') {
            return 3;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        } else {
            return 0;
        }
    }

    public static String infixToPostfix(String expr) {
        Stack s = new Stack(expr.length());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            // Ignore spaces
            if (ch == ' ') {
                continue;
            }
            // If operand (letter or digit), add to result
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            // If '(', push to stack
            else if (ch == '(') {
                s.push(ch);
            }
            // If ')', pop until '('
            else if (ch == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    result.append(s.pop());
                }
                if (!s.isEmpty() && s.peek() == '(') {
                    s.pop(); // pop '('
                }
            }

            // Operator: + - * / ^
            else {
                while (!s.isEmpty() &&
                        precedence(s.peek()) >= precedence(ch) &&
                        s.peek() != '(') {

                    result.append(s.pop());
                }
                s.push(ch);
            }
        }
        // Pop remaining operators
        while (!s.isEmpty()) {
            result.append(s.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String infix = sc.nextLine();

        String postfix = infixToPostfix(infix);
        System.out.println("Postfix expression: " + postfix);
        sc.close();
    }
}


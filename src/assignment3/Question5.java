package assignment3;
import java.util.Scanner;

public class Question5 {

    // ====== USER-DEFINED STACK CLASS (for int) ======
    static class Stack {
        private int top;
        private final int[] arr;
        private final int size;

        Stack(int n) {
            size = n;
            arr = new int[size];
            top = -1;
        }

        public void push(int value) {
            if (top == size - 1) {
                System.out.println("Stack Overflow!");
            } else {
                arr[++top] = value;
            }
        }

        public int pop() {
            if (top == -1) {
                System.out.println("Stack Underflow!");
                return 0;   // default value
            } else {
                return arr[top--];
            }
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    public static int evaluatePostfix(String expr) {
        Stack s = new Stack(expr.length());

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            // Ignore spaces
            if (ch == ' ') {
                continue;
            }
            // If operand (digit), push its integer value
            if (Character.isDigit(ch)) {
                int num = ch - '0';     // convert char '5' → int 5
                s.push(num);
            }
            // If operator, pop two operands and apply
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int b = s.pop();   // second operand
                int a = s.pop();   // first operand
                int result = 0;

                if (ch == '+') {
                    result = a + b;
                } else if (ch == '-') {
                    result = a - b;
                } else if (ch == '*') {
                    result = a * b;
                } else {
                    result = a / b;
                }
                s.push(result);
            }
        }

        // Final result will be on top
        return s.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter postfix expression: ");
        String postfix = sc.nextLine();
        int value = evaluatePostfix(postfix);

        System.out.println("Result = " + value);
        sc.close();
    }
}

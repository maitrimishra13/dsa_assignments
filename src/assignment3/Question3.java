package assignment3;

import java.util.Scanner;

public class Question3 {
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
                return '\0';
            } else {
                return arr[top--];
            }
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    public static boolean isBalanced(String expr) {
        Stack s = new Stack(expr.length());

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            // If opening bracket → push
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            }
            // If closing bracket → check top
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (s.isEmpty()) {
                    return false;  // no opening bracket exists
                }
                char top = s.pop();
                // Check mismatch
                if ((ch == ')' && top != '(') ||
                        (ch == ']' && top != '[') ||
                        (ch == '}' && top != '{')) {

                    return false;
                }
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression: ");
        String exp = sc.nextLine();

        if (isBalanced(exp))
            System.out.println("Balanced Expression");
        else
            System.out.println("Not Balanced");

        sc.close();
    }
}


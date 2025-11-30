package assignment3;
import java.util.Scanner;

public class Question2 {

    public static class Stack {
        private int top;
        private final char[] stack;
        private final int max;

        Stack(int size) {
            max = size;
            stack = new char[max];
            top = -1;
        }

        public boolean isFull() {
            return top == max - 1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public void push(char value) {
            if (isFull()) {
                System.out.println("\nStack is FULL! Cannot push " + value);
            } else {
                stack[++top] = value;   // first increment, then use
                System.out.println("\n" + value + " pushed to the stack");
            }
        }

        public char pop() {
            if (top == -1) {
                System.out.println("Stack Underflow!");
                return '\0';   // null character
            } else {
                return stack[top--];
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        Stack s = new Stack(str.length());

        // Push each character
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }

        // Pop into char array
        char[] reversed = new char[str.length()];
        int i = 0;

        while (!s.isEmpty()) {
            reversed[i++] = s.pop();
        }
        System.out.println("Reversed string: " + new String(reversed));
        sc.close();
    }
}

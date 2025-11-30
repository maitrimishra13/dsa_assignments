package assignment3;
import java.util.Scanner;

public class Question1 {
    public static class Stack {
        private int top;
        private final int[] stack;
        private final int max;

        Stack(int size) {
            max = size;
            stack = new int[max];
            top = -1;
        }

        public boolean isFull() {
            return top == max - 1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public void push(int value) {
            if (isFull()) {
                System.out.println("\nStack is FULL! Cannot push " + value);
            } else {
                stack[++top] = value;
                System.out.println("\n" + value + " pushed to the stack");
            }
        }

        // Pop an element
        public void pop() {
            if (isEmpty()) {
                System.out.println("\nStack is EMPTY! Nothing to pop.");
            } else {
                System.out.println("\n" + stack[top--] + " popped from the stack");
            }
        }

        // Display the stack
        public void display() {
            if (isEmpty()) {
                System.out.println("\nStack is EMPTY!");
            } else {
                System.out.println("\nStack elements:");
                for (int i = top; i >= 0; i--) {
                    System.out.println(stack[i]);
                }
            }
        }

        // Peek (top element)
        public void peek() {
            if (isEmpty()) {
                System.out.println("\nStack is EMPTY! No top element.");
            } else {
                System.out.println("\nTop element is: " + stack[top]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of stack: ");
        int size = sc.nextInt();

        Stack s = new Stack(size);

        while (true) {
            System.out.println("\n====== STACK MENU ======");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. isEmpty");
            System.out.println("4. isFull");
            System.out.println("5. Display");
            System.out.println("6. Peek");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    s.push(val);
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    System.out.println(s.isEmpty() ? "\nStack is EMPTY." : "\nStack is NOT empty.");
                    break;
                case 4:
                    System.out.println(s.isFull() ? "\nStack is FULL." : "\nStack is NOT full.");
                    break;
                case 5:
                    s.display();
                    break;
                case 6:
                    s.peek();
                    break;
                case 7:
                    System.out.println("\nExiting... Bye!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice! Try again.");
            }
        }
    }

}

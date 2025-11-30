package assignment4;

import java.util.Scanner;

public class Question1 {
    public static class Queue {
        private int front, rear;
        private final int size;
        private final int[] queue;

        Queue(int capacity) {
            size = capacity;
            queue = new int[size];
            front = -1;
            rear = -1;
        }

        public boolean isEmpty() {
            return (front == -1);
        }

        public boolean isFull() {
            return (rear == size - 1);
        }

        public void enqueue(int value) {
            if (isFull()) {
                System.out.println("Queue is FULL! Cannot enqueue " + value);
            } else {
                if (isEmpty()) {
                    front = 0;
                }
                queue[++rear] = value;
                System.out.println(value + " enqueued successfully.");
            }
        }

        public void dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is EMPTY! Nothing to dequeue.");
            } else {
                System.out.println(queue[front] + " dequeued from the queue.");
                front++;

                // Reset queue if it becomes empty after dequeue
                if (front > rear) {
                    front = rear = -1;
                }
            }
        }

        // Peek front element
        public void peek() {
            if (isEmpty()) {
                System.out.println("Queue is EMPTY! No front element.");
            } else {
                System.out.println("Front element is: " + queue[front]);
            }
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is EMPTY!");
            } else {
                System.out.println("Queue elements:");
                for (int i = front; i <= rear; i++) {
                    System.out.print(queue[i] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of queue: ");
        int size = sc.nextInt();

        Queue q = new Queue(size);

        while (true) {
            System.out.println("\n====== QUEUE MENU ======");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Check isEmpty");
            System.out.println("4. Check isFull");
            System.out.println("5. Display Queue");
            System.out.println("6. Peek");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    q.enqueue(sc.nextInt());
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    System.out.println(q.isEmpty() ? "Queue is EMPTY." : "Queue is NOT empty.");
                    break;

                case 4:
                    System.out.println(q.isFull() ? "Queue is FULL." : "Queue is NOT full.");
                    break;

                case 5:
                    q.display();
                    break;

                case 6:
                    q.peek();
                    break;

                case 7:
                    System.out.println("Exiting... Bye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

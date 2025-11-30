package assignment4;
import java.util.Scanner;

public class Question2 {
    public static class CircularQueue {
        private int front, rear;
        private final int size;
        private final int[] queue;

        CircularQueue(int capacity) {
            size = capacity;
            queue = new int[size];
            front = -1;
            rear = -1;
        }

        public boolean isFull() {
            return (front == (rear + 1) % size);
        }

        public boolean isEmpty() {
            return (front == -1);
        }

        public void enqueue(int value) {
            if (isFull()) {
                System.out.println("Circular Queue is FULL! Cannot enqueue " + value);
            } else {
                if (isEmpty()) {
                    front = 0;
                }
                rear = (rear + 1) % size;
                queue[rear] = value;
                System.out.println(value + " enqueued successfully.");
            }
        }

        public void dequeue() {
            if (isEmpty()) {
                System.out.println("Circular Queue is EMPTY! Nothing to dequeue.");
            } else {
                System.out.println(queue[front] + " dequeued from the queue.");

                if (front == rear) {
                    // After deleting last element, reset queue
                    front = rear = -1;
                } else {
                    front = (front + 1) % size;
                }
            }
        }

        public void peek() {
            if (isEmpty()) {
                System.out.println("Circular Queue is EMPTY! No front element.");
            } else {
                System.out.println("Front element is: " + queue[front]);
            }
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Circular Queue is EMPTY!");
            } else {
                System.out.print("Circular Queue elements: ");
                int i = front;

                while (true) {
                    System.out.print(queue[i] + " ");
                    if (i == rear) break;
                    i = (i + 1) % size;
                }
                System.out.println();
            }
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Circular Queue: ");
        int size = sc.nextInt();

        CircularQueue cq = new CircularQueue(size);

        while (true) {
            System.out.println("\n====== CIRCULAR QUEUE MENU ======");
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
                    cq.enqueue(sc.nextInt());
                    break;
                case 2:
                    cq.dequeue();
                    break;
                case 3:
                    System.out.println(cq.isEmpty() ? "Circular Queue is EMPTY." : "Circular Queue is NOT empty.");
                    break;
                case 4:
                    System.out.println(cq.isFull() ? "Circular Queue is FULL." : "Circular Queue is NOT full.");
                    break;
                case 5:
                    cq.display();
                    break;
                case 6:
                    cq.peek();
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

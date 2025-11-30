package assignment4;

public class Question3 {
    public static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static class MyQueue {
        Node front, rear;

        public void enqueue(int x) {
            Node temp = new Node(x);
            if (rear == null) {
                front = rear = temp;
                return;
            }
            rear.next = temp;
            rear = temp;
        }

        public int dequeue() {
            if (front == null) return -1;

            int val = front.data;
            front = front.next;

            if (front == null) rear = null;
            return val;
        }

        public boolean isEmpty() {
            return front == null;
        }

        int size() {
            int c = 0;
            Node temp = front;
            while (temp != null) {
                c++;
                temp = temp.next;
            }
            return c;
        }

        public static void interleave(MyQueue q) {
            int n = q.size();
            if (n % 2 != 0) {
                System.out.println("Queue size must be even");
                return;
            }

            int half = n / 2;
            int[] stack = new int[half];
            int top = -1;

            // STEP 1: push first half into stack
            for (int i = 0; i < half; i++)
                stack[++top] = q.dequeue();

            // STEP 2: add stack elements back (reversed)
            while (top != -1)
                q.enqueue(stack[top--]);

            // STEP 3: move first half elements to back
            for (int i = 0; i < half; i++)
                q.enqueue(q.dequeue());

            // STEP 4: push first half again into stack
            for (int i = 0; i < half; i++)
                stack[++top] = q.dequeue();

            // STEP 5: interleave
            while (top != -1) {
                q.enqueue(stack[top--]);   // from first half
                q.enqueue(q.dequeue());    // from second half
            }
        }

        public static void main(String[] args) {
            MyQueue q = new MyQueue();

            q.enqueue(4);
            q.enqueue(7);
            q.enqueue(11);
            q.enqueue(20);
            q.enqueue(5);
            q.enqueue(9);

            interleave(q);

            // print result
            while (!q.isEmpty()) {
                System.out.print(q.dequeue() + " ");
            }
        }
    }
}

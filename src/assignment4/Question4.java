package assignment4;

public class Question4 {
    public static class Node {
        char data;
        Node next;

        Node(char d) {
            data = d;
            next = null;
        }
    }

    public static class MyQueue {
        Node front, rear;

        void enqueue(char c) {
            Node temp = new Node(c);
            if (rear == null) {
                front = rear = temp;
                return;
            }
            rear.next = temp;
            rear = temp;
        }

        char dequeue() {
            if (front == null) return '#'; // empty
            char val = front.data;
            front = front.next;
            if (front == null) rear = null;
            return val;
        }

        boolean isEmpty() {
            return front == null;
        }

        char frontChar() {
            if (front == null) return '#';
            return front.data;
        }
    }

    public static void main(String[] args) {
        String input = "aabc";

        MyQueue q = new MyQueue();
        int[] freq = new int[26];

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // 1. Increase frequency
            freq[ch - 'a']++;

            // 2. Add to queue
            q.enqueue(ch);

            // 3. Remove all repeating chars from queue front
            while (!q.isEmpty() && freq[q.frontChar() - 'a'] > 1) {
                q.dequeue();
            }

            // 4. Print current answer
            if (q.isEmpty())
                System.out.print("-1 ");
            else
                System.out.print(q.frontChar() + " ");
        }
    }
}

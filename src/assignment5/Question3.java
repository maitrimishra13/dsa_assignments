package assignment5;

public class Question3 {
    public static class LinkedList {
        private static class Node {
            int data;
            Node next;
            Node(int value) {
                data = value;
                next = null;
            }
        }

        private Node head;

        public LinkedList() { head = null; }

        public void insertAtEnd(int value) {

            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        // Display linked list
        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println("NULL");
        }

        // Find middle element
        public void findMiddle() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }

            Node slow = head;  // moves 1 step
            Node fast = head;  // moves 2 steps

            while (fast != null && fast.next != null) {
                slow = slow.next;          // 1 step
                fast = fast.next.next;     // 2 steps
            }

            System.out.println("Middle element is: " + slow.data);
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.display();
        list.findMiddle();
    }
}

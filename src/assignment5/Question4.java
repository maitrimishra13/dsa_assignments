package assignment5;

public class Question4 {
    public static class LinkedList {
        public static class Node {
            int data;
            Node next;

            Node(int value) {
                data = value;
                next = null;
            }
        }

        private Node head;

        public LinkedList() {
            head = null;
        }

        public void display() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println("NULL");
        }

        public void insertAtBeg(int value) {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }

        public void insertAtEnd(int value) {
            Node temp = new Node(value);

            if (head == null) {
                head = temp;
                return;
            }

            Node current = head;

            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
        }

        public void reverse() {
            Node prev = null;
            Node current = head;
            Node next;

            while (current != null) {
                next = current.next;  // store next node
                current.next = prev;  // reverse the link
                prev = current;       // move prev forward
                current = next;       // move current forward
            }

            head = prev; // new head
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
        list.reverse();
        System.out.println("Reversed List: ");
        list.display();
    }
}
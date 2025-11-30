package assignment6;

public class Question2 {
    public static class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    public static void displayCircularList(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node curr = head;
        System.out.print("Output: ");

        // Traverse until one full circle
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);

        // Repeat head value at the end
        System.out.print(head.data);

        System.out.println();
    }

    public static void main(String[] args) {

        // Creating the circular linked list: 20 → 100 → 40 → 80 → 60
        Node head = new Node(20);
        Node n2 = new Node(100);
        Node n3 = new Node(40);
        Node n4 = new Node(80);
        Node n5 = new Node(60);

        // Linking nodes
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // Last node pointing back to head → circular
        n5.next = head;

        // Display list with repeated head value
        displayCircularList(head);
    }
}

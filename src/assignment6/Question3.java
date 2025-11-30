package assignment6;

public class Question3 {
    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int val) {
            data = val;
            next = null;
            prev = null;
        }
    }

    public static int sizeOfDLL(Node head) {
        int count = 0;
        Node curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public static int sizeOfCLL(Node head) {
        if (head == null) return 0;

        int count = 0;
        Node curr = head;

        do {
            count++;
            curr = curr.next;
        } while (curr != head);

        return count;
    }

    public static void main(String[] args) {

        // ------- Example Doubly Linked List: 10 <-> 20 <-> 30 -------
        Node d1 = new Node(10);
        Node d2 = new Node(20);
        Node d3 = new Node(30);

        d1.next = d2;  d2.prev = d1;
        d2.next = d3;  d3.prev = d2;

        System.out.println("Size of Doubly Linked List = " + sizeOfDLL(d1));

        // ------- Example Circular Linked List: 5 → 15 → 25 → 5 -------
        Node c1 = new Node(5);
        Node c2 = new Node(15);
        Node c3 = new Node(25);

        c1.next = c2;
        c2.next = c3;
        c3.next = c1;   // circular

        System.out.println("Size of Circular Linked List = " + sizeOfCLL(c1));
    }
}

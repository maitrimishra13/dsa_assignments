package assignment6;

import java.util.Scanner;

public class Question1CLL {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static class CircularLinkedList {
        private Node head;

        public boolean isEmpty() {
            return head == null;
        }

        public void insertAtBeginning(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                head.next = head; // points to itself
                return;
            }
            // find tail to fix circular link
            Node tail = head;
            while (tail.next != head) tail = tail.next;
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }

        public void insertAtEnd(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                head.next = head;
                return;
            }
            Node tail = head;
            while (tail.next != head) tail = tail.next;
            tail.next = newNode;
            newNode.next = head;
        }

        public void insertAfter(int target, int value) {
            if (head == null) {
                System.out.println("List is empty. Cannot insert after " + target);
                return;
            }
            Node curr = head;
            boolean found = false;
            do {
                if (curr.data == target) {
                    Node newNode = new Node(value);
                    newNode.next = curr.next;
                    curr.next = newNode;
                    found = true;
                    break;
                }
                curr = curr.next;
            } while (curr != head);

            if (!found) System.out.println("Value " + target + " not found in list.");
        }

        public void deleteNode(int key) {
            if (head == null) {
                System.out.println("List is empty. Cannot delete " + key);
                return;
            }

            // If only one node
            if (head.next == head) {
                if (head.data == key) {
                    head = null;
                    System.out.println("Deleted node " + key);
                } else {
                    System.out.println("Value " + key + " not found.");
                }
                return;
            }

            // If head needs to be deleted
            if (head.data == key) {
                // find tail
                Node tail = head;
                while (tail.next != head) tail = tail.next;
                head = head.next;
                tail.next = head;
                System.out.println("Deleted node " + key);
                return;
            }

            // Delete middle or tail
            Node prev = head;
            Node curr = head.next;
            boolean found = false;
            while (curr != head) {
                if (curr.data == key) {
                    prev.next = curr.next;
                    System.out.println("Deleted node " + key);
                    found = true;
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
            if (!found) System.out.println("Value " + key + " not found.");
        }

        public int search(int key) {
            if (head == null) return -1;
            Node curr = head;
            int pos = 1;
            do {
                if (curr.data == key) return pos;
                curr = curr.next;
                pos++;
            } while (curr != head);
            return -1;
        }

        public void display() {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }
            Node curr = head;
            System.out.print("CLL elements: ");
            do {
                System.out.print(curr.data + " ");
                curr = curr.next;
            } while (curr != head);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList cll = new CircularLinkedList();
        int choice;

        System.out.println("=== Question1CLL : Circular Linked List Menu ===");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at beginning (first node)");
            System.out.println("2. Insert at end (last node)");
            System.out.println("3. Insert AFTER a specific node");
            System.out.println("4. Insert BEFORE a specific node");
            System.out.println("5. Delete a node (by value)");
            System.out.println("6. Search for a node (by value)");
            System.out.println("7. Display list");
            System.out.println("8. Exit");
            System.out.print("Enter your choice (1-8): ");
            while (!sc.hasNextInt()) {
                System.out.print("Please enter a number (1-8): ");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value to insert at beginning: ");
                    int v = sc.nextInt();
                    cll.insertAtBeginning(v);
                    System.out.println(v + " inserted at beginning.");
                }
                case 2 -> {
                    System.out.print("Enter value to insert at end: ");
                    int v = sc.nextInt();
                    cll.insertAtEnd(v);
                    System.out.println(v + " inserted at end.");
                }
                case 3 -> {
                    System.out.print("Enter target value (after which to insert): ");
                    int target = sc.nextInt();
                    System.out.print("Enter value to insert: ");
                    int v = sc.nextInt();
                    cll.insertAfter(target, v);
                }
                case 4 -> {
                    System.out.print("Enter value to delete: ");
                    int key = sc.nextInt();
                    cll.deleteNode(key);
                }
                case 5 -> {
                    System.out.print("Enter value to search: ");
                    int key = sc.nextInt();
                    int pos = cll.search(key);
                    if (pos == -1) System.out.println(key + " not found in list.");
                    else System.out.println(key + " found at position " + pos + " (1-based).");
                }
                case 6 -> cll.display();
                case 7 -> System.out.println("Exiting. Goodbye!");
                default -> System.out.println("Invalid choice. Enter 1..8.");
            }

        } while (choice != 7);

        sc.close();
    }
}

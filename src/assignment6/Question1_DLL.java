package assignment6;

import java.util.Scanner;

public class Question1_DLL {
    public static class DoubleLinkedList{
        public static class Node{
            int data;
            Node next;
            Node prev;

            Node(int val) {
                data = val;
                prev = null;
                next = null;
            }
        }

        public Node head;

        public DoubleLinkedList() {
            head = null;
        }

        public void search(int num){
            if(head == null){
                System.out.println("List is empty");
                return;
            }
            Node cur = head;
            int pos = 1;
            while(cur != null){
                if(cur.data == num){
                    System.out.println("Element found at position: " + pos);
                    return;
                }
                cur = cur.next;
                pos++;
            }
            System.out.println("Element not found");
        }

        void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = newNode;
            newNode.prev = curr;
        }

        void insertAfter(int target, int data) {
            Node curr = head;
            while (curr != null && curr.data != target) curr = curr.next;
            if (curr == null) {
                System.out.println("InsertAfter: target " + target + " not found.");
                return;
            }
            Node newNode = new Node(data);
            newNode.next = curr.next;
            newNode.prev = curr;
            curr.next = newNode;
            if (newNode.next != null) newNode.next.prev = newNode;
        }

        // new: insertBefore
        void insertBefore(int target, int data) {
            if (head == null) {
                System.out.println("InsertBefore: list is empty.");
                return;
            }
            // if target is head
            if (head.data == target) {
                insertAtBeginning(data);
                return;
            }

            Node curr = head.next;
            while (curr != null && curr.data != target) curr = curr.next;
            if (curr == null) {
                System.out.println("InsertBefore: target " + target + " not found.");
                return;
            }

            Node newNode = new Node(data);
            Node prev = curr.prev;
            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = curr;
            curr.prev = newNode;
        }

        void deleteNode(int key) {
            if (head == null) {
                System.out.println("Delete: list is empty.");
                return;
            }

            Node curr = head;

            // find the node
            while (curr != null && curr.data != key) curr = curr.next;
            if (curr == null) {
                System.out.println("Delete: node " + key + " not found.");
                return;
            }

            // If node to be deleted is head
            if (curr == head) {
                head = head.next;
                if (head != null) head.prev = null;
                System.out.println("Deleted node " + key);
                return;
            }

            // If node to be deleted is in the middle or tail
            if (curr.next != null) {
                // middle
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
            } else {
                // tail
                curr.prev.next = null;
            }

            System.out.println("Deleted node " + key);
        }

        void display() {
            if (head == null) {
                System.out.println("Forward: (empty)");
                return;
            }
            Node curr = head;
            System.out.print("Forward: ");
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoubleLinkedList dll = new DoubleLinkedList();
        int choice;

        System.out.println("=== Doubly Linked List Menu ===");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert AFTER a value");
            System.out.println("4. Insert BEFORE a value");
            System.out.println("5. Delete a node (by value)");
            System.out.println("6. Search for a node (by value)");
            System.out.println("7. Display list");
            System.out.println("8. Exit");
            System.out.print("Enter choice (1-8): ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a number (1-8): ");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value to insert at beginning: ");
                    int v = sc.nextInt();
                    dll.insertAtBeginning(v);
                    System.out.println(v + " inserted at beginning.");
                }
                case 2 -> {
                    System.out.print("Enter value to insert at end: ");
                    int v = sc.nextInt();
                    dll.insertAtEnd(v);
                    System.out.println(v + " inserted at end.");
                }
                case 3 -> {
                    System.out.print("Enter target value (after which to insert): ");
                    int target = sc.nextInt();
                    System.out.print("Enter value to insert: ");
                    int v = sc.nextInt();
                    dll.insertAfter(target, v);
                }
                case 4 -> {
                    System.out.print("Enter target value (before which to insert): ");
                    int target = sc.nextInt();
                    System.out.print("Enter value to insert: ");
                    int v = sc.nextInt();
                    dll.insertBefore(target, v);
                }
                case 5 -> {
                    System.out.print("Enter value to delete: ");
                    int key = sc.nextInt();
                    dll.deleteNode(key);
                }
                case 6 -> {
                    System.out.print("Enter value to search: ");
                    int key = sc.nextInt();
                    dll.search(key);
                }
                case 7 -> dll.display();
                case 8 -> System.out.println("Exiting. Goodbye!");
                default -> System.out.println("Invalid choice. Enter 1..8.");
            }

        } while (choice != 8);

        sc.close();
    }
}

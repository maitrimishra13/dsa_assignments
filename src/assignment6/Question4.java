package assignment6;

import java.util.Scanner;

public class Question4 {
    public static class Node {
        char data;
        Node prev;
        Node next;

        Node(char d) {
            data = d;
            prev = null;
            next = null;
        }
    }

    public static Node createFromString(String s) {
        if (s == null || s.length() == 0) return null;
        Node head = new Node(s.charAt(0));
        Node tail = head;
        for (int i = 1; i < s.length(); i++) {
            Node n = new Node(s.charAt(i));
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        return head;
    }

    public static void printList(Node head) {
        Node cur = head;
        System.out.print("List: ");
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // find tail
        Node tail = head;
        while (tail.next != null) tail = tail.next;

        Node left = head;
        Node right = tail;

        // Compare moving inward
        // Stop when pointers meet or cross
        while (left != right && left.prev != right) {
            if (left.data != right.data) return false;
            left = left.next;
            right = right.prev;
        }
        return true;
    }

    public static void main(String[] args) {
        //palindrome
        String demo1 = "radar";
        Node head1 = createFromString(demo1);
        printList(head1);
        System.out.println("Is \"" + demo1 + "\" a palindrome? " + (isPalindrome(head1) ? "Yes" : "No"));
        System.out.println();

        //non-palindrome
        String demo2 = "hello";
        Node head2 = createFromString(demo2);
        printList(head2);
        System.out.println("Is \"" + demo2 + "\" a palindrome? " + (isPalindrome(head2) ? "Yes" : "No"));
        System.out.println();

        // input type
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to test (characters considered as-is): ");
        String input = sc.nextLine();
        Node headInput = createFromString(input);
        printList(headInput);
        boolean res = isPalindrome(headInput);
        System.out.println("Result: The list formed from \"" + input + "\" is " + (res ? "a palindrome." : "not a palindrome."));
        sc.close();
    }
}

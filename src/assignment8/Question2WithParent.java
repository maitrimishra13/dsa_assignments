package assignment8;

import java.util.Scanner;

public class Question2WithParent {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node parent;

        Node(int value){
            this.data = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    public static Node inorderPredecessorWithParent(Node key){
        if (key == null) return null;

        if (key.left != null) {
            Node temp = key.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            return temp;
        }

        Node parent = key.parent;
        Node current = key;
        while(parent != null && current == parent.left){
            current = parent;
            parent = parent.parent;
        }

        return parent;
    }

    public static Node inorderSuccessorWithParent(Node key){
        if (key == null) return null;

        if (key.right != null) {
            Node temp = key.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }

        Node parent = key.parent;
        Node current = key;
        while(parent != null && current == parent.left){
            current = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public static void main(String[] args) {

        //Sample tree
        /*
                60
              /     \
            41       74
          /   \     /   \
        16    53   65    70
       /     / \   / \     \
     25    46  55 63  62    64
           /
         42
        */

        Node root = new Node(60);

        // Left subtree
        root.left = new Node(41);
        root.left.left = new Node(16);
        root.left.left.left = new Node(25);

        root.left.right = new Node(53);
        root.left.right.left = new Node(46);
        root.left.right.left.left = new Node(42);
        root.left.right.right = new Node(55);

        // Right subtree
        root.right = new Node(74);

        root.right.left = new Node(65);
        root.right.left.left = new Node(63);
        root.right.left.left.right = new Node(62);

        root.right.right = new Node(70);
        root.right.right.right = new Node(64);


        Scanner sc = new Scanner(System.in);
        System.out.print("Enter element value: ");
        int value = sc.nextInt();
        Node element = new Node(value);

        System.out.println("The predecessor of " + element.data + " is "+ inorderPredecessorWithParent(element));
        System.out.println("The successor of " + element.data + " is "+ inorderSuccessorWithParent(element));

    }
}




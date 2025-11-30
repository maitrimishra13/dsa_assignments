package assignment8;

import java.util.Scanner;

public class Question2 {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int value){
            this.data = value;
            this.left = null;
            this.right = null;
        }
    }

    public static class BST{
        Node root = null;

        public Node searchRecursive(Node root, int key) {
            if (root == null || root.data == key)
                return root;

            if (key < root.data)
                return searchRecursive(root.left, key);
            else
                return searchRecursive(root.right, key);
        }

        public Node searchIterative(Node root, int key) {
            Node current = root;

            while (current != null) {
                if (current.data == key)
                    return current;

                if (key < current.data)
                    current = current.left;
                else
                    current = current.right;
            }

            return null;
        }

        public Node minimum(Node root){
            while(root.left != null){
                root = root.left;
            }
            return root;
        }

        public Node maximum(Node root){
            while(root.right != null){
                root = root.right;
            }
            return root;
        }

        public Node inorderPredecessorWithoutParent(Node root, Node key) {
            Node predecessor = null;

            if (key.left != null) {
                return minimum(key.left);
            }

            Node current = root;
            while (current != null) {
                if (key.data > current.data) {
                    predecessor = current;
                    current = current.right;
                } else if (key.data < current.data) {
                    current = current.left;
                } else {
                    break;
                }
            }

            return predecessor;
        }

        public Node inorderSuccessorWithoutParent(Node root, Node key) {
            Node successor = null;

            if (key.right != null) {
                return maximum(key.right);
            }

            Node current = root;
            while (current != null) {
                if (key.data < current.data) {
                    successor = current;
                    current = current.left;
                } else if (key.data > current.data) {
                    current = current.right;
                } else {
                    break;
                }
            }

            return successor;
        }
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

        BST tree = new BST();

        tree.root = new Node(60);

        // Left subtree
        tree.root.left = new Node(41);
        tree.root.left.left = new Node(16);
        tree.root.left.left.left = new Node(25);

        tree.root.left.right = new Node(53);
        tree.root.left.right.left = new Node(46);
        tree.root.left.right.left.left = new Node(42);
        tree.root.left.right.right = new Node(55);

        // Right subtree
        tree.root.right = new Node(74);

        tree.root.right.left = new Node(65);
        tree.root.right.left.left = new Node(63);
        tree.root.right.left.left.right = new Node(62);

        tree.root.right.right = new Node(70);
        tree.root.right.right.right = new Node(64);


        Scanner sc = new Scanner(System.in);
        System.out.print("Enter key: ");
        int key = sc.nextInt();

        System.out.println(tree.searchRecursive(tree.root, key));
        System.out.println(tree.searchIterative(tree.root, key));

        System.out.println("The minimum value in the tree is " + tree.minimum(tree.root).data);
        System.out.println("The maximum value in the tree is " + tree.maximum(tree.root).data);

        System.out.print("Enter element value: ");
        int value = sc.nextInt();
        Node element = new Node(value);
        System.out.println("The predecessor of " + element.data + " is "+ tree.inorderPredecessorWithoutParent(tree.root, element));
        System.out.println("The successor of " + element.data + " is "+ tree.inorderSuccessorWithoutParent(tree.root, element));

    }
}




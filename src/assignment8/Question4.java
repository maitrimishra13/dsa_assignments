package assignment8;

public class Question4 {
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

    public static class BST {
        Node root = null;

        public Node insert(Node root, int value) {
            if (root == null) {
                return new Node(value);
            }

            if (value < root.data) {
                root.left = insert(root.left, value);
            } else if (value > root.data) {
                root.right = insert(root.right, value);
            } else {
                // value == root.data → DUPLICATE
                System.out.println("Duplicate value " + value + " ignored.");
                return root;
            }

            return root;
        }

        public boolean isBST(Node root) {
            return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private boolean isBSTUtil(Node node, int min, int max) {
            if (node == null)
                return true;   // empty tree is BST

            // Check if this node is within allowed range
            if (node.data <= min || node.data >= max)
                return false;

            // Left child range becomes: (min, node.data)
            // Right child range becomes: (node.data, max)
            return isBSTUtil(node.left, min, node.data) &&
                    isBSTUtil(node.right, node.data, max);
        }

    }

    public static void main(String[] args) {
        BST tree = new BST();

        // inserting values
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 70);  // duplicate
        tree.root = tree.insert(tree.root, 30);  // duplicate
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);

        boolean result = tree.isBST(tree.root);
        System.out.println("Is BST? " + result);
    }
}

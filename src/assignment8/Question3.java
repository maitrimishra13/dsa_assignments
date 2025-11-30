package assignment8;

public class Question3 {
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

        public void inorder(Node root) {
            if (root == null) return;

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public Node findMin(Node node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        public Node deleteNode(Node root, int key) {
            if (root == null) return null;

            // STEP 1: Search for the key
            if (key < root.data) {
                root.left = deleteNode(root.left, key);
            } else if (key > root.data) {
                root.right = deleteNode(root.right, key);
            } else {
                // Node found → handle 3 deletion cases
                // CASE 1: No child (leaf node)
                if (root.left == null && root.right == null) {
                    return null;
                }

                // CASE 2: One child
                if (root.left == null) return root.right;   // only right child
                else if (root.right == null) return root.left; //only left child

                // CASE 3: Two children
                // Replace value with inorder successor (minimum in right subtree)
                Node successor = findMin(root.right);
                root.data = successor.data;

                // Delete the successor node
                root.right = deleteNode(root.right, successor.data);
            }
            return root;
        }

        public int maxDepth(Node root) {
            if (root == null)
                return 0;

            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);

            return Math.max(leftDepth, rightDepth) + 1;
        }

        public int minDepth(Node root) {
            if (root == null)
                return 0;

            // If left subtree is null → depth must come from right
            if (root.left == null)
                return minDepth(root.right) + 1;

            // If right subtree is null → depth must come from left
            if (root.right == null)
                return minDepth(root.left) + 1;

            // Both children exist → take the minimum
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
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

        System.out.print("\nInorder traversal of final tree: ");
        tree.inorder(tree.root);

        tree.root = tree.deleteNode(tree.root, 40);
        System.out.print("\nInorder traversal of final tree: ");
        tree.inorder(tree.root);

        System.out.println("Max Depth of the tree: " + tree.maxDepth(tree.root));
        System.out.println("Min Depth of the tree: " + tree.minDepth(tree.root));
    }
}

package assignment8;

public class QuestionFromSlides {
    /*
    Question
        15, 18, 6, 7, 17, 3, 4, 13, 9, 20, 2
            • Generate BST for the given sequence.
            • Visit the generated BST using inorder, preorder, and postorder traversals.
            • Delete 4, 7, and 15 in sequence showing BST after every deletion.
     */
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int value){
            this.data = value;
            this.right = null;
            this.left = null;
        }
    }
    public static class BST{
        Node root = null;

        public void preorder(Node root){
            if (root == null) return;

            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public void inorder (Node root){
            if (root == null) return;

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public void postorder(Node root){
            if (root == null) return;

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public Node insert(Node root, int value){
            if (root == null){
                return new Node(value);
            }

            if (value < root.data){
                root.left = insert(root.left, value);
            } else if (value > root.data){
                root.right = insert(root.right, value);
            } else {
                System.out.println("Duplicated value " + value + " ignored!");
                return root;
            }

            return root;
        }

        public Node findMin(Node node){
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        public Node deleteNode(Node root, int key) {
            if (root == null) {
                return null;
            }
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
    }

    public static void main(String[] args) {
        BST tree = new BST();

        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 18);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 17);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 13);
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 2);

        System.out.println("Preorder Traversal of the tree:");
        tree.preorder(tree.root);
        System.out.println();

        System.out.println("Inorder Traversal of the tree:");
        tree.inorder(tree.root);
        System.out.println();

        System.out.println("Postorder Traversal of the tree:");
        tree.postorder(tree.root);
        System.out.println();

        tree.root = tree.deleteNode(tree.root, 4);
        System.out.println("Inorder Traversal of the tree after deletion of key 4:");
        tree.inorder(tree.root);
        System.out.println();

        tree.root = tree.deleteNode(tree.root, 7);
        System.out.println("Inorder Traversal of the tree after deletion of key 7:");
        tree.inorder(tree.root);
        System.out.println();

        tree.root = tree.deleteNode(tree.root, 15);
        System.out.println("Inorder Traversal of the tree after deletion of key 15:");
        tree.inorder(tree.root);
        System.out.println();
    }
}

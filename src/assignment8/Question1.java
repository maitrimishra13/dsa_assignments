package assignment8;

public class Question1 {
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

    public static void preorder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postorder(Node root){
        if (root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        // Creating a sample tree manually
    /*
                 41
                /   \
               12    53
                \    / \
                 25 46  55
                    /
                   42
    */

        Node root = new Node(41);
        root.left = new Node(16);
        root.right = new Node(53);
        root.left.right = new Node(25);
        root.right.left = new Node(46);
        root.right.right = new Node(55);
        root.right.left.left = new Node(42);

        System.out.println("Pre-order Traversal:");
        preorder(root);

        System.out.println("\nIn-order Traversal:");
        inorder(root);

        System.out.println("\nPost-order Traversal:");
        postorder(root);
    }
}

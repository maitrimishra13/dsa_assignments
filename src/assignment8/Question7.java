package assignment8;

public class Question7 {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static Node buildFromInPost(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
        return buildInPost(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static Node buildInPost(int[] in, int inS, int inE, int[] post, int postS, int postE) {
        if (inS > inE || postS > postE) return null;
        int rootVal = post[postE];
        Node root = new Node(rootVal);

        // find rootVal in inorder (linear)
        int idx = inS;
        while (idx <= inE && in[idx] != rootVal) idx++;
        int leftSize = idx - inS;

        root.left = buildInPost(in, inS, idx - 1, post, postS, postS + leftSize - 1);
        root.right = buildInPost(in, idx + 1, inE, post, postS + leftSize, postE - 1);
        return root;
    }

    public static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void printPostorder(Node root) {
        if (root == null) return;

        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        System.out.println("Build from Inorder + Postorder");
        int[] inorder  = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        Node rootFromInPost = buildFromInPost(inorder, postorder);

        System.out.print("Inorder of constructed tree: ");
        printInorder(rootFromInPost); // should equal inorder
        System.out.println();

        System.out.print("Postorder of constructed tree: ");
        printPostorder(rootFromInPost); // should equal postorder
        System.out.println();
    }
}

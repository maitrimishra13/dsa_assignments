package assignment8;

public class Question6 {
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

    public static Node buildFromPreIn(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        return buildPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static Node buildPreIn(int[] pre, int preS, int preE, int[] in, int inS, int inE) {
        if (preS > preE || inS > inE) return null;
        int rootVal = pre[preS];
        Node root = new Node(rootVal);

        // find rootVal in inorder (linear search to avoid extra DS)
        int idx = inS;
        while (idx <= inE && in[idx] != rootVal) idx++;
        int leftSize = idx - inS;

        root.left = buildPreIn(pre, preS + 1, preS + leftSize, in, inS, idx - 1);
        root.right = buildPreIn(pre, preS + leftSize + 1, preE, in, idx + 1, inE);
        return root;
    }

    public static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void printPreorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {
        System.out.println("Build from Preorder + Inorder: ");
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder  = {4, 2, 5, 1, 6, 3, 7};

        Node rootFromPreIn = buildFromPreIn(preorder, inorder);

        System.out.print("Inorder of constructed tree: ");
        printInorder(rootFromPreIn); // should match 'inorder' array
        System.out.println();

        System.out.print("Preorder of constructed tree: ");
        printPreorder(rootFromPreIn); // should match 'preorder' array
        System.out.println();
    }
}

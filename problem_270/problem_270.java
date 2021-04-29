import java.util.ArrayList;

class BinaryTree {
    public int data;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree() {}
    public BinaryTree(int data) { this.data = data; }
    public BinaryTree(int data, BinaryTree left, BinaryTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class Solution{
    public static BinaryTree invertTree(BinaryTree root){
        //ここから書きましょう
        if (root == null) return root;

        if (root.left != null || root.right != null){
            BinaryTree temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}


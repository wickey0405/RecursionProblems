package problem_212;

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
    public static boolean validateBSTHelper(BinaryTree root, BinaryTree parent, BinaryTree bt){
        if (parent.left == bt && ((parent.data < bt.data) || (bt.right != null && bt.right.data > root.data))) return false;
        if (parent.right == bt && ((parent.data > bt.data) || (bt.left != null && bt.left.data < root.data))) return false;

        if (bt.left != null) validateBSTHelper(root, bt, bt.left);
        if (bt.right != null) validateBSTHelper(root, bt, bt.right);

        return true;
    }
    public static boolean validateBST(BinaryTree root){
        //ここから書きましょう
        if (root == null) return true;
        boolean left = root.left != null ? validateBSTHelper(root, root, root.left) : true;
        boolean right = root.right != null ? validateBSTHelper(root, root, root.right) : true;
        return left && right;
    }
}


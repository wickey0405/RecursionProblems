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
    public static boolean treeWithTheSameValue(BinaryTree root){
        //ここから書きましょう
        return treeWithTheSameValueHelper(root, root.data);
    }
    public static boolean treeWithTheSameValueHelper(BinaryTree bt, int value){
        if (bt == null) return true;
        if (bt.data != value) return false;

        return treeWithTheSameValueHelper(bt.left, value) && treeWithTheSameValueHelper(bt.right, value);
    }
}


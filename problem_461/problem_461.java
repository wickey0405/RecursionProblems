package problem_461;

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
    public static BinaryTree maximumNode(BinaryTree root){
        //ここから書きましょう
        if (root.right == null) return root;
        return maximumNode(root.right);
    }
}
// VScodeではエラーがでます

package problem_460;

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
    public static BinaryTree minimumNode(BinaryTree root){
        //ここから書きましょう
        if(root.left == null) return root;
        return minimumNode(root.left);
    }
}
// VScodeではエラーがでます


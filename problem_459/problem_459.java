package problem_459;

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
    public static boolean exists(BinaryTree root,int key){
        //ここから書きましょう
        if (root == null) return false;
        if (root.data == key) return true;

        if(root.data > key) return exists(root.left, key);
        else return exists(root.right, key);
    }
}
// VScodeではエラーがでます


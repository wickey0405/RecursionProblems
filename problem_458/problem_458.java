package problem_458;

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
    public static BinaryTree bstSearch(BinaryTree root,int key){
        //ここから書きましょう
        if (root == null) return null;
        if (root.data == key) return root;

        if (root.data > key) return bstSearch(root.left, key);
        else return bstSearch(root.right, key);
    }
}

// VSCode上ではエラーがでます。

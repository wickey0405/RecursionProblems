package problem_462;

import java.util.ArrayList;

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
    public static BinaryTree minimumNode(BinaryTree bt){
        if (bt.left == null) return bt;
        return minimumNode(bt.left);
    }
    public static BinaryTree findNode(BinaryTree bt,int key){
        if (bt == null) return null;
        if (bt.data == key) return bt;

        if (bt.data > key) return findNode(bt.left, key);
        else return findNode(bt.right, key);
    }
    public static BinaryTree successor(BinaryTree root,int key){
        //ここから書きましょう
        BinaryTree target = findNode(root, key);

        if (target == null) return null;
        if (target.right != null) return minimumNode(target.right);

        BinaryTree successor = null;
        BinaryTree iterator = root;
        while(iterator != null){
            if (target.data == iterator.data) return successor;
            if (target.data < iterator.data && (successor == null || successor.data > iterator.data)) successor = iterator;

            if (target.data < iterator.data) iterator = iterator.left;
            else iterator = iterator.right;
        }
        return successor;
    }
}

// VScodeではエラーになります。

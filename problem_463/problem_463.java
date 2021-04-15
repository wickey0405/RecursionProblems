package problem_463;

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
    public static BinaryTree findNode(BinaryTree bt, int key){
        if (bt == null) return null;
        if (bt.data == key) return bt;

        if (bt.data > key) return findNode(bt.left, key);
        else return findNode(bt.right, key);
    }
    public static BinaryTree maximumNode(BinaryTree bt){
        while (bt.right != null) return maximumNode(bt.right);
        return bt;
    }
    public static BinaryTree predecessor(BinaryTree root,int key){
        //ここから書きましょう
        BinaryTree target = findNode(root, key);
        
        if (target == null) return null;
        if (target.left != null) return maximumNode(target.left);

        BinaryTree predecessor = null;
        BinaryTree iterator = root;

        while(iterator != null){
            if (iterator.data == target.data) return predecessor;

            if (iterator.data < target.data &&(predecessor==null || iterator.data > predecessor.data)) predecessor = iterator;

            if (iterator.data > target.data) iterator = iterator.left;
            else iterator = iterator.right;
        }

        return predecessor;
    }
}
// VScodeではエラーになります。

package problem_481;

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
    public static BinaryTree findParent(BinaryTree bt, int key){
        BinaryTree iterator = bt;
        BinaryTree parent = null;
        while (iterator.data != key){
            parent = iterator;
            iterator = iterator.data > key ? iterator.left: iterator.right;
        }    
        return parent;
    }
    public static BinaryTree minimumNode(BinaryTree bt){
        if (bt != null && bt.left == null) return bt;
        return minimumNode(bt.left);
    }
    public static BinaryTree findSuccessor(BinaryTree bt, int key){
        BinaryTree node = findNode(bt, key);
        if (node == null) return bt;
        if (node.right != null) return minimumNode(node.right);

        BinaryTree successor = null;
        BinaryTree iterator = bt;
        
        while(iterator != null){
            if (key == iterator.data) return successor;

            if (iterator.data > key && (successor == null || iterator.data < successor.data)) successor = iterator;

            if (iterator.data > key) iterator = iterator.left;
            else iterator = iterator.right;
        }
        return successor;
    }
    public static BinaryTree transplant(BinaryTree root, BinaryTree nodeParent, BinaryTree node, BinaryTree target){
        if (nodeParent == null) root = target;
        else if (nodeParent.right == node) nodeParent.right = target;
        else nodeParent.left = target;
        return root;
    }
    public static BinaryTree bstDelete(BinaryTree root,int key){
        //ここから書きましょう
        BinaryTree node = findNode(root, key);

        if (root == null || node == null) return root;

        BinaryTree nodeParent = findParent(root, node.data);

        if (node.left == null) root = transplant(root, nodeParent, node, node.right);
        else if (node.right == null) root = transplant(root, nodeParent, node, node.left);
        else {
            BinaryTree successor = findSuccessor(root, key);
            BinaryTree successorParent = findParent(root, successor.data);

            if (successor != node.right){
                root = transplant(root, successorParent, successor, successor.right);
                successor.right = node.right;
            }
            root = transplant(root, nodeParent, node, successor);
            successor.left = node.left;
        }        
        return root;
    }
}


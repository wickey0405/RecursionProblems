package problem_267;

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
    public static boolean isLeaf(BinaryTree bt){
        if (bt == null) return false;
        if (bt.left == null && bt.right == null) return true;
        return false;
    }
    public static int searchMaxDepth(BinaryTree bt, int depth , int maxDepth){
        if (bt == null) return maxDepth;

        if (bt.left != null) maxDepth = searchMaxDepth(bt.left, depth+1, maxDepth < depth+1 ? depth+1 : maxDepth);
        if (bt.right != null) maxDepth = searchMaxDepth(bt.right, depth+1, maxDepth < depth+1 ? depth+1 : maxDepth);
        return maxDepth;
    }
    public static int deepestLeavesHelper(BinaryTree bt, int depth, int maxDepth, int total){
        if (bt == null) return total;
        
        System.out.println("maxDepth: " + maxDepth + ", bt: " + bt.data + ", depth: " + depth + ", total: " + total);
        if (bt.left != null) total = deepestLeavesHelper(bt.left, depth+1, maxDepth, depth+1 == maxDepth ? total+bt.left.data : total);
        if (bt.right != null) total = deepestLeavesHelper(bt.right, depth+1, maxDepth, depth+1 == maxDepth ? total+bt.right.data : total);
        return total;
    }
    public static int deepestLeaves(BinaryTree root){
        //ここから書きましょう
        return deepestLeavesHelper(root, 1, searchMaxDepth(root, 1, 1), 0);
    }
}


package problem_469;

import java.util.Arrays;

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
    public static int[] dynamicListToFixList(ArrayList<Integer> darr){
        int[] ans = new int[darr.size()];
        for (int i = 0; i < darr.size(); i++){
            ans[i] = darr.get(i);
        }
        return ans;
    }
    public static int[] preorderTraversalHelper(BinaryTree bt, ArrayList<Integer> darr){
        if (bt != null){
            darr.add(bt.data);
            preorderTraversalHelper(bt.left, darr);
            preorderTraversalHelper(bt.right, darr);
        }
        return dynamicListToFixList(darr);
    }

    public static int[] preorderTraversal(BinaryTree root){
        //ここから書きましょう
        ArrayList<Integer> darr = new ArrayList<>();
        return preorderTraversalHelper(root, darr);
    }
}
// VScodeではエラーになります。

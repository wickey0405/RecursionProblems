package problem_470;

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
    public static int[] dynamicListToFixLiet(ArrayList<Integer> darr){
        int[] ans = new int[darr.size()];
        for(int i = 0; i < darr.size(); i++){
            ans[i] = darr.get(i);
        }
        return ans;
    }
    public static int[] inorderTraversalHelper(BinaryTree bt, ArrayList<Integer> darr){
        if(bt!=null){
            inorderTraversalHelper(bt.left, darr);
            darr.add(bt.data);
            inorderTraversalHelper(bt.right, darr);
        }
        return dynamicListToFixLiet(darr);
    }
    public static int[] inorderTraversal(BinaryTree root){
        //ここから書きましょう
        ArrayList<Integer> darr = new ArrayList<>();
        return inorderTraversalHelper(root, darr);
    }
}
// VScodeではエラーになります。

package problem_471;

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
    public static int[] dynamicListToFixedList(ArrayList<Integer> darr){
        int[] ans = new int[darr.size()];
        for(int i = 0; i < darr.size(); i++){
            ans[i] = darr.get(i);
        }
        return ans;
    }
    public static int[] postorderTraversalHelper(BinaryTree bt, ArrayList<Integer> darr){
        if(bt != null){
            postorderTraversalHelper(bt.left,darr);
            postorderTraversalHelper(bt.right,darr);
            darr.add(bt.data);
        }
        return dynamicListToFixedList(darr);
    }
    public static int[] postorderTraversal(BinaryTree root){
        //ここから書きましょう
        ArrayList<Integer> darr = new ArrayList<>();
        return postorderTraversalHelper(root, darr);
    }
}
// VScodeではエラーになります。

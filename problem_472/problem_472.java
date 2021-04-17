package problem_472;

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
    public static int[] reverseInorderTraversalHelper(BinaryTree bt, ArrayList<Integer> darr){
        if(bt != null){
            reverseInorderTraversalHelper(bt.right, darr);
            darr.add(bt.data);
            reverseInorderTraversalHelper(bt.left, darr);
        }
        return dynamicListToFixedList(darr);
    }
    public static int[] reverseInorderTraversal(BinaryTree root){
        //ここから書きましょう
        ArrayList<Integer> darr = new ArrayList<>();
        return reverseInorderTraversalHelper(root, darr);
    }
}
// VScodeではエラーになります。

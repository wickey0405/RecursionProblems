package problem_473;

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
    public static int maximumDepthHelper(BinaryTree bt, int depth, ArrayList<Integer> dlist){
        System.out.println("bt: " + (bt != null ? bt.data : null) + " depth: " + depth + " dlist: " + dlist);
        if(bt != null){
            if(dlist.size()==0 || dlist.get(dlist.size()-1) < depth) dlist.add(depth);
            maximumDepthHelper(bt.left, depth+1, dlist);
            maximumDepthHelper(bt.right, depth+1, dlist);
        } else depth = 1;
        return dlist.get(dlist.size()-1);
    }
    public static int maximumDepth(BinaryTree root){
        //ここから書きましょう
        ArrayList<Integer> dlist = new ArrayList<>();
        return maximumDepthHelper(root, 1, dlist);
    }
}
// VScodeではエラーになります。

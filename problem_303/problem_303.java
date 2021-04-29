import java.util.Arrays;

import java.util.ArrayList;
import java.util.HashMap;

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
    public static int[] getAvarage(BinaryTree root){
        //ここから書きましょう
        HashMap<Integer, Integer> total = sumHashMap(root, new HashMap<Integer, Integer>(), 1);
        HashMap<Integer, Integer> amount = amountHashMap(root, new HashMap<Integer, Integer>(), 1);
        int[] ans = new int[total.size()];
        for (int i = 1; i <= total.size(); i++){
            ans[i-1] = total.get(i)/amount.get(i);
        }
        return ans;
    }
    public static HashMap<Integer, Integer> sumHashMap(BinaryTree bt, HashMap<Integer, Integer> hashmap, int depth){
        if (bt != null){
            if (hashmap.get(depth)==null) hashmap.put(depth, bt.data);
            else hashmap.replace(depth, hashmap.get(depth)+bt.data);
        }

        if(bt.left != null) sumHashMap(bt.left, hashmap, depth+1);
        if(bt.right != null) sumHashMap(bt.right, hashmap, depth+1);

        return hashmap;
    }
    public static HashMap<Integer, Integer> amountHashMap(BinaryTree bt, HashMap<Integer, Integer> hashmap, int depth){
        if (bt != null){
            if (hashmap.get(depth)==null) hashmap.put(depth, 1);
            else hashmap.replace(depth, hashmap.get(depth)+1);
        }

        if(bt.left != null) amountHashMap(bt.left, hashmap, depth+1);
        if(bt.right != null) amountHashMap(bt.right, hashmap, depth+1);

        return hashmap;
    }
}


import java.util.Arrays;

import java.util.ArrayList;
import java.util.stream.*;

class BinaryTree {
    public Integer data;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree() {}
    public BinaryTree(Integer data) { this.data = data; }
    public BinaryTree(Integer data, BinaryTree left, BinaryTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class Solution{
    public static ArrayList<Integer> inOrderWalk(BinaryTree bt, ArrayList<Integer> darr){
        if (bt != null){
            inOrderWalk(bt.left, darr);
            darr.add(bt.data);
            inOrderWalk(bt.right, darr);
        }
        return darr;
    }   
    public static int[] allElementsSorted(BinaryTree root1,BinaryTree root2){
        //ここから書きましょう 
        ArrayList<Integer> darr1 = inOrderWalk(root1, new ArrayList<Integer>());
        ArrayList<Integer> darr2 = inOrderWalk(root2, new ArrayList<Integer>());
        ArrayList<Integer> ans = new ArrayList<>();

        darr1.add(Integer.MAX_VALUE);
        darr2.add(Integer.MAX_VALUE);

        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < (darr1.size()+darr2.size()-2); i++){
            ans.add(darr1.get(i1) < darr2.get(i2) ? darr1.get(i1) : darr2.get(i2));
            if (darr1.get(i1) < darr2.get(i2)) i1++;
            else i2++;
        }
     
        return ans.stream().mapToInt(x->x).toArray();
    }
}


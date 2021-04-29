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

    public static int sumOfGrandChildData(BinaryTree BT, int generation, int total){
        if (BT == null || generation < 0) return total;
        if (generation > 0){
            total = sumOfGrandChildData(BT.left, generation-1, total);
            total = sumOfGrandChildData(BT.right, generation-1, total);
        }
        if (generation == 0){
            total += BT.data;
        }
        return total;        
    }
    public static int totalEvenGrandparentHelper(BinaryTree BT, int total){
        if (BT != null) {
            total = totalEvenGrandparentHelper(BT.left, total);
            if(BT.data % 2 == 0) total += sumOfGrandChildData(BT, 2 , 0);
            total = totalEvenGrandparentHelper(BT.right, total);
        }
        return total;
    }
    public static int totalEvenGrandparent(BinaryTree root){
        //ここから書きましょう
        return totalEvenGrandparentHelper(root, 0);
    }
}


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
        else return false;
    }
    public static int minDepthHelper(BinaryTree bt, int currDepth, int tempMinDepth){
        if (bt == null) return tempMinDepth;
        tempMinDepth = minDepthHelper(bt.left, currDepth+1, (isLeaf(bt) && tempMinDepth > currDepth ? currDepth : tempMinDepth));
        tempMinDepth = minDepthHelper(bt.right, currDepth+1, (isLeaf(bt) && tempMinDepth > currDepth ? currDepth : tempMinDepth));
        return tempMinDepth;
    }
    public static int minDepth(BinaryTree root){
        //ここから書きましょう
        return minDepthHelper(root, 1, Integer.MAX_VALUE);
    }
}


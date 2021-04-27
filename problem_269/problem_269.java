package problem_269;

import java.util.ArrayList;

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
    public static BinaryTree mergeBSTHelper(BinaryTree newBT , BinaryTree BT1, BinaryTree BT2){
        if (BT1 != null && BT2 != null) newBT = new BinaryTree(BT1.data + BT2.data);
        else if (BT1 == null && BT2 != null){
            newBT = new BinaryTree(BT2.data);
            BT1 = new BinaryTree(null);// ここにdataはnullだけどBinaryTreeとしてはnullではないものを仕込んでおくことで下部（A）の述語内のBT.leftやBT.rightがエラーにならずに済む
        }
        else if (BT1 != null && BT2 == null){
            newBT = new BinaryTree(BT1.data);
            BT2 = new BinaryTree(null);// ここにdataはnullだけどBinaryTreeとしてはnullではないものを仕込んでおくことで下部（A）の述語内のBT.leftやBT.rightがエラーにならずに済む
        }
        else return null;

        BinaryTree left = null;
        if (BT1.left != null || BT2.left != null) left = mergeBSTHelper(newBT.left, BT1.left, BT2.left);//(A)
        BinaryTree right = null;
        if (BT1.right != null || BT2.right != null) right = mergeBSTHelper(newBT.right, BT1.right, BT2.right);//(A)

        return new BinaryTree(newBT.data, left, right);
    }
    public static BinaryTree mergeBST(BinaryTree root1,BinaryTree root2){
        //ここから書きましょう
        BinaryTree newBT = new BinaryTree(null);
        return mergeBSTHelper(newBT, root1, root2);
    }
}


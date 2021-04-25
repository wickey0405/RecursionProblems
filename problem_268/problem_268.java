package problem_268;

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
    // 木を順にたどっていき、値が異なる場合はjudgeNumに1を加えていく。judgeNumが0以上はfalseとする。
    public static int inOrderWalk(BinaryTree BT1, BinaryTree BT2, int judgeNum){
        if (BT1 != null && BT2 != null){
            judgeNum = inOrderWalk(BT1.left, BT2.left, judgeNum);
            if (BT1.data != BT2.data) judgeNum = judgeNum+1;
            judgeNum = inOrderWalk(BT1.right, BT2.right, judgeNum);
        }
        else if(BT1 == null && BT2 == null) {}//何もしない
        else judgeNum = judgeNum+1;// 片方だけがnullの場合は1加える
        return judgeNum;
    }
    public static boolean isSameTree(BinaryTree root1,BinaryTree root2){
        //ここから書きましょう        
        return inOrderWalk(root1, root2, 0) > 0 ? false : true;
    }
}


package problem_462;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;

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
    public static BinaryTree walkDeque(BinaryTree bt, Deque<Integer> deque){
        if (deque.peekFirst() == null) return null;
        while(deque.peekFirst()!=null){
            if (deque.peekFirst()==-1) bt = bt.left;
            else bt = bt.right;
            deque.pollFirst();
        }
        return bt;
    }
    public static BinaryTree routeFromRootToKey(BinaryTree root, BinaryTree bt, BinaryTree parent, int key, Deque<Integer> deque){
        
        if (bt == null) return null;
        if (bt.data == key ){
            if (bt == root){
                if (bt.right == null) return null;
                else {
                    bt = bt.right;
                    while (bt.left != null) bt = bt.left;
                    return bt;
                }
            } 

            if (bt.right != null){
                bt = bt.right;
                while(bt.left != null){
                    bt = bt.left;
                }
                return bt;
            } 
            else if (parent.right == bt){
                System.out.println("First Deque Size: " + deque.size());
                while(deque.peekLast() != null && deque.peekLast() == 1) deque.pollLast();
                deque.pollLast();
                System.out.println("this route!" + " Deque Size: " + deque.size());
                return walkDeque(root, deque);
            } else {
                
                return parent;
            }
        }        

        if (bt.data > key){
            deque.addLast(-1);
            return routeFromRootToKey(root ,bt.left, bt, key, deque);
        } else {
            deque.addLast(1);
            return routeFromRootToKey(root, bt.right, bt, key, deque);
        }
    }
    public static BinaryTree successor(BinaryTree root,int key){
        //ここから書きましょう
        Deque<Integer> deque = new ArrayDeque<>();
        return routeFromRootToKey(root, root, null, key, deque);
    }
}
// VScodeではエラーになります。

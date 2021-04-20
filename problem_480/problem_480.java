package problem_480;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Queue;

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
    public static Integer[] convertDynamicToFix(ArrayList<Integer> darray){
        Integer[] arr = new Integer[darray.size()];
        for (int i = 0; i < darray.size(); i++) arr[i] = darray.get(i);
        return arr;
    }
    public static ArrayList<Integer> levelOrderTraversalHelper(Queue<BinaryTree> queue, ArrayList<Integer> darr){
        if (queue.isEmpty()) return darr;
        BinaryTree nullBT = new BinaryTree(null);//BinaryTreeでnullを表現
        if (queue.peek().data != null) {
            if(queue.peek().left != null) queue.offer(queue.peek().left);
            else queue.offer(nullBT);

            if(queue.peek().right != null) queue.offer(queue.peek().right);
            else queue.offer(nullBT);
        }        
        darr.add(queue.poll().data);//queueの先頭をdarrに格納していく
       
        return levelOrderTraversalHelper(queue, darr);
    }
    public static Integer[] levelOrderTraversal(BinaryTree root){
        //ここから書きましょう
        Queue<BinaryTree> queue = new ArrayDeque<>();
        ArrayList<Integer> darr = new ArrayList<>();
        queue.offer(root);

        ArrayList<Integer> dans = levelOrderTraversalHelper(queue,darr);
        while(dans.get(dans.size()-1) == null) dans.remove(dans.size()-1);//不要なnullを削除
        return convertDynamicToFix(dans);
    }
}

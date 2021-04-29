import java.util.ArrayList;
import java.util.ArrayDeque;

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
    public static boolean haveOnlyRight(BinaryTree bt){
        if (bt == null) return false;
        if (bt.left == null && bt.right != null) return true;
        else return false;
    }
    public static boolean haveOnlyLeft(BinaryTree bt){
        if (bt == null) return false;
        if (bt.left != null && bt.right == null) return true;
        else return false;
    }
    // 一番深く、一番右にあるNodeを知りたい（階層走査）
    public static ArrayList<BinaryTree> nodeList(ArrayDeque<BinaryTree> deque, ArrayList<BinaryTree> darr){
        if (deque.isEmpty()) return darr;
        if (deque.peekFirst().data != null){
            deque.addLast(deque.peekFirst().left == null ? new BinaryTree(null) : deque.peekFirst().left);
            deque.addLast(deque.peekFirst().right == null ? new BinaryTree(null) : deque.peekFirst().right);
        }
        
        darr.add(deque.pollFirst());

        while(darr.get(darr.size()-1).data == null) darr.remove(darr.size()-1);

        return nodeList(deque, darr);
    }
    
    public static boolean isCompleteBinaryTreeHelper(BinaryTree root, BinaryTree last){
        if (root == null) return true;
        if (haveOnlyRight(root)) return false;// 右にしか子がないのはNG
        if (haveOnlyLeft(root) && root.left != last) return false;//左にしか子がないのは、その子自体が一番深く、一番右側に存在しなければならない。

        return isCompleteBinaryTreeHelper(root.left,last) && isCompleteBinaryTreeHelper(root.right,last);
    }

    public static boolean isCompleteBinaryTree(BinaryTree root){
        //ここから書きましょう
        //階層走査の準備
        ArrayList<BinaryTree> list = new ArrayList<>();
        ArrayDeque<BinaryTree> deque = new ArrayDeque<>();
        deque.offerLast(root);

        ArrayList<BinaryTree> dans = nodeList(deque, list);
        BinaryTree last = dans.get(dans.size()-1);

        return isCompleteBinaryTreeHelper(root, last);
    }
}


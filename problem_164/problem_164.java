package problem_164;

import java.util.ArrayList;
import java.util.HashMap;

class Node{
    public String data;
    public Node next;

    public Node(String data){
        this.data = data;
    }
}
class Stack{
    public Node head;

    public Stack(){
        this.head = null;
    }
    public String peek(){
        if (this.head == null) return null;
        return this.head.data;
    }
    public void push(String data){
        if (this.head == null) this.head = new Node(data);
        else {
            Node temp = this.head;
            this.head = new Node(data);
            this.head.next = temp;
        }
    }
    public String pop(){
        if (this.head == null) return null;
        Node temp = this.head;
        this.head = this.head.next;
        return temp.data;
    }
    public void printList(){
        String str = "";
        Node iterator = this.head;
        while(iterator != null){
            str += iterator.data + " ";
            iterator = iterator.next;
        }
        System.out.println(str);
    }
}
class Solution{
    //不要な括弧を追跡する関数。不要な括弧がない場合に備えて、stackの一番最初に-1、最後に文字列長さを入れておく。
    public static Stack trakingUnnecessary(String parentheses){
        Stack stackJudge = new Stack();
        Stack stackIndex = new Stack();
        stackIndex.push(String.valueOf(-1));
        HashMap<String,String> pairs = new HashMap<>(){{put("(",")");}};

        for (int i = 0; i < parentheses.length(); i++){
            String curr = String.valueOf(parentheses.charAt(i));
            if (stackJudge.peek()!=null && pairs.get(stackJudge.peek()).equals(curr)){
                stackJudge.pop();
                stackIndex.pop();
            } else if(pairs.get(curr)!=null) {
                stackJudge.push(curr);
                stackIndex.push(String.valueOf(i));
            } else stackIndex.push(String.valueOf(i));
        }
        stackIndex.push(String.valueOf(parentheses.length()));
        return stackIndex;
    }
    //不要な括弧間の長さを求めて行き、それらの最大値を求める。
    public static int getMaxLength(Stack stackIndex){
        int maxValue = 0;  

        Node iterator = stackIndex.head;
        while(iterator.next != null){
            int temp = Integer.parseInt(iterator.data) - Integer.parseInt(iterator.next.data)-1;
            maxValue = maxValue < temp ? temp : maxValue;
            iterator = iterator.next;
        }
        stackIndex.printList();
        return maxValue;
    }
    public static int longestValidParentheses(String parentheses){
        //ここから書きましょう
        return getMaxLength(trakingUnnecessary(parentheses));
    }
}
class Main{
    public static void main(String[] args){
        String parentheses = ")))(((()))))()";
        System.out.println(Solution.longestValidParentheses(parentheses));
    }
}

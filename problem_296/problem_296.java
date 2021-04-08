package problem_296;

import java.util.Arrays;

class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class Stack{
    public Node head;

    public Stack(){
        this.head = null;
    }
    public Integer peek(){
        if (this.head == null) return null;
        return this.head.data;
    }
    public void push(int data){
        if (this.head == null) this.head = new Node(data);
        else {
            Node temp = this.head;
            this.head = new Node(data);
            this.head.next = temp;
        }
    }
    public Integer pop(){
        if (this.head == null) return null;
        Node temp = this.head;
        this.head = this.head.next;
        return temp.data;
    }
}

class Solution{
    public static int[] dailyStockPrice(int[] stocks){
        //ここから書きましょう
        int[] ans = new int[stocks.length];
        Stack stack = new Stack();

        for(int i = 0; i < stocks.length; i++){
            if (stack.peek()!=null && stocks[stack.peek()]>=stocks[i]){
                stack.push(i);
            } else {
                Node iterator = stack.head;
                while(iterator!=null && stocks[iterator.data] < stocks[i]){
                    ans[iterator.data] = i - iterator.data;
                    stack.pop();
                    iterator = iterator.next;
                }
                stack.push(i);
            }
        }
        return ans;
    }
}

class Main{
    public static void main(String[] args){
        System.out.println(Arrays.toString(Solution.dailyStockPrice(new int[]{38,37,38,35,34,37,39,40,33,33})));
    }
}

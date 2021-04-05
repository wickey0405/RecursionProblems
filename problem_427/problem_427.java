package problem_427;

import java.util.Arrays;

class Node{
    public int data;
    public Node next;
    public Node prev;

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
    public static int[] stockSpan(int[] stocks){
        //ここから書きましょう
        Stack stack = new Stack();
        int[] ans = new int[stocks.length];
        for (int i = 0; i < stocks.length; i++){
            int count = 1;
            if (stack.peek()==null || stocks[stack.peek()] > stocks[i]) stack.push(i);
            else{
                while(stack.peek() != null && stocks[stack.peek()] < stocks[i]){
                count += ans[stack.pop()];
                }
                stack.push(i);
            }
            
            ans[i] = count;
        }
        
        return ans;
    }
}

class Main{
    public static void main(String[] args){
        System.out.println(Arrays.toString(Solution.stockSpan(new int[]{1,2,3,4,5,6,4,5,1})));
    }
}

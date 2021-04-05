package problem_420;

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
        if (this.head != null) this.head.next = null;
        return temp.data;
    }
}

class Solution{
    public static int largestRectangle(int[] h){
        //ここから書きましょう
        Stack stack = new Stack();
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < h.length; i++){
            int bottom = 1;
            int j = i+1;
            Node iterator = stack.head;
            while(iterator != null && iterator.data >= h[i]){
                bottom++;
                iterator = iterator.next;
            }
            while(j < h.length && h[j] >= h[i]){
                bottom++;
                j++;
            }
            if (maxArea < h[i]*bottom) maxArea = h[i]*bottom;
            System.out.println("bottom: " + bottom + ", h[i]: " + h[i]);
            stack.push(h[i]);
        }
        
        return maxArea;
    }
}
class Main{
    public static void main(String[] args){
        System.out.println((Solution.largestRectangle(new int[]{2,3,1,1,12,3,10})));
    }
}

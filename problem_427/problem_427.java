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

class Deque{
    public Node head;
    public Node tail;

    public Deque(){
        this.head = null;
        this.tail = null;
    }
    public Integer peekFront(){
        if (this.head == null) return null;
        return this.head.data;
    }
    public Integer peekBack(){
        if (this.tail == null) return null;
        return this.tail.data;
    }
    public void enqueueFront(int data){
        if (this.head == null){
            this.head = new Node(data);
            this.tail = this.head;
        } else {
            Node newNode = new Node(data);
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
    }
    public void enqueueBack(int data){
        if (this.tail == null){
            this.tail = new Node(data);
            this.head = this.tail;
        } else {
            Node newNode = new Node(data);
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
    }
    public Integer dequeueFront(){
        if (this.head == null) return null;

        Node temp = this.head;
        this.head = this.head.next;
        if(this.head != null) this.head.prev = null;
        else this.tail = null;
        return temp.data;
    }
    public Integer dequeueBack(){
        if (this.tail == null) return null;

        Node temp = this.tail;
        this.tail = this.tail.prev;
        if(this.tail != null) this.tail.next = null;
        else this.head = null;
        return temp.data;
    }
}

class Solution{
    public static int[] stockSpan(int[] stocks){
        //ここから書きましょう
        Deque deque = new Deque();
        int[] ans = new int[stocks.length];

        for (int i = 0; i < stocks.length; i++){
            Node iterator = deque.tail;
            int count = 1;
            while(iterator != null && iterator.data < stocks[i]){
                iterator = iterator.prev;
                count++;
            }
            deque.enqueueBack(stocks[i]);
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

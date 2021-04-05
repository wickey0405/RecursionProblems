package problem_428;

import java.util.Arrays;
import java.util.ArrayList;

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
        if(this.head == null){
            this.head = new Node(data);
            this.tail = this.head;
        } else {
            Node temp = this.head;
            this.head.prev = new Node(data);
            this.head = this.head.prev;
            this.head.next = temp;
        }
    }
    public void enqueueBack(int data){
        if (this.tail == null){
            this.tail = new Node(data);
            this.head = this.tail;
        } else {
            Node temp = this.tail;
            this.tail.next = new Node(data);
            this.tail = this.tail.next;
            this.tail.prev = temp;
        }
    }
    public Integer dequeueFront(){
        if (this.head == null) return null;
        Node temp = this.head;
        this.head = this.head.next;
        if (this.head != null) this.head.prev = null;
        else this.tail = null;
        return temp.data;
    }
    public Integer dequeueBack(){
        if (this.tail == null) return null;
        Node temp = this.tail;
        this.tail = this.tail.prev;
        if (this.tail != null) this.tail.next = null;
        else this.head = null;
        return temp.data;
    }
}

class Solution{
    public static int[] minWindowArrK(int[] intArr,int k){
        //ここから書きましょう
        Deque deque = new Deque();
        for (int i = 0; i < k; i++){
            while(deque.peekFront()!=null && intArr[deque.peekBack()] >= intArr[i]){
                deque.dequeueBack();
            }
            deque.enqueueBack(i);
        }

        Node iterator = deque.head;
        while(iterator!=null){
            System.out.print(iterator.data + ", ");
            iterator = iterator.next;
        }

        int[] ans = new int[intArr.length-k+1];
        ans[0] = intArr[deque.peekFront()];

        for (int i = k; i < intArr.length; i++){
            while(deque.peekFront()!=null && deque.peekFront() <= i-k){
                deque.dequeueFront();
            }
            while(deque.peekFront()!=null && intArr[deque.peekBack()] >= intArr[i]){
                deque.dequeueBack();
            }
            deque.enqueueBack(i);
            ans[i-k+1] = intArr[deque.peekFront()];
        }

        return ans;
    }
}

class Main{
    public static void main(String[] args){
        System.out.println(Arrays.toString(Solution.minWindowArrK(new int[]{2,3,1,1,12,3,10}, 3)));
    }
}


package problem_426;

import java.util.stream.*;
import java.util.Arrays;
import java.util.ArrayList;

class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class Queue{
    public Node head;
    public Node tail;

    public Queue(){
        this.head = null;
        this.tail = null;
    }
    public Integer peekFront(){
        if (this.head == null) return null;
        return this.head.data;
    }
    public Integer peekBack(){
        if (this.tail == null) return this.peekFront();
        return this.tail.data;
    }
    public void enqueue(int data){
        if (this.head == null){
            this.head = new Node(data);
        } else if (this.tail == null){
            this.tail = new Node(data);
            this.head.next = this.tail;
        } else {
            this.tail.next = new Node(data);
            this.tail = this.tail.next;
        }
    }
    public Integer dequeue(){
        if (this.head == null) return null;

        Node temp = this.head;
        if (this.head.next == null){
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
        }
        return temp.data;
    }
    public Integer getSize(){
        Node iterator = this.head;
        int size = 0;
        while(iterator != null){
            size++;
            iterator = iterator.next;
        }
        return size;
    }
}

class Solution{
    public static int[] convertQueueToArr(Queue queue){
        int[] arr = new int[queue.getSize()];
        for (int i = 0; i < arr.length; i++){
            arr[i] = queue.dequeue();
        }
        return arr;
    }
    public static int[] increaseList (int[] arr){
        Queue queue = new Queue();
        for (int i = 0; i < arr.length; i++){
            while(queue.peekFront() != null && queue.peekBack() > arr[i]){
                queue.dequeue();
            }
            queue.enqueue(arr[i]);
        }
        return convertQueueToArr(queue);
    }
    public static String printList (int[] arr){
        String str = "";
        for (int i = 0; i < arr.length; i++){
            str += arr[i] + ",";
        }
        return str;
    }
    public static String diceStreakGamble(int[] player1,int[] player2,int[] player3,int[] player4){
        //ここから書きましょう
        ArrayList<Queue> darr = new ArrayList<>();
        int[][] players = {player1, player2, player3, player4};
        int[] maxPlayerList = increaseList(players[0]);
        int maxPlayer = 0;
        for (int i = 1; i < players.length; i++){
            if (maxPlayerList.length < increaseList(players[i]).length){
                maxPlayer = i;
                maxPlayerList = increaseList(players[i]);
            }
        }
        return "Winner: Player " + (maxPlayer+1) + " won $" + (maxPlayerList.length*4) + " by rolling [" + (printList(maxPlayerList).substring(0,printList(maxPlayerList).length()-1)) + "]";
    }
}

class Main{
    public static void main(String[] args){
        System.out.println(Solution.diceStreakGamble(new int[]{1,2,3,4},new int[]{1,3,4,1},new int[]{5,2,1,4},new int[]{1,6,3,4}));
    }
}
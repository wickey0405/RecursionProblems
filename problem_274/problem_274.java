package problem_274;

import java.util.Arrays;
class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}
class SinglyLinkedList{
    public Node head;

    public SinglyLinkedList(int[] arr){
        this.head = new Node(arr[0]);
        Node iterator = this.head;

        for(int i = 1; i < arr.length; i++){
            iterator.next = new Node(arr[i]);
            iterator = iterator.next;
        }
    }
    public void insertAsOrder(int num){
        Node dummy = new Node(0);// 先頭に挿入する場合に備えてDummyのNodeを入れておく
        dummy.next = this.head;
        this.head = dummy;
        Node iterator = this.head;
        while(iterator.next != null && iterator.next.data < num){
            iterator = iterator.next;
        }
        Node temp = iterator.next;
        iterator.next = new Node(num);
        iterator = iterator.next;
        iterator.next = temp;
        this.head = dummy.next;//　先頭はDummyなので忘れずに切り離しておくこと！
    }
    public Integer deleteHead(){
        if (this.head == null) return null;
        Node temp = this.head;
        this.head = this.head.next;
        return temp.data;
    }
    public Integer peekHead(){
        if (this.head == null) return null;
        return this.head.data;
    }
    public void printList(){
        Node iterator = this.head;
        String str = "";
        while(iterator != null){
            str += iterator.data + " ";
            iterator = iterator.next;
        }
        System.out.println(str);
    }
}

class Solution{
    public static int shipmentVolumePackages(int[] packages){
        //ここから書きましょう
        if(packages.length < 2) return 0;

        int[] sortedPackages = packages.clone();
        Arrays.sort(sortedPackages);
        SinglyLinkedList numList = new SinglyLinkedList(sortedPackages);      
        int total = 0;

        while(true){
            Integer temp = numList.deleteHead() + numList.deleteHead();
            if(numList.peekHead() == null){
                total+=temp;
                break;
            }
            numList.insertAsOrder(temp);
            total += temp;
            // numList.printList();
            // System.out.println("total: " + total);
        }
        return total;
    }
}

class Main{
    public static void main(String[] args){
        int[] input = {45,65,20,3,4,5,66,19,23,3,1};
        System.out.println(Solution.shipmentVolumePackages(input));
    }
}

package problem_299;
import java.util.function.*;
import java.util.List;
import java.util.Arrays;

class SinglyLinkedListNodeInt{
    public int data;
    public SinglyLinkedListNodeInt next;

    public SinglyLinkedListNodeInt(int data){
        this.data = data;
        this.next = null;
    }
}

class Solution{
    public static SinglyLinkedListNodeInt getTail(SinglyLinkedListNodeInt head){
        SinglyLinkedListNodeInt iterator = head;
        while(iterator.next!=null){
            iterator = iterator.next;
        }
        return iterator;
    }
    public static int getLength(SinglyLinkedListNodeInt head){
        SinglyLinkedListNodeInt iterator = head;
        int length = 0;
        while(iterator != null){
            iterator = iterator.next;
            length++;
        }
        return length;
    }
    public static SinglyLinkedListNodeInt rotateLinkedList(SinglyLinkedListNodeInt head,int x){
        //ここから書きましょう
        int listLength = getLength(head);
        SinglyLinkedListNodeInt tail = getTail(head);
        tail.next = head;//循環できるようにする
        for (int i = listLength - (x%listLength)-1; i>=0; i--){
            head = head.next;
            tail = tail.next;
        }
        tail.next = null;//循環を解除
        return head;
    }
}

class Main{
    public static SinglyLinkedListNodeInt makeList(List<Integer> list){
        SinglyLinkedListNodeInt head = new SinglyLinkedListNodeInt(list.get(0));
        SinglyLinkedListNodeInt iterator = head;
        for (int i = 1; i < list.size(); i++){
            iterator.next = new SinglyLinkedListNodeInt(list.get(i));
            iterator = iterator.next;
        }
        return head;
    }
    public static void main(String[] args){
        List<Integer> input = Arrays.asList(6,17,8,1,2,8,3,9,4,5);
        
        SinglyLinkedListNodeInt head = makeList(input);

        Consumer<SinglyLinkedListNodeInt> printList = (node)->{
            String str = "";
            while(node.next != null){
                str += node.data + "->";
                node = node.next;
            }
            str += node.data;
            System.out.println(str);
        };

        printList.accept(Solution.rotateLinkedList(head,18));
        // System.out.println();
    }
}
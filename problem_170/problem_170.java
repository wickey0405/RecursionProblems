package problem_170;

import java.util.function.*;
import java.util.stream.*;
import java.util.Arrays;
import java.util.List;

class SinglyLinkedListNodeInt{
    public int data;
    public SinglyLinkedListNodeInt next;

    public SinglyLinkedListNodeInt(int data){
        this.data = data;
        this.next = null;
    }
}

class Solution{
    public static SinglyLinkedListNodeInt insertHeadTail(SinglyLinkedListNodeInt head,int data){
        //ここから書きましょう
        SinglyLinkedListNodeInt iterator = head;
        
        SinglyLinkedListNodeInt newHead = new SinglyLinkedListNodeInt(data);
        SinglyLinkedListNodeInt newTail = new SinglyLinkedListNodeInt(data);

        Function<SinglyLinkedListNodeInt, SinglyLinkedListNodeInt> getTail = (node)->{
            while(node.next != null) node = node.next;
            return node;
        };

        newHead.next = head;
        getTail.apply(newHead).next = newTail;
        return newHead;
    }
}
class Main{
    public static void main(String[] args){
        List<Integer> input = Arrays.asList(3,3,2,10,34,45,67,356);
        SinglyLinkedListNodeInt head = new SinglyLinkedListNodeInt(input.get(0));
        SinglyLinkedListNodeInt iterator = head;

        for (int i = 1; i < input.size(); i++){
            iterator.next = new SinglyLinkedListNodeInt(input.get(i));
            iterator = iterator.next;
        }

        Consumer<SinglyLinkedListNodeInt> printList = (node)->{
            String str = "";
            while(node.next != null){
                str += node.data + "->";
                node = node.next;
            }
            str += node.data;
            System.out.println(str);
        };

        printList.accept(Solution.insertHeadTail(head,367));
    }
}

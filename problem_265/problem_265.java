package problem_265;

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
    public static int getLength(SinglyLinkedListNodeInt head){
        int count = 0;
        SinglyLinkedListNodeInt iterator = head;
        while(iterator != null){
            iterator = iterator.next;
            count++;
        }
        return count;
    }
    public static SinglyLinkedListNodeInt getAtIndexNode(SinglyLinkedListNodeInt head, int index){
        int count = 0;
        SinglyLinkedListNodeInt iterator = head;
        while(count < index){
            iterator = iterator.next;
            count++;
        }
        return iterator;
    }
    public static SinglyLinkedListNodeInt middleNode(SinglyLinkedListNodeInt head){
        //ここから書きましょう
        return getAtIndexNode(head,(int)Math.ceil(getLength(head)/2));
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
        List<Integer> input = Arrays.asList(1,1,2,3,3,5);
        
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

        printList.accept(Solution.middleNode(head));
        // System.out.println();
    }
}

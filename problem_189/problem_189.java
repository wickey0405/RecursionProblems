package problem_189;

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
    public static SinglyLinkedListNodeInt reverseList(SinglyLinkedListNodeInt head){
        SinglyLinkedListNodeInt iterator = head;
        iterator = iterator.next;
        SinglyLinkedListNodeInt reverse = head;
        reverse.next = null;

        while(iterator != null){
            SinglyLinkedListNodeInt temp = iterator;
            iterator = iterator.next;
            temp.next = reverse;
            reverse = temp;
        }
        return reverse;
    }
    public static boolean palindromeLinkedList(SinglyLinkedListNodeInt head){
        //ここから書きましょう
        SinglyLinkedListNodeInt reverse = reverseList(head);
        
        SinglyLinkedListNodeInt iterator1 = head;
        SinglyLinkedListNodeInt iterator2 = reverse;

        while(iterator1 != null){
            if (iterator1.data != iterator2.data) break;
            iterator1 = iterator1.next;
            iterator2 = iterator2.next;
        }

        return iterator1 == null;
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

        printList.accept(head);
        System.out.println(Solution.palindromeLinkedList(head));
    }
}
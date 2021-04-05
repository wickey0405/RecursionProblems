package problem_188;

import java.util.List;
import java.util.function.*;
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
    public static SinglyLinkedListNodeInt mergeTwoSortedLinkedLists(SinglyLinkedListNodeInt head1,SinglyLinkedListNodeInt head2){
        //ここから書きましょう
        SinglyLinkedListNodeInt newHead = new SinglyLinkedListNodeInt(0);// dummy
        SinglyLinkedListNodeInt iterator1 = head1;
        SinglyLinkedListNodeInt iterator2 = head2;
        SinglyLinkedListNodeInt iteratorNew = newHead;
        while(iterator1!=null && iterator2!=null){
            if(iterator1.data < iterator2.data){
                iteratorNew.next = new SinglyLinkedListNodeInt(iterator1.data);
                iteratorNew = iteratorNew.next;
                iterator1 = iterator1.next;
            } else {
                iteratorNew.next = new SinglyLinkedListNodeInt(iterator2.data);
                iteratorNew = iteratorNew.next;
                iterator2 = iterator2.next;
            }
        }
        if (iterator1 != null) iteratorNew.next = iterator1;
        if (iterator2 != null) iteratorNew.next = iterator2;
        return newHead.next;
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
        List<Integer> input1 = Arrays.asList(1,1,2,3,3,5);
        List<Integer> input2 = Arrays.asList(2,2,3,3,5,5,10,10);
        
        SinglyLinkedListNodeInt head1 = makeList(input1);
        SinglyLinkedListNodeInt head2 = makeList(input2);
        Consumer<SinglyLinkedListNodeInt> printList = (node)->{
            String str = "";
            while(node.next != null){
                str += node.data + "➡";
                node = node.next;
            }
            str += node.data;
            System.out.println(str);
        };

        printList.accept(Solution.mergeTwoSortedLinkedLists(head1,head2));
    }
}

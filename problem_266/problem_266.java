package problem_266;
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
    public static SinglyLinkedListNodeInt oddEven(SinglyLinkedListNodeInt head){
        //ここから書きましょう
        SinglyLinkedListNodeInt iterator = head;
        SinglyLinkedListNodeInt secondNode = head.next;//初期状態のhead.nextのアドレスをKeep
        while(iterator.next != null && iterator.next.next != null){
            SinglyLinkedListNodeInt temp = iterator.next;//index奇数側のiteratorとして用意
            iterator.next = iterator.next.next;//index偶数側nextのアドレス書き換え
            temp.next = temp.next.next;//index奇数側nextのアドレス書き換え
            iterator = iterator.next;//Walk
        }
        iterator.next = secondNode;//index偶数側の末尾のnextアドレスをindex奇数側の先頭にする
        
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
        List<Integer> input = Arrays.asList(43,56,12,32,58,97,89,74,3,7,103,1);
        
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

        printList.accept(Solution.oddEven(head));
        // System.out.println();
    }
}
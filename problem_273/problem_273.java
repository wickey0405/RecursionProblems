package problem_273;
import java.util.function.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class SinglyLinkedListNodeInt{
    public int data;
    public SinglyLinkedListNodeInt next;

    public SinglyLinkedListNodeInt(int data){
        this.data = data;
        this.next = null;
    }
}

class Solution{
    // 各Nodeのアドレスを格納（順序は反転）
    public static ArrayList<SinglyLinkedListNodeInt> makeArrayList(SinglyLinkedListNodeInt head){
        SinglyLinkedListNodeInt iterator = head;
        ArrayList<SinglyLinkedListNodeInt> darr = new ArrayList<>();
        while(iterator != null){
            darr.add(0,iterator);
            iterator = iterator.next;
        }
        return darr;
    }
    public static SinglyLinkedListNodeInt removeNthNode(SinglyLinkedListNodeInt head,int n){
        //ここから書きましょう
        if(n==0) return head;// n=0はheadを返す
        ArrayList<SinglyLinkedListNodeInt> darr = makeArrayList(head);

        if (n>darr.size()) return head;//n>リストサイズはheadを返す

        SinglyLinkedListNodeInt target = null;//変数の用意
        if (n!=darr.size()) target = darr.get(n);//先頭以外を削除する場合は、削除対象の一つ前のNodeのアドレスを選択
        else return head.next;//先頭を削除する場合は、head.nextをreturnでOK。

        if (target.next.next != null) target.next = target.next.next;
        else target.next = null;
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
        List<Integer> input = Arrays.asList(3,5,2,7,56,23,86,93,43,23,55,5,78,0,13,1);
        
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

        printList.accept(Solution.removeNthNode(head,11));
        // System.out.println();
    }
}

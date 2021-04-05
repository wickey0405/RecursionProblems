package problem_420;

import java.util.Arrays;
import java.util.stream.*;

class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class Stack{
    public Node head;
    
    public Stack(){
        this.head = null;
    }
    public Integer peek(){
        if (this.head == null) return null;
        return this.head.data;
    }
    public void push(int data){
        if (this.head == null) this.head = new Node(data);
        else {
            Node temp = this.head;
            this.head = new Node(data);
            this.head.next = temp;
        }
    }
    public Integer pop(){
        if (this.head == null) return null;

        Node temp = this.head;
        this.head = this.head.next;
        return temp.data;
    }
}

class Solution{
    public static int[] reverse(int[] arr){
        int[] reverse = arr.clone();
        for (int i = 0; i < reverse.length/2; i++){
            int temp = reverse[i];
            reverse[i] = reverse[reverse.length - 1 - i];
            reverse[reverse.length-1-i] = temp;
        }
        return reverse;
    }
    public static int[] calcConstructBottom(int[] arr){
        Stack stack = new Stack();
        int[] bottom = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            int count = 1;
            while(stack.peek()!=null && arr[stack.peek()] >= arr[i]){
                count += bottom[stack.peek()];
                stack.pop();
            }
            bottom[i] = count;
            stack.push(i);
        }
        return bottom;
    }
    public static int largestRectangle(int[] h){
        //ここから書きましょう
        int[] right = calcConstructBottom(h);
        int[] left = reverse(calcConstructBottom(reverse(h)));
        System.out.println(Arrays.toString(right));
        System.out.println(Arrays.toString(left));

        return IntStream.range(0,h.length).map(x->(right[x]+left[x]-1)*h[x]).max().getAsInt();
    }
}

class Main{
    public static void main(String[] args){
        System.out.println((Solution.largestRectangle(new int[]{2,3,1,1,12,3,10})));
    }
}

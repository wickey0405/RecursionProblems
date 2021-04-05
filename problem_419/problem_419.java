package problem_419;

import java.util.HashMap;
import java.util.stream.*;

class Node{
    public String data;
    public Node next;

    public Node(String data){
        this.data = data;
    }
}
class Stack{
    public Node head;

    public Stack(){
        this.head = null;
    }
    public String peek(){
        if (this.head == null) return null;
        return this.head.data;
    }
    public void push(String data){
        if (this.head == null){
            this.head = new Node(data);
        } else {
            Node temp = this.head;
            this.head = new Node(data);
            this.head.next = temp;
        }
    }
    public String pop(){
        if (this.head == null) return null;

        Node temp = this.head;
        this.head = this.head.next;
        return temp.data;
    }
}

class Solution{
    public static boolean isParenthesesValid(String parentheses){
        //ここから書きましょう
        HashMap<String, String> pairs = new HashMap<>(){
            {
                put("{" , "}");
                put("[" , "]");
                put("(" , ")");
                put("}" , "x");
                put("]" , "x");
                put(")" , "x");
            }
        };

        Stack stack = new Stack();

        parentheses.chars().mapToObj(ch->String.valueOf((char)ch)).forEach(x->{
            if (stack.peek() != null && pairs.get(stack.peek()).equals(x)) stack.pop();
            else stack.push(x);
        });
        return stack.peek() == null;
    }
}
class Main{
    public static void main(String[] args){
        System.out.println(Solution.isParenthesesValid("]][}{({()){}("));
    }
}

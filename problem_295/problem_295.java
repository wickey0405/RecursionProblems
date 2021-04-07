package problem_295;

class Node{
    public String data;
    public Node next;
    public Node prev;

    public Node(String data){
        this.data = data;
    }
}
class Deque{
    public Node head;
    public Node tail;

    public Deque(){
        this.head = null;
        this.tail = null;
    }
    public String peekFront(){
        if (this.head == null) return null;
        return this.head.data;
    }
    public String peekBack(){
        if (this.tail == null) return null;
        return this.tail.data;
    }
    public void enqueueFront(String data){
        if (this.head == null){
            this.head = new Node(data);
            this.tail = this.head;
        } else {
            Node node = new Node(data);
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }
    }
    public void enqueueBack(String data){
        if (this.tail == null){
            this.tail = new Node(data);
            this.head = this.tail;
        } else {
            Node node = new Node(data);
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }
    public String dequeueFront(){
        if (this.head == null) return null;
        Node temp = this.head;

        this.head = this.head.next;
        if (this.head != null) this.head.prev = null;
        else this.tail = null;
        return temp.data;
    }
    public String dequeueBack(){
        if (this.tail == null) return null;
        Node temp = this.tail;

        this.tail = this.tail.prev;
        if (this.tail != null) this.tail.next = null;
        else this.head = null;
        return temp.data;
    }
    public void printDeque(){
        String str = "";
        Node iterator = this.head;
        while (iterator!=null){
            str += iterator.data + " ";
            iterator = iterator.next;
        }
        System.out.println(str);
    }
    public int getLength(){
        int count = 0;
        Node iterator = this.head;
        while(iterator != null){
            iterator = iterator.next;
            count++;
        }
        return count;
    }
}


class Solution{
    public static int firstOperatorIndex(String str){
        int count = 0;
        while(count < str.length() && !String.valueOf(str.charAt(count)).matches("[*/+-]")){
            count++;
        }
        return count;
    }
    public static int calculationSimple(String num1, String num2, String operator){
        if (operator.equals("+")) return Integer.parseInt(num1) + Integer.parseInt(num2);
        else if (operator.equals("-")) return Integer.parseInt(num1) - Integer.parseInt(num2);
        else if (operator.equals("*")) return Integer.parseInt(num1) * Integer.parseInt(num2);
        else if (operator.equals("/")) return Integer.parseInt(num1) / Integer.parseInt(num2);
        return Integer.MIN_VALUE;
    }
    public static int calculationFormula(Deque operators, Deque numbers){
        Deque newOperators = new Deque();
        Deque newNumbers = new Deque();
        while (operators.peekFront()!=null){
            if (operators.peekFront().matches("[+-]")){
                String tempOperator = operators.dequeueFront();
                newOperators.enqueueBack(tempOperator);
                String tempNumber = numbers.dequeueFront();
                newNumbers.enqueueBack(tempNumber);
            } else {
                numbers.enqueueFront(String.valueOf(calculationSimple(numbers.dequeueFront(),numbers.dequeueFront(),operators.dequeueFront())));
            }
        }

        newNumbers.enqueueBack(numbers.dequeueFront());//最後の一個を渡す。

        while(newOperators.peekFront() != null){
            newNumbers.enqueueFront(String.valueOf(calculationSimple(newNumbers.dequeueFront(),newNumbers.dequeueFront(),newOperators.dequeueFront())));
        }
        return Integer.parseInt(newNumbers.peekFront());
    }
    public static int expressionParser(String expression){
        //ここから書きましょう
        Deque storageNumber = new Deque();
        Deque storageOperator = new Deque();
        while(expression.length()>0){
            int index = firstOperatorIndex(expression);
            if (index == expression.length()){
                storageNumber.enqueueBack(expression);
                break;
            }
            String num = expression.substring(0,index);
            expression = expression.substring(index);
            String operator = expression.substring(0,1);
            expression = expression.substring(1);
            storageNumber.enqueueBack(num);
            storageOperator.enqueueBack(operator);
        }
        storageNumber.printDeque();
        storageOperator.printDeque();
        return calculationFormula(storageOperator,storageNumber);
    }
}
class Main{
    public static void main(String[] args){
        System.out.println(Solution.expressionParser("2+5"));
    }
}

package problem_245;

import java.util.Stack;

class Solution{
    public static String getNumber(String code){
        //ここから書きましょう
        Stack<String> stack = new Stack<>();
        int codeLength = code.length();
        if (codeLength>=9) return "0";

        stack.push(String.valueOf(1));//初めに1を入れておく
        String ansStr = "";

        for (int i = 0; i < codeLength; i++){
            String numStr = String.valueOf(i+2);
            String curr = String.valueOf(code.charAt(i));

            if (curr.equals("I")) while(!stack.empty()) ansStr += stack.pop();
            stack.push(numStr);
        }
        while(!stack.empty()) ansStr += stack.pop();// stackの中に残っているものがあれば最後に加える
        return ansStr;
    }
}
class Main{
    public static void main(String[] args){
        System.out.println(Solution.getNumber("DDIDDIID"));
    }
}

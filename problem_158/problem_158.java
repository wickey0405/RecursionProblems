package problem_158;

import java.util.ArrayDeque;
import java.util.Deque;
class Solution{
    public static int longestSubstringLength(String password){
        //ここから書きましょう
        Deque<String> deque = new ArrayDeque<>();
        int maxValue = Integer.MIN_VALUE;
        
        for (int i = 0; i < password.length(); i++){
            String curr = String.valueOf(password.charAt(i));
            if (deque.peekFirst()!=null && deque.contains(curr)){
                while(!deque.peekFirst().equals(curr)) deque.removeFirst();
                deque.removeFirst();                
            }
            deque.addLast(curr);
            maxValue = maxValue < deque.size() ? deque.size() : maxValue;
        }
        return maxValue;
    }
}

class Main{
    public static void main(String[] args){
        System.out.println(Solution.longestSubstringLength("ametetoccaecatieosprovidentutvel"));
    }
}

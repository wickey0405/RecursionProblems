package problem_264;

import java.util.HashMap;

class Solution{
    public static HashMap<String, Integer> makeThashMap(String str, String t, HashMap<String, Integer> hashMap){
        for (int i = 0; i < str.length(); i++){
            String curr = str.substring(i,i+1);
            if (t.contains(curr)){
                if(hashMap.get(curr)==null) hashMap.put(curr, 1);
                else hashMap.replace(curr,hashMap.get(curr)+1);
            }
        }
        return hashMap;
    }
    public static HashMap<String, Integer> deleteThashMap(String str, HashMap<String, Integer> hashMap){
        for (int i = 0; i < str.length(); i++){
            String curr = str.substring(i,i+1);
            if(hashMap.get(curr)!=null) hashMap.replace(curr,hashMap.get(curr)-1);
        }
        return hashMap;
    }
    public static boolean judgeLessThanZERO(HashMap<String, Integer> hashMap){
        for (String key : hashMap.keySet()){
            if(hashMap.get(key) > 0) return false;
        }
        return true;
    }
    public static String minLengthSubstring(String s,String t){
        //ここから書きましょう
        HashMap<String, Integer> tHashMap = new HashMap<>();
        tHashMap = makeThashMap(t,t,tHashMap);

        int start = 0;
        int end = 0;
        String ans = s;
        String str = "";

        while (!judgeLessThanZERO(tHashMap) && end <= s.length()){
            str = s.substring(start,end);
            tHashMap = makeThashMap(t,t,new HashMap<String,Integer>());
            tHashMap = deleteThashMap(str,tHashMap);
            System.out.println("tHashMap: " + tHashMap);
            end++;//indexが+1されてしまうので注意
        }
        if (end-1 == s.length() && !judgeLessThanZERO(tHashMap)) return "";
        System.out.println(str);
        str = str.substring(0,end-2);
        System.out.println(str);

        for (int i = end-2; i < s.length(); i++){
            str += s.substring(i,i+1);
            
            String temp = "";
            while(judgeLessThanZERO(tHashMap)){
                temp = str.substring(0,1);
                str = str.substring(1);
                tHashMap = makeThashMap(t,t,new HashMap<String,Integer>());
                tHashMap = deleteThashMap(str,tHashMap);
            }
            str = temp + str;
            tHashMap = makeThashMap(t,t,new HashMap<String,Integer>());
            tHashMap = deleteThashMap(str,tHashMap);
            if (judgeLessThanZERO(tHashMap)) ans = ans.length() > str.length() ? str : ans;  
            // System.out.println(str);
        }
        return ans;
    }
}

class Main{
    public static void main(String[] args){
        System.out.println(Solution.minLengthSubstring("acbgbaca","aba"));
    }
}
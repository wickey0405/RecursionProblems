package problem_264;

import java.util.HashMap;

class Solution{
    // tに含まれる文字をkeyとして、そのkeyに該当するstr内の個数をvalueとする。tに含まれないものは無視
    public static HashMap<String, Integer> makeTHashMap(String str, String t){
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            String curr = str.substring(i,i+1);
            if (t.contains(curr)){
                if(hashMap.get(curr)==null) hashMap.put(curr, 1);
                else hashMap.replace(curr,hashMap.get(curr)+1);
            }
        }
        return hashMap;
    }
    // HashMapのKeyに該当するstr内の文字の個数をHashMapから削除する。
    public static HashMap<String, Integer> deleteTHashMap(String str, HashMap<String, Integer> hashMap){
        for (int i = 0; i < str.length(); i++){
            String curr = str.substring(i,i+1);
            if(hashMap.get(curr)!=null) hashMap.replace(curr,hashMap.get(curr)-1);
        }
        return hashMap;
    }
    // 引数HashMapが題意を満たすものかを判定する。（指定文字列からHashMap化する必要がある）全ての値が0以下であればOK
    public static boolean judgeLessThanZERO(HashMap<String, Integer> hashMap){
        for (String key : hashMap.keySet()){
            if(hashMap.get(key) > 0) return false;
        }
        return true;
    }
    // tのHashMapを作り直したうえでHashMapのKeyに該当するstr内の文字の個数をHashMapから削除する。
    public static HashMap<String, Integer> refreshTHashMap(String str, String t){
        HashMap<String, Integer> hashmap = makeTHashMap(t,t);
        hashmap = deleteTHashMap(str,hashmap);
        return hashmap;
    }
    public static String minLengthSubstring(String s,String t){
        //ここから書きましょう
        // tの文字をkey、個数をvalueとするHashMapを用意
        HashMap<String, Integer> THashMap = makeTHashMap(t,t);

        int start = 0;
        int end = 0;
        String ans = s;
        String str = "";

        // １．まず先頭から一つずつ文字列を連結していき、tをすべて含む文字列を探す。
        while (!judgeLessThanZERO(THashMap) && end <= s.length()){
            str = s.substring(start,end);
            THashMap = refreshTHashMap(str,t);
            end++;//indexが+1されてしまうので注意
        }
        // この時にsの末尾まで到達し、かつTHashMapがfalseであれば題意を満たす文字列は存在しない。
        if (end-1 == s.length() && !judgeLessThanZERO(THashMap)) return "";

        // １で見つけた文字列の末尾を一端削除。（次の処理で使いたい）
        str = str.substring(0,end-2);

        // ２．１で求めた文字列の末尾から始める。一文字ずつ加えていき、その文字が加わったことで削除可能なものを先頭から消していく。
        for (int i = end-2; i < s.length(); i++){
            str += s.substring(i,i+1);
            String temp = "";
            while(judgeLessThanZERO(THashMap)){
                temp = str.substring(0,1);//whileを抜けた後に一つ前の処理に戻せるように準備
                str = str.substring(1);// 先頭を削除
                THashMap = refreshTHashMap(str,t);
            }
            str = temp + str;//whileはfalseになったところで止まるので、一つ前に判定したTrue判定のものに戻す。これがループ内での最小文字列になる。
            THashMap = refreshTHashMap(str,t);
            if (judgeLessThanZERO(THashMap)) ans = ans.length() > str.length() ? str : ans;  
        }
        return ans;
    }
}



class Main{
    public static void main(String[] args){
        System.out.println(Solution.minLengthSubstring("acbgbaca","aba"));
    }
}
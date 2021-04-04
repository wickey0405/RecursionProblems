package problem_238;

class Solution{
    public static int decodeIntegerHelper(String prev, String str, int total){
        if (Integer.parseInt(prev)==0) return total-1;// prevが0の時は文字列として成立しないのでケースから1つ減らす。
        if (str.length() == 0) return total;

        String curr = str.substring(0,1);
        int temp = Integer.parseInt(prev + curr);
        
        // tempが26以下の時はルートが二つできる。この場合temp26以下の方のtotalに1足す。文字列のケースとしては1つしか増えない。
        if (temp<=26 && str.substring(1).length()>=0){
            total = decodeIntegerHelper(String.valueOf(temp),str.substring(1),total+1);
            total = decodeIntegerHelper(curr,str.substring(1),total);
        } else {
            total = decodeIntegerHelper(curr,str.substring(1),total);
        }
        return total;
    }
    public static int decodeInteger(int n){
        //ここから書きましょう
        String str = String.valueOf(n);    
        return decodeIntegerHelper(str.substring(0,1),str.substring(1),1);
    }
}
class Main{
    public static void main(String[] args){
        System.out.println(Solution.decodeInteger(1553));
    }
}
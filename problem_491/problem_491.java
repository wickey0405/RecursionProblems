package problem_491;

import java.util.Arrays;

class Solution{
    public static int[] buildMinHeap(int[] intArr){
        //ここから書きましょう
        int middle = (int)Math.floor((intArr.length-2)/2);
        for (int i = middle; i>=0; i--) minHeapify(intArr, i);
        return intArr;
    }
    public static void minHeapify(int[] arr, int i){
        int l = 2*i+1;
        int r = 2*i+2;

        int smallest = i;
        if(l<arr.length && arr[l] < arr[smallest]) smallest = l;
        if(r<arr.length && arr[r] < arr[smallest]) smallest = r;
        if(smallest != i){
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            minHeapify(arr,smallest);
        }
    }
}
class Main{
    public static void main(String[] args){
        int[] intArr = new int[]{879,487,98,397,610,150,474,977,404,478,623,554,306};
        System.out.println(Arrays.toString(Solution.buildMinHeap(intArr)));
    }
}

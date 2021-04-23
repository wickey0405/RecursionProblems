package problem_492;

import java.util.Arrays;

class Solution{
    public static int[] heapsort(int[] intArr){
        //ここから書きましょう
        int heapEnd = intArr.length-1;
        buildMaxHeap(intArr);
        while(heapEnd > 0){
            int temp = intArr[0];
            intArr[0] = intArr[heapEnd];
            intArr[heapEnd] = temp;
            heapEnd--;
            maxHeapify(intArr, heapEnd, 0);
        }
        return intArr;
    }
    public static void buildMaxHeap(int[] arr){
        int middle = parent(arr.length-1);
        for(int i = middle; i>=0; i--) maxHeapify(arr, arr.length-1, i);
    }
    public static void maxHeapify(int[] arr, int heapEnd, int i){
        int l = left(i);
        int r = right(i);

        int biggest = i;
        if (l<=heapEnd && arr[l] > arr[biggest]) biggest = l;
        if (r<=heapEnd && arr[r] > arr[biggest]) biggest = r;
        if (biggest!=i){
            int temp = arr[i];
            arr[i] = arr[biggest];
            arr[biggest] = temp;
            maxHeapify(arr, heapEnd, biggest);
        }
    }
    public static int left(int i){ return 2*i+1;}
    public static int right(int i){ return 2*i+2;}
    public static int parent(int i){ return (int)Math.floor((i-1)/2);}
}
class Main{
    public static void main(String[] args){
        int[] arr = new int[]{-10,-2,-1,0,1,2,2,2,3,4,5,5,5,6,7,10};
        System.out.println(Arrays.toString(Solution.heapsort(arr)));
    }
}

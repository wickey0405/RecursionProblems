package problem_493;

import java.util.Arrays;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

import java.util.ArrayList;

class HeapLibrary{
    public static void buildMaxHeap(ArrayList<Integer> arr){
        int middle = HeapLibrary.parent(arr.size()-1);
        for (int i = middle; i>=0; i--) HeapLibrary.maxHeapify(arr, arr.size()-1, i);
    }
    public static void maxHeapify(ArrayList<Integer> arr, int heapEnd, int i){
        int l = HeapLibrary.left(i);
        int r = HeapLibrary.right(i);

        int biggest = i;
        if (l<=heapEnd && arr.get(l) > arr.get(biggest)) biggest = l;
        if (r<=heapEnd && arr.get(r) > arr.get(biggest)) biggest = r;
        if (biggest!=i){
            int temp = arr.get(i);
            arr.set(i, arr.get(biggest));
            arr.set(biggest,temp);
            HeapLibrary.maxHeapify(arr, heapEnd, biggest);
        }
    }
    public static int left(int i){ return 2*i+1;}
    public static int right(int i){ return 2*i+2;}
    public static int parent(int i){ return (int)Math.floor((i-1)/2);}
}

class PriorityQueue{
    public ArrayList<Integer> maxHeap;

    public PriorityQueue(int[] arr){
        this.maxHeap = new ArrayList<Integer>();
        for (Integer i : arr) this.maxHeap.add(i);
        HeapLibrary.buildMaxHeap(this.maxHeap);
    }
    public int pop(){
        int poped = this.maxHeap.get(0);
        this.maxHeap.set(0, this.maxHeap.get(this.maxHeap.size()-1));
        this.maxHeap.set(this.maxHeap.size()-1, poped);

        this.maxHeap.remove(this.maxHeap.size()-1);
        HeapLibrary.maxHeapify(this.maxHeap, this.maxHeap.size()-1, 0);

        return poped;
    }
}

class Solution{
    public static int[] topKElements(int[] intArr,int k){
        //ここから書きましょう
        int[] ans = new int[k];
        PriorityQueue pq = new PriorityQueue(intArr);
        for (int i = 0; i < k; i++) ans[i] = pq.pop();
        return ans;
    }
}
class Main{
    public static void main(String[] args){
        int[] intArr = new int[]{879,487,98,397,610,150,474,977,404,478,623,554,306};
        System.out.println(Arrays.toString(Solution.topKElements(intArr, 8)));
    }
}

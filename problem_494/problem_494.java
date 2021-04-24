package problem_494;

import java.util.Arrays;
import java.util.ArrayList;

class HeapLibrary{
    public static void buildMinHeap(ArrayList<Integer> arr){
        int middle = HeapLibrary.parent(arr.size()-1);
        for (int i = middle; i>=0; i--) HeapLibrary.minHeapify(arr, arr.size()-1, i);
    }
    public static void minHeapify(ArrayList<Integer> arr, int heapEnd, int i){
        int left = HeapLibrary.left(i);
        int right = HeapLibrary.right(i);

        int smallest = i;
        if (left<=heapEnd && arr.get(left) < arr.get(smallest)) smallest = left;
        if (right<=heapEnd && arr.get(right) < arr.get(smallest)) smallest = right;
        if (smallest!=i){
            int temp = arr.get(i);
            arr.set(i, arr.get(smallest));
            arr.set(smallest,temp);
            HeapLibrary.minHeapify(arr, heapEnd, smallest);
        }    
    }
    public static int left(int i) {return 2*i+1;}
    public static int right(int i) {return 2*i+2;}
    public static int parent(int i) {return (int)Math.floor((i-1)/2);}
}

class PriorityQueue{
    public ArrayList<Integer> minHeap;

    public PriorityQueue(int[] arr){
        this.minHeap = new ArrayList<Integer>();
        for (Integer i : arr) this.minHeap.add(i);
        HeapLibrary.buildMinHeap(this.minHeap);
    }
    public int pop(){
        int poped = this.minHeap.get(0);
        this.minHeap.set(0,this.minHeap.get(this.minHeap.size()-1));

        this.minHeap.remove(this.minHeap.size()-1);
        HeapLibrary.minHeapify(this.minHeap, this.minHeap.size()-1, 0);
        return poped;
    }
}

class Solution{
    public static int[] minKElements(int[] intArr,int k){
        //ここから書きましょう
        int[] ans = new int[k];
        PriorityQueue pq = new PriorityQueue(intArr);
        for (int i = 0; i<k; i++) ans[i] = pq.pop();
        return ans;
    }
}
class Main{
    public static void main(String[] args){
        int[] intArr = new int[]{879,487,98,397,610,150,474,977,404,478,623,554,306};
        System.out.println(Arrays.toString(Solution.minKElements(intArr, 8)));
    }
}


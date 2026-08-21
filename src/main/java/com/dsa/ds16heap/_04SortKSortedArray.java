package com.dsa.ds16heap;

import java.util.PriorityQueue;

public class _04SortKSortedArray {


    public static void sortKSortedArray(int[] arr,int k){
        if (arr == null || arr.length==0){
            return;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int heapSize = Math.min(k + 1, arr.length);

        for (int i = 0; i < heapSize; i++) {
            heap.add(arr[i]);
        }

        int index = 0;

        for (int i = k+1; i< arr.length;i++){
            arr[index++] = heap.poll();
            heap.add(arr[i]);
        }

        while (!heap.isEmpty()){
            arr[index++] = heap.poll();
        }

    }
}

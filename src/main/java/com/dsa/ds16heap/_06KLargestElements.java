package com.dsa.ds16heap;

import java.util.PriorityQueue;

public class _06KLargestElements {

    public void kLargestElements(int[] arr,int k){
        if (arr == null || arr.length == 0 || arr.length < k){
            return;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i=0; i< k ;i++){
            heap.add(arr[i]);
        }

        for (int i =k ; i< arr.length ; i++){
            int curr = heap.peek();
            if (arr[i] > curr){
                heap.poll();
                heap.add(arr[i]);
            }
        }

        while (!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }
}

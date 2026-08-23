package com.dsa.ds16heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class _07KClosestElements {
    static class Pair implements Comparable<Pair>{
        int diff;
        int index;
        public Pair(int diff,int index){
            this.diff = diff;
            this.index = index;
        }

        @Override
        public int compareTo(Pair  p) {
            return  this.diff - p.diff;
        }
    }

    public static void kClosestElements(int[] arr, int x, int k){
        if (arr == null || arr.length==0 ||arr.length < k){
            return;
        }

        //Max heap
        PriorityQueue<Pair> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i < k;i++){
            int currDiff = Math.abs(x-arr[i]);
            queue.add(new Pair(currDiff,i));
        }

        for (int i= k; i< arr.length;i++){
            int currDiff = Math.abs(x-arr[i]);
            if (currDiff < queue.peek().diff){
                queue.poll();
                queue.add(new Pair(currDiff,i));
            }
        }

        while (!queue.isEmpty()){
            System.out.println(arr[queue.poll().index]);
        }
    }

    public static void main(String[] args) {

        int[] arr = {10, 15, 7, 3, 4};

        int x = 8;

        int k = 2;

        kClosestElements(arr, x, k);

    }


}

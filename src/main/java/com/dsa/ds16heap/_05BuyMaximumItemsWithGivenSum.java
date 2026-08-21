package com.dsa.ds16heap;

import java.util.PriorityQueue;

public class _05BuyMaximumItemsWithGivenSum {
    public int maxItems(int[] items,int sum){
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i : items){
            heap.add(i);
        }

        int res = 0;

        while (!heap.isEmpty()) {
            int curr = heap.poll();

            if (curr > sum) {
                break;
            }

            sum -= curr;
            res++;
        }

        return res;
    }
}

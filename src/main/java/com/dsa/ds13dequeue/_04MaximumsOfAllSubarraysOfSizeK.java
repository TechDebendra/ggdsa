package com.dsa.ds13dequeue;

import java.util.Deque;
import java.util.LinkedList;

public class _04MaximumsOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        printMax(input,3);
    }

    public static void printMax(int[] arr, int k){
        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException("Invalid Input");
        }

        int n = arr.length;
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i<k ; i++){
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
        }

        for (int i=k ; i<n ; i++){
            System.out.print(arr[dq.peekFirst()]+" ");

            while (!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.removeFirst();
            }

            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
        }

        System.out.print(arr[dq.peek()]);

    }
}

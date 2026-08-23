package com.dsa.ds16heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class _09MedianOfStream {

    public static void  meadian(int[] arr){

        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException("Invalid input!");
        }

        // max heap
        PriorityQueue<Integer> smallHalf = new PriorityQueue<>(Collections.reverseOrder());

        // min heap
        PriorityQueue<Integer> largerHalf = new PriorityQueue<>();

        smallHalf.add(arr[0]);
        System.out.print(smallHalf.peek()+" ");

        for (int i=1; i < arr.length ; i++){
            int x = arr[i];
            if (smallHalf.size() > largerHalf.size()){
                if (x > smallHalf.peek()){
                    largerHalf.add(x);
                }else {
                    largerHalf.add(smallHalf.poll());
                    smallHalf.add(x);
                }
                System.out.print((double)(smallHalf.peek() + largerHalf.peek()) / 2+" ");

            }else {
                if (x <= smallHalf.peek()){
                    smallHalf.add(x);
                }else {
                    largerHalf.add(x);
                    smallHalf.add(largerHalf.poll());
                }

                System.out.print(smallHalf.peek()+" ");

            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {25, 7, 10, 15, 20};
        System.out.println("Input :"+ Arrays.toString(arr));
        System.out.print("Median :");
        meadian(arr);
    }
}

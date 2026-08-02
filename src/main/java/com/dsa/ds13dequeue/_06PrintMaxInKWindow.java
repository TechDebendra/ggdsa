package com.dsa.ds13dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class _06PrintMaxInKWindow {

    public static void main(String[] args) {
        int[] input = {10,4,6,8,14,21,3,10};
        printMaxInKWindow(input,3);
    }


    public static void printMaxInKWindow(int[] arr,int k){
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i=0;i<k;i++){
            while (!deque.isEmpty() && arr[i]>= arr[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        for (int i=k;i<arr.length;i++){
            System.out.print(arr[deque.peekFirst()]+" ");

            while (!deque.isEmpty() && deque.peekFirst()<= i-k){
                deque.pollFirst();
            }

            while (!deque.isEmpty() && arr[i]>= arr[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);

        }
        System.out.print(arr[deque.peekFirst()]+" ");
    }
}

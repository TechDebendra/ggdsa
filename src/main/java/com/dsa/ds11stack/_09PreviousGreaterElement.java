package com.dsa.ds11stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _09PreviousGreaterElement {


    public static void printPreviousGreaterElement(int[] arr){
        if (arr == null || arr.length == 0 ){
            throw new IllegalArgumentException("Invalid Input");
        }
        int n = arr.length;
        int[] prev = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(arr[0]);
        prev[0] = -1;

        for (int i=1 ; i<n ; i++){
            while (!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            int prevGreater = stack.isEmpty() ? -1 : stack.peek();
            prev[i] = prevGreater;
            stack.push(arr[i]);
        }

        System.out.println("Input : "+Arrays.toString(arr));
        System.out.println("Output : "+Arrays.toString(prev));

    }

    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        printPreviousGreaterElement(arr);
    }
}

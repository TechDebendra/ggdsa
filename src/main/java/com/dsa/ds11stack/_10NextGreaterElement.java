package com.dsa.ds11stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _10NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        printNextGreaterElement(arr);
    }

    public static void printNextGreaterElement(int[] arr){
        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException("Invalid Input!");
        }

        int n = arr.length;
        int[] next = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(arr[n-1]);
        next[n-1] = -1;

        for (int i=n-2 ; i>=0 ;i--){
            while (!stack.isEmpty() && arr[i]>=stack.peek()){
                stack.pop();
            }
            int res = stack.isEmpty() ? -1 : stack.peek();
            next[i] = res;
            stack.push(arr[i]);
        }

        System.out.println("Input : "+ Arrays.toString(arr));
        System.out.println("Output : "+Arrays.toString(next));

    }
}

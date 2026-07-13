package com.dsa.ds11stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class _08StockSpanProblemUsingStack {

    public static int[] span(int[] arr){
        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        int n = arr.length;
        int[] span = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        span[0]=1;

        for (int i=1 ; i<n ; i++){
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            int sp = stack.isEmpty() ? i+1 : i-stack.peek();
            span[i] = sp;
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        int[] result = span(prices);

        System.out.println("Prices:");
        for (int price : prices) {
            System.out.print(price + " ");
        }

        System.out.println();

        System.out.println("Span:");
        for (int s : result) {
            System.out.print(s + " ");
        }
    }


}

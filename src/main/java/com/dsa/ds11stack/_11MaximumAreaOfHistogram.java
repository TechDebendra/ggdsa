package com.dsa.ds11stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class _11MaximumAreaOfHistogram {
    public static void main(String[] args) {
        int[] hist = new int[]{ 6, 2, 5, 4, 5, 1, 6 };

        System.out.println("Maximum area is "
                + getMaxArea(hist));
    }

    public static int getMaxArea(int[] arr){
        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException("Invalid Input!");
        }
        int result = 0;
        int index;
        int currentArea;
        int n = arr.length;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i=0 ; i<n ; i++){

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                index = stack.pop();
                currentArea = arr[index]* (stack.isEmpty() ? i : i-stack.peek()-1);
                result = Math.max(result,currentArea);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            index = stack.pop();
            currentArea = arr[index] * (stack.isEmpty() ? n : n-stack.peek()-1);
            result = Math.max(currentArea, result);
        }

        return result;
    }
}

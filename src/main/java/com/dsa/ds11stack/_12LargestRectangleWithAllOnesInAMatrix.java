package com.dsa.ds11stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class _12LargestRectangleWithAllOnesInAMatrix {
    public static void main(String[] args) {
        int[][] A = {
                { 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
        };
        System.out.print("Area of maximum rectangle is "
                + maxRectangleWithOnes(A));
    }


    public static int maxRectangleWithOnes(int[][] matrix){
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int result;
        int R = matrix.length;
        int C = matrix[0].length;
        int[] hist = new int[C];

        for (int i=0;i<C;i++){
            hist[i] = matrix[0][i];
        }

        result = largestHistogramArea(hist);

        for (int i=1;i<R;i++){
            for (int j=0;j<C;j++){
                if (matrix[i][j]==0){
                    hist[j]=0;
                }else {
                    hist[j]++;
                }
            }
            int current = largestHistogramArea(hist);
            result = Math.max(result,current);
        }

        return result;
    }

    public static int largestHistogramArea(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int result =0;
        int index;
        int currentArea;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = arr.length;

        for (int i=0;i<n;i++){
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                index = stack.pop();
                currentArea = arr[index] * (stack.isEmpty() ? i : i-stack.peek()-1);
                result = Math.max(result,currentArea);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            index = stack.pop();
            currentArea = arr[index] * (stack.isEmpty() ? n : n- stack.peek()-1);
            result = Math.max(result,currentArea);
        }

        return result;
    }
}

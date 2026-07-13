package com.dsa.ds11stack;

public class _07StockSpanProblem_Naive {
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

    public static int[] span(int[] arr){
        if (arr == null || arr.length == 0){
           throw new IllegalArgumentException("Invalid input");
        }
        int n = arr.length;
        int[]  span = new int[n];
        span[0] =1;
        for (int i=1;i<n;i++){
            span[i] = 1;
            for (int j= i-1;j>=0 && arr[j] <= arr[i];j--){
                span[i]++;
            }
        }

        return span;
    }
}

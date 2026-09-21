package com.dsa.ds20dynamicprograming;

public class _02FibonancciSeries {

    public static int fibonacci(int n) {

        if (n <= 1) {
            return n;
        }

        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }

        return table[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(6)); // 8
    }
}
package com.dsa.ds20dynamicprograming;

import java.util.Arrays;

public class _01FibonancciSeries {

    public static int N = 10;
    public static int[] memory = new int[N + 1];

    public static int fibonancci(int n) {

        if (memory[n] == -1) {   // Calculate only if not already computed

            if (n == 0 || n == 1) {
                memory[n] = n;
            } else {
                memory[n] = fibonancci(n - 1) + fibonancci(n - 2);
            }
        }

        return memory[n];
    }

    public static void main(String[] args) {

        Arrays.fill(memory, -1);

        System.out.println(fibonancci(N));

        // Print series
        for (int i = 0; i <= N; i++) {
            System.out.print(fibonancci(i) + " ");
        }
    }
}
package com.dsa.ds4array;

public class _03PrefixSumDemo {
    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 6, 5, 9, 1};
        int len = arr.length;

        int[] prefixSum = new int[len];

        prefixSum[0] = arr[0];

        for (int i = 1; i < len; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        printRangeSum(prefixSum, 0, 4);
        printRangeSum(prefixSum, 0, 3);
        printRangeSum(prefixSum, 2, 4);
        printRangeSum(prefixSum, 1, 3);
    }

    /**
     * Prints the sum of elements in the range [l, r]
     * using the prefix sum array.
     *
     * @param prefixSum prefix sum array
     * @param l left index (inclusive)
     * @param r right index (inclusive)
     */
    public static void printRangeSum(int[] prefixSum, int l, int r) {
        int sum;

        if (l == 0) {
            sum = prefixSum[r];
        } else {
            sum = prefixSum[r] - prefixSum[l - 1];
        }

        System.out.println(sum);
    }
}
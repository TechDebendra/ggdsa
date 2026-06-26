package com.dsa.ds6sorting;

import java.util.Arrays;

public class _11NaivePartition {

    public static void main(String[] args) {

        // Test Case 1: Normal Case
        test(new int[]{5, 13, 6, 9, 12, 8, 11}, 0, 6);

        // Test Case 2: Pivot is Smallest
        test(new int[]{9, 8, 7, 1}, 0, 3);

        // Test Case 3: Pivot is Largest
        test(new int[]{4, 1, 7, 9}, 0, 3);

        // Test Case 4: Duplicate Elements
        test(new int[]{5, 3, 8, 5, 2, 5}, 0, 5);

        // Test Case 5: All Elements Same
        test(new int[]{7, 7, 7, 7}, 0, 3);

        // Test Case 6: Single Element
        test(new int[]{10}, 0, 0);

        // Test Case 7: Two Elements
        test(new int[]{8, 5}, 0, 1);

        // Test Case 8: Partition a Subarray
        test(new int[]{20, 15, 5, 18, 10, 30}, 1, 4);

        // Test Case 9: Negative Numbers
        test(new int[]{-3, 8, -1, 5, -2}, 0, 4);

        // Test Case 10: Already Partitioned
        test(new int[]{1, 2, 3, 8, 6}, 0, 4);
    }

    /**
     * Naive Partition Algorithm
     *
     * Time Complexity  : O(n)
     * Auxiliary Space  : O(n)
     * Stable           : Yes
     *
     * Partitions the array around the last element (pivot).
     */
    public static void naivePartition(int[] arr, int low, int high) {

        int[] temp = new int[high - low + 1];
        int index = 0;

        int pivotValue = arr[high];

        // Copy elements <= pivot (excluding pivot itself)
        for (int i = low; i <= high; i++) {
            if (i != high && arr[i] <= pivotValue) {
                temp[index++] = arr[i];
            }
        }

        // Copy pivot
        temp[index++] = pivotValue;

        // Copy elements > pivot
        for (int i = low; i <= high; i++) {
            if (arr[i] > pivotValue) {
                temp[index++] = arr[i];
            }
        }

        // Copy back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }

    /**
     * Helper method to execute and print test results.
     */
    public static void test(int[] arr, int low, int high) {

        System.out.println("------------------------------------------");
        System.out.println("Input  : " + Arrays.toString(arr));
        System.out.println("Low    : " + low);
        System.out.println("High   : " + high);

        naivePartition(arr, low, high);

        System.out.println("Output : " + Arrays.toString(arr));
        System.out.println();
    }



}
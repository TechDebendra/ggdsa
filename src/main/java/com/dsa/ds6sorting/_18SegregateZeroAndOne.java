package com.dsa.ds6sorting;

import java.util.Arrays;

public class _18SegregateZeroAndOne {

    public static void main(String[] args) {

        // Test Case 1: Alternating 0s and 1s
        test(new int[]{0, 1, 0, 1, 0, 1});

        // Test Case 2: Starts with 1
        test(new int[]{1, 0, 1, 0, 1, 0});

        // Test Case 3: All 0s
        test(new int[]{0, 0, 0, 0});

        // Test Case 4: All 1s
        test(new int[]{1, 1, 1, 1});

        // Test Case 5: Single 0
        test(new int[]{0});

        // Test Case 6: Single 1
        test(new int[]{1});

        // Test Case 7: Already Segregated
        test(new int[]{0, 0, 0, 1, 1, 1});

        // Test Case 8: Reverse Segregated
        test(new int[]{1, 1, 1, 0, 0, 0});

        // Test Case 9: Two Elements
        test(new int[]{0, 1});

        // Test Case 10: Two Elements (Reverse)
        test(new int[]{1, 0});

        // Test Case 11: Mixed
        test(new int[]{1, 0, 0, 1, 1, 0, 1, 0});

        // Test Case 12: Empty Array
        test(new int[]{});
    }

    /**
     * Segregates all 0s to the left and all 1s to the right.
     *
     * Approach : Hoare Partition
     * Time Complexity : O(n)
     * Auxiliary Space : O(1)
     */
    public static void segregate(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        int i = -1;
        int j = arr.length;

        while (true) {

            do {
                i++;
            } while (i < arr.length && arr[i] == 0);

            do {
                j--;
            } while (j >= 0 && arr[j] == 1);

            if (i >= j) {
                return;
            }

            swap(arr, i, j);
        }
    }

    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void test(int[] arr) {

        System.out.println("--------------------------------------");
        System.out.println("Input  : " + Arrays.toString(arr));

        segregate(arr);

        System.out.println("Output : " + Arrays.toString(arr));
    }
}
package com.dsa.ds6sorting;
import java.util.Arrays;

public class _19DutchNationalFlagProblem {

    public static void main(String[] args) {

        // Test Case 1: Mixed
        test(new int[]{0, 1, 2, 1, 0, 2, 1, 0});

        // Test Case 2: Reverse Order
        test(new int[]{2, 2, 1, 1, 0, 0});

        // Test Case 3: Already Sorted
        test(new int[]{0, 0, 1, 1, 2, 2});

        // Test Case 4: All 0s
        test(new int[]{0, 0, 0, 0});

        // Test Case 5: All 1s
        test(new int[]{1, 1, 1, 1});

        // Test Case 6: All 2s
        test(new int[]{2, 2, 2, 2});

        // Test Case 7: Single Element
        test(new int[]{0});
        test(new int[]{1});
        test(new int[]{2});

        // Test Case 8: Two Elements
        test(new int[]{2, 0});
        test(new int[]{1, 0});
        test(new int[]{2, 1});

        // Test Case 9: Empty Array
        test(new int[]{});

        // Test Case 10: Random
        test(new int[]{2, 0, 2, 1, 1, 0});

        // Test Case 11: Mixed
        test(new int[]{2, 1, 0, 2, 1, 0, 1, 2, 0});
    }

    public static void sort012(int[] arr) {

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            switch (arr[mid]) {

                case 0:
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void test(int[] arr) {

        System.out.println("--------------------------------");
        System.out.println("Input  : " + Arrays.toString(arr));

        sort012(arr);

        System.out.println("Output : " + Arrays.toString(arr));
    }
}
package com.dsa.ds6sorting;

import java.util.Arrays;

public class _05InsertionSort {

    public static void main(String[] args) {

        // Test Case 1: Random order
        int[] arr1 = {12, 11, 13, 5, 6};
        test(arr1);

        // Test Case 2: Already sorted
        int[] arr2 = {1, 2, 3, 4, 5};
        test(arr2);

        // Test Case 3: Reverse sorted
        int[] arr3 = {5, 4, 3, 2, 1};
        test(arr3);

        // Test Case 4: Single element
        int[] arr4 = {10};
        test(arr4);

        // Test Case 5: Empty array
        int[] arr5 = {};
        test(arr5);

        // Test Case 6: Duplicate elements
        int[] arr6 = {4, 2, 2, 8, 1, 4};
        test(arr6);

        // Test Case 7: Negative numbers
        int[] arr7 = {-3, -1, -7, 2, 5, 0};
        test(arr7);

        // Test Case 8: All same elements
        int[] arr8 = {7, 7, 7, 7};
        test(arr8);

        // Test Case 9: Mixed positive and negative
        int[] arr9 = {3, -2, 5, 0, -1};
        test(arr9);
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    private static void test(int[] arr) {
        System.out.println("Before: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After : " + Arrays.toString(arr));
        System.out.println("--------------------------------");
    }
}
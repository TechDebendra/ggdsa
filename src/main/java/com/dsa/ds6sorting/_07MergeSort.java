package com.dsa.ds6sorting;

import java.util.Arrays;

public class _07MergeSort {

    public static void main(String[] args) {

        test(new int[]{5, 2, 8, 1, 3});
        test(new int[]{10});
        test(new int[]{});
        test(new int[]{5, 4, 3, 2, 1});
        test(new int[]{1, 2, 3, 4, 5});
        test(new int[]{7, 7, 7, 7});
        test(new int[]{9, -2, 5, -8, 3, 0});
        test(new int[]{4, 2, 2, 8, 3, 3, 1});
    }

    private static void test(int[] arr) {
        System.out.println("--------------------------------");

        System.out.println("Before : " + Arrays.toString(arr));

        if (arr.length > 0) {
            mergeSort(arr, 0, arr.length - 1);
        }

        System.out.println("After  : " + Arrays.toString(arr));
    }

    /**
     * Sorts the array using Merge Sort.
     * Time Complexity : O(n log n)
     * Space Complexity: O(n)
     */
    public static void mergeSort(int[] arr, int low, int high) {

        if (low < high) {

            int mid = low + (high - low) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    /**
     * Merges two sorted subarrays.
     * Left : l to m
     * Right: m+1 to r
     */
    public static void merge(int[] arr, int low, int middle, int high) {

        int n1 = middle - low + 1;
        int n2 = high - middle;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }

        for (int j = 0; j < n2; j++) {
            right[j] = arr[middle + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = low;

        while (i < n1 && j < n2) {

            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }

        while (j < n2) {
            arr[k++] = right[j++];
        }
    }
}
package com.dsa.ds4array;

import java.util.Arrays;

/**
 * Merges two sorted arrays into a single sorted array.
 */
public class _06MergeTwoSortedArrays {

    public static void main(String[] args) {

        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        System.out.println(Arrays.toString(mergeSortedArray(arr1, arr2)));

        int[] arr3 = {1, 2, 3};
        int[] arr4 = {4, 5, 6};

        System.out.println(Arrays.toString(mergeSortedArray(arr3, arr4)));

        int[] arr5 = {4, 5, 6};
        int[] arr6 = {1, 2, 3};

        System.out.println(Arrays.toString(mergeSortedArray(arr5, arr6)));

        int[] arr7 = {1, 3, 5};
        int[] arr8 = {};

        System.out.println(Arrays.toString(mergeSortedArray(arr7, arr8)));
    }

    /**
     * Merges two sorted arrays.
     *
     * @param arr1 first sorted array
     * @param arr2 second sorted array
     * @return merged sorted array
     */
    public static int[] mergeSortedArray(int[] arr1, int[] arr2) {

        int m = arr1.length;
        int n = arr2.length;

        int i = 0;
        int j = 0;
        int k = 0;

        int[] result = new int[m + n];

        while (i < m && j < n) {

            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < m) {
            result[k++] = arr1[i++];
        }

        while (j < n) {
            result[k++] = arr2[j++];
        }

        return result;
    }
}
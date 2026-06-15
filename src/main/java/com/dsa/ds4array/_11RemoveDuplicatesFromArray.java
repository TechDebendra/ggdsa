package com.dsa.ds4array;

import java.util.Arrays;

public class _11RemoveDuplicatesFromArray {

    public static void main(String[] args) {

        test(new int[]{10, 20, 20, 30, 30, 40});
        test(new int[]{10, 10, 10, 10});
        test(new int[]{10, 20, 30, 40});
        test(new int[]{10});
        test(new int[]{});
    }

    private static void test(int[] arr) {
        int size = removeDuplicates(arr);

        System.out.print("Unique Elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * Removes duplicate elements from a sorted array in-place.
     *
     * Only the first returnedSize elements of the array
     * contain the unique values after processing.
     *
     * Example:
     * [10,20,20,30,30,40]
     * becomes
     * [10,20,30,40,...]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param arr sorted input array
     * @return number of unique elements
     * @throws IllegalArgumentException if arr is null
     */
    public static int removeDuplicates(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (arr.length == 0) {
            return 0;
        }

        int res = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[res - 1]) {
                arr[res] = arr[i];
                res++;
            }
        }

        return res;
    }
}
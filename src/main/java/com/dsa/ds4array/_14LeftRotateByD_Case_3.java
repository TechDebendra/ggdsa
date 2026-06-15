package com.dsa.ds4array;

import java.util.Arrays;

public class _14LeftRotateByD_Case_3 {

    public static void main(String[] args) {

        // Normal cases
        int[] arr1 = {1, 2, 3, 4, 5};
        rotateByD(arr1, 2);
        System.out.println(Arrays.toString(arr1));
        // [3, 4, 5, 1, 2]

        int[] arr2 = {10, 20, 30, 40, 50};
        rotateByD(arr2, 3);
        System.out.println(Arrays.toString(arr2));
        // [40, 50, 10, 20, 30]

        // d == n
        int[] arr3 = {1, 2, 3, 4, 5};
        rotateByD(arr3, 5);
        System.out.println(Arrays.toString(arr3));
        // [1, 2, 3, 4, 5]

        // d > n
        int[] arr4 = {1, 2, 3, 4, 5};
        rotateByD(arr4, 7);
        System.out.println(Arrays.toString(arr4));
        // [3, 4, 5, 1, 2]

        // Single element
        int[] arr5 = {100};
        rotateByD(arr5, 10);
        System.out.println(Arrays.toString(arr5));
        // [100]

        // Empty array
        int[] arr6 = {};
        rotateByD(arr6, 3);
        System.out.println(Arrays.toString(arr6));
        // []

        // Null array
        try {
            rotateByD(null, 2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Negative d
        try {
            rotateByD(new int[]{1, 2, 3}, -1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Rotates the given array to the left by d positions
     * using the Reversal Algorithm.
     *
     * Example:
     * Input : [1, 2, 3, 4, 5], d = 2
     * Output: [3, 4, 5, 1, 2]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param arr input array
     * @param d number of positions to rotate
     * @throws IllegalArgumentException if array is null
     *                                  or d is negative
     */
    public static void rotateByD(int[] arr, int d) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (d < 0) {
            throw new IllegalArgumentException(
                    "Rotation count cannot be negative");
        }

        if (arr.length <= 1) {
            return;
        }

        d = d % arr.length;

        if (d == 0) {
            return;
        }

        reverse(arr, 0, d - 1);
        reverse(arr, d, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    /**
     * Reverses elements in the array between the
     * specified indices (inclusive).
     *
     * @param arr input array
     * @param low starting index
     * @param high ending index
     */
    public static void reverse(int[] arr, int low, int high) {

        while (low < high) {

            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low++;
            high--;
        }
    }
}
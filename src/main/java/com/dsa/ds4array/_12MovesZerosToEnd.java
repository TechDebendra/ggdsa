package com.dsa.ds4array;

import java.util.Arrays;

public class _12MovesZerosToEnd {

    public static void main(String[] args) {

        // Normal case
        System.out.println(Arrays.toString(
                moveZeros(new int[]{8, 5, 0, 10, 0, 20})));
        // [8, 5, 10, 20, 0, 0]

        // Zeros at beginning
        System.out.println(Arrays.toString(
                moveZeros(new int[]{0, 0, 0, 1, 2})));
        // [1, 2, 0, 0, 0]

        // No zeros
        System.out.println(Arrays.toString(
                moveZeros(new int[]{1, 2, 3, 4})));
        // [1, 2, 3, 4]

        // All zeros
        System.out.println(Arrays.toString(
                moveZeros(new int[]{0, 0, 0, 0})));
        // [0, 0, 0, 0]

        // Single element (non-zero)
        System.out.println(Arrays.toString(
                moveZeros(new int[]{5})));
        // [5]

        // Single element (zero)
        System.out.println(Arrays.toString(
                moveZeros(new int[]{0})));
        // [0]

        // Empty array
        System.out.println(Arrays.toString(
                moveZeros(new int[]{})));
        // []

        // Alternating zeros
        System.out.println(Arrays.toString(
                moveZeros(new int[]{0, 1, 0, 2, 0, 3})));
        // [1, 2, 3, 0, 0, 0]

        // Negative numbers
        System.out.println(Arrays.toString(
                moveZeros(new int[]{-1, 0, -2, 0, -3})));
        // [-1, -2, -3, 0, 0]

        // Null array
        try {
            moveZeros(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            // Array cannot be null
        }
    }

    /**
     * Moves all zero elements to the end of the array while preserving
     * the relative order of non-zero elements.
     *
     * Example:
     * Input : [8, 5, 0, 10, 0, 20]
     * Output: [8, 5, 10, 20, 0, 0]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param arr the input array
     * @return the same array after moving all zeros to the end
     * @throws IllegalArgumentException if the input array is null
     */
    public static int[] moveZeros(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {

                if (count != i) {
                    int temp = arr[count];
                    arr[count] = arr[i];
                    arr[i] = temp;
                }

                count++;
            }
        }

        return arr;
    }
}
package com.dsa.ds4array;

import java.util.Arrays;

public class _13LeftRotateByOne {

    public static void main(String[] args) {

        // Normal case
        System.out.println(Arrays.toString(
                rotate(new int[]{10, 20, 30, 40, 50})));
        // [20, 30, 40, 50, 10]

        // Two elements
        System.out.println(Arrays.toString(
                rotate(new int[]{1, 2})));
        // [2, 1]

        // Single element
        System.out.println(Arrays.toString(
                rotate(new int[]{100})));
        // [100]

        // Duplicate elements
        System.out.println(Arrays.toString(
                rotate(new int[]{1, 1, 2, 2, 3})));
        // [1, 2, 2, 3, 1]

        // Negative numbers
        System.out.println(Arrays.toString(
                rotate(new int[]{-1, -2, -3, -4})));
        // [-2, -3, -4, -1]

        // Empty array
        System.out.println(Arrays.toString(
                rotate(new int[]{})));
        // []

        // Null array
        try {
            rotate(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            // Array cannot be null
        }
    }

    /**
     * Rotates the given array to the left by one position.
     *
     * Example:
     * Input : [10, 20, 30, 40, 50]
     * Output: [20, 30, 40, 50, 10]
     *
     * The rotation is performed in-place.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param arr the input array
     * @return the same array after left rotation by one position
     * @throws IllegalArgumentException if the array is null
     */
    public static int[] rotate(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (arr.length <= 1) {
            return arr;
        }

        int temp = arr[0];

        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        arr[arr.length - 1] = temp;

        return arr;
    }
}
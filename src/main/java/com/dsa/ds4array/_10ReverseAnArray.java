package com.dsa.ds4array;

import java.util.Arrays;

public class _10ReverseAnArray {

    public static void main(String[] args) {

        // Normal cases
        System.out.println(Arrays.toString(
                reverse(new int[]{1, 2, 3, 4, 5}))); // [5, 4, 3, 2, 1]

        System.out.println(Arrays.toString(
                reverse(new int[]{10, 20, 30, 40}))); // [40, 30, 20, 10]

        // Odd number of elements
        System.out.println(Arrays.toString(
                reverse(new int[]{1, 2, 3, 4, 5, 6, 7}))); // [7, 6, 5, 4, 3, 2, 1]

        // Single element
        System.out.println(Arrays.toString(
                reverse(new int[]{10}))); // [10]

        // Empty array
        System.out.println(Arrays.toString(
                reverse(new int[]{}))); // []

        // Duplicate elements
        System.out.println(Arrays.toString(
                reverse(new int[]{1, 2, 2, 3, 3}))); // [3, 3, 2, 2, 1]

        // Negative numbers
        System.out.println(Arrays.toString(
                reverse(new int[]{-1, -2, -3, -4}))); // [-4, -3, -2, -1]

        // Null array
        try {
            reverse(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Array cannot be null
        }
    }

    /**
     * Reverses the given array in-place.
     *
     * Example:
     * [1, 2, 3, 4] -> [4, 3, 2, 1]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param arr the input array
     * @return the reversed array
     * @throws IllegalArgumentException if the array is null
     */
    public static int[] reverse(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low++;
            high--;
        }

        return arr;
    }
}
package com.dsa.ds4array;

public class _09SortedArrayOrNot {

    public static void main(String[] args) {

        // Sorted arrays
        System.out.println(isSorted(new int[]{1, 2, 3, 4, 5}));      // true
        System.out.println(isSorted(new int[]{1, 1, 2, 2, 3}));      // true
        System.out.println(isSorted(new int[]{-5, -3, -1, 0, 2}));   // true

        // Unsorted arrays
        System.out.println(isSorted(new int[]{5, 4, 3, 2, 1}));      // false
        System.out.println(isSorted(new int[]{1, 2, 5, 4, 6}));      // false
        System.out.println(isSorted(new int[]{10, 20, 30, 25}));     // false

        // Edge cases
        System.out.println(isSorted(new int[]{10}));                  // true
        System.out.println(isSorted(new int[]{}));                    // true
        System.out.println(isSorted(new int[]{7, 7, 7, 7}));         // true

        // Null array test
        try {
            System.out.println(isSorted(null));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Array cannot be null
        }
    }

    /**
     * Checks whether the given array is sorted in
     * non-decreasing (ascending) order.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param arr the input array
     * @return true if the array is sorted, otherwise false
     * @throws IllegalArgumentException if the array is null
     */
    public static boolean isSorted(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (arr.length < 2) {
            return true;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }

        return true;
    }
}
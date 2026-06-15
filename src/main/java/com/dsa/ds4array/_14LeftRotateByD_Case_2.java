package com.dsa.ds4array;

import java.util.Arrays;

public class _14LeftRotateByD_Case_2 {

    public static void main(String[] args) {

        // Normal cases
        System.out.println(Arrays.toString(
                rotateByD(new int[]{1, 2, 3, 4, 5}, 2)));
        // [3, 4, 5, 1, 2]

        System.out.println(Arrays.toString(
                rotateByD(new int[]{10, 20, 30, 40, 50}, 3)));
        // [40, 50, 10, 20, 30]

        // d == n
        System.out.println(Arrays.toString(
                rotateByD(new int[]{1, 2, 3, 4, 5}, 5)));
        // [1, 2, 3, 4, 5]

        // d > n
        System.out.println(Arrays.toString(
                rotateByD(new int[]{1, 2, 3, 4, 5}, 7)));
        // [3, 4, 5, 1, 2]

        // Single element
        System.out.println(Arrays.toString(
                rotateByD(new int[]{100}, 10)));
        // [100]

        // Empty array
        System.out.println(Arrays.toString(
                rotateByD(new int[]{}, 3)));
        // []

        // Null array
        try {
            rotateByD(null, 2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Negative rotation
        try {
            rotateByD(new int[]{1, 2, 3}, -1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Rotates the array to the left by d positions using
     * a temporary array.
     *
     * Example:
     * Input : [1, 2, 3, 4, 5], d = 2
     * Output: [3, 4, 5, 1, 2]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(d)
     *
     * @param arr input array
     * @param d number of positions to rotate
     * @return rotated array
     * @throws IllegalArgumentException if array is null or d is negative
     */
    public static int[] rotateByD(int[] arr, int d) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (d < 0) {
            throw new IllegalArgumentException(
                    "Rotation count cannot be negative");
        }

        if (arr.length <= 1) {
            return arr;
        }

        d = d % arr.length;

        if (d == 0) {
            return arr;
        }

        int[] temp = new int[d];

        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        for (int i = d; i < arr.length; i++) {
            arr[i - d] = arr[i];
        }

        for (int i = 0; i < d; i++) {
            arr[arr.length - d + i] = temp[i];
        }

        return arr;
    }
}
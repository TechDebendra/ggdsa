package com.dsa.ds4array;

import java.util.Arrays;

public class _14LeftRotateByD_Case_1 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(
                rotateByD(new int[]{1, 2, 3, 4, 5}, 2)));
        // [3, 4, 5, 1, 2]

        System.out.println(Arrays.toString(
                rotateByD(new int[]{10, 20, 30, 40, 50}, 3)));
        // [40, 50, 10, 20, 30]

        System.out.println(Arrays.toString(
                rotateByD(new int[]{1, 2, 3, 4, 5}, 5)));
        // [1, 2, 3, 4, 5]

        System.out.println(Arrays.toString(
                rotateByD(new int[]{1, 2, 3, 4, 5}, 7)));
        // [3, 4, 5, 1, 2]

        System.out.println(Arrays.toString(
                rotateByD(new int[]{100}, 10)));
        // [100]

        System.out.println(Arrays.toString(
                rotateByD(new int[]{}, 3)));
        // []

        try {
            rotateByD(null, 2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int[] oneRotate(int[] arr) {

        int temp = arr[0];

        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        arr[arr.length - 1] = temp;

        return arr;
    }

    /**
     * Rotates an array to the left by d positions.
     *
     * Time Complexity: O(n * d)
     * Space Complexity: O(1)
     */
    public static int[] rotateByD(int[] arr, int d) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (arr.length <= 1) {
            return arr;
        }

        d = d % arr.length;

        for (int i = 0; i < d; i++) {
            oneRotate(arr);
        }

        return arr;
    }
}
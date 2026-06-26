package com.dsa.ds6sorting;

import java.util.Arrays;

public class _16MinimumDifferenceInArray {

    public static void main(String[] args) {

        test(new int[]{1, 8, 12, 5, 18});
        test(new int[]{5, 3, 8, 2});
        test(new int[]{10, 20});
        test(new int[]{7, 7, 7, 7});
        test(new int[]{-10, -5, 0, 8});
        test(new int[]{100});
        test(new int[]{});
        test(new int[]{4, 9, 1, 32, 13});
        test(new int[]{2, 1});
        test(new int[]{1000, 100, 10, 1});
    }

    public static int minDifference(int[] arr) {

        if (arr == null || arr.length < 2) {
            return -1;
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i] - arr[i - 1]);
        }

        return min;
    }

    public static void test(int[] arr) {

        System.out.println("--------------------------------");
        System.out.println("Input : " + Arrays.toString(arr));

        int ans = minDifference(arr);

        System.out.println("Output: " + ans);
    }
}
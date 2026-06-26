package com.dsa.ds6sorting;

import java.util.Arrays;

public class _17ChocolateDistributionProblem {

    public static void main(String[] args) {

        test(new int[]{7, 3, 2, 4, 9, 12, 56}, 3);

        test(new int[]{3, 4, 1, 9, 56, 7, 9, 12}, 5);

        test(new int[]{12, 4, 7, 9, 2, 23, 25, 41, 30}, 5);

        test(new int[]{5, 8, 6}, 1);

        test(new int[]{5, 8, 6}, 3);

        test(new int[]{5, 8, 6}, 4);

        test(new int[]{7, 7, 7, 7}, 2);

        test(new int[]{1}, 1);

        test(new int[]{10, 20}, 2);

        test(new int[]{10, 20}, 1);
    }

    public static int chocolateDistribution(int[] arr, int m) {

        if (arr == null || arr.length == 0 || m <= 0 || m > arr.length) {
            return -1;
        }

        if (m == 1) {
            return 0;
        }

        Arrays.sort(arr);

        int minDifference = Integer.MAX_VALUE;

        for (int i = 0; i <= arr.length - m; i++) {

            int difference = arr[i + m - 1] - arr[i];

            minDifference = Math.min(minDifference, difference);
        }

        return minDifference;
    }

    public static void test(int[] arr, int m) {

        System.out.println("-------------------------------------");
        System.out.println("Packets : " + Arrays.toString(arr));
        System.out.println("Students: " + m);

        int ans = chocolateDistribution(arr, m);

        System.out.println("Minimum Difference = " + ans);
    }
}

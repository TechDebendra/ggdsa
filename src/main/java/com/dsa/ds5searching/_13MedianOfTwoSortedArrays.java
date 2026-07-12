package com.dsa.ds5searching;

/**
 * Finds the median of two sorted arrays using Binary Search.
 *
 * Time Complexity: O(log(min(n, m)))
 * Space Complexity: O(1)
 *
 * Assumption:
 * - Both arrays are sorted.
 * - At least one array is non-empty.
 */
public class _13MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] arr1 = {1, 3};
        int[] arr2 = {2};
        System.out.println(median(arr1, arr2)); // 2.0

        int[] arr3 = {1, 2};
        int[] arr4 = {3, 4};
        System.out.println(median(arr3, arr4)); // 2.5

        int[] arr5 = {1, 3, 8};
        int[] arr6 = {7, 9, 10, 11};
        System.out.println(median(arr5, arr6)); // 8.0

        int[] arr7 = {1};
        int[] arr8 = {2, 3, 4, 5};
        System.out.println(median(arr7, arr8)); // 3.0

        int[] arr9 = {};
        int[] arr10 = {1};
        System.out.println(median(arr9, arr10)); // 1.0

        int[] arr11 = {1, 2, 3};
        int[] arr12 = {4, 5, 6, 7};
        System.out.println(median(arr11, arr12)); // 4.0

        int[] arr13 = {-5, -3, -1};
        int[] arr14 = {2, 4, 6};
        System.out.println(median(arr13, arr14)); // 0.5
    }

    /**
     * Finds the median of two sorted arrays.
     *
     * @param arr1 First sorted array
     * @param arr2 Second sorted array
     * @return Median value
     */
    public static double median(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int m = arr2.length;

        // Ensure first array is smaller
        if (n > m) {
            return median(arr2, arr1);
        }

        int start = 0;
        int end = n;

        while (start <= end) {

            int a = start + (end - start) / 2;  // Mid of longest array
            int b = (n + m + 1) / 2 - a;        // (n + m + 1) / 2 is the mid of result array after merging two arrays

            int min1 = (a == n) ? Integer.MAX_VALUE : arr1[a];
            int max1 = (a == 0) ? Integer.MIN_VALUE : arr1[a - 1];

            int min2 = (b == m) ? Integer.MAX_VALUE : arr2[b];
            int max2 = (b == 0) ? Integer.MIN_VALUE : arr2[b - 1];

            if (max1 <= min2 && max2 <= min1) {

                if ((n + m) % 2 == 0) {

                    return ((double) Math.max(max1, max2)
                            + (double) Math.min(min1, min2)) / 2.0;

                } else {

                    return Math.max(max1, max2);
                }

            } else if (max1 > min2) {

                end = a - 1;

            } else {

                start = a + 1;
            }
        }

        throw new IllegalArgumentException(
                "Input arrays are not sorted correctly.");
    }
}
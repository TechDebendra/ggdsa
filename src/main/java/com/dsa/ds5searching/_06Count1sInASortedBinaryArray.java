package com.dsa.ds5searching;

/**
 * Counts the number of 1s in a sorted binary array.
 *
 * The array must contain only 0s and 1s and be sorted
 * in non-decreasing order.
 *
 * Examples:
 * [0, 0, 1, 1, 1] -> 3
 * [1, 1, 1, 1] -> 4
 * [0, 0, 0, 0] -> 0
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class _06Count1sInASortedBinaryArray {

    public static void main(String[] args) {

        int[] arr1 = {0, 0, 0, 1, 1, 1};
        System.out.println(countOne(arr1)); // 3

        int[] arr2 = {0, 0, 1, 1, 1, 1};
        System.out.println(countOne(arr2)); // 4

        int[] arr3 = {1, 1, 1, 1};
        System.out.println(countOne(arr3)); // 4

        int[] arr4 = {0, 0, 0, 0};
        System.out.println(countOne(arr4)); // 0

        int[] arr5 = {0};
        System.out.println(countOne(arr5)); // 0

        int[] arr6 = {1};
        System.out.println(countOne(arr6)); // 1

        int[] arr7 = {};
        System.out.println(countOne(arr7)); // 0

        int[] arr8 = {0, 1};
        System.out.println(countOne(arr8)); // 1

        int[] arr9 = {0, 0, 0, 0, 0, 1};
        System.out.println(countOne(arr9)); // 1
    }

    /**
     * Counts the number of 1s in a sorted binary array.
     *
     * @param arr Sorted binary array containing only 0s and 1s
     * @return Number of 1s present in the array
     */
    public static int countOne(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == 1) {

                if (mid == 0 || arr[mid - 1] == 0) {
                    return arr.length - mid;
                }

                end = mid - 1;

            } else {

                start = mid + 1;
            }
        }

        return 0;
    }
}
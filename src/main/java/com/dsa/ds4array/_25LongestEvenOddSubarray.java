package com.dsa.ds4array;

/**
 * Longest Even-Odd Subarray.
 *
 * <p>Given an array of integers, find the length of the longest
 * contiguous subarray where even and odd elements alternate.
 *
 * <p>Examples:
 * <pre>
 * [10, 12, 14]      -> 1
 * [5, 10, 20, 6, 3] -> 2
 * [5, 10, 3, 8, 7]  -> 5
 * </pre>
 *
 * <p>Time Complexity: O(n)
 * <br>Space Complexity: O(1)
 */
public class _25LongestEvenOddSubarray {

    public static void main(String[] args) {

        int[] arr1 = {5, 10, 20, 6, 3, 8};
        System.out.println("Test 1: " + longestSubArray(arr1));
        // Expected: 3

        int[] arr2 = {10, 12, 14, 16};
        System.out.println("Test 2: " + longestSubArray(arr2));
        // Expected: 1

        int[] arr3 = {5, 10, 3, 8, 7};
        System.out.println("Test 3: " + longestSubArray(arr3));
        // Expected: 5

        int[] arr4 = {7};
        System.out.println("Test 4: " + longestSubArray(arr4));
        // Expected: 1

        int[] arr5 = {2, 3};
        System.out.println("Test 5: " + longestSubArray(arr5));
        // Expected: 2

        int[] arr6 = {2, 4, 6, 8};
        System.out.println("Test 6: " + longestSubArray(arr6));
        // Expected: 1

        int[] arr7 = {1, 2, 3, 4, 5, 6};
        System.out.println("Test 7: " + longestSubArray(arr7));
        // Expected: 6
    }

    /**
     * Returns the length of the longest contiguous subarray
     * with alternating even and odd elements.
     *
     * @param arr input array
     * @return maximum length of alternating even-odd subarray
     */
    public static int longestSubArray(int[] arr) {

        if (arr == null || arr.length == 0) {
            System.out.println("Invalid input!");
            return -1;
        }

        if (arr.length == 1) {
            return 1;
        }

        int res = 1;
        int current = 1;

        for (int i = 1; i < arr.length; i++) {

            if ((arr[i] % 2) != (arr[i - 1] % 2)) {
                current++;
            } else {
                current = 1;
            }

            res = Math.max(res, current);
        }

        return res;
    }
}
package com.dsa.ds4array;

/**
 * Maximum Sum of K Consecutive Elements.
 *
 * <p>Given an array of integers and a positive integer k,
 * find the maximum sum among all contiguous subarrays of size k.
 *
 * <p>This implementation uses the Sliding Window technique:
 * <ul>
 *     <li>Compute the sum of the first window of size k.</li>
 *     <li>Slide the window one element at a time.</li>
 *     <li>Update the maximum sum encountered.</li>
 * </ul>
 *
 * <p>Example:
 * <pre>
 * Input  : [1, 8, 30, -5, 20, 7], k = 3
 * Windows:
 * [1, 8, 30]      = 39
 * [8, 30, -5]     = 33
 * [30, -5, 20]    = 45
 * [-5, 20, 7]     = 22
 *
 * Output : 45
 * </pre>
 *
 * <p>Time Complexity: O(n)
 * <br>Space Complexity: O(1)
 */
public class _29MaximumSumOfKConsecutiveElements {

    public static void main(String[] args) {

        int[] arr1 = {1, 8, 30, -5, 20, 7};
        System.out.println("Test 1: " + maxSum(arr1, 3));
        // Expected: 45

        int[] arr2 = {5, -10, 6, 90, 3};
        System.out.println("Test 2: " + maxSum(arr2, 2));
        // Expected: 96

        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println("Test 3: " + maxSum(arr3, 1));
        // Expected: 5

        int[] arr4 = {1, 2, 3, 4, 5};
        System.out.println("Test 4: " + maxSum(arr4, 5));
        // Expected: 15

        int[] arr5 = {-5, -2, -3, -1};
        System.out.println("Test 5: " + maxSum(arr5, 2));
        // Expected: -4

        int[] arr6 = {10};
        System.out.println("Test 6: " + maxSum(arr6, 1));
        // Expected: 10

        int[] arr7 = {4, 4, 4, 4, 4};
        System.out.println("Test 7: " + maxSum(arr7, 3));
        // Expected: 12

        int[] arr8 = {100, -50, 200, -100, 300};
        System.out.println("Test 8: " + maxSum(arr8, 2));
        // Expected: 200

        int[] arr9 = {2, 3, 5, 1, 6};
        System.out.println("Test 9: " + maxSum(arr9, 3));
        // Expected: 12

        int[] arr10 = {-1, -2, -3, -4, -5};
        System.out.println("Test 10: " + maxSum(arr10, 3));
        // Expected: -6
    }

    /**
     * Returns the maximum sum among all contiguous
     * subarrays of size k.
     *
     * @param arr input array
     * @param k size of the sliding window
     * @return maximum sum of any subarray of size k
     * @throws IllegalArgumentException if k is invalid
     */
    public static int maxSum(int[] arr, int k) {

        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        int curSum = 0;

        for (int i = 0; i < k; i++) {
            curSum += arr[i];
        }

        int result = curSum;

        for (int i = k; i < arr.length; i++) {
            curSum = curSum + arr[i] - arr[i - k];
            result = Math.max(curSum, result);
        }

        return result;
    }
}
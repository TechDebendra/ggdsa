package com.dsa.ds4array;

/**
 * Maximum Circular Subarray Sum.
 *
 * <p>A circular subarray may wrap around the end of the array.
 *
 * <p>Approach:
 * <ul>
 *     <li>Find normal maximum subarray sum using Kadane's Algorithm.</li>
 *     <li>Find minimum subarray sum by applying Kadane's Algorithm
 *         on the negated array.</li>
 *     <li>
 *         maxCircular =
 *         totalArraySum - minSubarraySum
 *     </li>
 * </ul>
 *
 * <p>Time Complexity: O(n)
 * <br>Space Complexity: O(1)
 */
public class _26MaximumCircularSumSubarray {

    public static void main(String[] args) {

        int[] arr1 = {5, -2, 3, 4};
        System.out.println("Test 1: " + maxSumCircularSubarray(arr1));
        // Expected: 12

        int[] arr2 = {8, -4, 3, -5, 4};
        System.out.println("Test 2: " + maxSumCircularSubarray(arr2));
        // Expected: 12

        int[] arr3 = {-3, -2, -5};
        System.out.println("Test 3: " + maxSumCircularSubarray(arr3));
        // Expected: -2

        int[] arr4 = {10, -3, -4, 7, 6, 5, -4, -1};
        System.out.println("Test 4: " + maxSumCircularSubarray(arr4));
        // Expected: 23

        int[] arr5 = {1, 2, 3};
        System.out.println("Test 5: " + maxSumCircularSubarray(arr5));
        // Expected: 6
    }

    /**
     * Standard Kadane's Algorithm.
     *
     * @param arr input array
     * @return maximum subarray sum
     */
    public static int maxSumSubarray(int[] arr) {

        int curSum = arr[0];
        int globalSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            curSum = Math.max(arr[i], arr[i] + curSum);
            globalSum = Math.max(globalSum, curSum);
        }

        return globalSum;
    }

    /**
     * Returns the maximum circular subarray sum.
     *
     * @param arr input array
     * @return maximum circular subarray sum
     */
    public static int maxSumCircularSubarray(int[] arr) {

        int normalSubMax = maxSumSubarray(arr);

        if (normalSubMax < 0) {
            return normalSubMax;
        }

        int arrSum = 0;

        for (int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
            arr[i] = -arr[i];
        }

        int maxNegated = maxSumSubarray(arr);

        int maxCircular = arrSum + maxNegated;

        return Math.max(normalSubMax, maxCircular);
    }
}
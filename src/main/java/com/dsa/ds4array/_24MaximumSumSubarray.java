package com.dsa.ds4array;

/**
 * Maximum Sum Subarray using Kadane's Algorithm.
 *
 * <p>Finds:
 * <ul>
 *     <li>Maximum subarray sum</li>
 *     <li>Start index of the subarray</li>
 *     <li>End index of the subarray</li>
 * </ul>
 *
 * <p>Time Complexity: O(n)
 * <br>Space Complexity: O(1)
 */
public class _24MaximumSumSubarray {

    public static void main(String[] args) {

        maxSubArray(new int[]{1, -2, 3, -1, 2});
        // Expected Sum: 4
        // Subarray: 3 -1 2

        maxSubArray(new int[]{-3, 8, -2, 4, -5, 6});
        // Expected Sum: 11
        // Subarray: 8 -2 4 -5 6

        maxSubArray(new int[]{-5, -2, -8});
        // Expected Sum: -2
        // Subarray: -2

        maxSubArray(new int[]{1, 2, 3, 4});
        // Expected Sum: 10
        // Subarray: 1 2 3 4

        maxSubArray(new int[]{5, -2, 3, 4});
        // Expected Sum: 10
        // Subarray: 5 -2 3 4
    }

    /**
     * Prints the maximum sum subarray and its sum.
     *
     * @param arr input array
     */
    public static void maxSubArray(int[] arr) {

        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int currentSum = arr[0];
        int globalSum = arr[0];

        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > currentSum + arr[i]) {
                currentSum = arr[i];
                tempStart = i;
            } else {
                currentSum += arr[i];
            }

            if (currentSum > globalSum) {
                globalSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        System.out.println("Maximum Sum: " + globalSum);

        System.out.print("Subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}
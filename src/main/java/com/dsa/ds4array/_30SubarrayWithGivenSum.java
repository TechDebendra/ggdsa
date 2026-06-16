package com.dsa.ds4array;

/**
 * Subarray with Given Sum (Positive Numbers Only).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _30SubarrayWithGivenSum {

    public static void main(String[] args) {

        subArray(new int[]{1, 4, 20, 3, 10, 5}, 33);
        // Expected: 20 3 10

        subArray(new int[]{1, 4, 0, 0, 3, 10, 5}, 7);
        // Expected: 4 0 0 3

        subArray(new int[]{1, 4}, 0);
        // Expected: Not Found

        subArray(new int[]{5, 8, 6, 13, 3, -1}, 22);
        // Sliding window not guaranteed for negatives
    }

    /**
     * Finds and prints a subarray having the given sum.
     *
     * Note:
     * Works correctly only when all elements are non-negative.
     *
     * @param arr input array
     * @param sum target sum
     */
    public static void subArray(int[] arr, int sum) {

        int start = 0;
        int curSum = 0;

        for (int end = 0; end < arr.length; end++) {

            curSum += arr[end];

            while (curSum > sum && start <= end) {
                curSum -= arr[start];
                start++;
            }

            if (curSum == sum) {

                System.out.println(
                        "Found subarray with given sum: " + sum);

                for (int i = start; i <= end; i++) {
                    System.out.print(arr[i] + " ");
                }

                System.out.println();
                return;
            }
        }

        System.out.println(
                "No subarray found with sum: " + sum);
    }
}
package com.dsa.ds4array;

/**
 * Maximum Difference Problem with Order Constraint.
 *
 * <p>Find the maximum value of arr[j] - arr[i]
 * such that j > i.</p>
 *
 * Example:
 * Input : [2, 3, 10, 6, 4, 8, 1]
 * Output: 8
 * Explanation: 10 - 2 = 8
 */
public class _16MaximumDifferenceProblemWithOrder {

    public static void main(String[] args) {

        int[] arr1 = {2, 3, 10, 6, 4, 8, 1};
        int[] arr2 = {7, 9, 5, 6, 3, 2};
        int[] arr3 = {10, 8, 7, 5, 2};
        int[] arr4 = {1, 2};
        int[] arr5 = {-5, -2, -1, -10};

        System.out.println(maxDifferenceProblem(arr1)); // 8
        System.out.println(maxDifferenceProblem(arr2)); // 2
        System.out.println(maxDifferenceProblem(arr3)); // -1
        System.out.println(maxDifferenceProblem(arr4)); // 1
        System.out.println(maxDifferenceProblem(arr5)); // 4
    }

    /**
     * Finds the maximum difference arr[j] - arr[i]
     * where j > i.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param arr input array
     * @return maximum difference
     * @throws IllegalArgumentException if array contains fewer than 2 elements
     */
    public static int maxDifferenceProblem(int[] arr) {

        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException(
                    "Array must contain at least 2 elements");
        }

        int result = arr[1] - arr[0];
        int minValue = arr[0];

        for (int i = 1; i < arr.length; i++) {
            result = Math.max(result, arr[i] - minValue);
            minValue = Math.min(minValue, arr[i]);
        }

        return result;
    }
}
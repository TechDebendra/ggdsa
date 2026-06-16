package com.dsa.ds4array;

/**
 * Maximum Consecutive 1s in a Binary Array.
 *
 * <p>Given a binary array containing only 0s and 1s,
 * find the length of the longest sequence of consecutive 1s.
 *
 * <p>Example:
 * <pre>
 * Input : [0, 1, 1, 0, 1, 1, 1]
 * Output: 3
 * </pre>
 *
 * <p>Time Complexity: O(n)
 * <br>Space Complexity: O(1)
 */
public class _23MaximumConsecutive1s {

    public static void main(String[] args) {

        int[] arr1 = {0, 1, 1, 0, 1, 1, 1};
        System.out.println("Test 1: " + maxConsecutiveOne(arr1));
        // Expected: 3

        int[] arr2 = {1, 1, 1, 1, 1};
        System.out.println("Test 2: " + maxConsecutiveOne(arr2));
        // Expected: 5

        int[] arr3 = {0, 0, 0, 0};
        System.out.println("Test 3: " + maxConsecutiveOne(arr3));
        // Expected: 0

        int[] arr4 = {1};
        System.out.println("Test 4: " + maxConsecutiveOne(arr4));
        // Expected: 1

        int[] arr5 = {0};
        System.out.println("Test 5: " + maxConsecutiveOne(arr5));
        // Expected: 0

        int[] arr6 = {1, 0, 1, 0, 1, 0};
        System.out.println("Test 6: " + maxConsecutiveOne(arr6));
        // Expected: 1

        int[] arr7 = {0, 1, 1, 1, 1, 0, 1, 1};
        System.out.println("Test 7: " + maxConsecutiveOne(arr7));
        // Expected: 4
    }

    /**
     * Returns the length of the longest sequence
     * of consecutive 1s in a binary array.
     *
     * @param arr binary array containing 0s and 1s
     * @return maximum count of consecutive 1s
     */
    public static int maxConsecutiveOne(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int res = 0;
        int current = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                current = 0;
            } else {
                current++;
                res = Math.max(res, current);
            }
        }

        return res;
    }
}
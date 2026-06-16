package com.dsa.ds4array;

/**
 * Finds the element that appears in the maximum number of given ranges.
 *
 * Example:
 * Ranges:
 * [1,3]
 * [2,5]
 * [3,7]
 *
 * Frequency:
 * 1 -> 1
 * 2 -> 2
 * 3 -> 3  <-- maximum
 * 4 -> 2
 * 5 -> 2
 * 6 -> 1
 * 7 -> 1
 *
 * Output: 3
 *
 * Time Complexity: O(maxRange)
 * Space Complexity: O(maxRange)
 */
public class _31MaximumAppearingElement {

    public static void main(String[] args) {

        // Test Case 1
        int[] left1 = {1, 2, 3};
        int[] right1 = {3, 5, 7};
        System.out.println("Test 1 Expected: 3, Actual: "
                + maxAppearingIndex(left1, right1));

        // Test Case 2
        int[] left2 = {1, 4, 9, 13, 21};
        int[] right2 = {15, 8, 12, 20, 30};
        System.out.println("Test 2 Expected: 4, Actual: "
                + maxAppearingIndex(left2, right2));

        // Test Case 3
        int[] left3 = {5};
        int[] right3 = {10};
        System.out.println("Test 3 Expected: 5, Actual: "
                + maxAppearingIndex(left3, right3));

        // Test Case 4
        int[] left4 = {1, 1, 1};
        int[] right4 = {5, 5, 5};
        System.out.println("Test 4 Expected: 1, Actual: "
                + maxAppearingIndex(left4, right4));

        // Test Case 5
        int[] left5 = {1, 2, 3};
        int[] right5 = {2, 3, 4};
        System.out.println("Test 5 Expected: 2 or 3, Actual: "
                + maxAppearingIndex(left5, right5));
    }

    /**
     * Returns the element that appears in the maximum number of ranges.
     *
     * @param left  starting points of ranges
     * @param right ending points of ranges
     * @return element with maximum occurrence across all ranges
     * @throws IllegalArgumentException if arrays are null, empty,
     *                                  or lengths are different
     */
    public static int maxAppearingIndex(int[] left, int[] right) {

        if (left == null || right == null) {
            throw new IllegalArgumentException("Input arrays cannot be null.");
        }

        if (left.length == 0 || right.length == 0) {
            throw new IllegalArgumentException("Input arrays cannot be empty.");
        }

        if (left.length != right.length) {
            throw new IllegalArgumentException(
                    "Left and Right arrays must have the same length.");
        }

        int n = left.length;

        int max = right[0];
        for (int value : right) {
            max = Math.max(max, value);
        }

        int[] freq = new int[max + 2];

        for (int i = 0; i < n; i++) {
            freq[left[i]]++;
            freq[right[i] + 1]--;
        }

        int res = 0;

        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];

            if (freq[i] > freq[res]) {
                res = i;
            }
        }

        return res;
    }
}
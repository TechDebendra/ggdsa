package com.dsa.ds4array;

/**
 * Trapping Rain Water - Naive Solution.
 *
 * <p>Given an array where each element represents the height
 * of a bar, calculate the total amount of rainwater that can
 * be trapped between the bars.
 *
 * <p>For each bar:
 *
 * <pre>
 * Water trapped =
 * min(max height on left, max height on right)
 * - current height
 * </pre>
 *
 * <p>This implementation computes the left maximum and right
 * maximum for every index separately.
 *
 * <p>Time Complexity: O(n²)
 * <br>Space Complexity: O(1)
 */
public class _20TrappingRainWater_Case1 {

    public static void main(String[] args) {

        int[] arr1 = {3, 0, 1, 2, 5};
        System.out.println("Test 1: " + waterCapacity(arr1));
        // Expected: 6

        int[] arr2 = {2, 0, 2};
        System.out.println("Test 2: " + waterCapacity(arr2));
        // Expected: 2

        int[] arr3 = {3, 0, 2, 0, 4};
        System.out.println("Test 3: " + waterCapacity(arr3));
        // Expected: 7

        int[] arr4 = {1, 2, 3, 4, 5};
        System.out.println("Test 4: " + waterCapacity(arr4));
        // Expected: 0

        int[] arr5 = {5, 4, 3, 2, 1};
        System.out.println("Test 5: " + waterCapacity(arr5));
        // Expected: 0

        int[] arr6 = {5};
        System.out.println("Test 6: " + waterCapacity(arr6));
        // Expected: 0

        int[] arr7 = {4, 2, 0, 3, 2, 5};
        System.out.println("Test 7: " + waterCapacity(arr7));
        // Expected: 9
    }

    /**
     * Calculates the total amount of rainwater trapped.
     *
     * @param arr array representing bar heights
     * @return total trapped water units
     */
    public static int waterCapacity(int[] arr) {

        if (arr == null || arr.length < 3) {
            return 0;
        }

        int result = 0;

        for (int i = 1; i < arr.length - 1; i++) {

            int leftMax = arr[i];

            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, arr[j]);
            }

            int rightMax = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }

            result += Math.min(leftMax, rightMax) - arr[i];
        }

        return result;
    }
}
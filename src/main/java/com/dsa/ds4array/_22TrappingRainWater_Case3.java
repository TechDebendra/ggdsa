package com.dsa.ds4array;

/**
 * Trapping Rain Water - Optimal Two Pointer Solution.
 *
 * <p>Uses two pointers and keeps track of the maximum height
 * seen from the left and right sides.
 *
 * <p>If leftMax <= rightMax, the trapped water at the left
 * pointer depends only on leftMax.
 *
 * <p>If rightMax < leftMax, the trapped water at the right
 * pointer depends only on rightMax.
 *
 * <p>Time Complexity: O(n)
 * <br>Space Complexity: O(1)
 */
public class _22TrappingRainWater_Case3 {

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

        int[] arr6 = {4, 2, 0, 3, 2, 5};
        System.out.println("Test 6: " + waterCapacity(arr6));
        // Expected: 9

        int[] arr7 = {5};
        System.out.println("Test 7: " + waterCapacity(arr7));
        // Expected: 0
    }

    /**
     * Calculates the total trapped rainwater using
     * the two-pointer technique.
     *
     * @param arr array of bar heights
     * @return total trapped water units
     */
    public static int waterCapacity(int[] arr) {

        if (arr == null || arr.length < 3) {
            return 0;
        }

        int left = 0;
        int right = arr.length - 1;

        int leftMax = arr[left];
        int rightMax = arr[right];

        int result = 0;

        while (left < right) {

            if (arr[left] <= arr[right]) {

                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    result += leftMax - arr[left];
                }

                left++;

            } else {

                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    result += rightMax - arr[right];
                }

                right--;
            }
        }

        return result;
    }
}
package com.dsa.ds5Searching;

/**
 * Finds a repeating element using Floyd's Cycle Detection
 * (Tortoise and Hare Algorithm).
 * Assumptions:
 * - Array size = n
 * - Elements are in the range 0 to n-2
 * - Exactly one element is repeated
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _15RepeatingElementPart2 {

    public static void main(String[] args) {

        int[] arr1 = {0, 2, 1, 3, 2};
        System.out.println(findRepeatingElement(arr1)); // 2

        int[] arr2 = {1, 3, 2, 4, 3};
        System.out.println(findRepeatingElement(arr2)); // 3

        int[] arr3 = {0, 0};
        System.out.println(findRepeatingElement(arr3)); // 0

        int[] arr4 = {2, 1, 0, 2};
        System.out.println(findRepeatingElement(arr4)); // 2

        int[] arr5 = {1, 2, 3, 4, 2};
        System.out.println(findRepeatingElement(arr5)); // 2

        int[] arr6 = {3, 1, 3, 4, 2};
        System.out.println(findRepeatingElement(arr6)); // 3
    }

    /**
     * Finds the repeating element using Floyd's Cycle Detection.
     *
     * @param arr Input array containing exactly one repeated element
     * @return Repeating element
     */
    public static int findRepeatingElement(int[] arr) {

        int slow = arr[0] + 1;
        int fast = arr[0] + 1;

        // Detect cycle
        do {
            slow = arr[slow] + 1;
            fast = arr[arr[fast] + 1] + 1;
        } while (slow != fast);

        // Find entrance of cycle
        slow = arr[0] + 1;

        while (slow != fast) {
            slow = arr[slow] + 1;
            fast = arr[fast] + 1;
        }

        return slow - 1;
    }
}
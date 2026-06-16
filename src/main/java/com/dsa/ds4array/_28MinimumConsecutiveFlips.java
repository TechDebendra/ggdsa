package com.dsa.ds4array;

/**
 * Minimum Consecutive Flips.
 *
 * <p>Given a binary array consisting of only 0s and 1s,
 * print the ranges of indices that should be flipped so that
 * all elements become the same with a minimum number of flips.
 *
 * <p>Idea:
 * Print the groups that differ from the first group.
 *
 * <p>Time Complexity: O(n)
 * <br>Space Complexity: O(1)
 */
public class _28MinimumConsecutiveFlips {

    public static void main(String[] args) {

        int[] arr1 = {1, 1, 0, 0, 0, 1};
        System.out.println("Test 1:");
        printGroups(arr1);
        // Expected: From :2 to :4

        int[] arr2 = {1, 1, 0, 0, 0, 1, 1, 0, 0, 1};
        System.out.println("\nTest 2:");
        printGroups(arr2);
        // Expected:
        // From :2 to :4
        // From :7 to :8

        int[] arr3 = {0, 0, 1, 1, 0, 0};
        System.out.println("\nTest 3:");
        printGroups(arr3);
        // Expected:
        // From :2 to :3

        int[] arr4 = {1, 1, 1, 1};
        System.out.println("\nTest 4:");
        printGroups(arr4);
        // Expected: No output

        int[] arr5 = {0, 0, 0, 0};
        System.out.println("\nTest 5:");
        printGroups(arr5);
        // Expected: No output

        int[] arr6 = {0, 1, 0, 1, 0, 1};
        System.out.println("\nTest 6:");
        printGroups(arr6);
        // Expected:
        // From :1 to :1
        // From :3 to :3
        // From :5 to :5
    }

    /**
     * Prints the index ranges that should be flipped
     * to make all elements equal with minimum flips.
     *
     * @param arr binary array containing only 0s and 1s
     */
    public static void printGroups(int[] arr) {

        if (arr == null || arr.length == 0) {
            System.out.println("Invalid input.");
            return;
        }

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] != arr[i - 1]) {

                if (arr[i] != arr[0]) {
                    System.out.print("From :" + i + " to :");
                } else {
                    System.out.println(i - 1);
                }
            }
        }

        if (arr[arr.length - 1] != arr[0]) {
            System.out.println(arr.length - 1);
        }
    }
}
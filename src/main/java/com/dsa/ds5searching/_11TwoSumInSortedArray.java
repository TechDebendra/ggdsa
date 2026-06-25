package com.dsa.ds5searching;

/**
 * Checks whether a pair exists in a sorted array
 * whose sum equals the given target.
 *
 * Uses the Two Pointer technique.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _11TwoSumInSortedArray {

    public static void main(String[] args) {

        int[] arr1 = {2, 5, 8, 12, 30};

        System.out.println(found(arr1, 17));  // true (5 + 12)
        System.out.println(found(arr1, 14));  // true (2 + 12)
        System.out.println(found(arr1, 32));  // true (2 + 30)
        System.out.println(found(arr1, 100)); // false

        int[] arr2 = {1, 2, 3, 4, 5};

        System.out.println(found(arr2, 9));   // true (4 + 5)
        System.out.println(found(arr2, 10));  // false

        int[] arr3 = {5};

        System.out.println(found(arr3, 10));  // false

        int[] arr4 = {};

        System.out.println(found(arr4, 5));   // false

        int[] arr5 = {-10, -5, 0, 5, 10};

        System.out.println(found(arr5, 0));    // true (-10 + 10)
        System.out.println(found(arr5, -15));  // true (-10 + -5)
        System.out.println(found(arr5, 100));  // false
    }

    /**
     * Checks whether a pair exists whose sum equals the target.
     *
     * @param arr Sorted input array
     * @param sum Target sum
     * @return true if a pair exists, otherwise false
     */
    public static boolean found(int[] arr, int sum) {

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            int currentSum = arr[start] + arr[end];

            if (currentSum == sum) {
                return true;
            } else if (currentSum < sum) {
                start++;
            } else {
                end--;
            }
        }

        return false;
    }
}
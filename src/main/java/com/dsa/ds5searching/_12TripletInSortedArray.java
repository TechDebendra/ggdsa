package com.dsa.ds5searching;

/**
 * Finds whether a triplet exists in a sorted array whose sum equals
 * the given target value.
 *
 * Approach:
 * 1. Fix one element.
 * 2. Use the Two Pointer technique to find a pair with the remaining sum.
 *
 * Example:
 * arr = {2, 3, 4, 8, 9, 20, 40}
 * sum = 32
 *
 * Triplet:
 * 3 + 9 + 20 = 32
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */
public class _12TripletInSortedArray {

    public static void main(String[] args) {

        int[] arr1 = {2, 3, 4, 8, 9, 20, 40};

        System.out.println(isTriplet(arr1, 32)); // true (3 + 9 + 20)
        System.out.println(isTriplet(arr1, 14)); // true (2 + 3 + 9)
        System.out.println(isTriplet(arr1, 27)); // true (3 + 4 + 20)
        System.out.println(isTriplet(arr1, 100)); // false

        int[] arr2 = {1, 2, 3, 4, 5};

        System.out.println(isTriplet(arr2, 9));  // true (1 + 3 + 5)
        System.out.println(isTriplet(arr2, 12)); // true (3 + 4 + 5)
        System.out.println(isTriplet(arr2, 50)); // false

        int[] arr3 = {-10, -5, 0, 5, 10, 20};

        System.out.println(isTriplet(arr3, 5));  // true (-10 + -5 + 20)
        System.out.println(isTriplet(arr3, 15)); // true (-10 + 5 + 20)
        System.out.println(isTriplet(arr3, 100)); // false

        int[] arr4 = {1, 2};

        System.out.println(isTriplet(arr4, 3)); // false

        int[] arr5 = {};

        System.out.println(isTriplet(arr5, 10)); // false

        int[] arr6 = {5, 10, 15};

        System.out.println(isTriplet(arr6, 30)); // true
        System.out.println(isTriplet(arr6, 20)); // false
    }

    /**
     * Checks whether a triplet exists whose sum equals the target.
     *
     * @param arr Sorted input array
     * @param sum Target sum
     * @return true if a triplet exists, otherwise false
     */
    public static boolean isTriplet(int[] arr, int sum) {

        for (int i = 0; i < arr.length - 2; i++) {

            if (isPair(arr, sum - arr[i], i + 1)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks whether a pair exists from the given starting index
     * whose sum equals the target.
     *
     * Uses the Two Pointer technique.
     *
     * @param arr Sorted input array
     * @param sum Target pair sum
     * @param start Starting index for the search
     * @return true if a pair exists, otherwise false
     */
    public static boolean isPair(int[] arr, int sum, int start) {

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
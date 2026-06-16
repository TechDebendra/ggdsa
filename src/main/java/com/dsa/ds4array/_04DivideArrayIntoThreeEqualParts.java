package com.dsa.ds4array;

public class _04DivideArrayIntoThreeEqualParts {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 0, 3};
        System.out.println(canDivideIntoThreeParts(arr1));
        // true

        int[] arr2 = {0, 2, 1, -3, 3, 0, 0};
        System.out.println(canDivideIntoThreeParts(arr2));
        // true

        int[] arr3 = {1, 1, 1, 1};
        System.out.println(canDivideIntoThreeParts(arr3));
        // false

        int[] arr4 = {3, 3, 3};
        System.out.println(canDivideIntoThreeParts(arr4));
        // true

        int[] arr5 = {1, 2, 3, 4, 5};
        System.out.println(canDivideIntoThreeParts(arr5));
        // false
    }

    /**
     * Checks whether the array can be divided into
     * three contiguous parts having equal sum.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param arr input array
     * @return true if possible, otherwise false
     */
    public static boolean canDivideIntoThreeParts(int[] arr) {

        if (arr == null || arr.length < 3) {
            return false;
        }

        int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        if (totalSum % 3 != 0) {
            return false;
        }

        int target = totalSum / 3;
        int currentSum = 0;
        int partitionsFound = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            currentSum += arr[i];

            if (currentSum == target) {
                partitionsFound++;
                currentSum = 0;

                if (partitionsFound == 2) {
                    return true;
                }
            }
        }

        return false;
    }
}

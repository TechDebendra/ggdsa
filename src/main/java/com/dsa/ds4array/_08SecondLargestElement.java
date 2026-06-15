package com.dsa.ds4array;

/**
 * Utility class to find the second largest distinct element in an array.
 */
public class _08SecondLargestElement {

    public static void main(String[] args) {

        // Normal cases
        System.out.println(secondLargest(new int[]{10, 20, 30, 40})); // 30
        System.out.println(secondLargest(new int[]{40, 30, 20, 10})); // 30
        System.out.println(secondLargest(new int[]{10, 40, 20, 30})); // 30

        // Duplicate values
        System.out.println(secondLargest(new int[]{10, 20, 20, 30})); // 20
        System.out.println(secondLargest(new int[]{5, 5, 4, 4, 3}));  // 4

        // Negative numbers
        System.out.println(secondLargest(new int[]{-10, -20, -30, -40})); // -20
        System.out.println(secondLargest(new int[]{-5, -1, -10}));        // -5

        // Edge cases
        try {
            System.out.println(secondLargest(new int[]{10}));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(secondLargest(new int[]{10, 10, 10}));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Finds the second largest distinct element in the given array.
     *
     * Example:
     * [10, 20, 30, 40] -> 30
     * [10, 20, 20, 30] -> 20
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param arr input integer array
     * @return second largest distinct element
     * @throws IllegalArgumentException if array is null,
     *                                  has fewer than 2 elements,
     *                                  or does not contain a second largest distinct element
     */
    public static int secondLargest(int[] arr) {

        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException(
                    "Array must contain at least two elements.");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {

            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num != largest && num > secondLargest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE && largest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "Second largest distinct element does not exist.");
        }

        boolean found = false;
        for (int num : arr) {
            if (num == secondLargest) {
                found = true;
                break;
            }
        }

        if (!found) {
            throw new IllegalArgumentException(
                    "Second largest distinct element does not exist.");
        }

        return secondLargest;
    }
}
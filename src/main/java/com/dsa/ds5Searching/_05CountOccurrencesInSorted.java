package com.dsa.ds5Searching;

/**
 * Counts the number of occurrences of a given element
 * in a sorted array using Binary Search.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class _05CountOccurrencesInSorted {

    public static void main(String[] args) {

        int[] arr1 = {10, 20, 20, 20, 30, 30, 40};

        System.out.println(findOccurrence(arr1, 10)); // 1
        System.out.println(findOccurrence(arr1, 20)); // 3
        System.out.println(findOccurrence(arr1, 30)); // 2
        System.out.println(findOccurrence(arr1, 40)); // 1
        System.out.println(findOccurrence(arr1, 50)); // 0

        int[] arr2 = {5, 5, 5, 5};
        System.out.println(findOccurrence(arr2, 5));  // 4
        System.out.println(findOccurrence(arr2, 10)); // 0

        int[] arr3 = {7};
        System.out.println(findOccurrence(arr3, 7));  // 1
        System.out.println(findOccurrence(arr3, 10)); // 0

        int[] arr4 = {};
        System.out.println(findOccurrence(arr4, 5));  // 0

        int[] arr5 = {-10, -5, -5, 0, 0, 0, 10};
        System.out.println(findOccurrence(arr5, -5)); // 2
        System.out.println(findOccurrence(arr5, 0));  // 3

        int[] arr6 = {1, 2, 3, 4, 5};
        System.out.println(findOccurrence(arr6, 3));  // 1
    }

    /**
     * Returns the number of occurrences of x in the sorted array.
     *
     * @param arr Sorted input array
     * @param x   Element to search
     * @return Number of occurrences of x
     */
    public static int findOccurrence(int[] arr, int x) {

        int firstOcc = firstOccurrence(arr, x);

        if (firstOcc == -1) {
            return 0;
        }

        int lastOcc = lastOccurrence(arr, x);

        return lastOcc - firstOcc + 1;
    }

    /**
     * Finds the index of the first occurrence of x.
     *
     * @param arr Sorted input array
     * @param x   Element to search
     * @return First occurrence index, or -1 if not found
     */
    public static int firstOccurrence(int[] arr, int x) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (x == arr[mid]) {

                if (mid == 0 || arr[mid] != arr[mid - 1]) {
                    return mid;
                }

                end = mid - 1;

            } else if (x < arr[mid]) {

                end = mid - 1;

            } else {

                start = mid + 1;
            }
        }

        return -1;
    }

    /**
     * Finds the index of the last occurrence of x.
     *
     * @param arr Sorted input array
     * @param x   Element to search
     * @return Last occurrence index, or -1 if not found
     */
    public static int lastOccurrence(int[] arr, int x) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (x == arr[mid]) {

                if (mid == arr.length - 1 || arr[mid] != arr[mid + 1]) {
                    return mid;
                }

                start = mid + 1;

            } else if (x < arr[mid]) {

                end = mid - 1;

            } else {

                start = mid + 1;
            }
        }

        return -1;
    }
}
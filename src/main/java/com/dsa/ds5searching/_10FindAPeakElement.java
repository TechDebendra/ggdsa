package com.dsa.ds5searching;

/**
 * Finds any peak element in an array using Binary Search.
 *
 * A peak element is an element that is not smaller
 * than its adjacent elements.
 *
 * Examples:
 * [5, 10, 20, 15] -> 20
 * [10, 20, 15, 2, 23, 90, 67] -> 20 or 90
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class _10FindAPeakElement {

    public static void main(String[] args) {

        int[] arr1 = {5, 10, 20, 15};
        System.out.println(peakElement(arr1)); // 2

        int[] arr2 = {10, 20, 15, 2, 23, 90, 67};
        System.out.println(peakElement(arr2)); // 1 or 5

        int[] arr3 = {10};
        System.out.println(peakElement(arr3)); // 0

        int[] arr4 = {10, 20};
        System.out.println(peakElement(arr4)); // 1

        int[] arr5 = {20, 10};
        System.out.println(peakElement(arr5)); // 0

        int[] arr6 = {10, 20, 30, 40, 50};
        System.out.println(peakElement(arr6)); // 4

        int[] arr7 = {50, 40, 30, 20, 10};
        System.out.println(peakElement(arr7)); // 0

        int[] arr8 = {1, 3, 20, 4, 1, 0};
        System.out.println(peakElement(arr8)); // 2

        int[] arr9 = {};
        System.out.println(peakElement(arr9)); // -1
    }

    /**
     * Finds the index of any peak element.
     *
     * @param arr Input array
     * @return Index of a peak element, or -1 if array is empty
     */
    public static int peakElement(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if ((mid == 0 || arr[mid - 1] <= arr[mid]) &&
                    (mid == arr.length - 1 || arr[mid + 1] <= arr[mid])) {

                return mid;
            }

            if (mid > 0 && arr[mid - 1] >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
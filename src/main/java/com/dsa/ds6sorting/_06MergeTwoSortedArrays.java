package com.dsa.ds6sorting;

import java.util.Arrays;

public class _06MergeTwoSortedArrays {

    public static void main(String[] args) {

        // Test Case 1: Normal case
        test(new int[]{1, 3, 5}, new int[]{2, 4, 6});

        // Test Case 2: Different sizes
        test(new int[]{1, 2, 3, 8}, new int[]{4, 5});

        // Test Case 3: First array empty
        test(new int[]{}, new int[]{1, 2, 3});

        // Test Case 4: Second array empty
        test(new int[]{1, 2, 3}, new int[]{});

        // Test Case 5: Both arrays empty
        test(new int[]{}, new int[]{});

        // Test Case 6: Duplicate elements
        test(new int[]{1, 2, 2, 5}, new int[]{2, 3, 5, 6});

        // Test Case 7: Negative numbers
        test(new int[]{-5, -2, 0}, new int[]{-4, -1, 3});

        // Test Case 8: All elements of first array smaller
        test(new int[]{1, 2, 3}, new int[]{4, 5, 6});

        // Test Case 9: All elements of second array smaller
        test(new int[]{4, 5, 6}, new int[]{1, 2, 3});
    }

    public static int[] merge(int[] arr1, int[] arr2) {

        int m = arr1.length;
        int n = arr2.length;

        int[] res = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                res[k++] = arr1[i++];
            } else {
                res[k++] = arr2[j++];
            }
        }

        while (i < m) {
            res[k++] = arr1[i++];
        }

        while (j < n) {
            res[k++] = arr2[j++];
        }

        return res;
    }

    private static void test(int[] arr1, int[] arr2) {
        System.out.println("Array 1 : " + Arrays.toString(arr1));
        System.out.println("Array 2 : " + Arrays.toString(arr2));
        System.out.println("Merged  : " + Arrays.toString(merge(arr1, arr2)));
        System.out.println("----------------------------------------");
    }
}
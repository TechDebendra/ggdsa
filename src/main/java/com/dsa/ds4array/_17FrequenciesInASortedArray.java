package com.dsa.ds4array;

/**
 * Prints the frequency of each distinct element in a sorted array.
 *
 * <p>Example:
 * <pre>
 * Input:  [10, 10, 20, 20, 20, 30]
 * Output:
 * 10 : 2
 * 20 : 3
 * 30 : 1
 * </pre>
 *
 * <p>Assumption:
 * The input array must be sorted in non-decreasing order.
 *
 * <p>Time Complexity: O(n)
 * <br>Space Complexity: O(1)
 */
public class _17FrequenciesInASortedArray {

    public static void main(String[] args) {

        System.out.println("Test Case 1: Normal sorted array");
        frequencies(new int[]{10, 10, 20, 20, 20, 30});
        System.out.println();

        System.out.println("Test Case 2: Single element");
        frequencies(new int[]{5});
        System.out.println();

        System.out.println("Test Case 3: All elements same");
        frequencies(new int[]{7, 7, 7, 7, 7});
        System.out.println();

        System.out.println("Test Case 4: All elements unique");
        frequencies(new int[]{1, 2, 3, 4, 5});
        System.out.println();

        System.out.println("Test Case 5: Negative numbers");
        frequencies(new int[]{-3, -3, -1, -1, -1, 0, 2, 2});
        System.out.println();

        System.out.println("Test Case 6: Empty array");
        frequencies(new int[]{});
        System.out.println();

        System.out.println("Test Case 7: Null array");
        frequencies(null);
    }

    /**
     * Prints the frequency of each distinct element in a sorted array.
     *
     * @param arr the sorted input array
     */
    public static void frequencies(int[] arr) {

        if (arr == null || arr.length == 0) {
            System.out.println("Array is null or empty.");
            return;
        }

        int freq = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                freq++;
            } else {
                System.out.println(arr[i - 1] + " : " + freq);
                freq = 1;
            }
        }

        // Print frequency of the last element/group
        System.out.println(arr[arr.length - 1] + " : " + freq);
    }
}
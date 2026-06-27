package com.dsa.ds6sorting;

import java.util.Arrays;

public class _22CycleSort {

    public static void main(String[] args) {

        test("Test 1 : Already Sorted",
                new int[]{1, 2, 3, 4, 5});

        test("Test 2 : Reverse Sorted",
                new int[]{5, 4, 3, 2, 1});

        test("Test 3 : Random Array",
                new int[]{20, 40, 50, 10, 30});

        test("Test 4 : Single Element",
                new int[]{7});

        test("Test 5 : Two Elements",
                new int[]{2, 1});

        test("Test 6 : Duplicate Values",
                new int[]{3, 5, 2, 1, 2});

        test("Test 7 : All Same Elements",
                new int[]{5, 5, 5, 5});

        test("Test 8 : Negative Numbers",
                new int[]{-3, -1, -5, -2});

        test("Test 9 : Mixed Positive & Negative",
                new int[]{4, -1, 7, 0, -5, 2});

        test("Test 10 : Large Numbers",
                new int[]{1000, 1, 999, 50, 20});

        test("Test 11 : Empty Array",
                new int[]{});

        test("Test 12 : Nearly Sorted",
                new int[]{1, 3, 2, 4, 5});

        test("Test 13 : Duplicate at Beginning",
                new int[]{2, 2, 1});

        test("Test 14 : Duplicate at End",
                new int[]{3, 1, 2, 3});

        test("Test 15 : Large Random",
                new int[]{8, 4, 7, 3, 6, 2, 5, 1});
    }

    private static void test(String title, int[] arr) {

        System.out.println("\n========================================");
        System.out.println(title);
        System.out.println("========================================");

        System.out.println("Before Sorting : " + Arrays.toString(arr));

        int writes = cycleSort(arr);

        System.out.println("After Sorting  : " + Arrays.toString(arr));
        System.out.println("Writes         : " + writes);
    }

    /**
     * Cycle Sort
     *
     * Time Complexity:
     * Best    : O(n²)
     * Average : O(n²)
     * Worst   : O(n²)
     *
     * Auxiliary Space : O(1)
     *
     * Stable  : No
     * In-place: Yes
     */

    public static int cycleSort(int[] arr) {

        if (arr == null || arr.length == 0)
            return 0;

        int writes = 0;
        int n = arr.length;

        for (int cycleStart = 0; cycleStart < n - 1; cycleStart++) {

            int item = arr[cycleStart];
            int position = cycleStart;

            // Find the correct position of current item.
            for (int i = cycleStart + 1; i < n; i++) {
                if (arr[i] < item)
                    position++;
            }

            // Item is already in correct position.
            if (position == cycleStart)
                continue;

            // Ignore duplicate elements.
            while (position < n && item == arr[position]) {
                position++;
            }

            // Put the item into its correct position.
            if (position < n) {
                int temp = arr[position];
                arr[position] = item;
                item = temp;
                writes++;
            }

            // Rotate the remaining cycle.
            while (position != cycleStart) {

                position = cycleStart;

                for (int i = cycleStart + 1; i < n; i++) {
                    if (arr[i] < item)
                        position++;
                }

                while (position < n && item == arr[position]) {
                    position++;
                }

                if (position < n) {
                    int temp = arr[position];
                    arr[position] = item;
                    item = temp;
                    writes++;
                }
            }
        }

        return writes;
    }
}
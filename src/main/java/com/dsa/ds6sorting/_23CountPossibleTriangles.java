package com.dsa.ds6sorting;

import java.util.Arrays;

public class _23CountPossibleTriangles {

    public static void main(String[] args) {

        test("Test 1 : GFG Example",
                new int[]{4, 6, 3, 7});

        test("Test 2 : Already Sorted",
                new int[]{3, 4, 6, 7});

        test("Test 3 : No Triangle",
                new int[]{1, 2, 3});

        test("Test 4 : All Same",
                new int[]{5, 5, 5, 5});

        test("Test 5 : Single Triangle",
                new int[]{2, 3, 4});

        test("Test 6 : Two Elements",
                new int[]{2, 3});

        test("Test 7 : Single Element",
                new int[]{5});

        test("Test 8 : Empty Array",
                new int[]{});

        test("Test 9 : Large Values",
                new int[]{10, 21, 22, 100, 101, 200, 300});

        test("Test 10 : Duplicate Values",
                new int[]{4, 4, 4, 4});

        test("Test 11 : Mixed Values",
                new int[]{10, 15, 7, 6});

        test("Test 12 : Random Input",
                new int[]{8, 4, 2, 10, 12, 6});

        test("Test 13 : Consecutive Numbers",
                new int[]{1, 2, 3, 4, 5, 6});

        test("Test 14 : Large Random",
                new int[]{20, 15, 8, 10, 5, 12, 25});

        test("Test 15 : All Invalid",
                new int[]{1, 1, 2, 5});
    }

    private static void test(String title, int[] arr) {

        System.out.println("\n========================================");
        System.out.println(title);
        System.out.println("========================================");

        System.out.println("Input : " + Arrays.toString(arr));

        int result = countTriangles(arr);

        System.out.println("Possible Triangles : " + result);
    }

    /**
     * Counts the number of possible triangles.
     *
     * Time Complexity : O(n²)
     * Auxiliary Space : O(1)
     */
    public static int countTriangles(int[] arr) {

        if (arr == null || arr.length < 3)
            return 0;

        // Sort the array
        Arrays.sort(arr);

        System.out.println("Sorted: " + Arrays.toString(arr));

        int n = arr.length;
        int count = 0;

        // Fix the largest side
        for (int k = n - 1; k >= 2; k--) {

            int left = 0;
            int right = k - 1;

            while (left < right) {

                if (arr[left] + arr[right] > arr[k]) {

                    // Every element between left and right forms a triangle
                    count += (right - left);

                    right--;

                } else {

                    left++;

                }
            }
        }

        return count;
    }
}
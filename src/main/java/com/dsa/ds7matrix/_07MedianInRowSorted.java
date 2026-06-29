package com.dsa.ds7matrix;

public class _07MedianInRowSorted {

    public static void main(String[] args) {

        // Test Case 1 : GFG Example
        test(new int[][]{
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        }, 5);

        // Test Case 2 : Simple Sorted Matrix
        test(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 5);

        // Test Case 3 : Large Values
        test(new int[][]{
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        }, 50);

        // Test Case 4 : All Same Elements
        test(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        }, 1);

        // Test Case 5 : Large Gap Between Values
        test(new int[][]{
                {1, 2, 100},
                {101, 102, 103},
                {104, 105, 106}
        }, 102);

        // Test Case 6 : Negative Numbers
        test(new int[][]{
                {-10, -5, -1},
                {0, 2, 4},
                {5, 8, 10}
        }, 2);

        // Test Case 7 : Single Row
        test(new int[][]{
                {1, 3, 5, 7, 9}
        }, 5);

        // Test Case 8 : Single Column
        test(new int[][]{
                {1},
                {3},
                {5},
                {7},
                {9}
        }, 5);

        // Test Case 9 : Many Duplicates
        test(new int[][]{
                {1, 2, 2},
                {2, 2, 3},
                {3, 3, 4}
        }, 2);

        // Test Case 10 : Minimum Size Matrix
        test(new int[][]{
                {42}
        }, 42);

        // Test Case 11 : Non-square Matrix (3 x 5)
        test(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        }, 8);

        // Test Case 12 : Duplicate Median
        test(new int[][]{
                {1, 2, 3},
                {4, 5, 5},
                {5, 6, 7}
        }, 5);

    }

    private static void test(int[][] matrix, int expected) {

        System.out.println("----------------------------------------");
        print(matrix);

        int ans = median(matrix);

        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + ans);

        if (ans == expected)
            System.out.println("Result   : PASS");
        else
            System.out.println("Result   : FAIL");
    }

    public static int median(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find minimum and maximum element
        for (int i = 0; i < r; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][c - 1]);
        }

        int desired = (r * c + 1) / 2;

        while (low < high) {

            int mid = low + (high - low) / 2;

            int count = 0;

            for (int i = 0; i < r; i++) {
                count += countUpper(matrix[i], mid);
            }

            if (count < desired)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    // Returns the count of elements <= k
    public static int countUpper(int[] arr, int k) {

        int low = 0;
        int high = arr.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] <= k)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    public static void print(int[][] matrix) {

        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
    }
}
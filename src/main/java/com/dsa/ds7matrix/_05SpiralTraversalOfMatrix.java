package com.dsa.ds7matrix;

public class _05SpiralTraversalOfMatrix {

    public static void main(String[] args) {

        test("Test 1 : 4 x 4 Matrix",
                new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 8, 9},
                        {10, 13, 14, 16},
                        {20, 22, 45, 90}
                });

        test("Test 2 : 3 x 3 Matrix",
                new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                });

        test("Test 3 : 3 x 5 Matrix",
                new int[][]{
                        {1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11, 12, 13, 14, 15}
                });

        test("Test 4 : 5 x 3 Matrix",
                new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9},
                        {10, 11, 12},
                        {13, 14, 15}
                });

        test("Test 5 : Single Row",
                new int[][]{
                        {1, 2, 3, 4, 5}
                });

        test("Test 6 : Single Column",
                new int[][]{
                        {1},
                        {2},
                        {3},
                        {4},
                        {5}
                });

        test("Test 7 : Single Element",
                new int[][]{
                        {100}
                });

        test("Test 8 : Two Rows",
                new int[][]{
                        {1, 2, 3},
                        {4, 5, 6}
                });

        test("Test 9 : Two Columns",
                new int[][]{
                        {1, 2},
                        {3, 4},
                        {5, 6}
                });

        test("Test 10 : Negative Numbers",
                new int[][]{
                        {-1, -2, -3},
                        {-4, -5, -6},
                        {-7, -8, -9}
                });

        test("Test 11 : Empty Matrix",
                new int[][]{});

        test("Test 12 : One Empty Row",
                new int[][]{{}});
    }

    private static void test(String title, int[][] matrix) {

        System.out.println("\n========================================");
        System.out.println(title);
        System.out.println("========================================");

        System.out.println("Matrix:");

        print(matrix);

        System.out.print("Spiral Traversal: ");

        spiralTraversal(matrix);

        System.out.println();
    }

    /**
     * Prints the matrix.
     */
    public static void print(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            System.out.println("Empty Matrix");
            return;
        }

        if (matrix[0].length == 0) {
            System.out.println("Empty Matrix");
            return;
        }

        for (int[] row : matrix) {

            for (int value : row) {
                System.out.printf("%4d", value);
            }

            System.out.println();
        }
    }

    /**
     * Spiral Traversal
     *
     * Time Complexity : O(R × C)
     * Auxiliary Space : O(1)
     */
    public static void spiralTraversal(int[][] matrix) {

        if (matrix == null ||
                matrix.length == 0 ||
                matrix[0].length == 0) {

            System.out.println("Empty Matrix");
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;

        int left = 0;
        int right = cols - 1;

        while (top <= bottom && left <= right) {

            // Traverse Top Row
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;

            // Traverse Right Column
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            // Traverse Bottom Row
            if (top <= bottom) {

                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }

                bottom--;
            }

            // Traverse Left Column
            if (left <= right) {

                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }

                left++;
            }
        }
    }
}
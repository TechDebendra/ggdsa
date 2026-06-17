package com.dsa.ds5Searching;

/**
 * Finds the floor value of the square root of a number
 * using Binary Search.
 *
 * Examples:
 * sqrt(25) = 5
 * sqrt(15) = 3
 * sqrt(10) = 3
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class _07SquareRoot {

    public static void main(String[] args) {

        System.out.println(squareRoot(0));   // 0
        System.out.println(squareRoot(1));   // 1
        System.out.println(squareRoot(4));   // 2
        System.out.println(squareRoot(9));   // 3
        System.out.println(squareRoot(16));  // 4
        System.out.println(squareRoot(25));  // 5

        // Non-perfect squares
        System.out.println(squareRoot(2));   // 1
        System.out.println(squareRoot(3));   // 1
        System.out.println(squareRoot(10));  // 3
        System.out.println(squareRoot(15));  // 3
        System.out.println(squareRoot(27));  // 5

        // Large values
        System.out.println(squareRoot(1000000)); // 1000
        System.out.println(squareRoot(Integer.MAX_VALUE)); // 46340
    }

    /**
     * Returns the floor value of the square root of x.
     *
     * Examples:
     * squareRoot(25) = 5
     * squareRoot(15) = 3
     *
     * @param x Non-negative integer
     * @return Floor value of sqrt(x)
     * @throws IllegalArgumentException if x is negative
     */
    public static int squareRoot(int x) {

        if (x < 0) {
            throw new IllegalArgumentException(
                    "Square root is not defined for negative numbers");
        }

        int start = 0;
        int end = x;
        int res = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            long square = (long) mid * mid;

            if (square == x) {

                return mid;

            } else if (square > x) {

                end = mid - 1;

            } else {

                res = mid;
                start = mid + 1;
            }
        }

        return res;
    }
}
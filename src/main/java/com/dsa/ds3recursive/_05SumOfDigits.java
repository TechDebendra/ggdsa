package com.dsa.ds3recursive;

/**
 * Program to find the sum of digits of a number using recursion.
 *
 * Example:
 * 1234223
 * = 1 + 2 + 3 + 4 + 2 + 2 + 3
 * = 17
 *
 * Time Complexity: O(d)
 * Space Complexity: O(d)
 *
 * where d is the number of digits in the number.
 *
 * @author Debendra
 */
public class _05SumOfDigits {

    public static void main(String[] args) {

        System.out.println("Sum of 1234223 : " + getSum(1234223));
        System.out.println("Sum of 12345   : " + getSum(12345));
        System.out.println("Sum of 9999    : " + getSum(9999));
        System.out.println("Sum of 5       : " + getSum(5));
        System.out.println("Sum of 0       : " + getSum(0));
    }

    /**
     * Recursively calculates the sum of digits of a number.
     *
     * Logic:
     * 1. Extract the last digit using (num % 10).
     * 2. Remove the last digit using (num / 10).
     * 3. Add the last digit to the sum of the remaining digits.
     * 4. Continue until the number becomes 0.
     *
     * Example:
     * getSum(123)
     *
     * = getSum(12) + 3
     * = getSum(1) + 2 + 3
     * = getSum(0) + 1 + 2 + 3
     * = 0 + 1 + 2 + 3
     * = 6
     *
     * @param num Input number.
     * @return Sum of all digits in the number.
     */
    public static int getSum(int num) {

        // Base condition
        if (num <= 9) {
            return num;
        }

        // Recursive case:
        // Sum of remaining digits + current last digit
        return getSum(num / 10) + num % 10;
    }
}
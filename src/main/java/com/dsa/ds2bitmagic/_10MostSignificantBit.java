package com.dsa.ds2bitmagic;

/**
 * Demonstrates how to find the Most Significant Bit (MSB) of a number.
 *
 * <p>The Most Significant Bit (MSB) is the highest power of 2
 * present in the binary representation of a number.
 *
 * <p>Examples:
 * <pre>
 * 10 = 1010
 * MSB = 1000 = 8
 *
 * 18 = 10010
 * MSB = 10000 = 16
 *
 * 37 = 100101
 * MSB = 100000 = 32
 * </pre>
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class _10MostSignificantBit {

    public static void main(String[] args) {
        int num = 18;

        System.out.println("Number : " + num);
        System.out.println("MSB    : " + findMSB(num));
    }

    /**
     * Finds the value of the most significant set bit.
     *
     * @param num the input number
     * @return the value of the most significant set bit
     * @throws IllegalArgumentException if num is less than or equal to 0
     */
    public static int findMSB(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException(
                    "Number must be greater than 0"
            );
        }

        int power = (int) (Math.log(num) / Math.log(2));

        return 1 << power;
    }
}
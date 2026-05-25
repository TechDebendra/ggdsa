package com.dsa.ds2bitmagic;

/**
 * Demonstrates how to flip all bits of a number.
 *
 * <p>Approach:
 * <ul>
 *     <li>Create a value having all bits set to 1 up to the most significant bit of the number.</li>
 *     <li>Subtract the number from this value.</li>
 * </ul>
 *
 * <p>Formula:
 * <pre>
 * flippedNumber = value - number
 * </pre>
 *
 * <p>Example:
 * <pre>
 * Number = 23
 * Binary = 10111
 *
 * Value  = 11111 (31)
 *
 * Flipped:
 * 11111
 * 10111
 * -----
 * 01000 (8)
 * </pre>
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class _07FlipBitsOfNumber {

    public static void main(String[] args) {
        int num = 23;

        System.out.println("Original Number : " + num);
        System.out.println("Flipped Number  : " + flipBits(num));
    }

    /**
     * Flips all bits of the given number from the least significant bit
     * up to its most significant set bit.
     *
     * @param num the input number
     * @return the flipped number
     */
    public static int flipBits(int num) {

        // Find the number of bits required to represent num
        int bitLength = Integer.toBinaryString(num).length();

        // Create a value having all bits set (e.g. 11111 for 5 bits)
        int value = (1 << bitLength) - 1;

        return value - num;
    }
}
package com.dsa.ds2bitmagic;

/**
 * Demonstrates how to unset (clear) the nth bit of a number.
 *
 * <p>Approach:
 * <ul>
 *     <li>Create a mask with only the nth bit set using {@code 1 << (p - 1)}.</li>
 *     <li>Invert the mask using the bitwise NOT operator ({@code ~}).</li>
 *     <li>Perform a bitwise AND between the number and the inverted mask.</li>
 * </ul>
 *
 * <p>Example:
 * <pre>
 * num = 10  (1010)
 * p = 2
 *
 * mask         = 0010
 * invertedMask = 1101
 *
 * 1010
 * 1101
 * ----
 * 1000 (8)
 * </pre>
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class _02UnsetBitAtNthPosition {

    public static void main(String[] args) {
        int num = 10;
        int p = 2;

        System.out.println("Original Number : " + num);
        System.out.println("After clearing " + p + "th bit : " + unSetBit(num, p));
    }

    /**
     * Clears (unsets) the bit at the given position.
     *
     * @param num the input number
     * @param p   the bit position to clear (1-based indexing)
     * @return the number after clearing the specified bit
     * @throws IllegalArgumentException if p is less than 1
     */
    public static int unSetBit(int num, int p) {
        if (p < 1) {
            throw new IllegalArgumentException("Bit position must be greater than or equal to 1");
        }

        return num & ~(1 << (p - 1));
    }
}
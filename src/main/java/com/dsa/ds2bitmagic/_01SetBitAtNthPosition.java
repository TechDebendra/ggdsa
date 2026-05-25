package com.dsa.ds2bitmagic;

/**
 * Utility class to set the nth bit (1-based indexing) of a given number.
 *
 * <p>Approach:
 * <ul>
 *     <li>Create a mask by left-shifting 1 by (n - 1) positions.</li>
 *     <li>Perform a bitwise OR between the number and the mask.</li>
 *     <li>The OR operation ensures that the nth bit becomes 1,
 *         regardless of its previous value.</li>
 * </ul>
 *
 * <p>Example:
 * <pre>
 * num = 122  -> 1111010
 * n = 6
 *
 * mask = 1 << (6 - 1)
 *      = 100000
 *
 * 1111010
 * 0100000
 * -------
 * 1111010
 *
 * Result = 122
 * </pre>
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class _01SetBitAtNthPosition {

    public static void main(String[] args) {
        int num = 122;
        int n = 6;

        System.out.printf(
                "Setting %dth bit of %d gives %d%n",
                n,
                num,
                setBit(num, n)
        );
    }

    /**
     * Sets the nth bit (1-based indexing) of the given number.
     *
     * @param num the input number
     * @param n   the bit position to set (1-based indexing)
     * @return the number after setting the nth bit
     * @throws IllegalArgumentException if n is less than 1
     */
    public static int setBit(int num, int n) {
        if (n < 1) {
            throw new IllegalArgumentException(
                    "Bit position must be greater than or equal to 1"
            );
        }

        int mask = 1 << (n - 1);
        return num | mask;
    }
}

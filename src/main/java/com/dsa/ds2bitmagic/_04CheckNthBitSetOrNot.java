package com.dsa.ds2bitmagic;

/**
 * Demonstrates how to check whether the nth bit of a number is set or not.
 *
 * <p>Approach:
 * <ul>
 *     <li>Create a mask with only the nth bit set using {@code 1 << (n - 1)}.</li>
 *     <li>Perform a bitwise AND ({@code &}) between the number and the mask.</li>
 *     <li>If the result is non-zero, the nth bit is set (1).</li>
 *     <li>If the result is zero, the nth bit is unset (0).</li>
 * </ul>
 *
 * <p>Example:
 * <pre>
 * num = 10 (1010)
 * n = 2
 *
 * mask = 0010
 *
 * 1010
 * 0010
 * ----
 * 0010 (non-zero)
 * </pre>
 *
 * Therefore, the 2nd bit is SET.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class _04CheckNthBitSetOrNot {

    public static void main(String[] args) {
        int num = 10;
        int n = 2;

        System.out.println(
                "Is " + n + "th bit set in " + num + " ? "
                        + isNthBitSet(num, n)
        );
    }

    /**
     * Checks whether the bit at the given position is set.
     *
     * @param num the input number
     * @param n   the bit position to check (1-based indexing)
     * @return {@code true} if the nth bit is set, otherwise {@code false}
     * @throws IllegalArgumentException if n is less than 1
     */
    public static boolean isNthBitSet(int num, int n) {
        if (n < 1) {
            throw new IllegalArgumentException(
                    "Bit position must be greater than or equal to 1"
            );
        }

        return (num & (1 << (n - 1))) != 0;
    }
}
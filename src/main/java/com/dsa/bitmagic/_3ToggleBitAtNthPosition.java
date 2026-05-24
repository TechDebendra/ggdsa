package com.dsa.bitmagic;

/**
 * Demonstrates how to toggle the nth bit of a number.
 *
 * <p>Toggling means:
 * <ul>
 *     <li>If the bit is 1, it becomes 0.</li>
 *     <li>If the bit is 0, it becomes 1.</li>
 * </ul>
 *
 * <p>Approach:
 * <ul>
 *     <li>Create a mask with only the nth bit set using {@code 1 << (n - 1)}.</li>
 *     <li>Perform a bitwise XOR ({@code ^}) between the number and the mask.</li>
 * </ul>
 *
 * <p>XOR Properties:
 * <pre>
 * 1 ^ 1 = 0
 * 0 ^ 0 = 0
 * 1 ^ 0 = 1
 * 0 ^ 1 = 1
 * </pre>
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
 * 1000 (8)
 * </pre>
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class _3ToggleBitAtNthPosition {

    public static void main(String[] args) {
        int num = 10;
        int n = 2;

        System.out.println("Original Number : " + num);
        System.out.println("After toggling " + n + "th bit : " + toggleBit(num, n));
    }

    /**
     * Toggles the bit at the given position.
     *
     * @param num the input number
     * @param n   the bit position to toggle (1-based indexing)
     * @return the number after toggling the specified bit
     * @throws IllegalArgumentException if n is less than 1
     */
    public static int toggleBit(int num, int n) {
        if (n < 1) {
            throw new IllegalArgumentException(
                    "Bit position must be greater than or equal to 1"
            );
        }

        return num ^ (1 << (n - 1));
    }
}
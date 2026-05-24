package com.dsa.bitmagic;

/**
 * Demonstrates how to check whether a number is a power of 2.
 *
 * <p>Approach:
 * <ul>
 *     <li>A power of 2 has exactly one bit set in its binary representation.</li>
 *     <li>Subtracting 1 from a power of 2 turns the set bit into 0 and all
 *         lower bits into 1.</li>
 *     <li>Therefore, the bitwise AND of a power of 2 and its predecessor is 0.</li>
 * </ul>
 *
 * <p>Examples:
 * <pre>
 * 8  = 1000
 * 7  = 0111
 *
 * 1000
 * 0111
 * ----
 * 0000
 *
 * Hence, 8 is a power of 2.
 *
 * 10 = 1010
 * 9  = 1001
 *
 * 1010
 * 1001
 * ----
 * 1000
 *
 * Hence, 10 is NOT a power of 2.
 * </pre>
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class _09CheckNpowerOf2 {

    public static void main(String[] args) {
        int num = 16;

        System.out.println(num + " is power of 2: " + isPowerOfTwo(num));
    }

    /**
     * Checks whether the given number is a power of 2.
     *
     * @param num the number to check
     * @return true if the number is a power of 2, otherwise false
     */
    public static boolean isPowerOfTwo(int num) {
        return num > 0 && ((num & (num - 1)) == 0);
    }
}
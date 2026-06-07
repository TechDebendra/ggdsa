package com.dsa.ds3recursive;

/**
 * Rope Cutting Problem using Recursion.
 *
 * Given a rope of length n and three possible cut lengths a, b, and c,
 * determine the maximum number of pieces that can be obtained such that
 * every piece has a length equal to either a, b, or c.
 *
 * If it is not possible to cut the rope exactly into the given lengths,
 * return -1.
 *
 * Examples:
 *
 * n = 5, a = 2, b = 1, c = 5
 * Output: 5
 * Explanation:
 * 5 = 1 + 1 + 1 + 1 + 1
 *
 * n = 23, a = 12, b = 9, c = 11
 * Output: 2
 * Explanation:
 * 23 = 12 + 11
 *
 * n = 5, a = 4, b = 2, c = 6
 * Output: -1
 * Explanation:
 * No combination can produce exactly 5.
 *
 * Time Complexity: O(3ⁿ)
 * Space Complexity: O(n)
 *
 * @author Debendra
 */
public class _06RopeCuttingProblem {

    public static void main(String[] args) {

        System.out.println("Maximum Cuts : "
                + maxCuts(5, 2, 1, 5));

        System.out.println("Maximum Cuts : "
                + maxCuts(23, 12, 9, 11));

        System.out.println("Maximum Cuts : "
                + maxCuts(5, 4, 2, 6));
    }

    /**
     * Recursively finds the maximum number of cuts that can be made.
     *
     * At every step, we try three possibilities:
     * 1. Cut length 'a'
     * 2. Cut length 'b'
     * 3. Cut length 'c'
     *
     * Then we choose the option that produces the maximum number of cuts.
     *
     * Base Cases:
     * - If n becomes 0, the rope has been cut successfully.
     * - If n becomes negative, that path is invalid.
     *
     * @param n Remaining rope length.
     * @param a First possible cut length.
     * @param b Second possible cut length.
     * @param c Third possible cut length.
     * @return Maximum number of cuts possible, otherwise -1.
     */
    public static int maxCuts(int n, int a, int b, int c) {

        // Successfully cut the entire rope
        if (n == 0) {
            return 0;
        }

        // Invalid cut combination
        if (n < 0) {
            return -1;
        }

        int result = Math.max(
                maxCuts(n - a, a, b, c),
                Math.max(
                        maxCuts(n - b, a, b, c),
                        maxCuts(n - c, a, b, c)
                )
        );

        // No valid solution found
        if (result == -1) {
            return -1;
        }

        return result + 1;
    }
}
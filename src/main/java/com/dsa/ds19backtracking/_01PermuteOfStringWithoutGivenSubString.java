package com.dsa.ds19backtracking;

/**
 * Generate all permutations of a string
 * while avoiding permutations that contain the substring "AB".
 *
 * Example:
 * Input  : ABC
 * Output : ACB, BAC, BCA, CBA
 *
 * Permutations like ABC and CAB are skipped
 * because they contain "AB".
 */
public class _01PermuteOfStringWithoutGivenSubString {

    /**
     * Backtracking function to generate permutations.
     *
     * @param string Current string configuration
     * @param l      Current position to fix
     * @param r      Last index of the string
     */
    public static void permute(String string, int l, int r) {

        // Base case:
        // All positions have been fixed.
        if (l == r) {
            System.out.println(string);
            return;
        }

        // Try every possible character at position 'l'
        for (int i = l; i <= r; i++) {

            // Prune invalid branches before recursion
            if (isSafe(string, l, i, r)) {

                // Place character at index 'i' to position 'l'
                string = swap(string, i, l);

                // Recur for the remaining positions
                permute(string, l + 1, r);

                // Backtrack:
                // Restore original string state before next iteration
                string = swap(string, l, i);
            }
        }
    }

    /**
     * Swaps characters at indices i and j.
     *
     * Example:
     * swap("ABC", 0, 2) -> "CBA"
     */
    public static String swap(String string, int i, int j) {

        char[] chars = string.toCharArray();

        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

        return new String(chars);
    }

    /**
     * Checks whether choosing the current character
     * can potentially lead to an invalid permutation.
     *
     * This function is responsible for pruning
     * the recursion tree early.
     */
    public static boolean isSafe(String string, int l, int i, int r) {

        /*
         * Case 1:
         * If previous character is 'A'
         * and current fixed character becomes 'B',
         * then substring "AB" is formed.
         *
         * Example:
         * A B _
         * ^
         * Invalid, so stop exploring this branch.
         */
        if (l != 0 &&
                string.charAt(l - 1) == 'A' &&
                string.charAt(l) == 'B') {

            return false;
        }

        /*
         * Case 2:
         * Special optimization when only two positions remain.
         *
         * Example:
         * _ A B
         *
         * If choosing current character results in
         * the final pair being "AB", prune immediately.
         */
        if (l == r - 1 &&
                string.charAt(i) == 'A' &&
                string.charAt(r) == 'B') {

            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        String input = "ABC";

        // Generate permutations without substring "AB"
        permute(input, 0, input.length() - 1);
    }
}
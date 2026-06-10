package com.dsa.ds3recursive;

public class _11PrintingAllPermutations {
    public static void main(String[] args) {
        String input = "ABCD";
        int len = input.length();
        permute(input,0,len-1);

    }

    /**
     * Prints all permutations of a string using backtracking.
     *
     * @param str input string
     * @param l   current index to fix
     * @param r   last index
     */
    public static void permute(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
            return;
        }

        for (int i = l; i <= r; i++) {
            str = swap(str, l, i);
            permute(str, l + 1, r);
            str = swap(str, l, i); // backtrack
        }
    }

    /**
     * Swaps two characters in a string.
     *
     * @param str input string
     * @param i   first index
     * @param j   second index
     * @return string after swapping characters
     */
    public static String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();

        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

        return String.valueOf(chars);
    }
}

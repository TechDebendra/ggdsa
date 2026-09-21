package com.dsa.ds20dynamicprograming;

import java.util.Arrays;

public class _03LongestCommonSubsequence_TopDown {

    public static void main(String[] args) {

        String s1 = "ABCD";
        String s2 = "ADCFH";

        int m = s1.length();
        int n = s2.length();

        int[][] memory = new int[m + 1][n + 1];

        for (int[] row : memory) {
            Arrays.fill(row, -1);
        }

        int result = lcs(s1, s2, m, n, memory);

        System.out.println("Result : " + result);
    }

    public static int lcs(String s1, String s2,
                          int m, int n,
                          int[][] memory) {

        if (m == 0 || n == 0) {
            return 0;
        }

        if (memory[m][n] != -1) {
            return memory[m][n];
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            memory[m][n] =  1 + lcs(s1, s2, m - 1, n - 1, memory);
        } else {
            memory[m][n] =
                    Math.max(
                            lcs(s1, s2, m, n - 1, memory),
                            lcs(s1, s2, m - 1, n, memory)
                    );
        }

        return memory[m][n];
    }
}

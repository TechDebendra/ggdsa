package com.dsa.ds3recursive;

public class _10_SubsetSumProblem {

    public static void main(String[] args) {
        int[] array = {10, 20, 15};

        System.out.println(subsetSub(array, array.length, 25));
    }

    /**
     * Counts the number of subsets whose sum equals the given target.
     *
     * @param array input array
     * @param n     number of elements considered
     * @param sum   target sum
     * @return number of subsets having the target sum
     */
    public static int subsetSub(int[] array, int n, int sum) {
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }

        return subsetSub(array, n - 1, sum)
                + subsetSub(array, n - 1, sum - array[n - 1]);
    }
}
package com.dsa.ds3recursive;

public class _09JosephusProblem {

    public static void main(String[] args) {
        System.out.println("Survivor: " + josephus(5, 3));
    }

    /**
     * Returns the position of the survivor in the Josephus problem.
     *
     * @param n number of people
     * @param k every kth person is eliminated
     * @return survivor position (0-based index)
     */
    public static int josephus(int n, int k) {
        if (n == 1)
            return 0;

        return (josephus(n - 1, k) + k) % n;
    }

    /**
     * Returns the position of the survivor in the Josephus problem.
     *
     * @param n number of people
     * @param k every kth person is eliminated
     * @return survivor position (1-based index)
     */
    public static int josephusOneBasedIndex(int n, int k) {
        return josephus(n,k)+1;
    }
}
package com.dsa.math;

/**
 * Class to compute power using Iterative Fast Exponentiation (Exponentiation by Squaring).
 *
 * <p>This algorithm efficiently computes x^n in O(log n) time using an iterative approach.
 * Instead of multiplying x exactly n times (which takes O(n)),
 * it reduces the exponent by half in each step, achieving much better performance.</p>
 *
 * <h3>Example:</h3>
 * <pre>
 * Input: x = 2, n = 10
 * Output: 1024
 *
 * Explanation:
 * 2^10 = (2^5)^2
 * 2^5  = 2 * (2^2)^2
 * </pre>
 *
 * <h3>Time Complexity:</h3> O(log n) – since exponent is halved in each iteration. <br>
 * <h3>Space Complexity:</h3> O(1) – uses only constant extra space.
 */
public class _12IterativePower {
    public static void main(String[] args) {
        System.out.println("2 power 4 is : " + power(2, 4));
        System.out.println("3 power 7 is : " + power(3, 7));
        System.out.println("5 power 0 is : " + power(5, 0));
    }

    /**
     * Computes x raised to the power n using iterative fast exponentiation.
     *
     * @param x the base value
     * @param n the exponent (non-negative)
     * @return the computed value of x^n
     *
     * <p>Algorithm Explanation:</p>
     * <ul>
     *   <li>Initialize result as 1.</li>
     *   <li>While n > 0:</li>
     *   <ul>
     *     <li>If n is odd → multiply result by current base.</li>
     *     <li>Square the base (x = x * x).</li>
     *     <li>Divide n by 2 (integer division).</li>
     *   </ul>
     *   <li>Return result.</li>
     * </ul>
     */
    public static long power(int x, int n) {
        long res = 1;

        while (n > 0) {
            // If n is odd, multiply result with current base
            if (n % 2 == 1) {
                res = res * x;
            }
            // Square the base
            x = x * x;
            // Divide exponent by 2
            n = n / 2;
        }

        return res;
    }
}

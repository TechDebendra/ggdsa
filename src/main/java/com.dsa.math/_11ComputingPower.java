package com.dsa.math;

public class _11ComputingPower {
    public static void main(String[] args) {
        System.out.println("2 power 4 is : " + power1(2, 4));
        System.out.println("2 power 4 is : " + power2(2, 4));
    }

    // Approach 1: Naive iterative solution
    // Multiply x exactly n times
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public static long power1(int x, int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * x;
        }
        return res;
    }

    // Approach 2: Exponentiation by squaring (recursive)
    // Uses divide-and-conquer: x^n = (x^(n/2))^2 if n is even, else x * (x^(n/2))^2
    // Time Complexity : O(log n)
    // Space Complexity : O(log n)  (due to recursion stack)
    public static long power2(int x, int n) {
        if (n == 0) return 1;

        long temp = power2(x, n / 2);
        temp = temp * temp;

        if (n % 2 == 0) {
            return temp;
        } else {
            return temp * x;
        }
    }
}

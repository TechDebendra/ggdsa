package com.dsa.math;

public class _05GCD {
    public static void main(String[] args) {
        System.out.println("Approach-1");
        System.out.println(" GCD of 4 and 6 is :"+gcd(4,6));
        System.out.println(" GCD of 24 and 48 is :"+gcd(24,48));

        System.out.println("Approach-2");
        System.out.println(" GCD of 4 and 6 is :"+gcd1(4,6));
        System.out.println(" GCD of 24 and 48 is :"+gcd1(24,48));

        System.out.println("Approach-3");
        System.out.println(" GCD of 4 and 6 is :"+gcd2(4,6));
        System.out.println(" GCD of 24 and 48 is :"+gcd2(24,48));

    }

    // Approach - 1: Brute Force
    // Time Complexity: O(min(a, b))
    // Space Complexity: O(1)
    public static int gcd(int a, int b) {
        // Input validation
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("GCD is not defined for negative numbers.");
        }
        if (a == 0) return b;
        if (b == 0) return a;

        int res = 1;
        int temp = Math.min(a, b);

        while (temp > 0) {
            if (a % temp == 0 && b % temp == 0) {
                res = temp;
                break;
            }
            temp--;
        }
        return res;
    }

    // Approach - 2: Euclidean Algorithm (subtraction version)
    // gcd(a, b) = gcd(a-b, b)
    // Time Complexity: O(max(a, b)) in worst case (when numbers are consecutive Fibonacci)
    // Space Complexity: O(1)
    public static int gcd1(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("GCD is not defined for negative numbers.");
        }
        if (a == 0) return b;
        if (b == 0) return a;

        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    // Approach - 3: Euclidean Algorithm (modulus version) – Most Efficient
    // Time Complexity: O(log(min(a, b)))
    // Space Complexity: O(log(min(a, b))) due to recursion stack
    // If converted to iterative form → O(1) space
    public static int gcd2(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("GCD is not defined for negative numbers.");
        }
        if (b == 0) return a;
        return gcd2(b, a % b);
    }


}

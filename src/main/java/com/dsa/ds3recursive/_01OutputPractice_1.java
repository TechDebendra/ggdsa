package com.dsa.ds3recursive;

/**
 * Practice program to analyze the output of different recursive functions.
 * <p>
 * Demonstrates:
 * <ul>
 *     <li>Recursive printing before and after recursive calls</li>
 *     <li>Recursion tree traversal</li>
 *     <li>Logarithmic recursion</li>
 *     <li>Printing binary representation using recursion</li>
 * </ul>
 */
public class _01OutputPractice_1 {

    public static void main(String[] args) {

        System.out.println("fun1 :");
        fun1(3);

        System.out.println("fun2 :");
        fun2(3);

        System.out.println("fun3 :");
        System.out.println(fun3(16));

        System.out.println("fun4 :");
        System.out.println(fun4(27));

        System.out.println("fun5 :");
        fun5(7);
    }

    /**
     * Prints the value before and after the recursive call.
     * <p>
     * Example:
     * <pre>
     * fun1(3)
     * Output:
     * 3
     * 2
     * 1
     * 1
     * 2
     * 3
     * </pre>
     * The first print executes while moving down the recursion stack,
     * and the second print executes while returning from recursion.
     *
     * @param x positive integer to process recursively
     */
    public static void fun1(int x) {
        if (x == 0) {
            return;
        }

        System.out.println(x);
        fun1(x - 1);
        System.out.println(x);
    }

    /**
     * Demonstrates a recursion tree.
     * <p>
     * The function recursively calls itself twice with (n - 1)
     * and prints n between the recursive calls.
     *
     * Example:
     * <pre>
     * fun2(3)
     * Output:
     * 1
     * 2
     * 1
     * 3
     * 1
     * 2
     * 1
     * </pre>
     *
     * @param n recursion depth
     */
    public static void fun2(int n) {
        if (n == 0) {
            return;
        }

        fun2(n - 1);
        System.out.println(n);
        fun2(n - 1);
    }

    /**
     * Calculates floor(log₂(n)) recursively.
     * <p>
     * The number is repeatedly divided by 2 until it becomes 1.
     *
     * Examples:
     * <pre>
     * fun3(16) = 4
     * fun3(10) = 3
     * fun3(8)  = 3
     * </pre>
     *
     * @param n positive integer (n >= 1)
     * @return floor value of log base 2 of n
     */
    public static int fun3(int n) {
        if (n == 1) {
            return 0;
        }

        return 1 + fun3(n / 2);
    }

    /**
     * Calculates floor(log₃(n)) recursively.
     * <p>
     * The number is repeatedly divided by 3 until it becomes less than 3.
     *
     * Examples:
     * <pre>
     * fun4(27) = 3
     * fun4(9)  = 2
     * fun4(8)  = 1
     * </pre>
     *
     * @param n positive integer
     * @return floor value of log base 3 of n
     */
    public static int fun4(int n) {
        if (n < 3) {
            return 0;
        }

        return 1 + fun4(n / 3);
    }

    /**
     * Prints the binary representation of a decimal number using recursion.
     * <p>
     * The number is repeatedly divided by 2 and the remainder is printed
     * while the recursive calls return.
     *
     * Example:
     * <pre>
     * fun5(7)
     * Output:
     * 111
     * </pre>
     *
     * @param n decimal number to convert to binary
     */
    public static void fun5(int n) {
        if (n == 0) {
            return;
        }

        fun5(n / 2);
        System.out.print(n % 2);
    }
}
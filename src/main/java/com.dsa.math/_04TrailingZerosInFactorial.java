package com.dsa.math;

public class _04TrailingZerosInFactorial {
    public static void main(String[] args) {
        System.out.println("Trailing zeros of 5! :"+trailingZeros(5));
        System.out.println("Trailing zeros of 53! :"+trailingZeros(53));
        System.out.println("Trailing zeros of 1233! :"+trailingZeros(1233));
        System.out.println("Trailing zeros of 43323! :"+trailingZeros(43323));
    }

    /*
    * Time Complexity: O(log n)
    * Space Complexity: O(1)
    * */
    public static int trailingZeros(int n){
        if(n<0){
            throw new IllegalArgumentException("Factorial is not defined for negative number.");
        }
        int res=0;

        for(int i=5;i<=n;i=i*5){
            res=res+(n/i);
        }

        return res;
    }
}

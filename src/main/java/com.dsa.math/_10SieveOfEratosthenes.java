package com.dsa.math;

import java.util.Arrays;

public class _10SieveOfEratosthenes {
    public static void main(String[] args) {
        System.out.println("Prime numbers below 100 using Approach 1:");
        printPrimes1(100);

        System.out.println("\nPrime numbers below 100 using Approach 2:");
        printPrimes2(100);
    }

    // Approach 1: Classic sieve
    // Mark multiples of each prime starting from i*i
    // Time Complexity : O(n log log n)
    //   -> Very efficient for generating all primes up to n
    // Space Complexity : O(n) for boolean array
    public static void printPrimes1(int num){
        boolean[] isPrime = new boolean[num+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false; // 0 is not prime
        isPrime[1] = false; // 1 is not prime

        for(int i=2; i*i<=num; i++){
            if(isPrime[i]){
                for(int j=i*i; j<=num; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i=2; i<=num; i++){
            if(isPrime[i]){
                System.out.print(i + " ");
            }
        }
    }

    // Approach 2: Print primes on the fly
    // Still uses sieve logic, but prints immediately
    // Time Complexity : O(n log log n)
    // Space Complexity : O(n)
    public static void printPrimes2(int num){
        boolean[] isPrime = new boolean[num+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i<=num; i++){
            if(isPrime[i]){
                System.out.print(i + " ");
                for(int j=i*i; j<=num; j+=i){
                    isPrime[j] = false;
                }
            }
        }
    }
}

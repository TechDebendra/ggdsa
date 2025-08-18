package com.dsa.math;

public class _08PrimeFactors {
    public static void main(String[] args) {
        System.out.println("Prime Factors of 1242 using Approach 1:");
        primeFactors1(1242);

        System.out.println("\nPrime Factors of 1242 using Approach 2:");
        primeFactors2(1242);

        System.out.println("\nPrime Factors of 1242 using Approach 3:");
        primeFactors3(1242);
    }

    // Approach 1: Naive Solution (Check all numbers, then check primality, then factorize)
    // Time Complexity : O(n * sqrt(n))
    //   -> Outer loop runs up to sqrt(n), but for each number we call isPrime() (O(sqrt(i)))
    //   -> In worst case, it's closer to O(n log n) for large n
    // Space Complexity : O(1)
    public static void primeFactors1(int n){
        if(n <= 1){
            return;
        }
        for(int i=2; i*i<=n; i++){
            if(isPrime(i)){
                int x = i;
                while (n % x == 0){
                    System.out.print(i + " ");
                    x = x * i;
                }
            }
        }
    }

    // Helper: Optimized primality test
    public static boolean isPrime(int num){
        if(num == 1) return false;
        if(num == 2 || num == 3) return true;
        if(num % 2 == 0 || num % 3 == 0) return false;
        for(int i=5; i*i<=num; i+=6){
            if(num % i == 0 || num % (i+2) == 0){
                return false;
            }
        }
        return true;
    }

    // Approach 2: Divide by every number starting from 2
    // Time Complexity : O(sqrt(n))
    //   -> We only loop till sqrt(n), dividing as many times as possible
    //   -> Efficient compared to Approach 1
    // Space Complexity : O(1)
    public static void primeFactors2(int num){
        if(num <= 1) return;
        for(int i=2; i*i<=num; i++){
            while (num % i == 0){
                System.out.print(i + " ");
                num = num / i;
            }
        }
        if(num > 1){
            System.out.print(num);
        }
    }

    // Approach 3: Optimized (6k ± 1 optimization)
    // Time Complexity : O(sqrt(n))
    //   -> But fewer iterations since we skip even numbers and multiples of 3
    //   -> Roughly 2/3 fewer checks than Approach 2
    // Space Complexity : O(1)
    public static void primeFactors3(int num){
        if(num <= 1) return;

        while (num % 2 == 0){
            System.out.print(2 + " ");
            num = num / 2;
        }
        while (num % 3 == 0){
            System.out.print(3 + " ");
            num = num / 3;
        }

        for(int i=5; i*i<=num; i+=6){
            while (num % i == 0){
                System.out.print(i + " ");
                num = num / i;
            }
            while (num % (i+2) == 0){
                System.out.print((i+2) + " ");
                num = num / (i+2);
            }
        }

        if(num > 3){
            System.out.print(num);
        }
    }
}

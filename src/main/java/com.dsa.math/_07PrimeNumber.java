package com.dsa.math;

public class _07PrimeNumber {
    public static void main(String[] args) {
        System.out.println("Approach 1");
        System.out.println("2 is prime :"+isPrime1(2));
        System.out.println("9 is prime :"+isPrime1(9));
        System.out.println("1031 is prime :"+isPrime1(1031));
        System.out.println("23 is prime :"+isPrime1(23));

        System.out.println("Approach 2");
        System.out.println("2 is prime :"+isPrime2(2));
        System.out.println("9 is prime :"+isPrime2(9));
        System.out.println("1031 is prime :"+isPrime2(1031));
        System.out.println("23 is prime :"+isPrime2(23));

        System.out.println("Approach 3");
        System.out.println("2 is prime :"+isPrime3(2));
        System.out.println("9 is prime :"+isPrime3(9));
        System.out.println("1031 is prime :"+isPrime3(1031));
        System.out.println("23 is prime :"+isPrime3(23));
    }

    // Approach 1: Check divisibility up to n/2
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public static boolean isPrime1(int num){
        if(num == 1){
            return false;
        }
        for(int i=2;i<=num/2;i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    // Approach 2: Check divisibility up to sqrt(n)
    // Time Complexity : O(sqrt(n))
    // Space Complexity : O(1)
    public static boolean isPrime2(int num){
        if(num == 1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    // Approach 3: Optimized 6k ± 1 method
    // Time Complexity : O(sqrt(n) / log(n)) ≈ O(sqrt(n))
    //   (Because we skip even numbers and multiples of 3, reducing constant factors)
    // Space Complexity : O(1)
    public static boolean isPrime3(int num){
        if(num == 1){
            return false;
        }
        if(num == 2 || num == 3){
            return true;
        }
        if(num % 2 == 0 || num % 3 == 0){
            return false;
        }
        for(int i=5; i*i<=num; i+=6){
            if(num % i == 0 || num % (i+2) == 0){
                return false;
            }
        }
        return true;
    }
}

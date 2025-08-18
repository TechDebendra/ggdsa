package com.dsa.math;

public class _09Divisors {
    public static void main(String[] args) {
        System.out.println("All the divisors of 124 using Approach 1:");
        printDivisors1(124);

        System.out.println("\nAll the divisors of 124 using Approach 2:");
        printDivisors2(124);
    }

    // Approach 1: Print divisors in arbitrary order
    // Time Complexity : O(sqrt(n))
    //   -> We only loop up to sqrt(n)
    // Space Complexity : O(1)
    public static void printDivisors1(int num){
        for(int i=1; i*i<=num; i++){  // fixed <=
            if(num % i == 0){
                System.out.print(i + " ");
                if(i != num/i){  // avoid duplicate when i*i == num
                    System.out.print(num/i + " ");
                }
            }
        }
    }

    // Approach 2: Print divisors in sorted order
    // Time Complexity : O(sqrt(n))
    //   -> Still only loop up to sqrt(n)
    //   -> But requires 2 passes to ensure ascending order
    // Space Complexity : O(1)
    public static void printDivisors2(int num){
        int i=1;
        // First loop: print small divisors
        for(; i*i<=num; i++){   // fixed <=
            if(num % i == 0){
                System.out.print(i + " ");
            }
        }
        i--; // rollback to last valid sqrt(n)
        // Second loop: print larger divisors in correct order
        for(; i>=1; i--){
            if(num % i == 0 && i != num/i){
                System.out.print(num/i + " ");
            }
        }
    }
}

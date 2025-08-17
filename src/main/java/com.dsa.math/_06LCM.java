package com.dsa.math;

public class _06LCM {
    public static void main(String[] args) {
        System.out.println("LCM of 4 and 6 is :"+lcm(4,6));

    }
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    // Time Complexity: O(log(min(a, b)))
    public static int lcm(int a,int b){
        return (a*b)/gcd(a,b);

    }
}


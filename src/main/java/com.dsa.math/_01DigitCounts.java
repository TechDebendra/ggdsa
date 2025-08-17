package com.dsa.math;
/*
* Time Complexity: O(log n)
* Space Complexity: O(1)
* */
public class _01DigitCounts {
    public static void main(String[] args) {
        System.out.println("Digits of 123232 is : "+digitCounts(123232));
        System.out.println("Digits of 232 is : "+digitCounts(-23207));

    }

    public static int digitCounts(int digit){
        int res=0;
        if(digit<0){
            digit=digit*(-1);
        }

        while (digit>0){
            res++;
            digit/=10;
        }

        return res;
    }
}

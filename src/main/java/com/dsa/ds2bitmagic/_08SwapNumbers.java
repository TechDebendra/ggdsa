package com.dsa.ds2bitmagic;

public class _08SwapNumbers {
    public static void main(String[] args) {
        swap(10,29);
    }

    public static void swap(int m, int n){
        System.out.printf("m :"+m);
        System.out.printf("n :"+n);
        m = m^ n;
        n= n ^ m;
        m = m ^ n;
        System.out.printf("\nAfter swap :\n");
        System.out.printf("m :"+m);
        System.out.printf("n :"+n);

    }
}
